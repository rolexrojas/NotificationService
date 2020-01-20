package com.gcs.deoxys.routes;

import com.gcs.deoxys.EmailNotification;
import com.gcs.deoxys.SmsNotification;
import com.gcs.deoxys.config.ApplicationProperties;
import com.gcs.deoxys.types.TempProcessRequestDTO;
import com.gcs.deoxys.types.TransactionApiDTO;
import com.gcs.deoxys.types.TransactionApiResponseDTO;
import com.gcs.deoxys.types.TransactionRequestDTO;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.http4.HttpComponent;
import org.apache.camel.http.common.HttpOperationFailedException;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.support.jsse.KeyManagersParameters;
import org.apache.camel.support.jsse.KeyStoreParameters;
import org.apache.camel.support.jsse.SSLContextParameters;
import org.apache.camel.support.jsse.TrustManagersParameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * A simple Camel route that triggers from a timer and calls a bean and prints to system out.
 * <p/>
 * Use <tt>@Component</tt> to make Camel auto detect this route when starting.
 */
@SuppressWarnings("unchecked")
@Component
public class NotificationRoutes extends RouteBuilder {

    private Logger logger = LogManager.getLogger(NotificationRoutes.class);

    @Autowired
    private ApplicationProperties applicationProperties;


    @Override
    public void configure() {

        //Se hace la llamada del metodo para cargar las configuraciones SSL en el componente de hhtp4
        configureSslForHttp4();

        //Manejo de excepcion en caso de la solicitud https
        onException(IOException.class, HttpOperationFailedException.class)
                .useOriginalMessage()
                .maximumRedeliveries(1).onRedelivery(exchange -> logger.info("Reintentando enviar mensaje http: " +
                exchange.getUnitOfWork().getOriginalInMessage().getBody(TransactionRequestDTO.class).getGcsSequenceNo()))
                .handled(true);

        //Ultimo intento de envio de solicitud en caso de excepcion mientras sucedia el proceso
        errorHandler(deadLetterChannel("direct:dead")
                .useOriginalMessage()
                .maximumRedeliveries(1));

        //Notificacion de transacciones que no pudieron ser completadas durante el curso del flujo
        from("direct:dead").process(exchange -> logger.info("Transaccion no pudo ser completada "));

        /*
        Se busca el registro por el que se quedaron las notificaciones
        y se buscan las transacciones siguientes
        */
        from("jpa://com.gcs.types.TempProcessRequestDTO?namedQuery=lastProcessedTransaction" +
                "&persistenceUnit=transactions" +
                "&consumer.delay=" + applicationProperties.getProcessDelaySeconds() * 1000 +
                "&consumeDelete=false")
                .process(exchange -> {
                    TempProcessRequestDTO tempProcessRequestDTO = exchange.getIn().getBody(TempProcessRequestDTO.class);
                    exchange.getIn().setHeader("id", tempProcessRequestDTO.getGcs_sequence_number());

                })
                .toD("jpa://com.gcs.types.TransactionRequestDTO?namedQuery=searchTransactionPoll" +
                        "&parameters={\"lastProcessedTransaction\":${header.id}}" +
                        "&persistenceUnit=transactions" +
                        "&maximumResults=" + applicationProperties.getProcessTransactionAmount() +
                        "&consumeDelete=false&consumeLockEntity=false")
                .to("direct:processTransactions");

        //Se realiza el envio de las notificaciones recibidas al merchant
        from("direct:processTransactions")
                .multicast().parallelProcessing(true)
                .bean(EmailNotification.class, "emailNotify(${body})")
                .bean(SmsNotification.class, "smsNotify(${body})")
                .multicast().to("direct:postTransactions", "direct:updateTemp");

        //Se hace el POST en endpoint REST para enviar las transacciones
        from("direct:postTransactions")
                .split(body())
                .process(exchange -> {


                        if (exchange.getIn().getBody() instanceof TransactionRequestDTO) {

                            TransactionApiDTO transactionApiDTO = new TransactionApiDTO(exchange.getIn().getBody(TransactionRequestDTO.class));

                            exchange.getIn().setHeader("Content-Type", "application/json");
                            exchange.getIn().setHeader("Auth1", get_SHA_512_SecurePassword(applicationProperties.getSdpWebServiceUsername(), ""));
                            exchange.getIn().setHeader("Auth2", get_SHA_512_SecurePassword(applicationProperties.getSdpWebServicePassword(), ""));

                            exchange.getIn().setBody(transactionApiDTO);

                        }

                }).setHeader(Exchange.HTTP_METHOD, constant("POST"))
                .marshal().json(JsonLibrary.Gson)
                .to("https4://" + applicationProperties.getHttpRequestUrl())
                .process(exchange -> {
                    logger.info("LOG MENSAJE: " + exchange.getIn().getBody());
                }).unmarshal().json(JsonLibrary.Gson, TransactionApiResponseDTO.class)
                .process(exchange -> {

                    if(exchange.getIn().getBody() instanceof TransactionApiResponseDTO){

                        logger.info("Respuesta de transaccion " + exchange.getIn().getBody(TransactionApiResponseDTO.class).toString());
                    }
                    else{
                        logger.info("Respuesta de transaccion no tiene formato adecuado");
                    }
                });

        /*
        Se actualiza el registro en la db temporal
        para colocar el ultimo registro procesado
        */
        from("direct:updateTemp")
                .process(exchange -> {

                    List<TransactionRequestDTO> processRequests = (List<TransactionRequestDTO>) exchange.getIn().getBody();

                    TransactionRequestDTO lastProcessedRequest = processRequests.get(processRequests.size() - 1);
                    TempProcessRequestDTO processRequestDTO = new TempProcessRequestDTO(lastProcessedRequest);

                    exchange.getIn().getHeader("CamelEntityManager", EntityManager.class).persist(processRequestDTO);
                });
    }

    /**
     * Configuracion del keystore y key manager para conexion Https
     */
    private void configureSslForHttp4() {

        KeyStoreParameters ksp = new KeyStoreParameters();
        ksp.setResource(applicationProperties.getKeystoreRoute());
        ksp.setPassword(applicationProperties.getKeystorePassword());

        KeyManagersParameters kmp = new KeyManagersParameters();
        kmp.setKeyStore(ksp);
        kmp.setKeyPassword(applicationProperties.getKeystoreManagerPassword());

        TrustManagersParameters trustManagersParameters = new TrustManagersParameters();
        trustManagersParameters.setKeyStore(ksp);

        SSLContextParameters scp = new SSLContextParameters();
        scp.setKeyManagers(kmp);
        scp.setTrustManagers(trustManagersParameters);

        HttpComponent httpComponent = getContext().getComponent("https4", HttpComponent.class);
        httpComponent.setSslContextParameters(scp);

        //This is important to make your cert skip CN/Hostname checks
        // httpComponent.setX509HostnameVerifier(new AllowAllHostnameVerifier());
    }

    public static String get_SHA_512_SecurePassword(String passwordToHash, String salt){
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }





}

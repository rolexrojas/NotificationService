package com.gcs.deoxys;

import com.gcs.deoxys.process.NotificationDataGet;
import com.gcs.deoxys.services.implementation.MailSenderService;
import com.gcs.deoxys.types.MerchantPaymentDTO;
import com.gcs.deoxys.types.TransactionRequestDTO;
import com.gcs.deoxys.types.xml.MerchantXmlType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("sendEmail")
public class EmailNotification {

    @Autowired
    MailSenderService mailSenderService;

    @Autowired
    NotificationDataGet notificationDataGet;

    private Logger log = LogManager.getLogger(EmailNotification.class);

    /**
     * Metodo para realizar la notificacion via correos
     *
     * @param transactionRequestDTO datos de correos a enviar
     */
    public void emailNotify(List<TransactionRequestDTO> transactionRequestDTO) {

        log.info("Realizando notificacion por correo electrónico");

        MerchantPaymentDTO merchantPaymentDTO;
        MerchantXmlType merchantXmlType;

        try {

            //Se itera el paquete de transacciones a procesar
            for (TransactionRequestDTO requestDTO : transactionRequestDTO) {

                //Se buscan los datos del correo y numero en el archivo de configuracion
                merchantXmlType = notificationDataGet.findMerchantInformationByTpn(requestDTO.getTpn());

                if (merchantXmlType.getEmail() != null) {
                    merchantPaymentDTO = new MerchantPaymentDTO(requestDTO, merchantXmlType);

                    //Se envia la transaccion
                    mailSenderService.sendPaymentNotification(merchantPaymentDTO);

                } else {
                    log.info("No se encontro correo para TPN: " + requestDTO.getTpn());
                }
            }
            log.info("Terminada notificacion por correo electronico");

        } catch (Exception ex) {
            log.info("Error sending Email to merchant, trace: " + ex.getMessage(),ex);
        }


    }
}

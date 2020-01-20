package com.gcs.deoxys;


import com.gcs.deoxys.types.SMSRequestDTO;
import com.gcs.deoxys.types.TransactionRequestDTO;
import com.gcs.deoxys.types.xml.MerchantXmlType;
import com.gcs.deoxys.process.NotificationDataGet;
import com.gcs.deoxys.services.ISMSSenderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component("sendSms")
public class SmsNotification {

    private Logger log = LogManager.getLogger(SmsNotification.class);

    @Autowired
    NotificationDataGet notificationDataGet;

    @Autowired
    ISMSSenderService ismsSenderService;

    /**
     * Clase para notificar por sms en base a un paquete de transacciones
     *
     * @param transactionRequestDTO
     */
    public void smsNotify(List<TransactionRequestDTO> transactionRequestDTO) {

        log.info("Realizando notificacion por SMS");

        MerchantXmlType merchantXmlType;

        SMSRequestDTO smsRequestDTO;
        try {

            //Se itera el paquete de transacciones a procesar
            for (TransactionRequestDTO requestDTO : transactionRequestDTO) {

                merchantXmlType = notificationDataGet.findMerchantInformationByTpn(requestDTO.getTpn());

                if (merchantXmlType.getTelco() != null && merchantXmlType.getTelephone() != null) {
                    smsRequestDTO = new SMSRequestDTO(requestDTO, merchantXmlType);

                    //Se envia la notificacion de pago por SMS a la transaccion
                    ismsSenderService.sendSMS(smsRequestDTO);
                } else {
                    log.info("No se encontro telefono o telco para TPN: " + requestDTO.getTpn());
                }

            }
            log.info("Realizada notificacion por SMS");

        } catch (Exception ex) {
            log.info("Error sending SMS to merchant, trace: " + ex.getMessage());
        }
    }

}

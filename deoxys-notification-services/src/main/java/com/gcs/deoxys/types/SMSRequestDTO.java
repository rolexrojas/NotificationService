package com.gcs.deoxys.types;

import com.gcs.deoxys.types.xml.MerchantXmlType;

/**
 * Created by yinfante on 8/24/17.
 */
public class SMSRequestDTO {

    private String msisdn;
    private String message;
    private String telco;

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTelco() {
        return telco;
    }

    public void setTelco(String telco) {
        this.telco = telco;
    }

    @Override
    public String toString() {
        return "SMSRequestDTO{" +
                "msisdn='" + msisdn + '\'' +
                ", message='" + message + '\'' +
                ", telco='" + telco + '\'' +
                '}';
    }


    public SMSRequestDTO(TransactionRequestDTO transactionRequestDTO, MerchantXmlType merchantXmlType) {

        this.setMsisdn(merchantXmlType.getTelephone());
        this.setTelco(merchantXmlType.getTelco());
        this.setMessage("Estimado cliente, ha recibido una transferencia de RD$"+ transactionRequestDTO.getTransactionAmount() +" desde cta: " + transactionRequestDTO.getOriginAccount()+" mediante tPago QR. Transaccion #" + transactionRequestDTO.getAuthorizationNumber());
    }
}

package com.gcs.deoxys.types;

import com.gcs.deoxys.types.xml.MerchantXmlType;
import com.gcs.deoxys.util.MerchantUtil;

public class MerchantPaymentDTO {

    private String merchantDescription;

    private String transactionAmount;

    private String currency;

    private String destinationAccountNumber;

    private String sourceAccountNumber;

    private String sourceAccountName;

    private String transactionDate;

    private String transactionNumber;

    private String recipient;

    public MerchantPaymentDTO(TransactionRequestDTO transactionRequestDTO, MerchantXmlType merchantXmlType) {

        this.setMerchantDescription(transactionRequestDTO.getMerchant_description());
        this.setTransactionAmount(transactionRequestDTO.getTransactionAmount().toString());
        this.setCurrency("DOP");

        this.setDestinationAccountNumber("****" + MerchantUtil.parseAccountNumber(transactionRequestDTO.getPaymentMethod()));
        this.setSourceAccountNumber("Ahorros o Corriente ");
        this.setSourceAccountNumber(this.getSourceAccountNumber() + transactionRequestDTO.getOriginAccount());

        this.setTransactionDate(MerchantUtil.formatDateToString(transactionRequestDTO.getTransactionDate(), "dd/M/yyyy hh:mm a"));

        this.setSourceAccountName(MerchantUtil.parseMsisdn(merchantXmlType.getTelephone()));

        this.setTransactionNumber(transactionRequestDTO.getAuthorizationNumber());
        this.setRecipient(merchantXmlType.getEmail());
    }

    public MerchantPaymentDTO(TransactionRequestDTO requestDTO) {
    }

    public String getMerchantDescription() {
        return merchantDescription;
    }

    public void setMerchantDescription(String merchantDescription) {
        this.merchantDescription = merchantDescription;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDestinationAccountNumber() {
        return destinationAccountNumber;
    }

    public void setDestinationAccountNumber(String destinationAccountNumber) {
        this.destinationAccountNumber = destinationAccountNumber;
    }

    public String getSourceAccountNumber() {
        return sourceAccountNumber;
    }

    public void setSourceAccountNumber(String sourceAccountNumber) {
        this.sourceAccountNumber = sourceAccountNumber;
    }

    public String getSourceAccountName() {
        return sourceAccountName;
    }

    public void setSourceAccountName(String sourceAccountName) {
        this.sourceAccountName = sourceAccountName;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
}

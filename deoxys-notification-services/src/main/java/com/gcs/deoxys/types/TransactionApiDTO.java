package com.gcs.deoxys.types;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.gcs.deoxys.util.MerchantUtil;

import java.math.BigDecimal;

public class TransactionApiDTO {


    @JsonProperty("MerchantId")
    private String MerchantId;

    @JsonProperty("TerminalId")
    private String TerminalId;

    @JsonProperty("TransactionDate")
    private String TransactionDate;

    @JsonProperty("TransactionTime")
    private String TransactionTime;

    @JsonProperty("Amount")
    private BigDecimal Amount;

    @JsonProperty("Currency")
    private String Currency;

    @JsonProperty("TransactionType")
    private String TransactionType;

    @JsonProperty("AuthorizationCode")
    private String AuthorizationCode;

    @JsonProperty("TransactionNumber")
    private String TransactionNumber;

    @JsonProperty("MDRRatePercent")
    private BigDecimal MDRRatePercent;

    @JsonProperty("MDRRateAmount")
    private BigDecimal MDRRateAmount;

    @JsonProperty("TaxRetained")
    private BigDecimal TaxRetained;

    @JsonProperty("CommissionAZUL")
    private BigDecimal CommissionAZUL;

    @JsonProperty("CommissionGCS")
    private BigDecimal CommissionGCS;

    @JsonProperty("CommissionIssuingBank")
    private String CommissionIssuingBank;

    @JsonProperty("OriginAccountNumber")
    private String OriginAccountNumber;

    @JsonProperty("DestinationAccountNumber")
    private String DestinationAccountNumber;

    public TransactionApiDTO(TransactionRequestDTO transactionRequestDTO) {


        this.setMerchantId(transactionRequestDTO.getTpn().substring(4));
        this.setTerminalId(" ");

        this.setTransactionDate(MerchantUtil.formatDateToString(transactionRequestDTO.getTransactionDate(), "yyyy-M-dd"));
        this.setTransactionTime(MerchantUtil.formatDateToString(transactionRequestDTO.getTransactionDate(), "hh:mm:ss"));

        this.setAmount(transactionRequestDTO.getTransactionAmount());
        this.setCurrency("DOP");
        this.setTransactionType(" ");
        this.setAuthorizationCode(transactionRequestDTO.getAuthorizationNumber());
        this.setTransactionNumber(" ");
        this.setMDRRatePercent(new BigDecimal(0));
        this.setMDRRateAmount(new BigDecimal(0));
        this.setTaxRetained(transactionRequestDTO.getItbis());
        this.setCommissionAZUL(new BigDecimal(0));
        this.setCommissionGCS(new BigDecimal(0));
        this.setCommissionIssuingBank(" ");
        this.setOriginAccountNumber(" ");
        this.setDestinationAccountNumber(" ");
    }

    public TransactionApiDTO() {

    }

    public String getMerchantId() {
        return MerchantId;
    }

    public void setMerchantId(String merchantId) {
        MerchantId = merchantId;
    }

    public String getTerminalId() {
        return TerminalId;
    }

    public void setTerminalId(String terminalId) {
        TerminalId = terminalId;
    }

    public String getTransactionDate() {
        return TransactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        TransactionDate = transactionDate;
    }

    public String getTransactionTime() {
        return TransactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        TransactionTime = transactionTime;
    }

    public BigDecimal getAmount() {
        return Amount;
    }

    public void setAmount(BigDecimal amount) {
        Amount = amount;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    public String getTransactionType() {
        return TransactionType;
    }

    public void setTransactionType(String transactionType) {
        TransactionType = transactionType;
    }

    public String getAuthorizationCode() {
        return AuthorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        AuthorizationCode = authorizationCode;
    }

    public String getTransactionNumber() {
        return TransactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        TransactionNumber = transactionNumber;
    }

    public BigDecimal getMDRRatePercent() {
        return MDRRatePercent;
    }

    public void setMDRRatePercent(BigDecimal MDRRatePercent) {
        this.MDRRatePercent = MDRRatePercent;
    }

    public BigDecimal getMDRRateAmount() {
        return MDRRateAmount;
    }

    public void setMDRRateAmount(BigDecimal MDRRateAmount) {
        this.MDRRateAmount = MDRRateAmount;
    }

    public BigDecimal getTaxRetained() {
        return TaxRetained;
    }

    public void setTaxRetained(BigDecimal taxRetained) {
        TaxRetained = taxRetained;
    }

    public BigDecimal getCommissionAZUL() {
        return CommissionAZUL;
    }

    public void setCommissionAZUL(BigDecimal commissionAZUL) {
        CommissionAZUL = commissionAZUL;
    }

    public BigDecimal getCommissionGCS() {
        return CommissionGCS;
    }

    public void setCommissionGCS(BigDecimal commissionGCS) {
        CommissionGCS = commissionGCS;
    }

    public String getCommissionIssuingBank() {
        return CommissionIssuingBank;
    }

    public void setCommissionIssuingBank(String commissionIssuingBank) {
        CommissionIssuingBank = commissionIssuingBank;
    }

    public String getOriginAccountNumber() {
        return OriginAccountNumber;
    }

    public void setOriginAccountNumber(String originAccountNumber) {
        OriginAccountNumber = originAccountNumber;
    }

    public String getDestinationAccountNumber() {
        return DestinationAccountNumber;
    }

    public void setDestinationAccountNumber(String destinationAccountNumber) {
        DestinationAccountNumber = destinationAccountNumber;
    }
}

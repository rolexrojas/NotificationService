package com.gcs.deoxys.types;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "TransactionRequestDTO")
@Table(name = "bpdvw")
@NamedQuery(name = "searchTransactionPoll", query = "SELECT tr FROM TransactionRequestDTO tr " +
                                                    "WHERE tr.gcsSequenceNo > :lastProcessedTransaction " +
                                                    "ORDER BY tr.gcsSequenceNo ASC")

@NamedQuery(name = "searchRangeTransactions", query = "SELECT tr FROM TransactionRequestDTO tr " +
        "WHERE tr.transactionDate BETWEEN " +
        "CURRENT_DATE - 1" +
        "AND " +
        "current_date " +
        "ORDER BY tr.gcsSequenceNo ASC")

public class TransactionRequestDTO {


    @Column(name = "\"fecha_transaccion\"")
    private Date transactionDate;
    @Column(name = "\"Medio_de_pago\"")
    private String paymentMethod;
    @Column(name = "\"RNC\"")
    private long rnc;
    @Column(name = "\"Numero_de_afiliado\"")
    private String tpn;
    @Column(name = "\"Nombre_comercial\"")
    private String merchant_description;
    @Id
    @Column(name = "\"gcs_sequenceno\"")
    private int gcsSequenceNo;
    @Column(name = "\"No_Autorizacion_Transaccion\"")
    private String authorizationNumber;
    @Column(name = "\"monto\"")
    private BigDecimal transactionAmount;
    @Column(name = "\"itbis\"")
    private BigDecimal itbis;
    @Column(name = "\"Comision\"")
    private BigDecimal transactionCharge;
    @Column(name = "\"Monto_Acreditado\"")
    private BigDecimal creditedAmount;

    @Column(name = "\"Origin_Account\"")
    private String originAccount;


    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public long getRnc() {
        return rnc;
    }

    public void setRnc(long rnc) {
        this.rnc = rnc;
    }

    public String getTpn() {
        return tpn;
    }

    public void setTpn(String tpn) {
        this.tpn = tpn;
    }

    public String getMerchant_description() {
        return merchant_description;
    }

    public void setMerchant_description(String merchant_description) {
        this.merchant_description = merchant_description;
    }

    public int getGcsSequenceNo() {
        return gcsSequenceNo;
    }

    public void setGcsSequenceNo(int gcsSequenceNo) {
        this.gcsSequenceNo = gcsSequenceNo;
    }

    public String getAuthorizationNumber() {
        return authorizationNumber;
    }

    public void setAuthorizationNumber(String authorizationNumber) {
        this.authorizationNumber = authorizationNumber;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public BigDecimal getItbis() {
        return itbis;
    }

    public void setItbis(BigDecimal itbis) {
        this.itbis = itbis;
    }

    public BigDecimal getTransactionCharge() {
        return transactionCharge;
    }

    public void setTransactionCharge(BigDecimal transactionCharge) {
        this.transactionCharge = transactionCharge;
    }

    public BigDecimal getCreditedAmount() {
        return creditedAmount;
    }

    public void setCreditedAmount(BigDecimal creditedAmount) {
        this.creditedAmount = creditedAmount;
    }

    public String getOriginAccount() {
        return originAccount;
    }

    public void setOriginAccount(String originAccount) {
        this.originAccount = originAccount;
    }
}
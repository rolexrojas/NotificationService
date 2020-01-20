package com.gcs.deoxys.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties {

    @Value("${process.delay.seconds}")
    private int processDelaySeconds;

    @Value("${process.transaction.amount}")
    private int processTransactionAmount;

    @Value("${spring.mail.username}")
    private String fromEmail;

    @Value("${transaxion.address}")
    private String transaxionAddress;

    @Value("${camel.https.keystore.route}")
    private String keystoreRoute;

    @Value("${camel.https.keystore.password}")
    private String keystorePassword;

    @Value("${camel.https.keystore.manager.password}")
    private String keystoreManagerPassword;

    @Value("${camel.https.request.url}")
    private String httpRequestUrl;

    @Value("${camel.file.generation.quartz2.cron.expression}")
    private String cronExpression;

    @Value("${camel.file.save.directory}")
    private String fileDirectory;

    @Value("${sdp.webservice.username}")
    private String sdpWebServiceUsername;

    @Value("${sdp.webservice.password}")
    private String sdpWebServicePassword;

    public int getProcessDelaySeconds() {
        return processDelaySeconds;
    }

    public void setProcessDelaySeconds(int processDelaySeconds) {
        this.processDelaySeconds = processDelaySeconds;
    }

    public int getProcessTransactionAmount() {
        return processTransactionAmount;
    }

    public void setProcessTransactionAmount(int processTransactionAmount) {
        this.processTransactionAmount = processTransactionAmount;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public String getTransaxionAddress() {
        return transaxionAddress;
    }

    public void setTransaxionAddress(String transaxionAddress) {
        this.transaxionAddress = transaxionAddress;
    }

    public String getKeystoreRoute() {
        return keystoreRoute;
    }

    public void setKeystoreRoute(String keystoreRoute) {
        this.keystoreRoute = keystoreRoute;
    }


    public String getKeystorePassword() {
        return keystorePassword;
    }

    public void setKeystorePassword(String keystorePassword) {
        this.keystorePassword = keystorePassword;
    }

    public String getKeystoreManagerPassword() {
        return keystoreManagerPassword;
    }

    public void setKeystoreManagerPassword(String keystoreManagerPassword) {
        this.keystoreManagerPassword = keystoreManagerPassword;
    }

    public String getHttpRequestUrl() {
        return httpRequestUrl;
    }

    public void setHttpRequestUrl(String httpRequestUrl) {
        this.httpRequestUrl = httpRequestUrl;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getFileDirectory() {
        return fileDirectory;
    }

    public void setFileDirectory(String fileDirectory) {
        this.fileDirectory = fileDirectory;
    }

    public String getSdpWebServiceUsername() {
        return sdpWebServiceUsername;
    }

    public void setSdpWebServiceUsername(String sdpWebServiceUsername) {
        this.sdpWebServiceUsername = sdpWebServiceUsername;
    }

    public String getSdpWebServicePassword() {
        return sdpWebServicePassword;
    }

    public void setSdpWebServicePassword(String sdpWebServicePassword) {
        this.sdpWebServicePassword = sdpWebServicePassword;
    }
}

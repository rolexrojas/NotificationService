package com.gcs.deoxys.services;

import com.gcs.deoxys.types.MerchantPaymentDTO;
import freemarker.template.TemplateException;
import org.springframework.scheduling.annotation.Async;

import java.io.IOException;
import java.util.Map;

public interface IMailSenderService {

    @Async
    void sendEmail(String to, String content, String subject, boolean isHtml);

    @Async
    void sendEmailFromTemplate(Map model, String to, String template, String titleKey) throws IOException, TemplateException;

    @Async
    void sendPaymentNotification(MerchantPaymentDTO merchantPaymentDTO) throws IOException, TemplateException;

}

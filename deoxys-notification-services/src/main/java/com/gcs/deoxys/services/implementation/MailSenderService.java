package com.gcs.deoxys.services.implementation;

import com.gcs.deoxys.config.ApplicationProperties;
import com.gcs.deoxys.services.IMailSenderService;
import com.gcs.deoxys.types.MerchantPaymentDTO;
import com.gcs.deoxys.util.Messages;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class MailSenderService implements IMailSenderService {

    private Logger logger = LogManager.getLogger(MailSenderService.class);

    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private Configuration freemarkerConfiguration;

    @Autowired
    private Messages messages;


    public void sendPaymentNotification(MerchantPaymentDTO merchantPaymentDTO) throws IOException, TemplateException {
        logger.debug("sending payment notification email.");

        Map<String, Object> model = new HashMap<>();
        model.put("merchantDescription", merchantPaymentDTO.getMerchantDescription());
        model.put("currency", merchantPaymentDTO.getCurrency());
        model.put("transactionAmount", merchantPaymentDTO.getTransactionAmount());
        model.put("destinationAccountNumber", merchantPaymentDTO.getDestinationAccountNumber());
        model.put("sourceAccountNumber", merchantPaymentDTO.getSourceAccountNumber());
        model.put("sourceAccountName", merchantPaymentDTO.getSourceAccountName());
        model.put("transactionDate", merchantPaymentDTO.getTransactionDate());
        model.put("transactionNumber", merchantPaymentDTO.getTransactionNumber());


        sendEmailFromTemplate(model, merchantPaymentDTO.getRecipient(), "fm_notification_payment.ftl", "account.confirmation.email.payment");

    }

    @Override
    @Async
    public void sendEmailFromTemplate(final Map model, final String to, final String template, final String titleKey) throws IOException, TemplateException {

        String content = FreeMarkerTemplateUtils.processTemplateIntoString(
                freemarkerConfiguration.getTemplate(template), model);

        String subject = messages.get(titleKey);

        sendEmail(to, content, subject, true);
    }

    @Override
    @Async
    public void sendEmail(final String to, final String content, final String subject, final boolean isHtml) {

        logger.info("sending email ");

        MimeMessagePreparator preparator = new MimeMessagePreparator() {

            public void prepare(MimeMessage mimeMessage) throws Exception {

                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

                helper.setFrom(applicationProperties.getFromEmail(), messages.get(applicationProperties.getFromEmail()));
                helper.setSubject(subject);
                helper.setTo(to);
                // use the true flag to indicate you need a multipart message
                helper.setText(content, isHtml);

            }
        };

        emailSender.send(preparator);

        logger.info("email sent");
    }
}

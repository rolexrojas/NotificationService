package com.gcs.deoxys.services.implementation;

import com.gcs.deoxys.config.ApplicationProperties;
import com.gcs.deoxys.types.SMSRequestDTO;
import com.gcs.deoxys.services.ISMSSenderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class SMSSenderService implements ISMSSenderService {

    private Logger logger = LogManager.getLogger(SMSSenderService.class);

    @Autowired
    private ApplicationProperties applicationProperties;

    @Override
    @Async
    public void sendSMS(SMSRequestDTO smsRequestDTO) {

        logger.debug("sending SMS");

        logger.debug(smsRequestDTO);

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.postForObject(applicationProperties.getTransaxionAddress() + "/sms-sender", smsRequestDTO, String.class);

        logger.debug("SMS sent ");
    }

}

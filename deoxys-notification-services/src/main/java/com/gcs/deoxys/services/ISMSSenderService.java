package com.gcs.deoxys.services;

import com.gcs.deoxys.types.SMSRequestDTO;
import org.springframework.scheduling.annotation.Async;

public interface ISMSSenderService {
    @Async
    void sendSMS(SMSRequestDTO smsRequestDTO);
}

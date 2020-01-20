package com.gcs.deoxys.routes;

import com.gcs.deoxys.config.ApplicationProperties;
import org.apache.camel.builder.RouteBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@SuppressWarnings("unchecked")
@Component
public class ReadUploadFileRoutes extends RouteBuilder {

    private Logger logger = LogManager.getLogger(ReadUploadFileRoutes.class);

    @Autowired
    private ApplicationProperties applicationProperties;


    @Override
    public void configure() {


       from("quartz2://scheduler?cron=" + applicationProperties.getCronExpression())
                .to("jpa://com.gcs.types.TransactionRequestDTO?namedQuery=searchRangeTransactions" +
                        "&persistenceUnit=transactions" +
                        "&consumeDelete=false&consumeLockEntity=false")
                .to("freemarker://templates/fm_sdp_transactions_file.ftl?" +
                        "contentCache=false")
                .toD("file:" + applicationProperties.getFileDirectory() + "?fileName=QRCodePAYED${date:now:yyyyMMdd}.csv");

    }
}

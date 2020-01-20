package com.gcs.deoxys.process;

import com.gcs.deoxys.config.ApplicationProperties;
import com.gcs.deoxys.types.xml.MerchantListXmlType;
import com.gcs.deoxys.types.xml.MerchantXmlType;
import com.gcs.deoxys.util.MarshalUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class NotificationDataGet {

    private Logger log = LogManager.getLogger(NotificationDataGet.class);

//    public static final String CONFIG_FILE_PATH = "/merchant-config/merchant-config.xml";
    @Value("${notification.merchant.file}")
    public String CONFIG_FILE_PATH ;


    private ApplicationProperties applicationProperties;
    private MarshalUtil marshalUtil;

    @Autowired
    public NotificationDataGet(ApplicationProperties applicationProperties, MarshalUtil marshalUtil) {
        this.applicationProperties = applicationProperties;
        this.marshalUtil = marshalUtil;
    }

    @PostConstruct
    private void postConstruct() {
        log.info("Entering in post Construct");
        log.info("validation location file");

        Path PATH = Paths.get(CONFIG_FILE_PATH);

        if (!Files.exists(PATH) && !Files.isReadable(PATH)) {
            throw new RuntimeException("Error while validating config merchant file");
        }
    }


    public MerchantXmlType findMerchantInformationByTpn(String tpn) throws IOException, JAXBException {
        log.info("Entering in method findMerchantInformationByTpn");
        log.info("param tpn : " + tpn);

        Stream<String> stream = Files.lines(Paths.get(CONFIG_FILE_PATH));
        String data = stream.collect(Collectors.joining("\n"));

        log.info("find merchant config file found ");
        log.debug("###### DATA XML : \n  "+data);
        stream.close();

        MerchantListXmlType list = marshalUtil.parseToObject(data, MerchantListXmlType.class);

        log.info("parse merchant config file ");

        MerchantXmlType merchantXmlType = list.getListMerchants().stream()
                .filter(x -> tpn.equals(x.getTpn()))
                .findAny()
                .orElse(new MerchantXmlType());

        return merchantXmlType;
    }

}

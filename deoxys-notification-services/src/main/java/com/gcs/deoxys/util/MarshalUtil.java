package com.gcs.deoxys.util;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Component
public class MarshalUtil {


    public String parseToXml(Object obj) throws JAXBException {

        JAXBContext jaxbContextRequest = JAXBContext.newInstance(obj.getClass());
        Marshaller jaxbMarshaller = jaxbContextRequest.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter stringWriter = new StringWriter();
        jaxbMarshaller.marshal(obj, stringWriter);

        return stringWriter.toString();
    }

    public <T> T parseToObject(String objString, Class<T> type) throws JAXBException {

        InputStream stream = new ByteArrayInputStream(objString.getBytes(StandardCharsets.UTF_8));

        JAXBContext jaxbContextResponse = JAXBContext.newInstance(type);

        Unmarshaller jaxbUnmarshaller = jaxbContextResponse.createUnmarshaller();

        return (T) jaxbUnmarshaller.unmarshal(stream);
    }

    public String convert(InputStream inputStream, Charset charset) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, charset))) {
            return br.lines().collect(Collectors.joining(System.lineSeparator()));
        }
    }
}

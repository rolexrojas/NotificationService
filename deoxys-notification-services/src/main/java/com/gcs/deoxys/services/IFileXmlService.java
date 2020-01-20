package com.gcs.deoxys.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IFileXmlService {

    /**
     *
     * @param file
     * @return String
     * @throws IOException
     */
    String saveFileUpload(MultipartFile file) throws IOException;

}

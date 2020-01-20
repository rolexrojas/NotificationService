package com.gcs.deoxys.resources;

import com.gcs.deoxys.types.xml.MerchantListXmlType;
import com.gcs.deoxys.services.IFileXmlService;
import com.gcs.deoxys.util.MarshalUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/file")
public class FileUploadController {

    private Logger log = LogManager.getLogger(FileUploadController.class);

    @Autowired
    private MarshalUtil marshalUtil;

    private IFileXmlService iFileXmlService;

    @Autowired
    public FileUploadController(IFileXmlService iFileXmlService){
        this.iFileXmlService = iFileXmlService;
    }

    @PostMapping("/uploadFile")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        log.info("Entering method uploadFile");
        try{
            log.info("parse entry xml");
            String content = new String(file.getBytes(), "UTF-8");
            MerchantListXmlType list = marshalUtil.parseToObject(content, MerchantListXmlType.class);
            log.info("content parser : "+list );

            iFileXmlService.saveFileUpload(file);
        }catch (Exception ex){
            log.info("Error in elaboration File: "+ ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok().body("file is safe");
    }


    @GetMapping("/downloadFile/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable("fileName") String fileName) {

        String contentType = "application/octet-stream";
        Resource resource =  null;

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

}

package com.backend.eindopdracht.musictool.service;

import com.backend.eindopdracht.musictool.exceptions.FileStorageException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;

@Service
public class FileUploadService {

    @Value("${app.upload.dir:${user.home}}")
    public String uploadDir;

    //dit was eerst MultipartFile
    public void uploadFile(MultipartFile file) {

        try {
            Path copyLocation = Paths.get(uploadDir + File.separator + StringUtils.cleanPath(file.getOriginalFilename()
            ));
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch(Exception e) {
            e.printStackTrace();
            throw new FileStorageException("File " + file.getOriginalFilename() + "was not stored. Please try again");
        }
    }
}

// na uploaden moet ie ook worden opgeslagen

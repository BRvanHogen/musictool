package com.backend.eindopdracht.musictool.controller;

import com.backend.eindopdracht.musictool.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.util.Base64;

@Controller
public class FileUploadController {

    @Autowired
    FileUploadService fileUploadService;
// op regel 18 had ik MultipartFile file, even aangepast naar File file... ging niet.
    @PostMapping("/upload-file")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        fileUploadService.uploadFile(file);
        redirectAttributes.addFlashAttribute("message", "Uploading" + file.getOriginalFilename() + "was successful!");

        return "redirect:/";
    }
}

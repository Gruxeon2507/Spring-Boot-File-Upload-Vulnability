package com.example.fileuploadvul.controller;

import java.io.File;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AppController {
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "Hello World");
        return "hello";
    }
    @GetMapping("/hi")
    public String hello2(Model model) {
        model.addAttribute("message", "Hello World");
        return "hello";
    }
    @PostMapping("/hi")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            // File is not selected for upload
            return "hi";
        }

        try {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            File destFile = new File("../../../../../../home/kmd/FPTU-LABIA/fileuploadvul/src/main/webapp/WEB-INF/views/" + fileName);
            file.transferTo(destFile);
            
            // File saved successfully
            return "hi";
        } catch (IOException e) {
            // Error occurred while saving the file
            e.printStackTrace();
            return "hi";
        }
    }
}

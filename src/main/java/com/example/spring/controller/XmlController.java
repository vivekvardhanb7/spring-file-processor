package com.example.spring.controller;


import com.example.spring.service.XmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
@RequestMapping("/xml")
public class XmlController {

    @Autowired
    private XmlService xmlService;

    @PostMapping("/convert")  // ✅ Change endpoint to match your request
    public String convertXmlToJson(@RequestParam("file") MultipartFile file) throws IOException {
        return xmlService.convertXmlToJson(file);
    }
}


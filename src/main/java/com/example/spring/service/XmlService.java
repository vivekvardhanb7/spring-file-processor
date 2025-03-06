package com.example.spring.service;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
@Service
public class XmlService {

    private static final String OUTPUT_PATH = "C:/temp/output.json";

    public String convertXmlToJson(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IOException("Uploaded XML file is empty!");
        }

        // Convert XML to JSON
        XmlMapper xmlMapper = new XmlMapper();
        JsonNode xmlTree = xmlMapper.readTree(file.getInputStream()); // Read XML as a tree structure

        ObjectMapper jsonMapper = new ObjectMapper();
        String jsonString = jsonMapper.writeValueAsString(xmlTree);

        // Save the JSON file
        File outputFile = new File(OUTPUT_PATH);
        jsonMapper.writeValue(outputFile, xmlTree);

        return "JSON file saved successfully at: " + OUTPUT_PATH;
    }
}

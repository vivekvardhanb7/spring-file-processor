package com.example.spring.utils;


import com.opencsv.CSVReader;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.util.*;

public class CsvHelper {

    public static List<Map<String, String>> readCsv(MultipartFile file) throws Exception {
        List<Map<String, String>> dataList = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream()))) {
            List<String[]> records = reader.readAll();
            if (records.isEmpty()) {
                throw new Exception("CSV file is empty!");
            }

            String[] headers = records.get(0); // First row as headers
            for (int i = 1; i < records.size(); i++) {
                String[] values = records.get(i);
                Map<String, String> rowData = new LinkedHashMap<>();
                for (int j = 0; j < headers.length; j++) {
                    rowData.put(headers[j], j < values.length ? values[j] : ""); // Handle missing values
                }
                dataList.add(rowData);
            }
        }
        return dataList;
    }
}
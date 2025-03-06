package com.example.spring.service;
import com.example.spring.utils.ExcelHelper;
import com.example.spring.utils.CsvHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import java.util.Map;



@Service
public class FileService {

    public List<Map<String, String>> processExcelCsv(MultipartFile file, int startRow) throws Exception {
        if (file.isEmpty()) {
            throw new Exception("File is empty!");
        }

        String fileName = file.getOriginalFilename();
        if (fileName == null) {
            throw new Exception("File name is invalid!");
        }

        if (fileName.endsWith(".csv")) {
            return CsvHelper.readCsv(file);
        } else if (fileName.endsWith(".xlsx") || fileName.endsWith(".xls")) {
            return ExcelHelper.readExcel(file, startRow);
        } else {
            throw new Exception("Unsupported file format! Please upload CSV or Excel.");
        }
    }
}

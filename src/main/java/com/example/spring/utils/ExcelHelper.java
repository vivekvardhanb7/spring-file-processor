package com.example.spring.utils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.*;


public class ExcelHelper {

    public static List<Map<String, String>> readExcel(MultipartFile file, int startRow) throws IOException {
        List<Map<String, String>> data = new ArrayList<>();
        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        int rowNum = 0;
        List<String> headers = new ArrayList<>();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            if (rowNum < startRow) {
                rowNum++;
                continue;
            }

            Map<String, String> rowData = new LinkedHashMap<>();
            int cellNum = 0;
            for (Cell cell : row) {
                if (rowNum == startRow) {
                    headers.add(cell.toString());
                } else {
                    rowData.put(headers.get(cellNum), cell.toString());
                }
                cellNum++;
            }

            if (!rowData.isEmpty()) {
                data.add(rowData);
            }
            rowNum++;
        }
        workbook.close();
        return data;
    }
}

package com.archive.log.service;

import com.archive.log.util.helper.exel.ExcelHelper;
import com.archive.log.model.LogEntry;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.util.List;

public class ExcelService {
    public static void createExcelFile(List<LogEntry> data, String fileName , String directory) {
        try (Workbook workbook = new HSSFWorkbook()) {

            Sheet sheet = workbook.createSheet("Library Books");

            String[] headers = data.get(0).toArrayHeader();

            ExcelHelper.createHeaderRow(sheet , headers);

            for (int i = 0; i < data.size(); i++) {
                ExcelHelper.createBodyRow(sheet, i, data.get(i).toArrayValue());
            }


            ExcelHelper.autoSizeColumns(sheet, headers);

            ExcelHelper.saveWorkbook(workbook, fileName , directory);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ExcelService excelService = new ExcelService();
        LogService logService = new LogService();

        List<LogEntry> logEntries = List.of(
                logService.info("Select directory",logService),
                logService.erorr("Directory selected",logService),
                logService.info("Directory not selected successfully",logService)
        );

        createExcelFile(logEntries, "aftas", "logs");

    }

}

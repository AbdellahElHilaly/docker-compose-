package com.archive.log.util.helper.exel;

import com.archive.log.util.helper.LogicHelper;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class ExcelHelper {

    public static CellStyle getTitleStyle(Workbook workbook) {
        CellStyle titleStyle = workbook.createCellStyle();

        Font titleFont = workbook.createFont();
        titleFont.setBold(true);
        titleFont.setFontHeightInPoints((short) 14);
        titleStyle.setFont(titleFont);

        return titleStyle;
    }

    public static CellStyle getHeaderStyle(Workbook workbook) {
        workbook.createCellStyle();
        CellStyle headerStyle = workbook.createCellStyle();


        headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        //add border
        headerStyle.setBorderBottom(BorderStyle.THIN);
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerStyle.setFont(headerFont);


        return headerStyle;
    }

    public static void createHeaderRow(Sheet sheet, String[] headers) {
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(getHeaderStyle(sheet.getWorkbook()));
        }
    }


    public static void createBodyRow(Sheet sheet, int i, String[] arrayValue) {
        Row dataRow = sheet.createRow(i + 1);
        CellStyle bodyStyle = createBodyStyle(sheet.getWorkbook()); // Create body style

        for (int j = 0; j < arrayValue.length; j++) {
            Cell cell = dataRow.createCell(j);
            cell.setCellValue(arrayValue[j]);
            cell.setCellStyle(bodyStyle);
        }
    }

    // Modify the createBodyStyle method to set the gray background
    public static CellStyle createBodyStyle(Workbook workbook) {
        CellStyle bodyStyle = workbook.createCellStyle();
        bodyStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex()); // Set gray background color
        bodyStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND); // Set fill pattern
        // Customize other body cell styles here if needed
        return bodyStyle;
    }


    public static void autoSizeColumns(Sheet sheet,  String[] headers) {
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }
    }

    public static void saveWorkbook(Workbook workbook, String fileName , String directory) {

        fileName+= " " + LogicHelper.formatDateTime(new Date());
        String filePath = directory + fileName + ".xls";

        File file = new File(filePath);
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            workbook.write(fileOutputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

package com.archive.log.util.helper;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileHelper {
    public static String getUserDirectory() {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile().getAbsolutePath();
        }

        return null;
    }

    public static String getFilePath(String directory, String fileName, String xls) {
        return directory+ "\\" + fileName + "." + xls;
    }

    public static String getDownloadsDirectory() {
        return System.getProperty("user.home") + "/Downloads/";
    }

    public static PrintWriter openFileForWriting(String filePath) throws IOException {
        return new PrintWriter(new BufferedWriter(new FileWriter(filePath)));
    }

    public static void writeHeader(PrintWriter writer, String[] headers) {
        for (int i = 0; i < headers.length; i++) {
            writer.print(headers[i]);
            if (i != headers.length - 1) {
                writer.print(",");
            }
        }
        writer.println();
    }

    public static <T> void writeExcelRowData(PrintWriter writer, String[] data) {

        try (Workbook workbook = new HSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Library Books");

            for (int i = 0; i < data.length; i++) {
                Row dataRow = sheet.createRow(i + 1);
                dataRow.createCell(i).setCellValue(data[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void closeFile(PrintWriter writer) {
        writer.close();
    }
}

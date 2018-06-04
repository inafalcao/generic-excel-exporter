package com.inafalcao;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;

public class GenericExcelExporter {

    private ColumnHandler columnHandler;
    //private StyleHandler styleHandler;

    public GenericExcelExporter(List<?> table) {
        this.columnHandler = new ColumnHandler(table);
    }

    public void export() {

        Workbook workbook = new XSSFWorkbook(); //or new HSSFWorkbook();

        Sheet sheet = workbook.createSheet("what name");

        // Build Header + body + adjust column to fit the contents.
        headerRow(sheet, workbook);
        body(sheet, workbook);
        StyleHandler.autoziseColumns(sheet, columnHandler.columnCount());

        // Return file name or stream?
        try (OutputStream fileOut = new FileOutputStream("workbook.xls")) {
            workbook.write(fileOut);
        } catch(IOException ex) {
            // todo
            ex.printStackTrace();
        }

    }

    private void body(Sheet sheet, Workbook workbook) {
        
        List<List<String>> data = columnHandler.getData();

        for(int j = 0; j < data.size(); j++) {

            Row row = sheet.createRow(j+1);

            for (int i = 0; i < data.get(j).size(); i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(data.get(j).get(i));
                cell.setCellStyle(StyleHandler.bodyStyle(workbook));
            }
        }

        //return header;
    }

    private Row headerRow(Sheet sheet, Workbook workbook) {
        Row header = sheet.createRow(0);
        List<String> fields = columnHandler.getFields();

        for (int i = 0; i < fields.size(); i++) {
            Cell cell = header.createCell(i);
            cell.setCellValue(fields.get(i));
            cell.setCellStyle(StyleHandler.headerStyle(workbook));
        }

        return header;
    }


}

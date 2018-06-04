package com.inafalcao;

import org.apache.poi.ss.usermodel.*;

import java.util.stream.IntStream;


public class StyleHandler {

    public static CellStyle headerStyle(Workbook workbook) {
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setColor(IndexedColors.BLACK.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        headerCellStyle.setBorderBottom(BorderStyle.THICK);

        headerCellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        headerCellStyle.setAlignment(HorizontalAlignment.RIGHT);
        headerCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        return headerCellStyle;
    }

    public static CellStyle bodyStyle(Workbook workbook) {
        Font bodyFont = workbook.createFont();
        bodyFont.setFontHeightInPoints((short) 12);
        bodyFont.setColor(IndexedColors.BLACK.getIndex());

        CellStyle bodyCellStyle = workbook.createCellStyle();
        bodyCellStyle.setFont(bodyFont);
        bodyCellStyle.setAlignment(HorizontalAlignment.RIGHT);
        bodyCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        return bodyCellStyle;
    }

    public static void autoziseColumns(Sheet sheet, int columnRange) {
        IntStream.range(0, columnRange).forEach(sheet::autoSizeColumn);
    }

}

package com.inafalcao;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;


public class StyleHandler {

    /*public void defaultStyle(Workbook workbook) {
        headerStyle(workbook);

    }*/

    public static CellStyle headerStyle(Workbook workbook) {
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.BLUE_GREY.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        headerCellStyle.setFillBackgroundColor(IndexedColors.LIGHT_BLUE.getIndex());

        return headerCellStyle;
    }

    public static CellStyle bodyStyle(Workbook workbook) {
        Font bodyFont = workbook.createFont();
        bodyFont.setFontHeightInPoints((short) 12);
        bodyFont.setColor(IndexedColors.BLACK.getIndex());

        CellStyle bodyCellStyle = workbook.createCellStyle();
        bodyCellStyle.setFont(bodyFont);

        return bodyCellStyle;
    }

}

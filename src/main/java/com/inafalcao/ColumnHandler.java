package com.inafalcao;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class ColumnHandler {

    private final List<?> list;
    private Class clazz;

    public ColumnHandler(List<?> list) {
        this.list = list;
        // what if list is empty?
        if(hasList()) this.clazz = list.get(0).getClass();
    }

    // todo: need to make a String matrix with
    // this is what I`m gonna need to export xml data.
    // 1. title
    // 2. rows
    /*public String[][] getMatrix() {
        // todo how to get field value?


    }*/

    /**
     * @return the number of rows, counting with the title row.
     */
    public int rowCount() {
        // If list is null or empty, xsl file is always gonna be empty.
        return (hasList()) ? list.size() + 1 : 0;
    }

    /**
     * @return The count of @ExcelColumn annotated fields..
     */
    public long columnCount() {
        // If list is null or empty, xls file is always gonna be empty.
        if(!hasList()) return 0;

        // todo: what about recursion in fields?
        Field[] fields = clazz.getDeclaredFields();
        final long count = Arrays.stream(fields).filter(field -> field.isAnnotationPresent(ExcelColumn.class)).count();

        return count;
    }

    private boolean hasList() {
        return list != null && !list.isEmpty();
    }

}

package com.inafalcao;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ColumnHandler {

    private final List<?> list;
    private Class clazz;

    public ColumnHandler(List<?> list) {
        this.list = list;
        // what if list is empty?
        if(hasList()) this.clazz = list.get(0).getClass();
    }

    /**
     * @return String data matrix.
     * @throws GenericExcelExporterException if SecurityManager does not allow changing field accessibility.
     */
    public List<List<String>> getData() {

        Field[] fields = clazz.getDeclaredFields();

        return list.stream().map(element -> {

                return Arrays.stream(fields).map(field -> {
                    try {
                        field.setAccessible(true); // because it's private
                        final Object fieldValue = field.get(element);
                        field.setAccessible(false);
                        return fieldValue != null ? fieldValue.toString() : "";
                    } catch(IllegalAccessException e) {
                        e.printStackTrace();
                        throw new GenericExcelExporterException();
                    }
                }).collect(Collectors.toList());

        }).collect(Collectors.toList());

    }

    /**
     * @return Title fields for the columns.
     */
    public List<String> getFields() {
        Field[] fields = clazz.getDeclaredFields();
        return Arrays.stream(fields)
                .filter(field -> field.isAnnotationPresent(ExcelColumn.class))
                .map(annotation -> annotation.getAnnotation(ExcelColumn.class).name())
                .collect(Collectors.toList());
    }

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

        return Arrays.stream(fields).filter(field -> field.isAnnotationPresent(ExcelColumn.class)).count();
    }

    private boolean hasList() {
        return list != null && !list.isEmpty();
    }

}

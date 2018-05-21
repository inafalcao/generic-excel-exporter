package com.inafalcao;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColumnHandlerTest {

    private List<TestReflection> list = new ArrayList<>();

    @Test
    void countColumnsTest() {
        TestReflection test = new TestReflection("Inafalcao", 2, true);
        list.add(test);
        ColumnHandler handler = new ColumnHandler(list);
        long columnCount = handler.columnCount();
        assertEquals(columnCount, 4);
    }

    @Test
    void countRowsTest() {
        TestReflection test = new TestReflection("Inafalcao", 2, true);
        list.add(test);
        ColumnHandler handler = new ColumnHandler(list);
        long rowCount = handler.rowCount();
        // row + title
        assertEquals(rowCount, 2);
    }

    @Test
    void getFieldsTest() {
        TestReflection test = new TestReflection("Inafalcao", 2, true);
        list.add(test);
        ColumnHandler handler = new ColumnHandler(list);
        List<String> fields = handler.getFields();
        assertEquals(fields.size(), 4);
    }

    @Test
    void getDataTest() {
        TestReflection test = new TestReflection("Inafalcao", 2, true);
        list.add(test);
        ColumnHandler handler = new ColumnHandler(list);
        List<List<String>> data = handler.getData();
        assertEquals(data.get(0).size(), 4);
    }

}

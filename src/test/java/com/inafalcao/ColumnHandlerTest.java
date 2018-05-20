package com.inafalcao;

import org.junit.jupiter.api.Test;
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
        assertEquals(columnCount, 3);
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

}

package com.inafalcao;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenericExcelExporterTest {

    private List<TestReflection> list = new ArrayList<>();

    @Test
    void test() {
        TestReflection test = new TestReflection("Inafalcao", 2, true);
        list.add(test);
        ColumnHandler handler = new ColumnHandler(list);
        //List<List<String>> data = handler.getData();

        GenericExcelExporter exporter = new GenericExcelExporter(list);
        exporter.export();

        //assertEquals(data.get(0).size(), 4);
    }


}

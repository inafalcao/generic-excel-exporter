package com.inafalcao;

public class TestReflection {

    // todo: how to deal with column names internationalization??
    /**
     * Ex: @ExcelColumn(name = "Some name")
     */

    @ExcelColumn(name = "Field one!")
    private String fieldOne;

    @ExcelColumn(name = "Field two!")
    private int fieldTwo;

    @ExcelColumn(name = "Field three!")
    private boolean fieldThree;

    @ExcelColumn(name = "Recursive!")
    private TestRecursionLevelOne fieldFour;

    public TestReflection(String fieldOne, int fieldTwo, boolean fieldThree) {
        this.fieldOne = fieldOne;
        this.fieldTwo = fieldTwo;
        this.fieldThree = fieldThree;
    }

    public TestReflection(String fieldOne, int fieldTwo, boolean fieldThree, TestRecursionLevelOne fieldFour) {
        this.fieldOne = fieldOne;
        this.fieldTwo = fieldTwo;
        this.fieldThree = fieldThree;
        this.fieldFour = fieldFour;
    }

    public String getFieldOne() {
        return fieldOne;
    }

    public void setFieldOne(String fieldOne) {
        this.fieldOne = fieldOne;
    }

    public int getFieldTwo() {
        return fieldTwo;
    }

    public void setFieldTwo(int fieldTwo) {
        this.fieldTwo = fieldTwo;
    }

    public boolean isFieldThree() {
        return fieldThree;
    }

    public void setFieldThree(boolean fieldThree) {
        this.fieldThree = fieldThree;
    }
}

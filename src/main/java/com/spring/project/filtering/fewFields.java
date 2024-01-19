package com.spring.project.filtering;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class fewFields {
    private String field1;
    private String field2;
    @JsonIgnore
    private String field3;

    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    public String getField3() {
        return field3;
    }

    public fewFields(String value1, String value2, String value3) {
        super();
        this.field1=value1;
        this.field2=value2;
        this.field3=value3;
    }
}

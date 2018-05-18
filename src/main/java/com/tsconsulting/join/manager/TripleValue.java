package com.tsconsulting.join.manager;

public class TripleValue {
    private int id;
    private String value1;
    private String value2;

    public TripleValue(int id, String value1, String value2) {
        this.id = id;
        this.value1 = value1;
        this.value2 = value2;
    }

    public int getId() {
        return id;
    }

    public String getValue1() {
        return value1;
    }

    public String getValue2() {
        return value2;
    }
}

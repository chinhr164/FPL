package com.zrapp.moneylover.model;

public class IncomeType {
    private int id;
    private String name;

    public IncomeType() {
    }

    public IncomeType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

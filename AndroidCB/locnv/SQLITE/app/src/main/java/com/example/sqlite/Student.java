package com.example.sqlite;

public class Student {

    private String tenSV,maSV;
    private int id;

    public Student() {
    }

    public Student(int id, String maSV,String tenSV) {
        this.id = id;
        this.maSV = maSV;
        this.tenSV = tenSV;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }


}

package com.fpoly.lab6.bai3;

public class Student {
    private String name;
    private String email;
    private String tel;
    private String CIC;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTel() {
        return tel;
    }

    public void setCIC(String CIC) {
        this.CIC = CIC;
    }

    public String getCIC() {
        return CIC;
    }

    public Student(String name, String email, String tel, String CIC) {
        this.name = name;
        this.email = email;
        this.tel = tel;
        this.CIC = CIC;
    }
}

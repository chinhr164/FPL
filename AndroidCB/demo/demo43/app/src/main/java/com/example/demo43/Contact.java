package com.example.demo43;

public class Contact {
    private int color;
    private String name, phone;

    public Contact() {
    }

    public Contact(int color, String name, String phone) {
        this.color = color;
        this.name = name;
        this.phone = phone;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

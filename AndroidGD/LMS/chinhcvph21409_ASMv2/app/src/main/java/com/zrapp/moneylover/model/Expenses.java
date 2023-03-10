package com.zrapp.moneylover.model;

public class Expenses {
    private int id, id_ExT, price;
    private String name, date, user;

    public Expenses() {
    }

    public Expenses(int id, int id_ExT, String name, String date, int price, String user) {
        this.id = id;
        this.id_ExT = id_ExT;
        this.price = price;
        this.name = name;
        this.date = date;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_ExT() {
        return id_ExT;
    }

    public void setId_ExT(int id_ExT) {
        this.id_ExT = id_ExT;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}

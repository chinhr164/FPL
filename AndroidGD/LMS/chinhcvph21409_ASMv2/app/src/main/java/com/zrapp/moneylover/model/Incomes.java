package com.zrapp.moneylover.model;

public class Incomes {
    private int id, id_InT, price;
    private String name, date, user;

    public Incomes() {
    }

    public Incomes(int id, int id_InT, String name, String date, int price, String user) {
        this.id = id;
        this.id_InT = id_InT;
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

    public int getId_InT() {
        return id_InT;
    }

    public void setId_InT(int id_InT) {
        this.id_InT = id_InT;
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

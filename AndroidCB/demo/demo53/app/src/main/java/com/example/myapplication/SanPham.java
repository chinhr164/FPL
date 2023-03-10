package com.example.myapplication;

public class SanPham {
    private String id, name;
    private int qty;

    public SanPham() {
    }

    public SanPham(String id, String name, int qty) {
        this.id = id;
        this.name = name;
        this.qty = qty;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}

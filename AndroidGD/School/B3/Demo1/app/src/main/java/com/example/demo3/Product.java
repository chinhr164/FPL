package com.example.demo3;

public class Product {
    private int id, img_res;
    private String name;

    public Product() {
    }

    public Product(int id, String name, int img_res) {
        this.id = id;
        this.img_res = img_res;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImg_res() {
        return img_res;
    }

    public void setImg_res(int img_res) {
        this.img_res = img_res;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

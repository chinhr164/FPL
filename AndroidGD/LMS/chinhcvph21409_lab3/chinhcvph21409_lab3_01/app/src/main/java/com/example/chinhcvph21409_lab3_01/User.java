package com.example.chinhcvph21409_lab3_01;

public class User {
    private String id, name;
    private byte[] img_res;

    public User() {
    }

    public User(String id, String name, byte[] img_res) {
        this.id = id;
        this.name = name;
        this.img_res = img_res;
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

    public byte[] getImg_res() {
        return img_res;
    }

    public void setImg_res(byte[] img_res) {
        this.img_res = img_res;
    }
}

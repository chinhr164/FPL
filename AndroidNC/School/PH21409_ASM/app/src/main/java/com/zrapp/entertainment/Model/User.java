package com.zrapp.entertainment.Model;

public class User {
    private String username, password, name, tel, email;
    private byte[] avatar, cover;

    public User() {
    }

    public User(String name, String tel, String email) {
        this.name = name;
        this.tel = tel;
        this.email = email;
    }

    public User(byte[] avatar, byte[] cover) {
        this.avatar = avatar;
        this.cover = cover;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public byte[] getCover() {
        return cover;
    }

    public void setCover(byte[] cover) {
        this.cover = cover;
    }
}

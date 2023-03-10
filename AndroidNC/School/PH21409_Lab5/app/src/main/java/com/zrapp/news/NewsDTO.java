package com.zrapp.news;

public class NewsDTO {
    private String title, descip, img, link;

    public NewsDTO() {
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescip() {
        return descip;
    }

    public void setDescip(String descip) {
        this.descip = descip;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}

package com.zrapp.entertainment.Model;

import java.io.Serializable;

public class Song implements Serializable {
    private double id;
    private String title, artist, path;
    private long favorite;

    public Song() {
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getFavorite() {
        return favorite;
    }

    public void setFavorite(long favorite) {
        this.favorite = favorite;
    }
}

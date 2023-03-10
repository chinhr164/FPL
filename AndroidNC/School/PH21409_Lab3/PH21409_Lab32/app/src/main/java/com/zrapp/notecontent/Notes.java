package com.zrapp.notecontent;

public class Notes {
    private int id;
    private String tieuDe, noiDung, ngayThang;

    public Notes() {
    }

    public Notes(int id, String tieuDe, String noiDung, String ngayThang) {
        this.id = id;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.ngayThang = ngayThang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getNgayThang() {
        return ngayThang;
    }

    public void setNgayThang(String ngayThang) {
        this.ngayThang = ngayThang;
    }
}

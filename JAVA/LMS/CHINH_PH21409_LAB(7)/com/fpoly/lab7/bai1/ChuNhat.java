package com.fpoly.lab7.bai1;

public class ChuNhat {
    public double dai;
    public double rong;

    public ChuNhat(double dai, double rong) {
        this.dai = dai;
        this.rong = rong;
    }

    public void xuat() {
        System.out.println("\tChu vi: " + ((dai + rong) * 2));
        System.out.println("\tDiện tích: " + (dai * rong));
    }
}

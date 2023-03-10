package com.fpoly.lab7.bai2bai3bai4;

import java.util.Scanner;

public class SinhVienIT extends SinhVienPoly {
    public double diemJava;
    public double diemHtml;
    public double diemCss;

    public SinhVienIT(){}

    public SinhVienIT(String hoTen, String nganh, double diemJava, double diemHtml, double diemCss) {
        super(hoTen, nganh);
        this.diemJava = diemJava;
        this.diemHtml = diemHtml;
        this.diemCss = diemCss;
    }

    @Override
    public double getDiem() {
        return (2 * diemJava + diemHtml + diemCss) / 4;
    }

    @Override
    public void nhap() {
        super.nhap();
        nganh = "IT";
        System.out.print("\t\tĐiểm Java: ");
        diemJava = new Scanner(System.in).nextDouble();
        System.out.print("\t\tĐiểm Html: ");
        diemHtml = new Scanner(System.in).nextDouble();
        System.out.print("\t\tĐiểm Css: ");
        diemCss = new Scanner(System.in).nextDouble();
    }
}
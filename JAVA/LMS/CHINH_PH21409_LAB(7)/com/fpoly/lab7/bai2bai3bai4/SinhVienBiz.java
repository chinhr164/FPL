package com.fpoly.lab7.bai2bai3bai4;

import java.util.Scanner;

public class SinhVienBiz extends SinhVienPoly {
    public double diemMarketing;
    public double diemSales;

    public SinhVienBiz(String hoTen, String nganh, double diemMarketting, double diemSales) {
        super(hoTen, nganh);
        this.diemMarketing = diemMarketting;
        this.diemSales = diemSales;
    }

    public SinhVienBiz() {}

    @Override
    public double getDiem() {
        return (2 * diemMarketing + diemSales) / 3;
    }

    @Override
    public void nhap() {
        super.nhap();
        nganh = "Biz";
        System.out.print("\t\tĐiểm Marketing: ");
        diemMarketing = new Scanner(System.in).nextDouble();
        System.out.print("\t\tĐiểm Sales: ");
        diemSales = new Scanner(System.in).nextDouble();
    }
}


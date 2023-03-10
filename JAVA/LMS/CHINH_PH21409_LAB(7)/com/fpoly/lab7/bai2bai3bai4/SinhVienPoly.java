package com.fpoly.lab7.bai2bai3bai4;

import java.util.Scanner;

abstract class SinhVienPoly {
    public String hoTen;
    public String nganh;

    public SinhVienPoly() {}

    public SinhVienPoly(String hoTen, String nganh) {
        this.hoTen = hoTen;
        this.nganh = nganh;
    }

    abstract public double getDiem();

    public String getHocLuc() {
        if (getDiem() < 5) {return "Yếu";} else if (getDiem() < 6.5) {return "Trung bình";} else if (getDiem() < 7.5) {
            return "Khá";
        } else if (getDiem() < 9) {return "Giỏi";} else {
            return "Xuất sắc";
        }
    }

    public void nhap() {
        System.out.print("\tTên: ");
        hoTen = new Scanner(System.in).nextLine();
    }

    public void xuat() {
        System.out.printf("%-20s %-15s %-10.2f %-15s\n", hoTen, nganh, getDiem(), getHocLuc());
    }
}

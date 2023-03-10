package com.fpoly.assignment;

import com.fpoly.custom.XPoly;

import java.util.Scanner;

public abstract class NhanVien {

    public String manv, hoTen;
    private double luong;



    public NhanVien(){
    }

    public NhanVien(String manv, String hoTen, double luong) {
        this.manv = manv;
        this.hoTen = hoTen;
        this.luong = luong;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    abstract public double getThuNhap();

    public double getThue() {
        if (getThuNhap() < 9000000) {
            return 0;
        } else if (getThuNhap() <= 15000000) {
            return (getThuNhap() * 0.1);
        } else {
            return (getThuNhap() * 0.12);
        }
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\tMã nhân viên: ");
        manv = sc.nextLine().toUpperCase();
        System.out.print("\tTên nhân viên: ");
        hoTen = XPoly.toUpperFirstChar(sc.nextLine());
        System.out.print("\tLương: ");
        luong = Double.parseDouble(sc.nextLine());
    }

    public void xuat() {
        System.out.printf("%-10s %-20s %-15s %-15s\n", manv, hoTen, XPoly.numFomart(getThuNhap()),
                XPoly.numFomart(getThue()));
    }
}

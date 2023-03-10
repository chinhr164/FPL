package com.fpoly.lab4;

import java.util.Scanner;
import custom.XPoly;

public class NhanVien {

    String maNV, hoTen;
    double luong;

    Scanner sc = new Scanner(System.in);

    public double thue(double luong) {
        if (luong < 9000000) {
            return 0;
        }
        if (luong < 15000000) {
            return luong * 0.1;
        }
        if (luong < 25000000) {
            return luong * 0.15;
        } else {
            return luong * 0.2;
        }
    }

    public void nhap() {
        System.out.print("<> Nhập thông tin NV1\n");
        System.out.print(" - Mã NV: ");
        maNV = sc.nextLine().toUpperCase();
        System.out.print(" - Tên: ");
        hoTen = XPoly.toUpperFirstChar(sc.nextLine());
        System.out.print(" - Luong: ");
        luong = Double.parseDouble(sc.nextLine());
    }

    public void xuat() {
        System.out.printf("%-5d %-10s %-15s %-15s %-15s\n", 1, maNV, hoTen, XPoly.numFomart(luong),
                          XPoly.numFomart(thue(luong)));
    }

    public void input() {
        System.out.println("\n\t\t>< NHẬP THÔNG TIN NHÂN VIÊN ><\n");
        System.out.print("");
        nhap();
    }

    public void output() {
        System.out.println("\n\n\t\t>< DANH SÁCH NHÂN VIÊN ><\n");
        System.out.printf("%-5s %-10s %-15s %-15s %-15s\n", "STT", "Mã GV", "Họ tên", "Lương",
                          "Thuế");
        xuat();
    }

    public static void main(String[] args) {
        NhanVien code = new NhanVien();

        code.input();
        code.output();
    }
}

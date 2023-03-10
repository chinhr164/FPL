package com.fpoly.lab4;

import java.util.*;
import custom.XPoly;

public class GiaoVien {

    String maGV, hoTen;
    double diem;

    Scanner sc = new Scanner(System.in);

    public void nhap() {
        System.out.println("<> Nhập thông tin GV1:");
        System.out.print(" - Mã GV: ");
        maGV = sc.nextLine().toUpperCase();
        System.out.print(" - Tên: ");
        hoTen = XPoly.toUpperFirstChar(sc.nextLine());
        System.out.print(" - Điểm: ");
        diem = Double.parseDouble(sc.nextLine());
    }

    public String xepLoai(double diem) {
        if (diem < 50) {
            return "Yếu";
        }
        if (diem < 70) {
            return "Trung bình";
        } else {
            return "Tốt";
        }
    }

    public void xuat() {
        System.out.printf("%-5d %-10s %-15s %-10.2f %-15s\n", 1, maGV, hoTen, diem, xepLoai(diem));
    }

    public void input() {
        System.out.println("\n\t\t>< NHẬP THÔNG TIN GIÁO VIÊN ><\n");
        nhap();
    }

    public void output() {
        System.out.println("\n\n\t\t>< DANH SÁCH GIÁO VIÊN ><\n");
        System.out.printf("%-5s %-10s %-15s %-10s %-15s\n", "STT", "Mã GV", "Họ tên", "Điểm",
                          "Xếp loại");
        xuat();
    }

    public static void main(String[] args) {
        GiaoVien code = new GiaoVien();

        code.input();
        code.output();
    }
}

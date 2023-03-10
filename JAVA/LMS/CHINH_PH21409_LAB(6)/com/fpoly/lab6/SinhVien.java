package com.fpoly.lab6;

import java.util.*;

import custom.XPoly;

public class SinhVien {

    private String maSV, hoTen, email, sdt, cmnd;

    public String getMaSV() {
        return maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public SinhVien() {}

    public SinhVien(String maSV, String hoTen, String email, String sdt, String cmnd) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.email = email;
        this.sdt = sdt;
        this.cmnd = cmnd;
    }

    Scanner sc = new Scanner(System.in);

    public void nhap(int i) {
        while (true) {
            System.out.println("<> Nhập thông tin sinh viên thứ " + (i + 1));
            System.out.print("\t- Mã số SV: ");
            maSV = sc.nextLine().toUpperCase();
            System.out.print("\t- Tên: ");
            hoTen = XPoly.toUpperFirstChar(sc.nextLine());
            System.out.print("\t- Email: ");
            email = sc.nextLine();
            System.out.print("\t- Số điện thoại: ");
            sdt = sc.nextLine();
            System.out.print("\t- CCCD: ");
            cmnd = sc.nextLine();
            if (!(email.matches("^\\w+@[A-Za-z0-9]+[.A-Za-z0-9]+")) || !(sdt.matches("0+(\\d){9}"))
                    || !(cmnd.matches("\\d{12}"))) {
                if (!(email.matches("^\\w+@[A-Za-z0-9]+[.A-Za-z0-9]+"))) {
                    System.out.print("\nNhập lại email");
                }

                if (!(sdt.matches("0+(\\d){9}"))) {
                    System.out.print("\nNhập lại số điện thoại");
                }

                if (!(cmnd.matches("\\d{12}"))) {
                    System.out.print("\nNhập lại CMND");
                }
                System.out.println("\n____");
            } else {
                break;
            }
        }
    }

    public void xuat(int i) {
        System.out.printf("%-5d %-10s %-25s %-35s %-15s %-15s\n", i, getMaSV(), getHoTen(), getEmail(), getSdt(),
                getCmnd());
    }
}

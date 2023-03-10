package com.fpoly.lab4.bai3;

public class MainClass {

    public static void main(String[] args) {
        SanPham sp1 = new SanPham();
        SanPham sp2 = new SanPham();
        System.out.println("\n+++  QUẢN LÝ SẢN PHẨM +++\n");
        System.out.println("Nhập sản phẩm thứ nhất");
        sp1.input();
        System.out.println("\nNhập sản phẩm thứ hai");
        sp2.input();
        System.out.println("\n_____________");
        System.out.println("Thông sản phẩm thứ nhất");
        sp1.output();
        System.out.println("\nThông sản phẩm thứ hai");
        sp2.output();
    }

}

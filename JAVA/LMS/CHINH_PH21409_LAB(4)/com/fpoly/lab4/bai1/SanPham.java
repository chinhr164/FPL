package com.fpoly.lab4.bai1;

import java.util.Scanner;

public class SanPham {

    Scanner sc = new Scanner(System.in);

    String name;
    int price, discount;

    public double getImportTax(double price) {
        return (price * 0.1);
    }

    public void input() {
        System.out.print(" - Tên sản phẩm: ");
        name = sc.nextLine();
        System.out.print(" - Giá bán: ");
        price = Integer.parseInt(sc.nextLine());
        System.out.print(" - Giảm giá: ");
        discount = Integer.parseInt(sc.nextLine());
    }

    public void output() {
        System.out.println(" - Tên sản phẩm: " + name);
        System.out.println(" - Giá bán: " + price);
        System.out.println(" - Giảm giá: " + discount);
        System.out.println(" - Thuế sản phẩm: " + getImportTax(price));
    }
}

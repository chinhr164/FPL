package com.fpoly.lab4.bai3;

import java.util.Scanner;

public class SanPham {

    Scanner sc = new Scanner(System.in);

    private String name;
    private int price, discount;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return this.discount;
    }

    public SanPham() {
    }

    public SanPham(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public SanPham(String name, int price, int discount) {
        this(name, price);
        this.discount = discount;
    }

    private double getImportTax(double price) {
        return (price * 0.1);
    }


    public SanPham input() {
        System.out.print(" - Tên sản phẩm: ");
        name = sc.nextLine();
        System.out.print(" - Giá bán: ");
        price = Integer.parseInt(sc.nextLine());
        System.out.print("> Có mức giảm giá (Y/N) - ");
        if (sc.nextLine().equalsIgnoreCase("y")) {
            System.out.print(" - Giảm giá: ");
            discount = Integer.parseInt(sc.nextLine());
            return new SanPham(name, price, discount);
        } else {
            return new SanPham(name, price);
        }
    }

    public void output() {
        System.out.println(" - Tên sản phẩm: " + name);
        System.out.println(" - Giá bán: " + price);
        System.out.println(" - Giảm giá: " + discount);
        System.out.println(" - Thuế sản phẩm: " + getImportTax(price));
    }
}

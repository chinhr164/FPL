package com.poly.lab1;

import java.util.Scanner;

public class Product implements DAO {
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product() {}

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getImportTax() {
        return price * 0.1;
    }

    Scanner sc = new Scanner(System.in);

    public void nhap() {
        System.out.print("\t+ Tên sản phẩm: ");
        name = sc.nextLine();
        System.out.print("\t+ Giá sản phẩm: ");
        price = Double.parseDouble(sc.nextLine());
    }

    public void xuat(int index) {
        System.out.printf("%-5d %-30s %-12.0f %-10.0f\n", index + 1, name, price, getImportTax());
    }

    @Override
    public void insert(int index) {
        System.out.println("Thêm mới sản phẩm " + (index + 1) + " thành công!");
    }

    @Override
    public void update(int index) {
        System.out.println("Cập nhật sản phẩm " + (index + 1) + " thành công!");
    }

    @Override
    public void delete(int index) {
        System.out.println("Đã xóa sản phẩm " + (index + 1) + " thành công!");
    }

    @Override
    public void select(int index) {
        System.out.println("Chọn đối tượng sản phẩm " + (index + 1));
    }
}

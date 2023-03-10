package com.fpoly.lab6.bai2;

import java.util.ArrayList;
import java.util.Scanner;

public class Product {

    private String name;
    private double price;
    private String firm;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getFirm() {
        return firm;
    }

    public Product() {
    }

    public Product(String name, double price, String firm) {
        this.name = name;
        this.price = price;
        this.firm = firm;
    }

    static ArrayList<Product> productList = new ArrayList<>();

    public void input(int i) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập sản phẩm thứ %d\n", i + 1);
        System.out.print("\tNhập tên: ");
        name = sc.nextLine();
        System.out.print("\tNhập giá: ");
        price = Double.parseDouble(sc.nextLine());
        System.out.print("\tNhập hãng: ");
        firm = sc.nextLine();
        productList.add(new Product(name, price, firm));
        System.out.println("");
    }

    public void output() {
        int index = 1;
        System.out.println("+++ DANH SÁCH SẢN PHẨM HÃNG NOKIA +++");
        System.out.printf("\n%-5s %-30s %-15s %-15s", "STT", "Tên sản phẩm", "Giá bán",
                "Hãng SX");
        for (Product product : productList) {
            if (product.getFirm().equalsIgnoreCase("Nokia")) {
                System.out.printf("\n%-5d %-30s %-15.0f %-15s", index++, product.getName(),
                        product.getPrice(), product.getFirm());
            }
        }
    }
}

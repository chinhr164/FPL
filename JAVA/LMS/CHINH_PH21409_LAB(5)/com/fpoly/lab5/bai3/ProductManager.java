package com.fpoly.lab5.bai3;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
    Scanner sc = new Scanner(System.in);
    ArrayList<Product> productList = new ArrayList();

    public void input() {
        int index = 1;
        while (true) {
            System.out.printf("Nhập sản phẩm thứ %d\n", index);
            System.out.print("\tTên sản phẩm: ");
            String name = sc.nextLine();
            System.out.print("\tGiá bán: ");
            int price = Integer.parseInt(sc.nextLine());

            productList.add(new Product(name, price));

            System.out.print("Nhập thêm (Y/N)? - ");
            String check = sc.nextLine();
            if (check.equals("n") || check.equals("N"))
                break;
            index++;
        }
        output();
    }

    public void output() {
        int index = 1;
        System.out.print("\n+---------- DANH SÁCH SẢN PHẨM ----------+\n");
        System.out.printf("%-5s %-25s %-10s\n", "STT", "Tén sản phẩm", "Giá bán");
        for (Product product : productList) {
            System.out.printf("%-5d %-25s %-10d\n", index, product.getName(), product.getPrice());
            index++;
        }
        System.out.println("\n__________________________________________________________________________________");
    }

    public void soft() {
        System.out.println("Chọn loại sắp xếp");
        System.out.println("1. Sắp xếp theo tên");
        System.out.println("2. Sắp xếp theo đơn giá");
        System.out.print("Mời chọn: ");
        if (sc.nextLine().equals("1")) {
            System.out.println("\nChọn kiểu sắp xếp");
            System.out.println("1. Tăng dần");
            System.out.println("2. Giảm dần");
            System.out.print("Mời chọn: ");
            if (sc.nextLine().equals("1")) {
                productList.sort((sp1, sp2) -> sp1.getName().compareTo(sp2.getName()));
                System.out.print("\nSắp xếp danh sách theo thứ tự tên sản phẩm tâng dần.\n>\n>");
            } else {
                productList.sort((sp1, sp2) -> sp2.getName().compareTo(sp1.getName()));
                System.out.print("\nSắp xếp danh sách theo thứ tự tên sản phẩm giảm dần.\n<\n<");
            }
        } else {
            System.out.println("\nChọn kiểu sắp xếp");
            System.out.println("1. Tăng dần");
            System.out.println("2. Giảm dần");
            System.out.print("Mời chọn: ");
            if (sc.nextLine().equals("1")) {
                productList.sort((sp1, sp2) -> sp1.getPrice() - sp2.getPrice());
                System.out.print("\nSắp xếp danh sách theo thứ tự đơn giá tâng dần.\n>\n>");
            } else {
                productList.sort((sp1, sp2) -> sp2.getPrice() - sp1.getPrice());
                System.out.print("\nSắp xếp danh sách theo thứ tự đơn giá giảm dần.\n<\n<");
            }
        }
        output();
    }

    public void delete() {
        System.out.println("Nhập tên sản phẩm cần xoá: ");
        String del = sc.nextLine();
        Product product = null;
        for (Product product1 : productList) {
            if (product1.getName().equals(del)) {
                product = product1;
                break;
            }
        }
        if (product != null) {
            productList.remove(product);
            output();
        } else {
            System.out.printf("%s Không tồn tại trong danh sách.\n", del);
        }
    }

    public void ava() {
        double s = 0;
        for (Product product : productList) {
            s += product.getPrice();
        }
        System.out.printf("Giá trung bình các sản phẩm: %.2f", s / productList.size());
    }
}


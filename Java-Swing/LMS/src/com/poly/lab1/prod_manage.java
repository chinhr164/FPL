package com.poly.lab1;

import java.util.ArrayList;
import java.util.Scanner;

public class prod_manage {
    ArrayList<Product> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    int n;

    public void input() {
        for (int i = 0; i < 5; i++) {
            System.out.println("\n<>Nhập thông tín sản phẩm thứ " + (i + 1));
            boolean flag = true;
            while (flag) {
                System.out.println("< 1.SP có thuế - 2.SP không có thuế >");
                System.out.print(" - Chọn loại sản phẩm: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("\t+ Loại: SP có thuế");
                        Product prod = new Product();
                        prod.nhap();
                        list.add(prod);
                        flag = false;
                        break;

                    case 2:
                        System.out.println("\t+ Loại: SP Không có thuế");
                        NoTaxProduct prodNT = new NoTaxProduct();
                        prodNT.nhap();
                        list.add(prodNT);
                        flag = false;
                        break;

                    default:
                        System.out.print(".Loại sản phẩm không nằm trong danh mục.\n.Chọn lại loại SP ");
                }
            }
        }
        System.out.println("_ _ _ _ _ _ _ _ _\n");
    }

    public void output() {
        int index = 0;
        System.out.println("+++--------------- DANH SÁCH SẢN PHẨM ---------------+++\n");
        System.out.printf("%-5s %-30s %-12s %-10s\n", "STT", "Tên SP", "Giá bán", "Thuế");
        for (Product sp : list) {
            sp.xuat(index++);
        }
        System.out.println("\nGọi các phương thức 'DAO'");
        index = 0;
        for (Product sp : list) {
            sp.insert(index);
            sp.update(index);
            sp.delete(index);
            sp.select(index);
            index++;
            System.out.println("+-+-+");
        }
        System.out.println("_ _ _ _ _ _ _ _ _\n");
    }
}

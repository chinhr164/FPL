package com.fpoly.lab5.bai3;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        ProductManager code = new ProductManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("\n+------------- MENU -------------+\n");
            System.out.print("\t1. Nhập sản phẩm.\n");
            System.out.print("\t2. Sắp xếp danh sách.\n");
            System.out.print("\t3. Xoá thông tin.\n");
            System.out.print("\t4. Giá trung bình.\n");
            System.out.print("\t0. Thoát chương trình.\n");
            System.out.print("+--------------------------------+\n");
            System.out.print("Chọn chức năng: ");
            int cn = sc.nextInt();
            switch (cn) {
                case 1: code.input();
                case 2: code.soft();
                case 3: code.delete();
                case 4: code.ava();
                case 0: System.exit(0);
                default: System.out.print("\n>>Chức năng được chọn nằm ngoài phạm vi.\n");
            }
        }
    }
}


package com.poly.lab1;

import java.util.Scanner;

public class Main_Class {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        prod_manage code = new prod_manage();
        int cn;

        while (true) {
            System.out.println("\n+++  --------------  MENU  --------------  +++");
            System.out.println("\t1. Nhập danh sách sản phẩm.");
            System.out.println("\t2. Xuất danh sách sản phẩm.");
            System.out.println("\t0. Thoát.");
            System.out.println("+++  ------------------------------------  +++\n");
            System.out.print("<> Mời chọn: ");
            cn = Integer.parseInt(sc.nextLine());

            switch (cn) {
                case 1:
                    code.input();
                    break;

                case 2:
                    code.output();
                    break;

            }
        }
    }
}

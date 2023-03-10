package com.fpoly.lab6.bai1;

import java.util.Scanner;

public class Bai1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n+++ TÁCH HỌ TÊN +++\n");
        System.out.print("- Nhập họ tên: ");
        String name = sc.nextLine();
        System.out.print("\n>> Họ: " + name.substring(0, name.indexOf(" ")).toUpperCase());
        System.out.print("\n>> Tên đệm: " + name.substring(name.indexOf(" ") + 1, name.lastIndexOf(" ")));
        System.out.print("\n>> Tên: " + name.substring(name.lastIndexOf(" ") + 1).toUpperCase());
    }
}

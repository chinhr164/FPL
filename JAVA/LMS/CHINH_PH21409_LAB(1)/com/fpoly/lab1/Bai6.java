package com.fpoly.lab1;

import java.util.Scanner;

public class Bai6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(" >1< Nhập và hiển thị 1 chuỗi >1<");
        System.out.print("<> Nhập chuổi: ");
        String sHienThi = sc.nextLine();
        System.out.print("\n\"Hiển thị\": "+sHienThi);

        System.out.println("\n-----------------------\n");
        System.out.println(" >2< Nhập 2 chuôi >2< và hiẻn thi \"Chuỗi 1 + Chuỗi 2\"");
        System.out.print("<> Nhập chuổi 1: ");
        String chuoi1 = sc.nextLine();
        System.out.print("<> Nhập chuổi 2: ");
        String chuoi2 = sc.nextLine();
        System.out.print("\"Chuỗi 1 + Chuỗi 2\": "+(chuoi1+chuoi2));
    }
}

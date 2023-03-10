package com.extra.string;

import java.util.Scanner;

public class KiemTraMaSV {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("<> Nhập chuỗi: ");
        String s = sc.nextLine();
        if (s.matches("PH(\\d){5}")) {
            System.out.println(">> Mã sinh viên nhập đúng quy chuẩn!");
        }else {
            System.out.println(">> Mã sinh viên không nhập đúng quy chuẩn");
        }
    }
}

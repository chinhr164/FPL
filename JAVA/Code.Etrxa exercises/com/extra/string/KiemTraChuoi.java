package com.extra.string;

import java.util.Scanner;

public class KiemTraChuoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\n <> Nhập chuỗi: ");
        if (sc.nextLine().matches("^[A-Z]([^ ]){18}[0-9]$")) {
            System.out.println(">> Duyệt!");
        }else
            System.out.println(">> Không duyệt");
    }
}

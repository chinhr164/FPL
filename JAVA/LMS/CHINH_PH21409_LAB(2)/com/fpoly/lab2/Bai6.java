package com.fpoly.lab2;

import java.util.Scanner;

public class Bai6 {

    public static void main(String [] arg) {
        Scanner sc = new Scanner(System.in);

        System.out.println(">4< KIỂM TRA SỐ NGUYÊN >4<");
        System.out.print(" <> Nhập số nguyên: ");
        int n = sc.nextInt();
        //kiem tra chan le
        if (n % 2 == 0) {
            System.out.printf("\n - %d là số chẵn.", n);
        } else {
            System.out.printf("\n - %d là số lẻ.", n);
        }
        //kiem tra am duong
        if (n > 0) {
            System.out.printf("\n - %d là số dương.", n);
        } else if (n < 0) {
            System.out.printf("\n - %d là số âm.", n);
        } else {
            System.out.print("\n - Số 0.");
        }
        //so 3 chu so
        if (n >= 100 && n <= 999) {
            System.out.printf("\n - Đầu: %d", n / 100);
            System.out.printf("\n - Cuối: %d", n % 10);
        } else {
            System.out.print("\n - Số nhập vào không phải số có 3 chữ số.");
        }
        System.out.print("\n__________\n");
    }
}

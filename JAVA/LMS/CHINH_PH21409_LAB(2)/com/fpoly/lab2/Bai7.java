package com.fpoly.lab2;

import java.util.Scanner;

public class Bai7 {

    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);

        System.out.println(">5< TỔNG SỐ ÂM MẢNG [-n,0] >5<");
        System.out.print(" <> Nhập số nguyên âm n = ");
        int n = sc.nextInt();
        int s = 0;
        if (n >= 0) {
            System.out.println("\n - Nhập liệu không hợp lệ");
        } else {
            for (int i=n;i<=0;i++) {
                s+=i;
            }
            System.out.printf("\n - Tổng phẩn tử âm trong [%d,0] là: %d", n, s);
        }
        System.out.print("\n__________\n");
    }
}

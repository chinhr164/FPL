package com.fpoly.lab2;

import java.util.Scanner;

public class Bai8 {

    public static void main(String [] arg) {
        Scanner sc = new Scanner(System.in);

        System.out.println(">6< KIÊM TRA SỐ CHÍNH PHƯƠNG >6<");
        System.out.print(" <> Nhập n = ");
        int n =sc.nextInt();
        if (Math.sqrt(n) == (int) Math.sqrt(n)) {
            System.out.printf("\n > %d là số chính phương.", n);
        } else {
            System.out.printf("\n > %d không là số chính phương.", n);
        }
        System.out.print("\n__________\n");
    }
}

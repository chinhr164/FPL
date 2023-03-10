package com.fpoly.lab3;

import java.util.Scanner;

public class Bai1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n+++ Số nguyên tố +++\n");
        System.out.print("Nhập số: ");
        int n = sc.nextInt();
        if (n < 2) {
            System.out.printf(">> %d không phải là số nguyên tố.", n);
        } else if (n == 2) {
            System.out.print(">> 2 là số nguyên tố.");
        } else {
            boolean ok = true;
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                System.out.printf(">> %d là số nguyên tố.", n);
            } else {
                System.out.printf(">> %d không phải là số nguyên tố.", n);
            }
        }
    }

}

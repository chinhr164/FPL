package com.fpoly.lab3;

import java.util.Scanner;

public class Bai7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\t>< ƯỚC CHUNG LỚN NHẤT - BỘI CHUNG NHỎ NHẤT ><\n");
        System.out.print("<> Nhập a = ");
        int a = sc.nextInt();
        System.out.print("<> Nhập b = ");
        int b = sc.nextInt();
        a = Math.abs(a);
        b = Math.abs(b);
        int temp = a * b;
        if (a == 0 || b == 0) {
            System.out.printf("\n> UCLN = %d", a + b);
            System.out.printf("\n> BCNN = %d", temp / (a + b));
        } else {
            while (a != b) {
                if (a > b) {
                    a = a - b;
                } else {
                    b = b - a;
                }
            }
            System.out.printf("\n> UCLN = %d", a);
            System.out.printf("\n> BCNN = %d", temp / a);
        }
    }
}

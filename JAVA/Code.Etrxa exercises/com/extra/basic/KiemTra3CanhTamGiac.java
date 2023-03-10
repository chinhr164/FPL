package com.extra.basic;

import java.util.Scanner;

public class KiemTra3CanhTamGiac {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n\t>< KIỂM TRA 3 CẠNH CỦA TAM GIÁC ><\n");
        System.out.printf(" - Nhập số thứ 1: ");
        double a = sc.nextDouble();
        System.out.printf(" - Nhập số thứ 2: ");
        double b = sc.nextDouble();
        System.out.printf(" - Nhập số thứ 3: ");
        double c = sc.nextDouble();

        if (a + b > c && a + c > b && b + c > a)
            System.out.printf("\n>> %.2f, %.2f và %.2f là ba cạnh của 1 tam giác.\n",a,b,c);
        else
            System.out.printf("\n>> %.2f, %.2f và %.2f không là ba cạnh của 1 tam giác.\n",a,b,c);
    }
}

package com.fpoly.lab2;

import java.util.Scanner;

public class Bai1 {

    public static void main(String [] arg) {
        Scanner sc = new Scanner(System.in);

        System.out.println(">1< GIẢI PHƯƠNG TRÌNH BẬC NHẤT >1<");
        System.out.print("Nhập a: ");
        double a = sc.nextDouble();
        System.out.print("Nhập b: ");
        double b = sc.nextDouble();
        System.out.print("");
        if (a == 0) {
            if (b == 0) {
                System.out.print("\n>> Phương trình vô số nghiệm.");
            } else {
                System.out.print("\n>> Phương trình vô nghiệm.");
            }
        } else if (b == 0) {
            System.out.print("\n>> Phương trình có 1 nghiệm: 0.");
        } else {
            System.out.printf("\n>> Phương trình có 1 nghiệm: %.2f.", (-b) / a);
        }
        System.out.print("\n__________\n");
    }
}

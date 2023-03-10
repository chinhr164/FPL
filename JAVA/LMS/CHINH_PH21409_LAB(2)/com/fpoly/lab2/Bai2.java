package com.fpoly.lab2;

import java.util.Scanner;

public class Bai2 {

    public static void main(String [] arg) {
        Scanner sc = new Scanner(System.in);

        System.out.println(">2< GIẢI PHƯƠNG TRÌNH BẬC HAI >2<");
        System.out.print("Nhập a: ");
        double a = sc.nextDouble();
        System.out.print("Nhập b: ");
        double b = sc.nextDouble();
        System.out.print("Nhập c: ");
        double c = sc.nextDouble();
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.print("\n>> Phương trình vô số nghiệm.");
                } else {
                    System.out.print("\n>> Phương trình vô nghiệm.");
                }
            } else if (c == 0) {
                System.out.print("\n>> Phương trình có 1 nghiệm: 0.");
            } else {
                System.out.printf("\n>> Phương trình có 1 nghiệm: %.2f.", (-c) / b);
            }
        } else {
            double delta = b * b - (4 * a * c);
            if (delta < 0) {
                System.out.print("\n>> Phương trình vô nghiệm.");
            } else if (delta == 0) {
                System.out.printf("\n>> Phương trình có nghiệm kép: %.2f.", (-b) / (2 * a));
            } else {
                System.out.printf("\n>> Phương trình có nghiệm x1 = %.2f.",
                        ((-b) + Math.sqrt(delta)) / (2 * a));
                System.out.printf("\n>> Phương trình có nghiệm x2 = %.2f.",
                        ((-b) - Math.sqrt(delta)) / (2 * a));
            }
        }
        System.out.print("\n__________\n");
    }

}

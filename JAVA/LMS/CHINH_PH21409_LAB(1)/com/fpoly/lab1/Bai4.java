package com.fpoly.lab1;

import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập a: ");
        double a = sc.nextDouble();
        System.out.print("Nhập b: ");
        double b = sc.nextDouble();
        System.out.print("Nhập c: ");
        double c = sc.nextDouble();
        double delta = b * b - (4 * a * c);
        System.out.printf(">>Căn bậc hai của delta: %.2f", Math.sqrt(delta));
    }
}

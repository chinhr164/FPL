package com.fpoly.lab1;

import java.util.Scanner;

public class Bai7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final double PI = 3.14;

        System.out.println(" >< CHU VI - DIỆN TÍCH HÌNH TRÒN ><\n");
        System.out.print(" - Nhập bán kính: ");
        double r = sc.nextDouble();
        System.out.printf("\n>> Chu vi: %.2f",2*r*PI);
        System.out.printf("\n>> Diện tích: %.2f",r*r*PI);

    }
}

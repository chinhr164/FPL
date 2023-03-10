package com.fpoly.lab5.bai1;

import java.util.ArrayList;
import java.util.Scanner;

public class Bai1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> a = new ArrayList<>();
        double s = 0.;
        int index = 1;

        System.out.println("\n+++ TÍNH TỔNG 1 MẢNG SỐ THỰC +++\n");
        while (true) {
            System.out.printf("Nhập phần tử thứ %d: ", index++);
            double i = Double.parseDouble(sc.nextLine());
            a.add(i);
            System.out.print("Nhập thêm (Y/N)? - ");
            if (sc.nextLine().equals("n")) {
                break;
            }
        }
        System.out.print("\n> Mảng: ");
        for (Double i : a) {
            System.out.print(i + "  ");
            s += i;
        }
        System.out.print("\n> Tổng: " + s);
    }
}

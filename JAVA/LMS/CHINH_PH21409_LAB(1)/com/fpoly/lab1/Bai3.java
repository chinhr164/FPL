package com.fpoly.lab1;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Độ dài cạnh: ");
        double canh = sc.nextDouble();
        //
        System.out.printf("<> Thể tích hình lập phương: %.2f.", Math.pow(canh, 3));
    }
}

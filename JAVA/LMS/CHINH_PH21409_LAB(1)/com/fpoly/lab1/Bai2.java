package com.fpoly.lab1;


import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Cạnh thứ nhất: ");
        double canh1 = sc.nextDouble();
        System.out.print("Cạnh thứ hai: ");
        double canh2 = sc.nextDouble();
        //hiển thị
        System.out.printf("\n>> Chu vi: %.2f.", (canh1 + canh2) * 2);
        System.out.printf("\n>> Diện tích: %.2f.", canh1 * canh2);
        System.out.printf("\n>> Cạnh nhỏ nhất: %.2f.", Math.min(canh1, canh2));
    }
}

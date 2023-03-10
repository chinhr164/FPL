package com.fpoly.lab7.bai1;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n+++ Tính chu vi & diện tích HCN-HV +++\n");
        System.out.print("Nhập chiều dài hình chữ nhật: ");
        double dai = sc.nextDouble();
        System.out.print("Nhập chiều rộng hình chữ nhật: ");
        double rong = sc.nextDouble();
        System.out.print("Nhập cạnh hình vuông: ");
        double canh = sc.nextDouble();

        ChuNhat cn = new ChuNhat(dai, rong);
        ChuNhat cn2 = new ChuNhat(3, 5);
        Vuong vu = new Vuong(canh);

        System.out.println("Chu vi - Diện tích hình chữ nhật 1:");
        cn.xuat();
        System.out.println("");
        System.out.println("Chu vi - Diện tích hình chữ nhật 2:");
        cn2.xuat();
        System.out.println("");
        System.out.println("Chu vi - Diện tích hình vuông:");
        vu.xuat();
    }
}

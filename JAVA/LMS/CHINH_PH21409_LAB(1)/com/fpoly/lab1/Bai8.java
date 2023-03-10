package com.fpoly.lab1;

import java.util.Scanner;

public class Bai8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(" >< QUẢN LÝ SINH VIÊN ><\n");
        System.out.print(" - Nhập tên sinh viên: ");
        String name = sc.nextLine();
        System.out.print(" - Nhập điểm Toán: ");
        double math = sc.nextDouble();
        System.out.print(" - Nhập điểm Lý: ");
        double phy = sc.nextDouble();
        System.out.print(" - Nhập điểm Hoá: ");
        double chem = sc.nextDouble();

        System.out.println("\n\n\t\t<+><+><+><+><+> DANH SÁCH SINH VIÊN <+><+><+><+><+>");
        System.out.printf("\n%-5s %-20s %-10s %-10s %-10s %-10s", "STT", "Họ tên", "Toán", "Lý",
                          "Hoá", "ĐTB");
        System.out.printf("\n%-5d %-20s %-10.2f %-10.2f %-10.2f %-10.2f", 1, name, math, phy, chem,
                          (math + phy + chem) / 3);
    }
}

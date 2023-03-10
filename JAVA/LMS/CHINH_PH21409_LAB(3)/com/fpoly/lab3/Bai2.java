package com.fpoly.lab3;

public class Bai2 {

    public static void main(String[] args) {
        System.out.println("\n+++ IN BẢNG CỬU CHƯƠNG +++\n");
        for (int i = 1; i <= 9; i++) {
            System.out.printf("\n+---- BẢNG CỬU CHƯƠNG (%d) ----+", i);
            for (int j = 1; j <= 10; j++) {
                System.out.printf("\n\t\t%-2d * %2d = %2d", i, j, i * j);
            }
            System.out.print("\n");
        }
    }
}

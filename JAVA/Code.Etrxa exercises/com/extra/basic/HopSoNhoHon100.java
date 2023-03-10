package com.extra.basic;

public class HopSoNhoHon100 {

    public static void main(String[] args) {
        System.out.print("\n\t\t>< CÁC HỢP SỐ NHỎ HƠN 100 ><\n\n\t");
        int line = 0;
        for (int i = 4; i < 100; i++) {
            for (int j = 2; j < i - 1; j++) {
                if (i % j == 0) {
                    System.out.printf("%-5d", i);
                    line++;
                    if (line % 7 == 0) {
                        System.out.print("\n\t");
                    }
                    break;
                }
            }
        }
    }
}

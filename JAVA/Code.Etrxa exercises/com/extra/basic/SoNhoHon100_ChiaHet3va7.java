package com.extra.basic;

public class SoNhoHon100_ChiaHet3va7 {

    public static void main(String[] args) {
        System.out.print("\n\t>< SỐ NHỎ HƠN 100 CHIA HẾT CHO 3 VÀ 7 ><\n\n\t\t");

        for (int i = 0; i < 100; i++) {
            if (i % 21 == 0) {
                System.out.printf("%-8d", i);
            }
        }
        System.out.println("");
    }
}

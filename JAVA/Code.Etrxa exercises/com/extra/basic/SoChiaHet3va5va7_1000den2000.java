package com.extra.basic;

public class SoChiaHet3va5va7_1000den2000 {

    public static void main(String[] args) {
        System.out.print("\n\t>< SỐ CHIA HẾT 3 VÀ 5 VÀ 7 TỪ 1000 ĐẾN 2000 ><\n\n\t\t");
        int line = 0;
        for (int i = 1000; i <= 2000; i++) {
            if (i % 105 == 0) {
                System.out.printf("%-9d", i);
                if (++line % 5 == 0) {
                    System.out.print("\n\t\t");
                }
            }
        }
    }
}

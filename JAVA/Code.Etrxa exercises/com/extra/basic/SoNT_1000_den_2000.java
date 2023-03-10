package com.extra.basic;

public class SoNT_1000_den_2000 {

    public static void main(String[] args) {
        System.out.print("\n\t>< SỐ NGUYÊN TỐ TỪ 1000 ĐẾN 2000 ><\n\n\t\t");
        int line = 0;
        for (int i = 1000; i <=2000; i++) {
            int j;
            for (j = 2; j < i; j++) {
                if (i % j == 0) {
                    break;
                }
            }
            if (j == i) {
                System.out.printf("%-7d", i);
                if (++line % 5 == 0) {
                    System.out.print("\n\t\t");
                }
            }
        }
    }
}



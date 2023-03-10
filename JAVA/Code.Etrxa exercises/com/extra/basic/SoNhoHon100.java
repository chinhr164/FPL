package com.extra.basic;

public class SoNhoHon100 {

    public static void main(String[] args) {
        System.out.println("\n\t>< CÁC SỐ NHỎ HƠN 100 ><\n");
        int du0 = 0, du1 = 0, du2 = 0, du3 = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 5 == 0) {
                du0++;
            }
            if (i % 5 == 1) {
                du1++;
            }
            if (i % 5 == 2) {
                du2++;
            }
            if (i % 5 == 3) {
                du3++;
            }
        }
        System.out.printf(" - Có %d số chia hết cho 5.\n", du0);
        System.out.printf(" - Có %d số chia cho 5 dư 1.\n", du1);
        System.out.printf(" - Có %d số chia cho 5 dư 2.\n", du2);
        System.out.printf(" - Có %d số chia cho 5 dư 3.\n", du3);
    }
}

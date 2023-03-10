package com.extra.basic;

import java.util.ArrayList;

public class VietDuoiDangTichSoNguyenTo {

    public static void main(String[] args) {
        System.out.println("\n\t>< VIẾT DUÓI DẠNG TÍCH SỐ NGUYÊN TỐ ><\n");
        int N = 1998;
        ArrayList<Integer> x = new ArrayList<>();

        x.add(N);
        for (int i = 2; i <= N; i++) {
            if (N % i == 0) {
                x.add(i);
                N = N / i;
                i--;
            }
        }
        if (x.size() == 2) {
            System.out.printf(
                    " - %d là số nguyên tố nên không thể viết dưới dạng tích các số nguyên tố.\n",
                    x.get(0));
        } else {
            System.out.printf(" - Số %d viết dưới dạng tích các số nguyên tố\n", x.get(0));
            System.out.printf("\t\t%d = ", x.get(0));
            for (int i = 0; i < x.size() - 1; i++) {
                if (i == x.size() - 2) {
                    System.out.printf("%d", x.get(i + 1));
                } else {
                    System.out.printf("%d * ", x.get(i + 1));
                }
            }
        }
    }
}

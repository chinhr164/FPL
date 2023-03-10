package com.extra.basic;

import java.util.ArrayList;

public class UocSoNguyenToKhacNhau {

    public static void main(String[] args) {
        System.out.println("\n\t>< ƯỚC SỐ NGUYÊN TỐ KHÁC NHAU ><\n");
        int N = 1998;
        ArrayList<Integer> x = new ArrayList<>();

        x.add(N);
        for (int i = 2; i <= N; i++) {
            if (N % i == 0) {
                int j = 2;
                while (j < i) {
                    if (i % j == 0) {
                        break;
                    }
                    j++;
                }
                if (j == i) {
                    x.add(i);
                    N = N / i;
                }
            }
        }
        System.out.printf(" - ƯỚC SỐ NGUYÊN TỐ CỦA %d: ", x.get(0));
        for (int i = 0; i < x.size() - 1; i++) {
            System.out.printf("%-4d", x.get(i + 1));
        }
    }
}


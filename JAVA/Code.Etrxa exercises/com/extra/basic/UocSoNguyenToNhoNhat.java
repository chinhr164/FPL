package com.extra.basic;

public class UocSoNguyenToNhoNhat {

    public static void main(String[] args) {
        System.out.println("\n\t>< ƯỚC SỐ NGUYÊN TỐ NHỎ NHẤT ><\n");
        int N = 8191;

        for (int i = 2; i <= N; i++) {
            if (N % i == 0) {
                System.out.printf(" - Ước số nguyên tó nhỏ nhất của %d là %d.\n", N, i);
                break;
            }
        }
    }
}


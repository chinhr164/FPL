package com.fpoly.lab3;

import java.util.Arrays;
import java.util.Scanner;

public class Bai3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n+++ TRUNG BÌNH CỘNG MẢNG SỐ NGUYÊN +++\n");
        System.out.print("Nhập số lượng phần tử: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf(" - Phần tử thứ %d: ", i + 1);
            a[i] = sc.nextInt();
        }
        System.out.println("\n<> Màng gốc: " + Arrays.toString(a) + "\n_____");
        //
        Arrays.sort(a);
        System.out.println("\n>> Sau soft: " + Arrays.toString(a));
        //
        int min = a[0];
        for (int i = 0; i < n; i++) {
            min = Math.min(min, a[i]);
        }
        System.out.println("\n>> Giá trị bé nhất: " + min);
        //
        double s = 0, count = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] % 3 == 0) {
                s += a[i];
                count++;
            }
        }
        System.out.println("\n>> Trung bình cộng các phần tử chia hết cho 3: " + (s / count));
    }
}

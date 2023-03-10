package com.fpoly.lab3;

import java.util.Scanner;

public class Bai5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\t>< TÍNH TỔNG N ><\n");
        System.out.print("<> Nhập n = ");
        int n = sc.nextInt();
        int S1 = 0, S2 = 0, S3 = 0;

        for (int i = 1; i <= n; i++) {
            //S1=1+2+3+...+n
            S1 += i;
            //S2=-1+2-3+4-...+(-1)*n
            S2 += i * Math.pow(-1, i);
            //S3=2+4+6+...+2n
            S3 += 2 * i;
        }
        System.out.printf("\n>S1 = %d", S1);
        System.out.printf("\n>S2 = %d", S2);
        System.out.printf("\n>S1 = %d", S3);
    }
}

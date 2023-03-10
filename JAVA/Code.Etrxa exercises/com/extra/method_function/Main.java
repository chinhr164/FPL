package com.extra.method_function;

import java.util.Scanner;

public class Main {

    //S1 = 1 + 1/(1+2) + 1/(1+2+3) + ... + 1/(1+2+3+...+N)
    public double tongS1(int x) {
        double s = 0, k = 0;
        for (int i = 1; i <= x; i++) {
            k += i;
            s += Math.pow(k, -1);
        }

        return s;
    }

    //S2 = 1 + 1/2! + 1/3! + ... + 1/N!
    public double tongS2(int x) {
        double s = 0, k = 1;
        for (int i = 1; i <= x; i++) {
            k *= i;
            s += Math.pow(k, -1);
        }
        return s;
    }

    //S2 = 1 + 1/(1+2!) + 1/(1+2!+3!) + ... + 1/(1+2!+3!+ ... +N!)
    public double tongS3(int x) {
        double s = 0, k = 1, v = 0;
        for (int i = 1; i <= x; i++) {
            k *= i;
            v += k;
            s += Math.pow(v, -1);
        }
        return s;
    }

    //Fibonacci(N)
    public int F(int x) {
        if (x > 2) {
            return F(x - 1) + F(x - 2);
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main code = new Main();
        System.out.print("\n >1< Nhập vào N = ");
        int n = sc.nextInt();

        System.out.printf("\n - Tổng S1(%d) = %.2f", n, code.tongS1(n));
        System.out.printf("\n - Tổng S2(%d) = %.2f", n, code.tongS2(n));
        System.out.printf("\n - Tổng S3(%d) = %.2f", n, code.tongS3(n));
        System.out.printf("\n - Só F(%d) = %d", n, code.F(n));
    }
}

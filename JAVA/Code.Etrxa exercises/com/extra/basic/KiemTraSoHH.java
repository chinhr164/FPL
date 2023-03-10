package com.extra.basic;

public class KiemTraSoHH {

    public static void main(String[] args) {
        int s=0, n =33550336;
        for (int i = 1; i <= n ; i++) {
            if (n%i==0) {
             s+=i;
            }
        }
        int x = s-n;
        System.out.println("\n"+x);
    }
}

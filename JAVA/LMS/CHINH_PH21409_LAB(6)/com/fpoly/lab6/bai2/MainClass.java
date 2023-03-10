package com.fpoly.lab6.bai2;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product code = new Product();

        System.out.println("\n+++ QUẢN LÝ SẢN PHẨM +++\n");
        for (int i = 0; i < 2
                ; i++) {
            code.input(i);
        }

        code.output();
    }
}
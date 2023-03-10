package com.extra.string;

import java.util.Scanner;

public class KiemTraSoTrongChuoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\n>< Nhập chuỗi: ");
        String s = sc.nextLine();
        String[] words = s.split("");
        for (int i = 0; i < words.length; i++) {
            if (words[i].matches("\\d")) {
                System.out.println("<> Trong chuỗi có xuất hiện số!");
                break;
            }
            if (i== words.length-1) {
                System.out.println("<> Trong chuỗi không xuất hiện số!");
            }
        }
    }
}

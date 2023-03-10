package com.extra.string;

import java.util.Scanner;

public class Doi0Thanh1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\n - Nhập chuỗi: ");
        String s = sc.nextLine();
        String[] words = s.split("");
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("0")) {
                words[i] = "1";
            } else {
                words[i] = "0";
            }
        }
        System.out.print(">> Hiển thị: ");
        for (String word : words) {
            System.out.print(word);
        }
    }
}

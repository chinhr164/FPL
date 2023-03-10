package com.extra.string;

import java.util.*;

import com.extra.zcustom.XPoly;

public class XoaDauCachThuaTrongTen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\n<> Nhập chuỗi: ");
        String s = sc.nextLine();
        String[] words = s.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("")) {
                continue;
            } else {
                list.add(words[i]);
            }
        }
        System.out.println(">> Hiển thị: " + XPoly.toUpperFirstChar(String.join(" ", list)));
    }

}

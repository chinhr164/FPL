package com.fpoly.lab2;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Bai3 {

    public static void main(String [] arg) {
        Scanner sc = new Scanner(System.in);
        NumberFormat en = NumberFormat.getInstance(new Locale("en", "EN"));

        System.out.println(">3< TÍNH TIỀN ĐIỆN >3<");
        System.out.print("Nhập số điện: ");
        int soDien = sc.nextInt();
        int soTien;
        if (soDien <= 50) {
            soTien = soDien * 1000;
        } else {
            soTien = 50 * 1000 + (soDien - 50) * 1200;
        }
        System.out.printf("\n>> Số tiền điện phải đóng: %s", en.format(soTien));
        System.out.print("\n__________\n");
    }

}

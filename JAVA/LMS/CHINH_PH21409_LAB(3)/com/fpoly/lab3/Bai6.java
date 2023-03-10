package com.fpoly.lab3;

import java.util.Scanner;

public class Bai6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\t>< THỐNG KÊ SỐ HÀNG ><\n");
        System.out.print("<> Nhập số tiến ban đầu: ");
        int soTien = sc.nextInt();
        System.out.print("<> Nhập đơn giá sản phẩm: ");
        int donGia = sc.nextInt();
        int soLuong = 0;

        while (soTien >= donGia) {
            soLuong++;
            soTien = soTien - donGia;
        }
        System.out.printf("\n> Số lượng hàng mua được: %d", soLuong);
        System.out.printf("\n> Số tiền mua được: %d", soTien);
    }
}

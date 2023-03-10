package com.fpoly.lab8.bai4;

import com.fpoly.lab8.bai1bai2bai3.XPoly;

import java.util.Scanner;

public class MainClass {

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);

          System.out.println("\n+++ CHƯƠNG TRÌNH ÁP DỤNG \"XPOLY\"\n");
          System.out.println("Nhập mảng - Tính tổng và tìm Min, Max");
          System.out.print("Số lương phần từ mảng: ");
          int n = Integer.parseInt(sc.nextLine());
          double[] a = new double[n];
          for (int i = 0; i < n; i++) {
               System.out.print(" - Nhập phần tử thứ " + (i+1) + ": ");
               a[i] = Double.parseDouble(sc.nextLine());
          }
          System.out.println("\n<> Tổng các phẩn tử trong mảng: " + XPoly.sum(a));
          System.out.println("<> Giá trị nhỏ nhất: " + XPoly.min(a));
          System.out.println("<> Giá trị lớn nhất: " + XPoly.max(a));
          System.out.println("\n-------------");

          System.out.println("\nNhập chuỗi bất kì - Chuyển đổi thành viêt hoa mỗi chữ đầu từ");
          System.out.print("- Nhập chuỗi: ");
          System.out.println("\n<> Chuỗi đã chuyển đổi: " + XPoly.toUpperFirstChar(sc.nextLine()));
     }
}

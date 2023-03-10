package com.poly.lab8.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

     public static void main(String[] args) {
          ArrayList<Product> list = new ArrayList<>();
          File file = new File("D:/chinhcvph21409");
          if (!file.exists()) {
               file.mkdirs();
          }
          String path = file.getAbsoluteFile() + "\\prod.bin";
          //
          Product p1 = new Product("Kem đánh răng", 32000);
          System.out.println("Đã thêm sản phẩm " + p1.getName() + " - " + p1.getPrice());
          Product p2 = new Product("Bàn chải PS", 15000);
          System.out.println("Đã thêm sản phẩm " + p2.getName() + " - " + p2.getPrice());
          System.out.println("");
          int index = 3;
          while (true) {
               System.out.print("Xác nhận thêm sản phẩm mới (Y/N)? - ");
               String choice = new Scanner(System.in).nextLine();
               if (choice.equalsIgnoreCase("n")) {
                    break;
               } else {
                    System.out.println("<~> Sản phẩm thứ " + index++);
                    System.out.print("\t- Tên sản phẩm: ");
                    String name = new Scanner(System.in).nextLine();;
                    System.out.print("\t- Giá: ");
                    double price = Double.parseDouble(new Scanner(System.in).nextLine());
                    list.add(new Product(name, price));
                    System.out.println("Đã thêm sản phẩm " + name + " - " + price);
                    System.out.println("");
               }
          }
          //
          ProductDAO daoW = new ProductDAO();
          daoW.add(p1);
          daoW.add(p2);
          daoW.store(path);
          System.out.println("Danh sách sản phẩm đã được lưu theo đường dẫn: " + path);
          //
          ProductDAO daoR = new ProductDAO();
          daoR.load(path);
          //
          System.out.print("Nhập tên sản phẩm cần tìm: ");
          String find = new Scanner(System.in).nextLine();
          Product p = daoR.find(find);
          if (p == null) {
               System.out.println("Không tìm thấy sản phẩm " + find);
          } else {
               System.out.println(" > Tên sản phẩm: " + p.getName());
               System.out.println(" > Giá:" + p.getPrice());
          }
     }
}

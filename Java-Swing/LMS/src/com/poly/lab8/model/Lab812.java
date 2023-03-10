package com.poly.lab8.model;

import java.util.ArrayList;

public class Lab812 {

     public static void main(String[] args) {
          System.out.println("<!> Bài 1 <!>");
          ArrayList list = new ArrayList<>();
          list.add(1);
          list.add(9.9);
          list.add(true);
          list.add("Cao Văn Chỉnh");
          for (Object obj : list) {
               System.out.println(" - Giá trị thứ " + (list.indexOf(obj) + 1) + ": " + obj);
          }

          System.out.println("");

          System.out.println("<!> Bài 2 <!>");
          ArrayList<Integer> listInt = new ArrayList<>();
          for (int i = 1; i <= 10; i++) {
               listInt.add(i);
          }
          System.out.print("Hiển thị:");
          for (Integer i : listInt) {
               System.out.print("\t" + i);
          }
          System.out.println("");
     }
}

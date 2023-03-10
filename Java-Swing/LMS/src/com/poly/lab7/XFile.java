package com.poly.lab7;

public class XFile {

     @Deprecated
     public static boolean isCardNumber(String number) {
          String[] words = number.split(" ");
          String s = String.join("", words);
          int x = Integer.parseInt(s);
          int total = 0;
          while (x > 0) {
               int y = x % 10;
               x /= 10;
               total += y;
          }
          if (total % 2 == 0) {
               return true;
          } else {
               return false;
          }
     }
}

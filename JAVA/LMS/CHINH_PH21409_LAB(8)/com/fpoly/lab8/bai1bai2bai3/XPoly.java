package com.fpoly.lab8.bai1bai2bai3;

import java.text.NumberFormat;
import java.util.Locale;

public final class XPoly {
     public static final double sum(double... x) {
          double s = 0;
          for (double a : x) {
               s += a;
          }
          return s;
     }

     public static final double min(double... x) {
          double min = x[0];
          for (double a : x) {
               if (min > a) {
                    min = a;
               }
          }
          return min;
     }

     public static final double max(double... x) {
          double max = x[0];
          for (double a : x) {
               if (max < a) {
                    max = a;
               }
          }
          return max;
     }

     public static final String toUpperFirstChar(String s) {
          s = s.toLowerCase();
          String[] words = s.split(" ");
          for (int i = 0; i < words.length; i++) {
               char firstChar = words[i].charAt(0);
               char upperFirstChar = String.valueOf(firstChar).toUpperCase().charAt(0);
               words[i] = upperFirstChar + words[i].substring(1);
          }
          return String.join(" ", words);
     }

     //hàng thêm do người viết
     public static final String numFomart(double x){
          NumberFormat en = NumberFormat.getInstance(new Locale("en", "EN"));
          return en.format(x);
     }
}

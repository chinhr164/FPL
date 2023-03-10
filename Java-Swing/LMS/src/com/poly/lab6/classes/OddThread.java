package com.poly.lab6.classes;

public class OddThread extends Thread {

     @Override
     public void run() {
          System.out.print("Old Thread:");
          for (int i = 1; i <= 10; i++) {
               if (i % 2 != 0) {
                    System.out.print("\t" + i);
               }
               try {
                    Thread.sleep(10);
               } catch (Exception e) {
               }
          }
          System.out.println("");
     }
}

package com.poly.lab6.classes;

public class MainClass {

     public static void main(String[] args) {
          Thread1 mt1 = new Thread1();
          Thread2 mt2 = new Thread2();
          mt1.start();
          try {
               mt1.join();
          } catch (Exception e) {
          }
          mt2.start();
          OddThread ot = new OddThread();
          EvenThread et = new EvenThread();
          try {
               mt2.join();
          } catch (Exception e) {
          }
          ot.start();
          try {
               ot.join();
          } catch (Exception e) {
          }
          et.start();
     }
}

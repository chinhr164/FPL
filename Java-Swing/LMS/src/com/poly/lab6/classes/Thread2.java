package com.poly.lab6.classes;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Thread2 extends Thread {

     @Override
     public void run() {
          System.out.print("Thread2:");
          for (int i = 10; i < 20; i++) {
               System.out.print("\t" + i);
               try {
                    Thread.sleep(500);
               } catch (InterruptedException ex) {
                    Logger.getLogger(Thread1.class.getName()).log(Level.SEVERE, null, ex);
               }
          }
          System.out.println("");
     }
}

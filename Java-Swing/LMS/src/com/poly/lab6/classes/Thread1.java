package com.poly.lab6.classes;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Thread1 extends Thread {

     @Override
     public void run() {
          System.out.print("Thread1:");
          for (int i = 0; i < 10; i++) {
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

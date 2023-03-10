package com.poly.lab6.classes;

import javax.swing.JTextField;

public class show extends Thread {

     JTextField txt;

     public show(JTextField txt) {
          this.txt = txt;
     }

     @Override
     public void run() {
          for (int i = 0; i < 500; i++) {
               txt.setText(String.valueOf(Math.round(9 * Math.random())));
               try {
                    Thread.sleep(10);
               } catch (Exception ex) {
               }
          }
     }
}

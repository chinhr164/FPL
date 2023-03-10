package buoi12;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyThread extends Thread{
     
     @Override
     public void run() {
               for (int i = 0; i < 10; i++) {
                    System.out.println(i+1);
                    try { 
                         Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                         Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
                    }                    
          }
     }
}

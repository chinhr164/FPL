package buoi12;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadZr implements Runnable {

     @Override
     public void run() {
          for (int i = 10; i < 20; i++) {
               System.out.println(i + 1);
               try {
                    Thread.sleep(2000);
               } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadZr.class.getName()).log(Level.SEVERE, null, ex);
               }
          }
     }
}

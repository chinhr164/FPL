package buoi12;

import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Clock extends javax.swing.JFrame {

     public Clock() {
          initComponents();
          showClock();
     }

     @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          lblClock = new javax.swing.JLabel();
          jButton1 = new javax.swing.JButton();

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

          lblClock.setText("jLabel1");

          jButton1.setText("Start");
          jButton1.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
               }
          });

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(layout.createSequentialGroup()
                              .addGap(146, 146, 146)
                              .addComponent(lblClock))
                         .addGroup(layout.createSequentialGroup()
                              .addGap(118, 118, 118)
                              .addComponent(jButton1)))
                    .addContainerGap(174, Short.MAX_VALUE))
          );
          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addGap(71, 71, 71)
                    .addComponent(lblClock)
                    .addGap(46, 46, 46)
                    .addComponent(jButton1)
                    .addContainerGap(123, Short.MAX_VALUE))
          );

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          new Thread(new Runnable() {
               @Override
               public void run() {
                    while (true) {
                         Calendar c = Calendar.getInstance();
                         String h = String.valueOf(c.get(Calendar.HOUR_OF_DAY));
                         String m = String.valueOf(c.get(Calendar.MINUTE));
                         String s = String.valueOf(c.get(Calendar.SECOND));
                         lblClock.setText(h + " : " + m + " : " + s);
                         try {
                              Thread.sleep(1000);
                         } catch (InterruptedException ex) {
                              Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
                         }
                    }
               }
          }).start();
     }//GEN-LAST:event_jButton1ActionPerformed

     public static void main(String args[]) {
          /* Set the Windows look and feel */
          //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
          try {
               for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Windows".equals(info.getName())) {
                         javax.swing.UIManager.setLookAndFeel(info.getClassName());
                         break;

                    }
               }
          } catch (ClassNotFoundException ex) {
               java.util.logging.Logger.getLogger(Clock.class
                       .getName()).log(java.util.logging.Level.SEVERE, null, ex);

          } catch (InstantiationException ex) {
               java.util.logging.Logger.getLogger(Clock.class
                       .getName()).log(java.util.logging.Level.SEVERE, null, ex);

          } catch (IllegalAccessException ex) {
               java.util.logging.Logger.getLogger(Clock.class
                       .getName()).log(java.util.logging.Level.SEVERE, null, ex);

          } catch (javax.swing.UnsupportedLookAndFeelException ex) {
               java.util.logging.Logger.getLogger(Clock.class
                       .getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
          //</editor-fold>

          java.awt.EventQueue.invokeLater(new Runnable() {
               public void run() {
                    new Clock().setVisible(true);
               }
          });
     }

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JButton jButton1;
     private javax.swing.JLabel lblClock;
     // End of variables declaration//GEN-END:variables

     public void showClock() {

     }
}

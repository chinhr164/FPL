package com.poly.lab6.model;

import java.util.Calendar;

public class Clock
        extends javax.swing.JFrame {

     public Clock() {
          initComponents();
          this.setTitle("Đồng hồ");
          this.setLocationRelativeTo(null);
          showClock();
     }

     @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          jPanel1 = new javax.swing.JPanel();
          btn = new javax.swing.JButton();

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

          jPanel1.setRequestFocusEnabled(false);

          btn.setAlignmentY(0.0F);
          btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
          btn.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnActionPerformed(evt);
               }
          });

          javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
          jPanel1.setLayout(jPanel1Layout);
          jPanel1Layout.setHorizontalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(105, 105, 105)
                    .addComponent(btn)
                    .addContainerGap(161, Short.MAX_VALUE))
          );
          jPanel1Layout.setVerticalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(102, 102, 102)
                    .addComponent(btn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(148, Short.MAX_VALUE))
          );

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          );
          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          );

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void showClock() {
          Calendar c = Calendar.getInstance();
          String hour = c.get(Calendar.HOUR_OF_DAY) > 9
                  ? "" + c.get(Calendar.HOUR_OF_DAY)
                  : "0" + c.get(Calendar.HOUR_OF_DAY);

          String minutes = c.get(Calendar.MINUTE) > 9
                  ? "" + c.get(Calendar.MINUTE)
                  : "0" + c.get(Calendar.MINUTE);

          String second = c.get(Calendar.SECOND) > 9
                  ? "" + c.get(Calendar.SECOND)
                  : "0" + c.get(Calendar.SECOND);

          btn.setText(hour + " : " + minutes + " : " + second);
     }

     private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
          btn.setEnabled(false);
          new Thread(new Runnable() {
               @Override
               public void run() {
                    while (true) {
                         showClock();
                         try {
                              Thread.sleep(1000);
                         } catch (Exception e) {

                         }
                    }
               }
          }).start();
     }//GEN-LAST:event_btnActionPerformed

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
     private javax.swing.JButton btn;
     private javax.swing.JPanel jPanel1;
     // End of variables declaration//GEN-END:variables

}

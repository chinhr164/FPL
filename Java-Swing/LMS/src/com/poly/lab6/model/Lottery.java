package com.poly.lab6.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Lottery extends javax.swing.JFrame {

     public Lottery() {
          initComponents();
          this.setTitle("Xổ Số Kiến Thiết");
          this.setLocationRelativeTo(null);
          this.getRootPane().setDefaultButton(btn100);
     }

     @SuppressWarnings(
             "unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          jLabel1 = new javax.swing.JLabel();
          txt100 = new javax.swing.JTextField();
          txt10 = new javax.swing.JTextField();
          txt1 = new javax.swing.JTextField();
          btn100 = new javax.swing.JButton();
          btn10 = new javax.swing.JButton();
          btn1 = new javax.swing.JButton();
          jLabel2 = new javax.swing.JLabel();
          jLabel3 = new javax.swing.JLabel();
          jLabel4 = new javax.swing.JLabel();
          btnReset = new javax.swing.JButton();

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

          jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
          jLabel1.setForeground(new java.awt.Color(255, 0, 0));
          jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
          jLabel1.setText("XỔ SỐ KIẾN THIẾT");

          txt100.setHorizontalAlignment(javax.swing.JTextField.CENTER);
          txt100.setText("x");
          txt100.setFocusCycleRoot(true);

          txt10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
          txt10.setText("x");

          txt1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
          txt1.setText("x");

          btn100.setText("Start");
          btn100.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btn100ActionPerformed(evt);
               }
          });

          btn10.setText("Start");
          btn10.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btn10ActionPerformed(evt);
               }
          });

          btn1.setText("Start");
          btn1.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btn1ActionPerformed(evt);
               }
          });

          jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
          jLabel2.setText("Trăm");

          jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
          jLabel3.setText("Chục");

          jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
          jLabel4.setText("Đơn vị");

          btnReset.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
          btnReset.setText("Reset");
          btnReset.setEnabled(false);
          btnReset.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnResetActionPerformed(evt);
               }
          });

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addGroup(layout.createSequentialGroup()
                    .addGap(59, 59, 59)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                              .addComponent(txt100, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(btn100, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addComponent(jLabel2))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(txt10, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(btn10, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(jLabel3)
                         .addGroup(layout.createSequentialGroup()
                              .addGap(6, 6, 6)
                              .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(jLabel4)
                         .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(51, Short.MAX_VALUE))
          );
          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(jLabel1)
                    .addGap(40, 40, 40)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel2)
                         .addComponent(jLabel3)
                         .addComponent(jLabel4))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                         .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(txt10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(txt100, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(btn10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(btn100, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(21, 21, 21)
                    .addComponent(btnReset)
                    .addContainerGap(12, Short.MAX_VALUE))
          );

          pack();
     }// </editor-fold>//GEN-END:initComponents

//     public void show(JTextField txt) {
//          Thread tR = new Thread(new Runnable() {
//               @Override
//               public void run() {
//                    for (int i = 0; i < 500; i++) {
//                         txt.setText(String.valueOf(Math.round(9 * Math.random())));
//                         try {
//                              Thread.sleep(10);
//                         } catch (Exception ex) {
//                         }
//                         notify();
//                    }
//               }
//          }).start();
//     }

     private void btn100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn100ActionPerformed
//          btn100.setEnabled(false);
//          btn10.grabFocus();
//          show(txt100);
//          show(txt10);
     }//GEN-LAST:event_btn100ActionPerformed

     private void btn10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn10ActionPerformed

     }//GEN-LAST:event_btn10ActionPerformed

     private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
          btnReset.setEnabled(true);
          btn1.setEnabled(false);
          btnReset.grabFocus();
//          show(txt1);
     }//GEN-LAST:event_btn1ActionPerformed

     private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
          txt100.setText("x");
          txt10.setText("x");
          txt1.setText("x");
          btn100.setEnabled(true);
          btn10.setEnabled(true);
          btn1.setEnabled(true);
          btnReset.setEnabled(false);
          btn100.grabFocus();
     }//GEN-LAST:event_btnResetActionPerformed

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
               java.util.logging.Logger.getLogger(Lottery.class
                       .getName()).log(java.util.logging.Level.SEVERE, null, ex);

          } catch (InstantiationException ex) {
               java.util.logging.Logger.getLogger(Lottery.class
                       .getName()).log(java.util.logging.Level.SEVERE, null, ex);

          } catch (IllegalAccessException ex) {
               java.util.logging.Logger.getLogger(Lottery.class
                       .getName()).log(java.util.logging.Level.SEVERE, null, ex);

          } catch (javax.swing.UnsupportedLookAndFeelException ex) {
               java.util.logging.Logger.getLogger(Lottery.class
                       .getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
          //</editor-fold>

          java.awt.EventQueue.invokeLater(new Runnable() {
               public void run() {
                    new Lottery().setVisible(true);
               }
          });
     }

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JButton btn1;
     private javax.swing.JButton btn10;
     private javax.swing.JButton btn100;
     private javax.swing.JButton btnReset;
     private javax.swing.JLabel jLabel1;
     private javax.swing.JLabel jLabel2;
     private javax.swing.JLabel jLabel3;
     private javax.swing.JLabel jLabel4;
     private javax.swing.JTextField txt1;
     private javax.swing.JTextField txt10;
     private javax.swing.JTextField txt100;
     // End of variables declaration//GEN-END:variables

}

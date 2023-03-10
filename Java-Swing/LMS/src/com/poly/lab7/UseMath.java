package com.poly.lab7;

import static java.lang.Math.*;
import javax.swing.JOptionPane;

public class UseMath extends javax.swing.JFrame {

     public UseMath() {
          initComponents();
          this.setTitle("Sử dụng Math");
          this.setLocationRelativeTo(null);
          this.getRootPane().setDefaultButton(btn);
     }

     @SuppressWarnings(
             "unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          jLabel1 = new javax.swing.JLabel();
          jLabel2 = new javax.swing.JLabel();
          jLabel3 = new javax.swing.JLabel();
          jLabel4 = new javax.swing.JLabel();
          jLabel5 = new javax.swing.JLabel();
          jLabel7 = new javax.swing.JLabel();
          jLabel8 = new javax.swing.JLabel();
          txtA = new javax.swing.JTextField();
          txtB = new javax.swing.JTextField();
          txtSqrt = new javax.swing.JTextField();
          txtPow = new javax.swing.JTextField();
          txtMin = new javax.swing.JTextField();
          txtMax = new javax.swing.JTextField();
          btn = new javax.swing.JButton();

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

          jLabel1.setText("Số thứ 1");

          jLabel2.setText("Số thứ 2");

          jLabel3.setText("Căn bậc 2:");

          jLabel4.setText("KẾT QUẢ");

          jLabel5.setText("Số nhỏ nhất");

          jLabel7.setText("Số lớn nhất");

          jLabel8.setText("Lũy thừa");

          txtSqrt.setEnabled(false);

          txtPow.setEnabled(false);

          txtMin.setEnabled(false);

          txtMax.setEnabled(false);

          btn.setText("Thực hiện");
          btn.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnActionPerformed(evt);
               }
          });

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(jLabel4)
                         .addGroup(layout.createSequentialGroup()
                              .addComponent(jLabel7)
                              .addGap(18, 18, 18)
                              .addComponent(txtMax, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGroup(layout.createSequentialGroup()
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(jLabel5)
                                   .addComponent(jLabel8)
                                   .addComponent(jLabel3)
                                   .addComponent(jLabel2)
                                   .addComponent(jLabel1))
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(txtA, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(txtB, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(txtSqrt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(txtPow, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(txtMin, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn)
                    .addContainerGap())
          );
          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel1)
                         .addComponent(txtA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel2)
                         .addComponent(txtB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel4)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel3)
                         .addComponent(txtSqrt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel8)
                         .addComponent(txtPow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel5)
                         .addComponent(txtMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel7)
                         .addComponent(txtMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btn)
                    .addContainerGap(13, Short.MAX_VALUE))
          );

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
          if (txtA.getText().isEmpty() || txtB.getText().isEmpty()) {
               JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ 2 số");
          } else {
               try {
                    int a = Integer.parseInt(txtA.getText());
                    int b = Integer.parseInt(txtB.getText());
                    txtSqrt.setText(a < 1 ? "Không tồn tại giá trị căn bậc 2" : "" + sqrt(a));
                    txtPow.setText("" + pow(a, b));
                    txtMax.setText("" + max(a, b));
                    txtMin.setText("" + min(a, b));
               } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Giá trị nhập vào phải là số");
               }
          }
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
               java.util.logging.Logger.getLogger(UseMath.class
                       .getName()).log(java.util.logging.Level.SEVERE, null, ex);

          } catch (InstantiationException ex) {
               java.util.logging.Logger.getLogger(UseMath.class
                       .getName()).log(java.util.logging.Level.SEVERE, null, ex);

          } catch (IllegalAccessException ex) {
               java.util.logging.Logger.getLogger(UseMath.class
                       .getName()).log(java.util.logging.Level.SEVERE, null, ex);

          } catch (javax.swing.UnsupportedLookAndFeelException ex) {
               java.util.logging.Logger.getLogger(UseMath.class
                       .getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
          //</editor-fold>

          java.awt.EventQueue.invokeLater(new Runnable() {
               public void run() {
                    new UseMath().setVisible(true);
               }
          });
     }

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JButton btn;
     private javax.swing.JLabel jLabel1;
     private javax.swing.JLabel jLabel2;
     private javax.swing.JLabel jLabel3;
     private javax.swing.JLabel jLabel4;
     private javax.swing.JLabel jLabel5;
     private javax.swing.JLabel jLabel7;
     private javax.swing.JLabel jLabel8;
     private javax.swing.JTextField txtA;
     private javax.swing.JTextField txtB;
     private javax.swing.JTextField txtMax;
     private javax.swing.JTextField txtMin;
     private javax.swing.JTextField txtPow;
     private javax.swing.JTextField txtSqrt;
     // End of variables declaration//GEN-END:variables

}

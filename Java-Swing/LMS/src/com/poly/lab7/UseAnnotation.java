package com.poly.lab7;

import javax.swing.JOptionPane;
import static com.poly.lab7.XFile.*;

public class UseAnnotation extends javax.swing.JFrame {

     public UseAnnotation() {
          initComponents();
          this.setTitle("Annotation");
          this.setLocationRelativeTo(null);
          this.getRootPane().setDefaultButton(btn);
     }

     @SuppressWarnings(
             "unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          jLabel1 = new javax.swing.JLabel();
          txt = new javax.swing.JTextField();
          btn = new javax.swing.JButton();

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

          jLabel1.setText("Credit Card");

          btn.setText("Kiểm tra");
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
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                         .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btn)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          );

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
          if (txt.getText().isEmpty()) {
               JOptionPane.showMessageDialog(this, "Vui lòng nhập giá trị");
          } else{
               try {
                    if(isCardNumber(txt.getText()))
                         JOptionPane.showMessageDialog(this, "Tổng chuỗi là chẵn");
                    else
                         JOptionPane.showMessageDialog(this, "Tổng chuỗi là lẻ");
               } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập chuỗi số");
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
               java.util.logging.Logger.getLogger(UseAnnotation.class
                       .getName()).log(java.util.logging.Level.SEVERE, null, ex);

          } catch (InstantiationException ex) {
               java.util.logging.Logger.getLogger(UseAnnotation.class
                       .getName()).log(java.util.logging.Level.SEVERE, null, ex);

          } catch (IllegalAccessException ex) {
               java.util.logging.Logger.getLogger(UseAnnotation.class
                       .getName()).log(java.util.logging.Level.SEVERE, null, ex);

          } catch (javax.swing.UnsupportedLookAndFeelException ex) {
               java.util.logging.Logger.getLogger(UseAnnotation.class
                       .getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
          //</editor-fold>

          java.awt.EventQueue.invokeLater(new Runnable() {
               public void run() {
                    new UseAnnotation().setVisible(true);
               }
          });
     }

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JButton btn;
     private javax.swing.JLabel jLabel1;
     private javax.swing.JTextField txt;
     // End of variables declaration//GEN-END:variables

}

package buoi12;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Boom
        extends javax.swing.JFrame {

     public Boom() {
          initComponents();
          txtBoom.setVisible(false);
     }

     @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          btnBoom = new javax.swing.JButton();
          txtBoom = new javax.swing.JLabel();

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

          btnBoom.setText("Đặt boom");
          btnBoom.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnBoomActionPerformed(evt);
               }
          });

          txtBoom.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
          txtBoom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
          txtBoom.setText("Bùm!!!");

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(txtBoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(14, 14, 14))
               .addGroup(layout.createSequentialGroup()
                    .addGap(136, 136, 136)
                    .addComponent(btnBoom)
                    .addContainerGap(136, Short.MAX_VALUE))
          );
          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addComponent(btnBoom)
                    .addGap(64, 64, 64)
                    .addComponent(txtBoom, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(114, Short.MAX_VALUE))
          );

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void btnBoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoomActionPerformed
          btnBoom.setText("00:30");
          new Thread(new Runnable() {
               @Override
               public void run() {
                    for (int i = 29; i >= 0; i--) {
                         if (i > 9) {
                              btnBoom.setText("00:" + i);
                         } else {
                              btnBoom.setText("00:0" + i);
                         }
                         if (i == 0) {
                              txtBoom.setVisible(true);
                         }
                         try {
                              Thread.sleep(1000);
                         } catch (InterruptedException ex) {
                              Logger.getLogger(Boom.class.getName()).log(Level.SEVERE, null, ex);
                         }
                    }

               }
          }).start();
     }//GEN-LAST:event_btnBoomActionPerformed

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
               java.util.logging.Logger.getLogger(Boom.class
                       .getName()).log(java.util.logging.Level.SEVERE, null, ex);

          } catch (InstantiationException ex) {
               java.util.logging.Logger.getLogger(Boom.class
                       .getName()).log(java.util.logging.Level.SEVERE, null, ex);

          } catch (IllegalAccessException ex) {
               java.util.logging.Logger.getLogger(Boom.class
                       .getName()).log(java.util.logging.Level.SEVERE, null, ex);

          } catch (javax.swing.UnsupportedLookAndFeelException ex) {
               java.util.logging.Logger.getLogger(Boom.class
                       .getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
          //</editor-fold>

          java.awt.EventQueue.invokeLater(new Runnable() {
               public void run() {
                    new Boom().setVisible(true);
               }
          });
     }

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JButton btnBoom;
     private javax.swing.JLabel txtBoom;
     // End of variables declaration//GEN-END:variables

}

package Buoi9.ui;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

public class UI extends javax.swing.JFrame {

    public UI() {
        initComponents();
        this.setTitle("");
        this.setLocationRelativeTo(null);
        this.getRootPane().setDefaultButton(btnWrite);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnWrite = new javax.swing.JButton();
        btnRead = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTemp = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nhập xuất dữ liệu (Nhị phân)");

        btnWrite.setText("Ghi dữ liệu");
        btnWrite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWriteActionPerformed(evt);
            }
        });

        btnRead.setText("Đọc dữ liệu");
        btnRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });

        txtTemp.setColumns(20);
        txtTemp.setRows(5);
        jScrollPane1.setViewportView(txtTemp);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnWrite)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRead)))
                .addGap(61, 61, 61))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnWrite)
                    .addComponent(btnRead))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnWriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWriteActionPerformed
        try {
            FileOutputStream fileOS = new FileOutputStream("D:\\slide5.bin");
            DataOutputStream dos = new DataOutputStream(fileOS);
            dos.writeInt(10);
            dos.writeDouble(10.5);
            fileOS.close();
            dos.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Loi ghi dữ liệu");
        }

    }//GEN-LAST:event_btnWriteActionPerformed

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
        try {
            FileInputStream fileIS = new FileInputStream("D:\\slide5.bin");
            DataInputStream dis = new DataInputStream(fileIS);
            int a = dis.readInt();
            double b = dis.readDouble();
            JOptionPane.showMessageDialog(this, a+" || "+b);
            fileIS.close();
            dis.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi ghi dữ liệu");
        }
    }//GEN-LAST:event_btnReadActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRead;
    private javax.swing.JButton btnWrite;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtTemp;
    // End of variables declaration//GEN-END:variables

}

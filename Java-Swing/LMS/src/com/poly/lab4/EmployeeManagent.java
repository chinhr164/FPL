package com.poly.lab4;

import java.awt.Color;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EmployeeManagent extends javax.swing.JFrame {

    public EmployeeManagent() {
        initComponents();
        this.setTitle("Quản lý nhân viên");
        this.setLocationRelativeTo(null);
        this.getRootPane().setDefaultButton(btnCheck);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtBirth = new javax.swing.JTextField();
        txtSalary = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnCheck = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("HỌ VÀ TÊN");

        jLabel2.setText("NGÀY SINH");

        jLabel3.setText("LƯƠNG");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("QUẢN LÝ NHÂN VIÊN");

        btnCheck.setText("KIỂM TRA");
        btnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBirth)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCheck)
                                .addGap(0, 284, Short.MAX_VALUE))
                            .addComponent(txtSalary)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtName))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(btnCheck)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        if (txtName.getText().isEmpty() || txtBirth.getText().isEmpty() || txtSalary.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Điền đủ thông tin", "Thông báo", JOptionPane.WARNING_MESSAGE);
            if (txtName.getText().isEmpty()) {
                txtName.setBackground(Color.yellow);
            } else {
                txtName.setBackground(Color.WHITE);
            }
            if (txtBirth.getText().isEmpty()) {
                txtBirth.setBackground(Color.yellow);
            } else {
                txtBirth.setBackground(Color.WHITE);
            }
            if (txtSalary.getText().isEmpty()) {
                txtSalary.setBackground(Color.yellow);
            } else {
                txtSalary.setBackground(Color.WHITE);
            }
        } else {
            txtName.setBackground(Color.WHITE);
            txtBirth.setBackground(Color.WHITE);
            txtSalary.setBackground(Color.WHITE);
            XDate validator1 = new XDate(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            XDate validator2 = new XDate(DateTimeFormatter.ofPattern("d-M-yyyy"));
            if (validator1.isValid(txtBirth.getText()) && validator2.isValid(txtBirth.getText())) {
                for (int i = 0; i < fillter.length; i++) {
                    if (txtBirth.getText().substring(0, txtBirth.getText().lastIndexOf("-")).equals(fillter[i])) {
                        txtBirth.setBackground(Color.yellow);
                        JOptionPane.showMessageDialog(this, "Không đúng định dạng ngày tháng", "Thông báo", JOptionPane.ERROR_MESSAGE);
                        break;
                    }                   
                }
                return;
            } else {
                txtBirth.setBackground(Color.yellow);
                JOptionPane.showMessageDialog(this, "Không đúng định dạng ngày tháng", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        }

        try {
            txtSalary.setBackground(Color.WHITE);
            Double.parseDouble(txtSalary.getText());
        } catch (Exception ex) {
            txtSalary.setBackground(Color.yellow);
            JOptionPane.showMessageDialog(this, "Lương là giá trị số", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCheckActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeManagent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeManagent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeManagent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeManagent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeManagent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheck;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtBirth;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSalary;
    // End of variables declaration//GEN-END:variables

    String[] fillter = {
        "30-02", "31-02", "31-04", "31-06", "31-09", "31-11",
        "30/02", "31/02", "31/04", "31/06", "31/09", "31/11",
        "30-2", "31-2", "31-4", "31-6", "31-9",
        "30/2", "31/2", "31/4", "31/6", "31/9"
    };

}

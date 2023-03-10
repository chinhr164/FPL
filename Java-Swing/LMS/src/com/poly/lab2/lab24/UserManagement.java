package com.poly.lab2.lab24;

import java.util.ArrayList;
import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.TableUI;
import javax.swing.table.DefaultTableModel;

public class UserManagement extends javax.swing.JFrame {

    public UserManagement() {
        initComponents();

        this.setTitle("User Management");
        this.setLocationRelativeTo(null);
        this.getRootPane().setDefaultButton(btnAdd);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpRole = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        lblRole = new javax.swing.JLabel();
        rdoUser = new javax.swing.JRadioButton();
        rdoAdmin = new javax.swing.JRadioButton();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUserList = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("User Management");

        lblUsername.setText("Username");

        lblPassword.setText("Password");

        lblRole.setText("Role");

        grpRole.add(rdoUser);
        rdoUser.setText("User");

        grpRole.add(rdoAdmin);
        rdoAdmin.setText("Admin");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPassword)
                    .addComponent(lblUsername)
                    .addComponent(lblRole))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rdoUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoAdmin)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtUsername)
                            .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(14, 14, 14))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRemove)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReset)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRole)
                    .addComponent(rdoUser)
                    .addComponent(rdoAdmin))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnReset)
                    .addComponent(btnRemove)
                    .addComponent(btnAdd))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("EDITION", jPanel1);

        tblUserList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "USERNAME", "PASSWORD", "ROLE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUserList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUserListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUserList);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("LIST", jPanel11);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        fillColumn();
        fillTable();
    }//GEN-LAST:event_formWindowOpened

    private void tblUserListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserListMouseClicked
        int i = tblUserList.getSelectedRow();
        writeForm(list.get(i));
    }//GEN-LAST:event_tblUserListMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        clearForm();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        boolean flag = true;
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        ButtonModel role = null;
        role = grpRole.getSelection();
        if (username.equals("") || password.equals("") || role == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đủ thông tin", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            addUser();
            fillTable();
            JOptionPane.showMessageDialog(this, "Thêm user thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            updateUser();
            fillTable();
            JOptionPane.showMessageDialog(this, "Cập nhật user thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn User", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        try {
            removeUser();
            fillTable();
            JOptionPane.showMessageDialog(this, "Xóa user thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn User", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnRemoveActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup grpRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JRadioButton rdoAdmin;
    private javax.swing.JRadioButton rdoUser;
    private javax.swing.JTable tblUserList;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    ArrayList<User> list = new ArrayList<>();
    DefaultTableModel model = new DefaultTableModel();

    public void fillColumn() {
        model.setColumnIdentifiers(new String[]{"USERNAME", "PASSWORD", "ROLE"});
        tblUserList.setModel(model);
    }

    public void fillTable() {
        while (model.getRowCount() > 0) {
            model.removeRow(model.getRowCount() - 1);
        }
        for (User user : list) {
            String username = user.getUsername();
            String pass = user.getPassword();
            String role = user.getRole();
            String[] obj = new String[]{username, pass, role};
            model.addRow(obj);
        }

        tblUserList.setModel(model);
    }

    public User readForm() {
        User user = new User();
        user.setUsername(txtUsername.getText());
        user.setPassword(txtPassword.getText());
        if (rdoAdmin.isSelected()) {
            user.setRole("Admin");
        }
        if (rdoUser.isSelected()) {
            user.setRole("User");
        }
        return user;
    }

    public void writeForm(User user) {
        txtUsername.setText(user.getUsername());
        txtPassword.setText(user.getPassword());
        if (user.getRole().equalsIgnoreCase("admin")) {
            rdoAdmin.setSelected(true);
        } else {
            rdoUser.setSelected(true);
        }
    }

    public void addUser() {
        list.add(readForm());

        txtUsername.setText("");
        txtPassword.setText("");
        grpRole.clearSelection();
    }

    public void removeUser() {
        int i = tblUserList.getSelectedRow();
        list.remove(i);

        txtUsername.setText("");
        txtPassword.setText("");
        grpRole.clearSelection();
    }

    public void updateUser() {
        int i = tblUserList.getSelectedRow();
        list.remove(i);
        list.add(i, readForm());
    }

    public void clearForm() {
        txtUsername.setText("");
        txtPassword.setText("");
        grpRole.clearSelection();
    }
}

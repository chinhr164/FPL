package Test;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sun.awt.AWTAccessor;

public class StaffList extends javax.swing.JFrame {

    public StaffList() {
        initComponents();
        fillColumn();
        loadData();
        loadComboBox();
        this.setTitle("");
        this.setLocationRelativeTo(null);
        this.getRootPane().setDefaultButton(btnAdd);
        System.out.println(cboDepartment.getSelectedItem());
    }

    DefaultTableModel model = new DefaultTableModel();
    ArrayList<Staff> list = new ArrayList<>();

    private void fillColumn() {
        model.setColumnIdentifiers(new String[]{"Mã nhân viên", "Họ tên", "Giới tính", "Quê quán", "Phòng ban"});
        tblStaffList.setModel(model);
    }

    private void loadData() {
        list.add(new Staff("NV01", "Vũ Khắc Bình", "Nam", "Hà Nội", "Tổ chức"));
        list.add(new Staff("NV02", "Hoàng An", "Nam", "Vĩnh Phúc", "Marketing"));
        list.add(new Staff("NV03", "Trần Thu Hoa", "Nữ", "Hưng Yên", "Kế toán"));
        for (Staff staff : list) {
            model.addRow(new String[]{staff.getId(), staff.getName(), staff.getGender(),
                staff.getCountry(), staff.getDepartment()});
        }
        tblStaffList.setModel(model);
    }

    private void loadComboBox() {
        cboDepartment.setModel(new DefaultComboBoxModel<>(new String[]{"Hành chính", "Tổ chức", "Kế toán",
            "Công nghệ thông tin", "Marketing"}));
        cboDepartment.setSelectedItem(null);
    }

    private void fillTable() {
        model.setRowCount(0);
        for (Staff staff : list) {
            model.addRow(new String[]{staff.getId(), staff.getName(), staff.getGender(),
                staff.getCountry(), staff.getDepartment()});
        }
        tblStaffList.setModel(model);
    }

    private Staff readForm() {
        return new Staff(txtId.getText().toUpperCase(), txtName.getText(),
                rdoMale.isSelected() ? "Nam" : (rdoFemale.isSelected() ? "Nữ" : ""),
                txtCountry.getText(), cboDepartment.getSelectedItem() == null ? "" : cboDepartment.getSelectedItem().toString()
        );
    }

    private void writeForm(int i) {
        txtId.setText(tblStaffList.getValueAt(i, 0).toString());
        txtName.setText(tblStaffList.getValueAt(i, 1).toString());
        if (tblStaffList.getValueAt(i, 2).toString().equalsIgnoreCase("nam")) {
            rdoMale.setSelected(true);
        } else if (tblStaffList.getValueAt(i, 2).toString().equalsIgnoreCase("nữ")) {
            rdoFemale.setSelected(true);
        } else {
            grpGender.clearSelection();
        }
        txtCountry.setText(tblStaffList.getValueAt(i, 3).toString());
        cboDepartment.setSelectedItem(
                tblStaffList.getValueAt(i, 4).toString().equals("") ? null : tblStaffList.getValueAt(i, 4).toString());
    }

    private void addStaff() {
        list.add(readForm());
    }

    private void removeStaff() {
        int i = tblStaffList.getSelectedRow();
        list.remove(i);
    }

    private void updateStaff() {
        int i = tblStaffList.getSelectedRow();
        list.remove(i);
        list.add(i, readForm());
    }

    private void clearForm() {
        txtId.setText("");
        txtName.setText("");
        grpGender.clearSelection();
        txtCountry.setText("");
        cboDepartment.setSelectedIndex(-1);
        txtId.grabFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpGender = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStaffList = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        rdoMale = new javax.swing.JRadioButton();
        rdoFemale = new javax.swing.JRadioButton();
        txtCountry = new javax.swing.JTextField();
        cboDepartment = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DANH SÁCH NHÂN VIÊN");

        tblStaffList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStaffList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStaffListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStaffList);

        jLabel2.setText("Mã nhân viên");

        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("*");

        jLabel4.setText("Họ tên");

        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("*");

        jLabel6.setText("Giới tính");

        jLabel7.setText("Quê quán");

        jLabel8.setText("Phòng ban");

        grpGender.add(rdoMale);
        rdoMale.setText("Nam");

        grpGender.add(rdoFemale);
        rdoFemale.setText("Nữ");

        cboDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboDepartment.setSelectedIndex(-1);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Chức năng");

        btnAdd.setText("Thêm mới");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnRemove.setText("Xóa");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnExit.setText("Thoát");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdoMale)
                                .addGap(18, 18, 18)
                                .addComponent(rdoFemale))
                            .addComponent(txtCountry)
                            .addComponent(txtName)
                            .addComponent(txtId)
                            .addComponent(cboDepartment, 0, 230, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnRemove, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnReset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnExit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(rdoMale)
                            .addComponent(rdoFemale))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cboDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblStaffListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStaffListMouseClicked
        writeForm(tblStaffList.getSelectedRow());
    }//GEN-LAST:event_tblStaffListMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (txtName.getText().isEmpty() || txtId.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đủ Mã NV và Họ tên", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            boolean flag = true;
            for (int i = 0; i < tblStaffList.getRowCount(); i++) {
                if (txtId.getText().equalsIgnoreCase(tblStaffList.getValueAt(i, 0).toString())) {
                    JOptionPane.showMessageDialog(this, "Đã tồn tại Mã NV", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    flag = !flag;
                    break;
                }
            }
            if (flag) {
                addStaff();
                fillTable();
                JOptionPane.showMessageDialog(this, "Đã thêm nhân viên " + txtId.getText(),
                        "Thành công", JOptionPane.INFORMATION_MESSAGE);
                clearForm();
            }
        }
        txtId.grabFocus();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int choice = JOptionPane.showConfirmDialog(this, "Chắc chắn cập nhật?", "Thông báo",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (choice == JOptionPane.YES_OPTION) {
            updateStaff();
            fillTable();
            JOptionPane.showMessageDialog(this, "Đã cập nhật nhân viên " + txtId.getText(),
                    "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        int choice = JOptionPane.showConfirmDialog(this, "Chắc chắn xóa?", "Thông báo",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (choice == JOptionPane.YES_OPTION) {
            removeStaff();
            fillTable();
            JOptionPane.showMessageDialog(this, "Đã xóa nhân viên " + txtId.getText(),
                    "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            clearForm();
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        clearForm();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        int choice = JOptionPane.showConfirmDialog(this, "Chắc chắn thoát?", "Thông báo",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int choice = JOptionPane.showConfirmDialog(this, "Chắc chắn thoát?", "Thông báo",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(StaffList.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffList.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffList.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffList.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StaffList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboDepartment;
    private javax.swing.ButtonGroup grpGender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoFemale;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JTable tblStaffList;
    private javax.swing.JTextField txtCountry;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

}

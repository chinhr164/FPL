package com.poly.lab3.model;

import com.poly.lab3.classes.Student;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class StudentManagent extends javax.swing.JFrame {
    
    public StudentManagent() {
        initComponents();
        this.fillMajor();
        this.setTitle("Quản lý sinh viên");
        this.setLocationRelativeTo(null);
        this.getRootPane().setDefaultButton(btnAdd);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMark = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cboMajor = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtGrade = new javax.swing.JTextField();
        chkBonus = new javax.swing.JCheckBox();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudentList = new javax.swing.JTable();
        btnOrderByName = new javax.swing.JButton();
        btnOrderByMark = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("QUẢN LÝ SINH VIÊN");

        jLabel2.setText("HỌ VÀ TÊN");

        jLabel3.setText("ĐIỂM");

        jLabel4.setText("NGÀNH");

        jLabel5.setText("HỌC LỰC");

        txtGrade.setEditable(false);

        chkBonus.setText("Có phần thưởng?");
        chkBonus.setEnabled(false);

        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Cập nhật");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnNew.setText("Nhập mới");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        tblStudentList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tblStudentList.setRowHeight(20);
        tblStudentList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStudentList);
        if (tblStudentList.getColumnModel().getColumnCount() > 0) {
            tblStudentList.getColumnModel().getColumn(0).setMinWidth(150);
            tblStudentList.getColumnModel().getColumn(0).setMaxWidth(150);
            tblStudentList.getColumnModel().getColumn(1).setMinWidth(80);
            tblStudentList.getColumnModel().getColumn(1).setMaxWidth(80);
            tblStudentList.getColumnModel().getColumn(2).setMinWidth(150);
            tblStudentList.getColumnModel().getColumn(2).setMaxWidth(150);
            tblStudentList.getColumnModel().getColumn(3).setMinWidth(100);
            tblStudentList.getColumnModel().getColumn(3).setMaxWidth(100);
            tblStudentList.getColumnModel().getColumn(4).setMinWidth(80);
            tblStudentList.getColumnModel().getColumn(4).setMaxWidth(80);
        }

        btnOrderByName.setText("Sắp xếp theo tên");
        btnOrderByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderByNameActionPerformed(evt);
            }
        });

        btnOrderByMark.setText("Sắp xếp theo điểm");
        btnOrderByMark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderByMarkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtName)
                                    .addComponent(txtMark)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(chkBonus)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnAdd)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnDelete)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnUpdate)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnNew))
                                            .addComponent(cboMajor, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtGrade)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnOrderByName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnOrderByMark)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboMajor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkBonus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnDelete)
                    .addComponent(btnUpdate)
                    .addComponent(btnNew))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOrderByName)
                    .addComponent(btnOrderByMark))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        this.fillColumn();
    }//GEN-LAST:event_formWindowOpened

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        txtName.setText("");
        txtMark.setText("");
        cboMajor.setSelectedIndex(-1);
        txtGrade.setText("");
        chkBonus.setSelected(false);
        txtName.grabFocus();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String name = txtName.getText();
        String mark = txtMark.getText();
        int major = cboMajor.getSelectedIndex();
        if (name.equals("") || mark.equals("") || major == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đủ thông tin", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            if (Double.parseDouble(mark) < 0 || Double.parseDouble(mark) > 10) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập điểm từ 0 - 10", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else {
                this.addStudent();
                this.fillTable();
                JOptionPane.showMessageDialog(this, "Thêm sinh viên thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
                txtName.setText("");
                txtMark.setText("");
                cboMajor.setSelectedIndex(-1);
                txtGrade.setText("");
                chkBonus.setSelected(false);
                txtName.grabFocus();
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            this.removeStudent();
            int choice = JOptionPane.showConfirmDialog(this, "Chắc chắn xoá?", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            if (choice == JOptionPane.YES_OPTION) {
                this.fillTable();
                txtName.setText("");
                txtMark.setText("");
                cboMajor.setSelectedIndex(-1);
                txtGrade.setText("");
                chkBonus.setSelected(false);
                txtName.grabFocus();
                JOptionPane.showMessageDialog(this, "Xóa sinh viên thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn Sinh viên", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            String name = txtName.getText();
            String mark = txtMark.getText();
            int major = cboMajor.getSelectedIndex();
            if (name.equals("") || mark.equals("") || major == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng điền đủ thông tin", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else {
                if (Double.parseDouble(mark) < 0 || Double.parseDouble(mark) > 10) {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập điểm từ 0 - 10", "Lỗi", JOptionPane.ERROR_MESSAGE);
                } else {
                    int choice = JOptionPane.showConfirmDialog(this, "Chắc chắn cập nhật?", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                    if (choice == JOptionPane.YES_OPTION) {
                        updateStudent();
                        fillTable();
                        JOptionPane.showMessageDialog(this, "Cập nhật sinh viên thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
                        txtName.setText("");
                        txtMark.setText("");
                        cboMajor.setSelectedIndex(-1);
                        txtGrade.setText("");
                        chkBonus.setSelected(false);
                        txtName.grabFocus();
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn Sinh viên", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tblStudentListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentListMouseClicked
        // TODO add your handling code here:
        this.showDetail();
    }//GEN-LAST:event_tblStudentListMouseClicked
    
    boolean flag1 = true;
    private void btnOrderByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderByNameActionPerformed
        this.orderByName(flag1);
        this.fillTable();
        flag1 = !flag1;
    }//GEN-LAST:event_btnOrderByNameActionPerformed
    
    boolean flag2 = true;
    private void btnOrderByMarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderByMarkActionPerformed
        this.orderByMark(flag2);
        this.fillTable();
        flag2 = !flag2;
    }//GEN-LAST:event_btnOrderByMarkActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int choice = JOptionPane.showConfirmDialog(this, "Chắc chắn thoát?", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
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
            java.util.logging.Logger.getLogger(StudentManagent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentManagent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentManagent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentManagent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentManagent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnOrderByMark;
    private javax.swing.JButton btnOrderByName;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboMajor;
    private javax.swing.JCheckBox chkBonus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblStudentList;
    private javax.swing.JTextField txtGrade;
    private javax.swing.JTextField txtMark;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

    public void fillMajor() {
        String[] major = {"Ứng dụng phần mềm", "Lập trình Mobile",
            "Thiết kế đồ họa", "Thương mại điện tử"};
        cboMajor.setModel(new javax.swing.DefaultComboBoxModel<>(major));
    }
    
    ArrayList<Student> list = new ArrayList<>();
    DefaultTableModel model = new DefaultTableModel();
    
    public void addStudent() {
        Student student = new Student();
        student.setName(txtName.getText());
        student.setMark(Double.parseDouble(txtMark.getText()));
        student.setMajor(cboMajor.getSelectedItem().toString());
        list.add(student);
    }
    
    public void removeStudent() {
        int i = tblStudentList.getSelectedRow();
        list.remove(i);
    }
    
    public void updateStudent() {
        Student student = new Student();
        student.setName(txtName.getText());
        student.setMark(Double.parseDouble(txtMark.getText()));
        student.setMajor(cboMajor.getSelectedItem().toString());
        int i = tblStudentList.getSelectedRow();
        this.removeStudent();
        list.add(i, student);
    }
    
    public void fillColumn() {
        model.setColumnIdentifiers(new String[]{"HỌ VÀ TÊN", "ĐIỂM", "NGÀNH", "HỌC LỰC", "THƯỞNG"});
        tblStudentList.setModel(model);
    }
    
    public void fillTable() {
        while (model.getRowCount() > 0) {
            model.removeRow(model.getRowCount() - 1);
        }
        for (Student student : list) {
            String name = student.getName();
            String mark = String.valueOf(student.getMark());
            String major = student.getMajor();
            String grade = student.getGrade();
            String bonus = student.isBonus() ? "Có" : "Không";
            model.addRow(new String[]{name, mark, major, grade, bonus});
            tblStudentList.setModel(model);
        }
    }
    
    private void showDetail() {
        int i = tblStudentList.getSelectedRow();
        Student student = list.get(i);
        txtName.setText(student.getName());
        txtMark.setText(String.valueOf(student.getMark()));
        cboMajor.setSelectedItem(student.getMajor());
        txtGrade.setText(student.getGrade());
        chkBonus.setSelected(student.isBonus());
    }
    
    public void orderByName(boolean flag) {
        if (flag) {
            list.sort((sv1, sv2) -> (int) (sv1.getName().compareTo(sv2.getName())));
        } else {
            Collections.reverse(list);
        }
    }
    
    public void orderByMark(boolean flag) {
        if (flag) {
            list.sort((sv1, sv2) -> (int) (sv1.getMark() - sv2.getMark()));
        } else {
           Collections.reverse(list);
        }
    }
}
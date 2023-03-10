package TestLab8.model;

import TestLab8.classes.Student;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class StudentManage extends javax.swing.JFrame {

      public StudentManage() {
            initComponents();
            this.setTitle("Quản lý Sinh viên");
            this.setLocationRelativeTo(null);
            initData();
            cboMajor.setModel(new DefaultComboBoxModel<>(new String[]{"CNTT", "UD", "TKĐH","TKĐH"}));
      }

      @SuppressWarnings(
              "unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            jScrollPane1 = new javax.swing.JScrollPane();
            jTable1 = new javax.swing.JTable();
            jLabel1 = new javax.swing.JLabel();
            jLabel2 = new javax.swing.JLabel();
            jLabel3 = new javax.swing.JLabel();
            jLabel4 = new javax.swing.JLabel();
            txtName = new javax.swing.JTextField();
            txtMark = new javax.swing.JTextField();
            cboMajor = new javax.swing.JComboBox<>();
            btnLoad = new javax.swing.JButton();
            btnSave = new javax.swing.JButton();
            btnFind = new javax.swing.JButton();
            jScrollPane2 = new javax.swing.JScrollPane();
            tblList = new javax.swing.JTable();

            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                  new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                  },
                  new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                  }
            ));
            jScrollPane1.setViewportView(jTable1);

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(255, 0, 51));
            jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel1.setText("QUẢN LÝ SINH VIÊN");

            jLabel2.setText("Tên SV");

            jLabel3.setText("Bộ môn");

            jLabel4.setText("Điểm");

            cboMajor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

            btnLoad.setText("Load");
            btnLoad.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnLoadActionPerformed(evt);
                  }
            });

            btnSave.setText("Save");
            btnSave.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnSaveActionPerformed(evt);
                  }
            });

            btnFind.setText("Find");
            btnFind.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnFindActionPerformed(evt);
                  }
            });

            tblList.setModel(new javax.swing.table.DefaultTableModel(
                  new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                  },
                  new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                  }
            ));
            tblList.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        tblListMouseClicked(evt);
                  }
            });
            jScrollPane2.setViewportView(tblList);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                              .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                              .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                          .addComponent(jLabel2)
                                          .addComponent(jLabel3)
                                          .addComponent(jLabel4))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                          .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtMark, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                          .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                          .addGroup(layout.createSequentialGroup()
                                                .addComponent(cboMajor, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())
            );
            layout.setVerticalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(jLabel2)
                              .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(btnLoad))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(jLabel3)
                              .addComponent(cboMajor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(btnSave))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnFind))
                              .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            pack();
      }// </editor-fold>//GEN-END:initComponents

      private void tblListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListMouseClicked
            writeForm(tblList.getSelectedRow());
      }//GEN-LAST:event_tblListMouseClicked

      private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
            File file = new File("D:/chinhcvph21409");
            if (!file.exists()) {
                  file.mkdirs();
            }
            try {
                  FileInputStream fis = new FileInputStream(file.getAbsoluteFile() + "/StudentList.bin");
                  ObjectInputStream ois = new ObjectInputStream(fis);
                  list = (ArrayList<Student>) ois.readObject();
                  fillTable();
                  fis.close();
                  ois.close();
            } catch (Exception e) {
            }
            writeForm(0);
      }//GEN-LAST:event_btnLoadActionPerformed

      private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
            if (txtName.getText().isEmpty() || txtMark.getText().isEmpty()) {
                  JOptionPane.showMessageDialog(this, "Vui lòng điền đủ thông tin");
            } else {
                  try {
                        double a = Double.parseDouble(txtMark.getText());
                        if (a < 0 || 10 < a) {
                              JOptionPane.showMessageDialog(this, "Điểm nhập từ 0 - 10");
                        } else {
                              list.add(new Student(txtName.getText(),
                                      cboMajor.getSelectedItem() + "", Double.parseDouble(txtMark.getText())));
                              File file = new File("D:/chinhcvph21409");
                              if (!file.exists()) {
                                    file.mkdirs();
                              }
                              try {
                                    FileOutputStream fos = new FileOutputStream(
                                            file.getAbsoluteFile() + "/StudentList.bin");
                                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                                    oos.writeObject(list);
                                    fos.close();
                                    oos.close();
                                    JOptionPane.showMessageDialog(this, "Thành công");
                              } catch (Exception e) {
                                    JOptionPane.showMessageDialog(this, "lỗi");
                              }
                        }
                  } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Điểm nhập vào phải là số");
                  }
            }
      }//GEN-LAST:event_btnSaveActionPerformed

      private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
            boolean flag = true;
            String find = JOptionPane.showInputDialog("Tên SV");
            for (Student s : list) {
                  if (s.getName().equalsIgnoreCase(find)) {
                        txtName.setText(s.getName());
                        cboMajor.setSelectedItem(s.getMajor());
                        txtMark.setText(s.getMark() + "");
                        tblList.setRowSelectionInterval(list.indexOf(s), list.indexOf(s));
                        flag = !flag;
                        break;
                  }
            }
            if (flag)
                  JOptionPane.showMessageDialog(this, "Không tìm thấy sinh viên");
      }//GEN-LAST:event_btnFindActionPerformed

      ArrayList<Student> list = new ArrayList<>();

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
                  java.util.logging.Logger.getLogger(StudentManage.class
                          .getName()).log(java.util.logging.Level.SEVERE, null, ex);

            } catch (InstantiationException ex) {
                  java.util.logging.Logger.getLogger(StudentManage.class
                          .getName()).log(java.util.logging.Level.SEVERE, null, ex);

            } catch (IllegalAccessException ex) {
                  java.util.logging.Logger.getLogger(StudentManage.class
                          .getName()).log(java.util.logging.Level.SEVERE, null, ex);

            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                  java.util.logging.Logger.getLogger(StudentManage.class
                          .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            java.awt.EventQueue.invokeLater(new Runnable() {
                  public void run() {
                        new StudentManage().setVisible(true);
                  }
            });
      }

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private javax.swing.JButton btnFind;
      private javax.swing.JButton btnLoad;
      private javax.swing.JButton btnSave;
      private javax.swing.JComboBox<String> cboMajor;
      private javax.swing.JLabel jLabel1;
      private javax.swing.JLabel jLabel2;
      private javax.swing.JLabel jLabel3;
      private javax.swing.JLabel jLabel4;
      private javax.swing.JScrollPane jScrollPane1;
      private javax.swing.JScrollPane jScrollPane2;
      private javax.swing.JTable jTable1;
      private javax.swing.JTable tblList;
      private javax.swing.JTextField txtMark;
      private javax.swing.JTextField txtName;
      // End of variables declaration//GEN-END:variables

      public void initData() {
            list.add(new Student("Chỉnh", "CNTT", 1));
            list.add(new Student("Hiếu", "TMĐT", 5));
            list.add(new Student("Khang", "UD", 10));
      }

      public void fillTable() {
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new String[]{"Tên SV", "Bộ môn", "Điểm", "KQ"});
            for (Student s : list) {
                  model.addRow(new String[]{s.getName(), s.getMajor(), "" + s.getMark(), s.isResult() ? "Đỗ" : "Trượt"});
            }
            tblList.setModel(model);
      }

      public void writeForm(int row) {
            txtName.setText(tblList.getValueAt(row, 0) + "");
            cboMajor.setSelectedItem(tblList.getValueAt(row, 1));
            txtMark.setText(tblList.getValueAt(row, 2) + "");
            tblList.setRowSelectionInterval(row, row);
      }
}

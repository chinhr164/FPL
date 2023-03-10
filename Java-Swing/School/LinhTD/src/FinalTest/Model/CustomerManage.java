package FinalTest.Model;

import FinalTest.Classes.KH;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CustomerManage extends javax.swing.JFrame {

      public CustomerManage() {
            initComponents();
            this.setTitle("Quản Lý Khách Hàng");
            this.setLocationRelativeTo(null);
//            initData();
            fillTable();
            effect();
      }

      ArrayList<KH> list = new ArrayList<>();

      @SuppressWarnings(
              "unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            grGender = new javax.swing.ButtonGroup();
            lbl = new javax.swing.JLabel();
            jLabel2 = new javax.swing.JLabel();
            jLabel3 = new javax.swing.JLabel();
            jLabel4 = new javax.swing.JLabel();
            rdoFemale = new javax.swing.JRadioButton();
            rdoMale = new javax.swing.JRadioButton();
            btnUpdate = new javax.swing.JButton();
            btnSave = new javax.swing.JButton();
            btnOpen = new javax.swing.JButton();
            jScrollPane1 = new javax.swing.JScrollPane();
            tblList = new javax.swing.JTable();
            txtName = new javax.swing.JTextField();
            txtAge = new javax.swing.JTextField();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            lbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
            lbl.setForeground(new java.awt.Color(255, 0, 0));
            lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lbl.setText("QUẢN LÝ KHÁCH HÀNG ");

            jLabel2.setText("Họ tên");

            jLabel3.setText("Giới tính");

            jLabel4.setText("Tuổi");

            grGender.add(rdoFemale);
            rdoFemale.setText("Nam");

            grGender.add(rdoMale);
            rdoMale.setText("Nữ");

            btnUpdate.setText("Sửa");
            btnUpdate.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnUpdateActionPerformed(evt);
                  }
            });

            btnSave.setText("Ghi");
            btnSave.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnSaveActionPerformed(evt);
                  }
            });

            btnOpen.setText("Mở");
            btnOpen.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnOpenActionPerformed(evt);
                  }
            });

            tblList.setModel(new javax.swing.table.DefaultTableModel(
                  new Object [][] {

                  },
                  new String [] {

                  }
            ));
            tblList.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        tblListMouseClicked(evt);
                  }
            });
            jScrollPane1.setViewportView(tblList);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(15, 15, 15))
                              .addGroup(layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                          .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                          .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                      .addComponent(jLabel3)
                                                      .addComponent(jLabel4)
                                                      .addComponent(jLabel2))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                      .addGroup(layout.createSequentialGroup()
                                                            .addComponent(rdoFemale, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(rdoMale, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                      .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                      .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                      .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                      .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                      .addComponent(btnOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addContainerGap(26, Short.MAX_VALUE))))
            );
            layout.setVerticalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(jLabel2)
                              .addComponent(btnSave)
                              .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(jLabel3)
                              .addComponent(rdoFemale)
                              .addComponent(rdoMale)
                              .addComponent(btnUpdate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(jLabel4)
                              .addComponent(btnOpen)
                              .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                        .addContainerGap())
            );

            pack();
      }// </editor-fold>//GEN-END:initComponents

      private void tblListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListMouseClicked
            writeForm(tblList.getSelectedRow());
      }//GEN-LAST:event_tblListMouseClicked

      private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
            if (txtName.getText().isEmpty() || txtAge.getText().isEmpty()) {
                  JOptionPane.showMessageDialog(this, "Nhập đủ thông tin!!");
            } else {
                  try {
                        int age = Integer.parseInt(txtAge.getText());
                        if (age < 1) {
                              JOptionPane.showMessageDialog(this, "Tuổi là số dương");
                        } else {
                              list.add(
                                      new KH(txtName.getText(),
                                              rdoFemale.isSelected() ? "Nam" : (rdoMale.isSelected() ? "Nữ" : ""), age));
                              clearForm();
                              fillTable();
                        }
                  } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Tuổi là giá trị số");
                  }
            }
      }//GEN-LAST:event_btnSaveActionPerformed

      private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
            if (list.size() == 0) {
                  JOptionPane.showMessageDialog(this, "Chưa có dữ liệu - Vui lòng ghi dữ liệu");
            } else {
                  try {
                        FileInputStream fis = new FileInputStream("D:/chinhcvph21409/Customer.bin");
                        ObjectInputStream ois = new ObjectInputStream(fis);
                        list = (ArrayList<KH>) ois.readObject();
                        fis.close();
                        ois.close();
                        fillTable();
                        writeForm(0);
                  } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Lỗi đọc file!!!");
                  }
            }
      }//GEN-LAST:event_btnOpenActionPerformed

      private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
            list.set(tblList.getSelectedRow(),
                    new KH(txtName.getText(), rdoFemale.isSelected() ? "Nam" : (rdoMale.isSelected() ? "Nữ" : ""),
                            Integer.parseInt(txtAge.getText())));
            writeFile();
            JOptionPane.showMessageDialog(this, "Sửa thành công!!!");
            clearForm();
            fillTable();
      }//GEN-LAST:event_btnUpdateActionPerformed

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
                  java.util.logging.Logger.getLogger(CustomerManage.class
                          .getName()).log(java.util.logging.Level.SEVERE, null, ex);

            } catch (InstantiationException ex) {
                  java.util.logging.Logger.getLogger(CustomerManage.class
                          .getName()).log(java.util.logging.Level.SEVERE, null, ex);

            } catch (IllegalAccessException ex) {
                  java.util.logging.Logger.getLogger(CustomerManage.class
                          .getName()).log(java.util.logging.Level.SEVERE, null, ex);

            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                  java.util.logging.Logger.getLogger(CustomerManage.class
                          .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            java.awt.EventQueue.invokeLater(new Runnable() {
                  public void run() {
                        new CustomerManage().setVisible(true);
                  }
            });
      }

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private javax.swing.JButton btnOpen;
      private javax.swing.JButton btnSave;
      private javax.swing.JButton btnUpdate;
      private javax.swing.ButtonGroup grGender;
      private javax.swing.JLabel jLabel2;
      private javax.swing.JLabel jLabel3;
      private javax.swing.JLabel jLabel4;
      private javax.swing.JScrollPane jScrollPane1;
      private javax.swing.JLabel lbl;
      private javax.swing.JRadioButton rdoFemale;
      private javax.swing.JRadioButton rdoMale;
      private javax.swing.JTable tblList;
      private javax.swing.JTextField txtAge;
      private javax.swing.JTextField txtName;
      // End of variables declaration//GEN-END:variables

      public void initData() {
            list.add(new KH("Chỉnh", "Nam", 24));
            list.add(new KH("T.Hiếu", "Nam", 17));
            list.add(new KH("Vân", "Nữ", 18));
      }

      public void fillTable() {
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new String[]{"Họ tên", "Giới tính", "Tuổi", "Trạng thái"});
            for (KH c : list) {
                  model.addRow(new String[]{c.getName(), c.getGender(), c.getAge() + "", c.status()});
            }
            tblList.setModel(model);
      }

      public void writeForm(int row) {
            txtName.setText(tblList.getValueAt(row, 0).toString());
            String gender = tblList.getValueAt(row, 1).toString();
            if (gender.equalsIgnoreCase("nam")) {
                  rdoFemale.setSelected(true);
            } else if (gender.equalsIgnoreCase("nữ")) {
                  rdoMale.setSelected(true);
            } else {
                  grGender.clearSelection();
            }
            txtAge.setText(tblList.getValueAt(row, 2).toString());
            tblList.setRowSelectionInterval(row, row);
      }

      public void clearForm() {
            txtName.setText("");
            grGender.clearSelection();
            txtAge.setText("");
            tblList.clearSelection();
      }

      public void writeFile() {
            try {
                  FileOutputStream fos = new FileOutputStream("D:/chinhcvph21409/Customer.bin");
                  ObjectOutputStream oos = new ObjectOutputStream(fos);
                  oos.writeObject(list);
                  fos.close();
                  oos.close();
            } catch (Exception e) {
            }
      }

      public void effect() {
            new Thread(new Runnable() {
                  @Override
                  public void run() {
                        while (true) {
                              String f = lbl.getText().substring(0, 1);
                              String s = lbl.getText().substring(1);
                              if (f.equals(" ")) {
                                    f = lbl.getText().substring(0, 2);
                                    s = lbl.getText().substring(2);
                              }
                              lbl.setText(s + f);
                              try {
                                    Thread.sleep(500);
                              } catch (InterruptedException ex) {
                              }
                        }
                  }
            }).start();
      }
}

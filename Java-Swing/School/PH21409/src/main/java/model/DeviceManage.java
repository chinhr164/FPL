package model;

import classes.Device;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DeviceManage extends javax.swing.JFrame {

      public DeviceManage() {
            initComponents();
            this.setTitle("Quản lý thiết bị");
            this.setLocationRelativeTo(null);
            cboProd.
                    setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Việt Nam", "Trung Quốc", "Mỹ", "Nga"}));
            effect();
      }

      ArrayList<Device> list = new ArrayList<>();
      String path = "D:/chinhcvph21409/final.bin";

      @SuppressWarnings(
              "unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            lbl = new javax.swing.JLabel();
            jLabel2 = new javax.swing.JLabel();
            jLabel3 = new javax.swing.JLabel();
            jLabel4 = new javax.swing.JLabel();
            txtName = new javax.swing.JTextField();
            btnOpen = new javax.swing.JButton();
            txtPrice = new javax.swing.JTextField();
            cboProd = new javax.swing.JComboBox<>();
            btnSave = new javax.swing.JButton();
            btnFind = new javax.swing.JButton();
            jScrollPane1 = new javax.swing.JScrollPane();
            tblList = new javax.swing.JTable();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            lbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
            lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lbl.setText("QUẢN LÝ THIẾT BỊ ");

            jLabel2.setText("Tên thiết bị");

            jLabel3.setText("Xuất xứ");

            jLabel4.setText("Giá");

            btnOpen.setText("Mở");
            btnOpen.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnOpenActionPerformed(evt);
                  }
            });

            cboProd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

            btnSave.setText("Ghi");
            btnSave.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnSaveActionPerformed(evt);
                  }
            });

            btnFind.setText("Tìm kiếm");
            btnFind.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnFindActionPerformed(evt);
                  }
            });

            tblList.setModel(new javax.swing.table.DefaultTableModel(
                  new Object [][] {

                  },
                  new String [] {

                  }
            ));
            jScrollPane1.setViewportView(tblList);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addComponent(jScrollPane1)
                              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                          .addComponent(jLabel2)
                                          .addComponent(jLabel4)
                                          .addComponent(jLabel3))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                          .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                          .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                      .addComponent(cboProd, javax.swing.GroupLayout.Alignment.LEADING, 0, 310, Short.MAX_VALUE)
                                                      .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                      .addComponent(btnOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                      .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addContainerGap())
            );
            layout.setVerticalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lbl)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(jLabel2)
                              .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(btnOpen))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(jLabel3)
                              .addComponent(cboProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(btnSave))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(jLabel4)
                              .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(btnFind))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                        .addContainerGap())
            );

            pack();
      }// </editor-fold>//GEN-END:initComponents

      private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
            readFile();
            if (list.size() == 0) {
                  JOptionPane.showMessageDialog(this, "Danh sách rỗng, mời ghi dữ liệu");
            } else {
                  fillTable();
                  writeForm(0);
            }
      }//GEN-LAST:event_btnOpenActionPerformed

      private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
            if (txtName.getText().isEmpty() || txtPrice.getText().isEmpty())
                  JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin");
            else {
                  try {
                        double price = Double.parseDouble(txtPrice.getText());
                        if (price < 0) {
                              JOptionPane.showMessageDialog(this, "Giá phải lớn hơn hoặc bằng 0!");
                        } else {
                              list.add(new Device(txtName.getText(), cboProd.getSelectedItem() + "", price));
                              writeFile();
                              fillTable();
                              clearForm();
                              JOptionPane.showMessageDialog(this, "Thêm thành công!!");
                        }
                  } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Giá phải là số!");
                  }
            }
      }//GEN-LAST:event_btnSaveActionPerformed

      private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
            String find = JOptionPane.showInputDialog("Tên thiết bị: ");
            boolean flag = true;
            for (Device d : list) {
                  if (d.getName().equalsIgnoreCase(find)) {
                        JOptionPane.showMessageDialog(this, "Tìm thấy thiết bị");
                        writeForm(list.indexOf(d));
                        flag = !flag;
                        break;
                  }
            }
            if (flag) {
                  JOptionPane.showMessageDialog(this, "Không tìm thấy thiết bị!");
            }
      }//GEN-LAST:event_btnFindActionPerformed

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
                  java.util.logging.Logger.getLogger(DeviceManage.class
                          .getName()).log(java.util.logging.Level.SEVERE, null, ex);

            } catch (InstantiationException ex) {
                  java.util.logging.Logger.getLogger(DeviceManage.class
                          .getName()).log(java.util.logging.Level.SEVERE, null, ex);

            } catch (IllegalAccessException ex) {
                  java.util.logging.Logger.getLogger(DeviceManage.class
                          .getName()).log(java.util.logging.Level.SEVERE, null, ex);

            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                  java.util.logging.Logger.getLogger(DeviceManage.class
                          .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            java.awt.EventQueue.invokeLater(new Runnable() {
                  public void run() {
                        new DeviceManage().setVisible(true);
                  }
            });
      }

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private javax.swing.JButton btnFind;
      private javax.swing.JButton btnOpen;
      private javax.swing.JButton btnSave;
      private javax.swing.JComboBox<String> cboProd;
      private javax.swing.JLabel jLabel2;
      private javax.swing.JLabel jLabel3;
      private javax.swing.JLabel jLabel4;
      private javax.swing.JScrollPane jScrollPane1;
      private javax.swing.JLabel lbl;
      private javax.swing.JTable tblList;
      private javax.swing.JTextField txtName;
      private javax.swing.JTextField txtPrice;
      // End of variables declaration//GEN-END:variables

      public void fillTable() {
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new String[]{"Tên thiết bị", "Xuất xứ", "Giá", "Trạng thái"});
            for (Device d : list) {
                  model.addRow(new String[]{d.getName(), d.getProd(), d.getPrice() + "", d.status()});
            }
            tblList.setModel(model);
      }

      public void writeForm(int row) {
            txtName.setText(tblList.getValueAt(row, 0) + "");
            cboProd.setSelectedItem(tblList.getValueAt(row, 1) + "");
            txtPrice.setText(tblList.getValueAt(row, 2) + "");
            tblList.setRowSelectionInterval(row, row);
      }

      public void clearForm() {
            txtName.setText("");
            cboProd.setSelectedIndex(-1);
            txtPrice.setText("");
            tblList.clearSelection();
      }

      public void writeFile() {
            try {
                  FileOutputStream fos = new FileOutputStream(path);
                  ObjectOutputStream oos = new ObjectOutputStream(fos);
                  oos.writeObject(list);
                  fos.close();
                  oos.close();
            } catch (Exception e) {
            }
      }

      public void readFile() {
            try {
                  FileInputStream fis = new FileInputStream(path);
                  ObjectInputStream ois = new ObjectInputStream(fis);
                  list = (ArrayList<Device>) ois.readObject();
                  fis.close();
                  ois.close();
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
                                    Thread.sleep(300);
                              } catch (Exception ex) {
                              }
                        }
                  }
            }).start();
      }
}

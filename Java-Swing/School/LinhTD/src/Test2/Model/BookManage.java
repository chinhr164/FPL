package Test2.Model;

import Test2.Classes.Book;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BookManage extends javax.swing.JFrame {

      public BookManage() {
            initComponents();
            this.setTitle("Quản Lý Sách");
            this.setLocationRelativeTo(null);
            effect();
            initData();
            cboType.setModel(new DefaultComboBoxModel<>(new String[]{"Manga", "Sử ký", "Tiểu thuyết"}));
      }

      ArrayList<Book> list = new ArrayList<>();

      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            lbl = new javax.swing.JLabel();
            jLabel2 = new javax.swing.JLabel();
            jLabel3 = new javax.swing.JLabel();
            jLabel4 = new javax.swing.JLabel();
            txtName = new javax.swing.JTextField();
            txtPrice = new javax.swing.JTextField();
            jScrollPane1 = new javax.swing.JScrollPane();
            tblList = new javax.swing.JTable();
            btnSave = new javax.swing.JButton();
            btnOpen = new javax.swing.JButton();
            btnDelete = new javax.swing.JButton();
            cboType = new javax.swing.JComboBox<>();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            addWindowListener(new java.awt.event.WindowAdapter() {
                  public void windowClosing(java.awt.event.WindowEvent evt) {
                        formWindowClosing(evt);
                  }
            });

            lbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
            lbl.setForeground(new java.awt.Color(255, 0, 0));
            lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lbl.setText("QUẢN LÝ SÁCH ");

            jLabel2.setText("Tên sách");

            jLabel3.setText("Thể loại");

            jLabel4.setText("Giá");

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

            btnSave.setText("Save");
            btnSave.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnSaveActionPerformed(evt);
                  }
            });

            btnOpen.setText("Open");
            btnOpen.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnOpenActionPerformed(evt);
                  }
            });

            btnDelete.setText("Delete");
            btnDelete.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnDeleteActionPerformed(evt);
                  }
            });

            cboType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(layout.createSequentialGroup()
                                    .addGap(15, 15, 15)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                          .addComponent(lbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                          .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                      .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                  .addComponent(jLabel4)
                                                                  .addComponent(jLabel3))
                                                            .addGap(25, 25, 25)
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                  .addComponent(txtPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                                                  .addComponent(cboType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                            .addGap(18, 18, 18)
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                  .addComponent(btnOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                  .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                      .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                            .addComponent(jLabel2)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE))))
                              .addGroup(layout.createSequentialGroup()
                                    .addGap(15, 15, 15)
                                    .addComponent(jScrollPane1)))
                        .addGap(15, 15, 15))
            );
            layout.setVerticalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lbl)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(jLabel2)
                              .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(btnSave))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(jLabel3)
                              .addComponent(btnOpen)
                              .addComponent(cboType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addComponent(jLabel4)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDelete)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                        .addGap(15, 15, 15))
            );

            pack();
      }// </editor-fold>//GEN-END:initComponents

      private void tblListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListMouseClicked
            writeForm(tblList.getSelectedRow());
      }//GEN-LAST:event_tblListMouseClicked

      private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
            if (txtName.getText().isEmpty() || txtPrice.getText().isEmpty()) {
                  JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin");
            } else {
                  try {
                        double price = Double.parseDouble(txtPrice.getText());
                        if (price < 0) {
                              JOptionPane.showMessageDialog(this, "Giá tiền tối thiểu là 0");
                        } else {
                              list.add(new Book(txtName.getText(), cboType.getSelectedItem().toString(), price));
                              fillTable();
                              FileOutputStream fos = new FileOutputStream("D:/chinhcvph21409/book.bin");
                              ObjectOutputStream oos = new ObjectOutputStream(fos);
                              oos.writeObject(list);
                              fos.close();
                              oos.close();
                              JOptionPane.showMessageDialog(this, "Thêm mới và Ghi dữ liệu thành công");
                        }
                  } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Giá tiền cần phải là số");
                  }
            }
      }//GEN-LAST:event_btnSaveActionPerformed

      private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
            try {
                  FileInputStream fis = new FileInputStream("D:/chinhcvph21409/book.bin");
                  ObjectInputStream ois = new ObjectInputStream(fis);
                  list = (ArrayList<Book>) ois.readObject();
                  fis.close();
                  ois.close();
            } catch (Exception e) {
            }
            writeForm(0);
            fillTable();
      }//GEN-LAST:event_btnOpenActionPerformed

      private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
            if (tblList.getSelectedRowCount() == 0) {
                  JOptionPane.showMessageDialog(this, "Vui lòng chọn dữ liệu");
            } else {
                  int choice = JOptionPane.showConfirmDialog(this, "Chắc chắn xóa?", "Thông báo",
                          JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                  if (choice == JOptionPane.YES_OPTION) {
                        for (Book b : list) {
                              if (b.getName().equalsIgnoreCase(txtName.getText())) {
                                    list.remove(b);
                                    fillTable();
                                    txtName.setText("");
                                    cboType.setSelectedIndex(-1);
                                    txtPrice.setText("");
                                    tblList.clearSelection();
                                    JOptionPane.showMessageDialog(this, "Xóa thành công!");
                              }
                        }
                  }
            }
      }//GEN-LAST:event_btnDeleteActionPerformed

      private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
            int choice = JOptionPane.showConfirmDialog(this, "Lưu dữ liệu trước khi thoát?", "Thông báo",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (choice == JOptionPane.YES_OPTION) {
                  try {
                        FileOutputStream fos = new FileOutputStream("D:/chinhcvph21409/book.bin");
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        oos.writeObject(list);
                        fos.close();
                        oos.close();
                  } catch (Exception e) {
                  }
            }
      }//GEN-LAST:event_formWindowClosing

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
                  java.util.logging.Logger.getLogger(BookManage.class
                          .getName()).log(java.util.logging.Level.SEVERE, null, ex);

            } catch (InstantiationException ex) {
                  java.util.logging.Logger.getLogger(BookManage.class
                          .getName()).log(java.util.logging.Level.SEVERE, null, ex);

            } catch (IllegalAccessException ex) {
                  java.util.logging.Logger.getLogger(BookManage.class
                          .getName()).log(java.util.logging.Level.SEVERE, null, ex);

            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                  java.util.logging.Logger.getLogger(BookManage.class
                          .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            java.awt.EventQueue.invokeLater(new Runnable() {
                  public void run() {
                        new BookManage().setVisible(true);
                  }
            });
      }

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private javax.swing.JButton btnDelete;
      private javax.swing.JButton btnOpen;
      private javax.swing.JButton btnSave;
      private javax.swing.JComboBox<String> cboType;
      private javax.swing.JLabel jLabel2;
      private javax.swing.JLabel jLabel3;
      private javax.swing.JLabel jLabel4;
      private javax.swing.JScrollPane jScrollPane1;
      private javax.swing.JLabel lbl;
      private javax.swing.JTable tblList;
      private javax.swing.JTextField txtName;
      private javax.swing.JTextField txtPrice;
      // End of variables declaration//GEN-END:variables

      public void initData() {
            list.add(new Book("One Piece", "Manga", 25000));
            list.add(new Book("Thần thoại Hy Lạp", "Thần thoại", 125000));
            list.add(new Book("Sử ký Tư Mã Thiên", "Sử kí", 150000));
      }

      public void fillTable() {
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new String[]{"Tên sách", "Thể loại", "Giá", "Trạng Thái"});
            for (Book b : list) {
                  model.addRow(new String[]{b.getName(), b.getType(), b.getPrice() + "", b.status()});
            }
            tblList.setModel(model);
      }

      public void writeForm(int row) {
            txtName.setText(tblList.getValueAt(row, 0) + "");
            cboType.setSelectedItem(tblList.getValueAt(row, 1) + "");
            txtPrice.setText(tblList.getValueAt(row, 2) + "");
            tblList.setRowSelectionInterval(row, row);
      }

      public void effect() {
            new Thread(new Runnable() {
                  @Override
                  public void run() {
                        while (true) {
                              String f = lbl.getText().substring(0, 1);
                              String s = lbl.getText().substring(1);
                              if(f.equals(" ")){
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

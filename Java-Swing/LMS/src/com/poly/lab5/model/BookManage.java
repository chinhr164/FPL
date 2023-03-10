package com.poly.lab5.model;

import com.poly.lab5.linhTD.classes.Book;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BookManage
        extends javax.swing.JFrame {

    public BookManage() {
        initComponents();
        initData();
        setTitle("Quản lý sách");
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblList = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtType = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        txtRecord = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnLoad = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnWrite = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ SÁCH");

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin sách"));

        jLabel2.setText("Mã sách");

        jLabel3.setText("Tên sách");

        jLabel4.setText("Giá");

        jLabel5.setText("Thể loại");

        btnFirst.setText("<<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrev.setText("<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setText(">");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setText(">>");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        txtRecord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtRecord.setText("Chưa tải dữ liệu");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtType)
                    .addComponent(txtPrice)
                    .addComponent(txtName))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));

        btnLoad.setText("Tải dữ liệu");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        btnAdd.setText("Thêm sách");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Cập nhật");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Xoá sách");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnWrite.setText("Ghi dữ liệu");
        btnWrite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWriteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnWrite, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnWrite, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    ArrayList<Book> list = new ArrayList<>();

    private void initData() {
        list.add(new Book("001", "One Piece", "Manga", 25000));
        list.add(new Book("002", "Naruto", "Manga", 21000));
        list.add(new Book("003", "Dragon Ball", "Manga", 35000));
    }

    private void fillTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Mã sách", "Tên sách",
            "Thể loại", "Giá"});
        for (Book b : list) {
            model.addRow(new String[]{b.getId(), b.getName(), b.getType(),
                String.valueOf(b.getPrice())});
        }
        tblList.setModel(model);
    }

    private void writeForm(int row) {
        if (tblList.getRowCount() > 0) {
            txtId.setText(tblList.getValueAt(row, 0).toString());
            txtName.setText(tblList.getValueAt(row, 1).toString());
            txtType.setText(tblList.getValueAt(row, 2).toString());
            txtPrice.setText(tblList.getValueAt(row, 3).toString());
            tblList.setRowSelectionInterval(row, row);
            txtRecord.setText((row + 1) + "/" + tblList.getRowCount());
        }
    }

    private void clearForm() {
        txtId.setText("");
        txtName.setText("");
        txtType.setText("");
        txtPrice.setText("");
        tblList.clearSelection();
        index = -1;
        txtRecord.setText("Chưa chọn dữ liệu");
    }

    private void btnWriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWriteActionPerformed
        File f = new File("D:/ChinhcvPH21409");
        if (!f.exists()) {
            f.mkdirs();
        }
        try {
            FileOutputStream fos = new FileOutputStream(
                    f.getAbsolutePath() + "/books.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            JOptionPane.showMessageDialog(this,
                    "Ghi dữ liệu thành công\nDữ liệu đã được ghi vào " + f.getAbsolutePath() + "/books.bin");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lỗi ghi dữ liệu");
        }
    }//GEN-LAST:event_btnWriteActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        File f = new File("D:/ChinhcvPH21409");
        if (!f.exists()) {
            f.mkdirs();
        }
        try {
            FileInputStream fis = new FileInputStream(
                    f.getAbsolutePath() + "/books.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (ArrayList<Book>) ois.readObject();
            fillTable();
            writeForm(0);
            txtRecord.setText("1/" + tblList.getRowCount());
            ois.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lỗi tải dữ liệu");
        }
    }//GEN-LAST:event_btnLoadActionPerformed

    int index = 0;
    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        index = 0;
        writeForm(index);
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        if (index > 0) {
            index--;
        } else {
            index = tblList.getRowCount() - 1;
        }
        writeForm(index);
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        if (index < tblList.getRowCount() - 1) {
            index++;
        } else {
            index = 0;
        }
        writeForm(index);
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        index = tblList.getRowCount() - 1;
        writeForm(index);
    }//GEN-LAST:event_btnLastActionPerformed

    private void tblListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListMouseClicked
        index = tblList.getSelectedRow();
        writeForm(index);
    }//GEN-LAST:event_tblListMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (tblList.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa tải dữ liệu");
        } else
             if (txtId.getText().isEmpty() || txtName.getText().isEmpty()
                || txtType.getText().isEmpty() || txtPrice.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đủ thông tin");
        } else {
            int count = tblList.getRowCount();
            int i = 0;
            for (; i < count; i++) {
                String s = tblList.getValueAt(i, 0).toString();
                if (txtId.getText().equalsIgnoreCase(s)) {
                    JOptionPane.showMessageDialog(this, "Đã tồn tại mã sách");
                    break;
                }
            }
            if (i == count) {
                try {
                    list.add(new Book(txtId.getText(), txtName.getText(), txtType.getText(),
                            Double.parseDouble(txtPrice.getText())));
                    fillTable();
                    JOptionPane.showMessageDialog(this, "Thêm sách thành công!");
                    clearForm();
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Giá cần nhập giá trị số");
                }
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (tblList.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa tải dữ liệu");
        } else if (index == -1) {
            JOptionPane.showMessageDialog(this, "Chưa chọn dữ liệu!");
        } else if (txtId.getText().isEmpty() || txtName.getText().isEmpty()
                || txtType.getText().isEmpty() || txtPrice.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đủ thông tin");
        } else {
            int count = tblList.getSelectedRowCount();
            int i;
            for (i = 0; i < count; i++) {
                String s = tblList.getValueAt(i, 0).toString();
                if (i == index) {
                    continue;
                }
                if (txtId.getText().equalsIgnoreCase(s)) {
                    JOptionPane.showMessageDialog(this, "Đã tồn tại mã sách");
                    break;
                }
            }
            if (i == count) {
                try {
                    list.set(index, new Book(txtId.getText(), txtName.getText(), txtType.getText(),
                            Double.parseDouble(txtPrice.getText())));
                    fillTable();
                    JOptionPane.showMessageDialog(this, "Cập nhật sách thành công!");
                    clearForm();
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Giá cần nhập giá trị số");
                }
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (tblList.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa tải dữ liệu");
        } else if (index == -1) {
            JOptionPane.showMessageDialog(this, "Chưa chọn dữ liệu!");
        } else {
            int choice = JOptionPane.showConfirmDialog(this, "Chắc chắn xoá?", "Cảnh báo!!", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                list.remove(index);
                fillTable();
                JOptionPane.showMessageDialog(this, "Xoá sách thành công!");
                clearForm();
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int choice = JOptionPane.showConfirmDialog(this, "Thoát?", "Cảnh báo!!", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing

    public static void main(String args[]) {
        /* Set the Windows look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info
                    : javax.swing.UIManager.getInstalledLookAndFeels()) {
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
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnWrite;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblList;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JLabel txtRecord;
    private javax.swing.JTextField txtType;
    // End of variables declaration//GEN-END:variables

}

package com.poly.asm.model;

import com.poly.asm.classes.Employee;
import com.poly.asm.classes.DAO;
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EmployeeManagement extends javax.swing.JFrame implements DAO {

     @Override
     public void insert() {
          boolean flag = true;
          for (Employee e : list) {
               if (txtId.getText().equalsIgnoreCase(e.getName())) {
                    JOptionPane.showMessageDialog(this, "Đã tồn tại mã nhân viên");
                    flag = !flag;
                    break;
               }
          }
          if (flag) {
               list.add(readForm());
               JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công");
               clearForm();
               fillTable();
          }
     }

     @Override
     public void update() {
          int i = 0;
          for (; i < list.size(); i++) {
               if (i == index) {
                    continue;
               }
               if (txtId.getText().equalsIgnoreCase(list.get(i).getName())) {
                    JOptionPane.showMessageDialog(this, "Đã tồn tại mã nhân viên");
                    break;
               }
          }
          if (i == list.size()) {
               list.set(index, readForm());
               JOptionPane.showMessageDialog(this, "Cập nhật nhân viên thành công");
               clearForm();
               fillTable();
          }
     }

     @Override
     public void delete() {
          if (index == -1) {
               JOptionPane.showMessageDialog(this, "Chưa chọn dữ liệu cần xoá!");
          } else {
               int choice = JOptionPane.
                       showConfirmDialog(this, "Chắc chắn xoá?", "Thông báo", JOptionPane.YES_NO_OPTION);
               if (choice == JOptionPane.YES_OPTION) {
                    list.remove(index);
                    fillTable();
                    clearForm();
                    JOptionPane.showMessageDialog(this, "Xoá nhân viên thành công");
               }
          }
     }

     public EmployeeManagement() {
          super();
          initComponents();
          this.setTitle("Quản Lý Nhân Viên");
          this.setLocationRelativeTo(null);
          this.getRootPane().setDefaultButton(btnSave);
          showClock();
          initData();
     }

     @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          jScrollPane1 = new javax.swing.JScrollPane();
          jTable1 = new javax.swing.JTable();
          jLabel1 = new javax.swing.JLabel();
          jLabel2 = new javax.swing.JLabel();
          jLabel3 = new javax.swing.JLabel();
          jLabel4 = new javax.swing.JLabel();
          jLabel6 = new javax.swing.JLabel();
          txtId = new javax.swing.JTextField();
          txtName = new javax.swing.JTextField();
          txtAge = new javax.swing.JTextField();
          txtEmail = new javax.swing.JTextField();
          txtSalary = new javax.swing.JTextField();
          jLabel5 = new javax.swing.JLabel();
          btnFirst = new javax.swing.JButton();
          btnPrev = new javax.swing.JButton();
          btnNext = new javax.swing.JButton();
          btnLast = new javax.swing.JButton();
          lblRecord = new javax.swing.JLabel();
          jPanel1 = new javax.swing.JPanel();
          btnNew = new javax.swing.JButton();
          btnSave = new javax.swing.JButton();
          btnDelete = new javax.swing.JButton();
          btnFind = new javax.swing.JButton();
          btnOpen = new javax.swing.JButton();
          btnExit = new javax.swing.JButton();
          lblTime = new javax.swing.JLabel();
          jScrollPane2 = new javax.swing.JScrollPane();
          tblList = new javax.swing.JTable();
          lblDate = new javax.swing.JLabel();

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
          addWindowListener(new java.awt.event.WindowAdapter() {
               public void windowClosing(java.awt.event.WindowEvent evt) {
                    formWindowClosing(evt);
               }
               public void windowOpened(java.awt.event.WindowEvent evt) {
                    formWindowOpened(evt);
               }
          });

          jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
          jLabel1.setText("MÃ NHÂN VIÊN");

          jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
          jLabel2.setText("HỌ VÀ TÊN");

          jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
          jLabel3.setText("TUỔI");

          jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
          jLabel4.setText("LƯƠNG");

          jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
          jLabel6.setText("EMAIL");

          jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
          jLabel5.setForeground(new java.awt.Color(255, 0, 0));
          jLabel5.setText("QUẢN LÝ NHÂN VIÊN");

          btnFirst.setText("|<");
          btnFirst.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnFirstActionPerformed(evt);
               }
          });

          btnPrev.setText("<<");
          btnPrev.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnPrevActionPerformed(evt);
               }
          });

          btnNext.setText(">>");
          btnNext.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnNextActionPerformed(evt);
               }
          });

          btnLast.setText(">|");
          btnLast.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnLastActionPerformed(evt);
               }
          });

          lblRecord.setForeground(new java.awt.Color(255, 0, 0));
          lblRecord.setText("Chưa tải dữ liệu");

          jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

          btnNew.setText("New");
          btnNew.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnNewActionPerformed(evt);
               }
          });

          btnSave.setText("Save");
          btnSave.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnSaveActionPerformed(evt);
               }
          });

          btnDelete.setText("Delete");
          btnDelete.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnDeleteActionPerformed(evt);
               }
          });

          btnFind.setText("Find");
          btnFind.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnFindActionPerformed(evt);
               }
          });

          btnOpen.setText("Open");
          btnOpen.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnOpenActionPerformed(evt);
               }
          });

          btnExit.setText("Exit");
          btnExit.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnExitActionPerformed(evt);
               }
          });

          javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
          jPanel1.setLayout(jPanel1Layout);
          jPanel1Layout.setHorizontalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                         .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(btnFind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(btnOpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          );
          jPanel1Layout.setVerticalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnNew)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btnSave)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btnDelete)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btnFind)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btnOpen)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btnExit)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          );

          lblTime.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
          lblTime.setForeground(new java.awt.Color(255, 0, 0));
          lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

          tblList.setModel(new javax.swing.table.DefaultTableModel(
               new Object [][] {

               },
               new String [] {
                    "Mã NV", "Họ tên", "Tuổi", "Email", "Lương"
               }
          ));
          tblList.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                    tblListMouseClicked(evt);
               }
          });
          jScrollPane2.setViewportView(tblList);
          if (tblList.getColumnModel().getColumnCount() > 0) {
               tblList.getColumnModel().getColumn(0).setMinWidth(50);
               tblList.getColumnModel().getColumn(0).setMaxWidth(50);
               tblList.getColumnModel().getColumn(1).setMinWidth(120);
               tblList.getColumnModel().getColumn(1).setMaxWidth(120);
               tblList.getColumnModel().getColumn(2).setMinWidth(60);
               tblList.getColumnModel().getColumn(2).setMaxWidth(60);
               tblList.getColumnModel().getColumn(4).setMinWidth(80);
               tblList.getColumnModel().getColumn(4).setMaxWidth(80);
          }

          lblDate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
          lblDate.setForeground(new java.awt.Color(255, 0, 0));
          lblDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                         .addGroup(layout.createSequentialGroup()
                              .addContainerGap()
                              .addComponent(jScrollPane2))
                         .addGroup(layout.createSequentialGroup()
                              .addGap(19, 19, 19)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                   .addComponent(jLabel1)
                                   .addComponent(jLabel2)
                                   .addComponent(jLabel3)
                                   .addComponent(jLabel6)
                                   .addComponent(jLabel4))
                              .addGap(18, 18, 18)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                             .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                             .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                             .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                             .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                             .addGap(18, 18, 18)
                                             .addComponent(lblRecord))
                                        .addComponent(txtEmail)
                                        .addComponent(txtName)
                                        .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                   .addComponent(jLabel5))
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(lblTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(lblDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap())
          );
          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(layout.createSequentialGroup()
                              .addGap(21, 21, 21)
                              .addComponent(jLabel5)
                              .addGap(21, 21, 21)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jLabel1)
                                   .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addGap(18, 18, 18)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jLabel2)
                                   .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addGap(18, 18, 18)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jLabel3)
                                   .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addGap(18, 18, 18)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jLabel6)
                                   .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addGap(18, 18, 18)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(jLabel4))
                              .addGap(18, 18, 18)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(lblRecord)))
                         .addGroup(layout.createSequentialGroup()
                              .addGap(11, 11, 11)
                              .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(42, 42, 42)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                    .addContainerGap())
          );

          btnFirst.getAccessibleContext().setAccessibleDescription("");
          btnPrev.getAccessibleContext().setAccessibleDescription("");
          btnNext.getAccessibleContext().setAccessibleDescription("");
          btnLast.getAccessibleContext().setAccessibleDescription("");

          pack();
     }// </editor-fold>//GEN-END:initComponents

     ArrayList<Employee> list = new ArrayList<>();

     private void showClock() {
          new ThreadImpl().start();
     }

     private void initData() {
          list.add(new Employee("NV001", "Cao Văn Chỉnh", 24, "chinhcvph21409@fpt.edu.vn", 20000000));
          list.add(new Employee("NV002", "Đinh Viết Khang", 19, "khangdvph21079@fpt.edu.vn", 15000000));
          list.add(new Employee("NV003", "Ngô Trung Hiếu", 18, "hieuntph21424@fpt.edu.vn", 10000000));
          list.add(new Employee("NV004", "Đỗ Xuân Hiếu", 18, "hieudxph21411@fpt.edu.vn", 25000000));
          list.add(new Employee("NV005", "Hà Thị Ngọc Hải", 18, "haihtnph23144@fpt.edu.vn", 22000000));
     }

     private void fillTable() {
          DecimalFormat df = new DecimalFormat("#");
          DefaultTableModel model = new DefaultTableModel();
          model.setColumnIdentifiers(new String[]{"MÃ", "HỌ VÀ TÊN", "TUỔI", "EMAIL", "LƯƠNG"});
          for (Employee e : list) {
               model.addRow(new String[]{e.getId(), e.getName(), String.valueOf(e.getAge()),
                    e.getEmail(), df.format(e.getSalary())});
          }
          tblList.setModel(model);
     }
     String chuoi;
     private void writeFile() {
          JFileChooser c = new JFileChooser();
          int rVal = c.showSaveDialog(this);
          if (rVal == JFileChooser.APPROVE_OPTION) {
               String filename = c.getSelectedFile().getName();
               String dir = c.getCurrentDirectory().toString();
               String filePath = dir + "\\" + filename;
               File file = new File(filePath);
               try {
                    FileOutputStream fos = new FileOutputStream(file);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(list);
                    oos.close();
               } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lỗi ghi dữ liệu");
               }
          } else {
               System.exit(0);
          }
     }

     private void readFile() {
          JFileChooser c = new JFileChooser();
          int rVal = c.showOpenDialog(this);
          if (rVal == JFileChooser.APPROVE_OPTION) {
               String filename = c.getSelectedFile().getName();
               String dir = c.getCurrentDirectory().toString();
               String filePath = dir + "\\" + filename;
               File file = new File(filePath);
               try {
                    FileInputStream fis = new FileInputStream(file);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    list = (ArrayList<Employee>) ois.readObject();
                    fis.close();
                    ois.close();
               } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lỗi đọc dữ liệu");
               }
          }
     }

     private void writeForm(int row) {
          if (tblList.getRowCount() > 0) {
               txtId.setText(tblList.getValueAt(row, 0).toString());
               txtName.setText(tblList.getValueAt(row, 1).toString());
               txtAge.setText(tblList.getValueAt(row, 2).toString());
               txtEmail.setText(tblList.getValueAt(row, 3).toString());
               txtSalary.setText(tblList.getValueAt(row, 4).toString());
               tblList.setRowSelectionInterval(row, row);
               lblRecord.setText((row + 1) + "/" + tblList.getRowCount());
          } else {
               JOptionPane.showMessageDialog(this, "Chưa tải dữ liệu");
          }
     }

     private Employee readForm() {
          Employee e = new Employee();
          e.setId(txtId.getText());
          e.setName(txtName.getText());
          e.setAge(Integer.parseInt(txtAge.getText()));
          e.setEmail(txtEmail.getText());
          e.setSalary(Double.parseDouble(txtSalary.getText()));
          return e;
     }

     private void clearForm() {
          txtId.setText("");
          txtName.setText("");
          txtAge.setText("");
          txtEmail.setText("");
          txtSalary.setText("");
          tblList.clearSelection();
          index = -1;
          lblRecord.setText("Chưa chọn dữ liệu");
          txtId.grabFocus();
     }


    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

         index = -1;
         int choice = JOptionPane.showConfirmDialog(this, "Đã có sẵn file?", "Thông báo", JOptionPane.YES_NO_OPTION,
                 JOptionPane.QUESTION_MESSAGE);
         if (choice == JOptionPane.YES_OPTION) {
              readFile();
              fillTable();
         } else {
              int choiceInner = JOptionPane.
                      showConfirmDialog(this, "Tạo file mới\nđể bắt đầu phiên làm việc", "Thông báo",
                              JOptionPane.YES_NO_OPTION);
              if (choiceInner == JOptionPane.YES_OPTION) {
                   writeFile();
              } else {
                   System.exit(0);
              }
         }
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
         int choice = JOptionPane.showConfirmDialog(this, "Chắc chắn thoát?", "Thông báo", JOptionPane.YES_NO_OPTION);
         if (choice == JOptionPane.YES_OPTION) {
              System.exit(0);
         } else {
              setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
         }
    }//GEN-LAST:event_formWindowClosing

    private void tblListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListMouseClicked
         index = tblList.getSelectedRow();
         writeForm(index);
    }//GEN-LAST:event_tblListMouseClicked

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
         readFile();
         fillTable();
         writeForm(0);
    }//GEN-LAST:event_btnOpenActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
         int choice = JOptionPane.showConfirmDialog(this, "Lưu và Thoát khỏi chương trinh?", "Thông báo",
                 JOptionPane.YES_NO_OPTION);
         if (choice == JOptionPane.YES_OPTION) {
              writeFile();
              System.exit(0);
         }
    }//GEN-LAST:event_btnExitActionPerformed

     boolean flagNew;
    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
         clearForm();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
         if (txtId.getText().isEmpty()) {
              JOptionPane.showMessageDialog(this, "Vui lòng nhập Mã nhân viên");
         } else {
              try {
                   if (16 > Integer.parseInt(txtAge.getText()) || Integer.parseInt(txtAge.getText()) > 55) {
                        JOptionPane.showMessageDialog(this, "Tuổi phải từ 16 đến 55");
                   } else if (!txtEmail.getText().matches(
                           "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")) {
                        JOptionPane.showMessageDialog(this,
                                "Email phải đúng định dạng, và không được để trống.");
                   } else if (Double.parseDouble(txtSalary.getText()) <= 5000000) {
                        JOptionPane.showMessageDialog(this, "Lương phải trên 5 triệu");
                   } else {
                        if (index == -1) {
                             insert();
                        } else {
                             update();
                        }
                   }
              } catch (NumberFormatException e) {
                   JOptionPane.showMessageDialog(this, "Tuổi và Lương là giá trị số");
              } catch (Exception e) {
                   JOptionPane.showMessageDialog(this, "Có lỗi xảy ra");
              }
         }
    }//GEN-LAST:event_btnSaveActionPerformed


    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
         if (tblList.getRowCount() > 0) {
              String txtFind = JOptionPane
                      .showInputDialog("Mã sinh viên ");
              int count = tblList.getRowCount();
              int i = 0;
              for (; i < count; i++) {
                   String s = tblList.getValueAt(i, 0).toString();
                   if (txtFind.equalsIgnoreCase(s)) {
                        JOptionPane.showMessageDialog(this, "Tìm thấy nhân viên");
                        writeForm(i);
                        break;
                   }
              }
              if (i == count) {
                   JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên");
              }
         } else {
              JOptionPane.showMessageDialog(this, "Chưa tải dữ liệu");
         }
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
         delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

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

     public static void main(String args[]) {
          //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
          try {
               for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Windows".equals(info.getName())) {
                         javax.swing.UIManager.setLookAndFeel(info.getClassName());
                         break;

                    }
               }
          } catch (ClassNotFoundException ex) {
               java.util.logging.Logger.getLogger(EmployeeManagement.class
                       .getName()).log(java.util.logging.Level.SEVERE, null, ex);

          } catch (InstantiationException ex) {
               java.util.logging.Logger.getLogger(EmployeeManagement.class
                       .getName()).log(java.util.logging.Level.SEVERE, null, ex);

          } catch (IllegalAccessException ex) {
               java.util.logging.Logger.getLogger(EmployeeManagement.class
                       .getName()).log(java.util.logging.Level.SEVERE, null, ex);

          } catch (javax.swing.UnsupportedLookAndFeelException ex) {
               java.util.logging.Logger.getLogger(EmployeeManagement.class
                       .getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
          //</editor-fold>
          //</editor-fold>

          java.awt.EventQueue.invokeLater(new Runnable() {
               public void run() {
                    new EmployeeManagement().setVisible(true);
               }
          });
     }


     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JButton btnDelete;
     private javax.swing.JButton btnExit;
     private javax.swing.JButton btnFind;
     private javax.swing.JButton btnFirst;
     private javax.swing.JButton btnLast;
     private javax.swing.JButton btnNew;
     private javax.swing.JButton btnNext;
     private javax.swing.JButton btnOpen;
     private javax.swing.JButton btnPrev;
     private javax.swing.JButton btnSave;
     private javax.swing.JLabel jLabel1;
     private javax.swing.JLabel jLabel2;
     private javax.swing.JLabel jLabel3;
     private javax.swing.JLabel jLabel4;
     private javax.swing.JLabel jLabel5;
     private javax.swing.JLabel jLabel6;
     private javax.swing.JPanel jPanel1;
     private javax.swing.JScrollPane jScrollPane1;
     private javax.swing.JScrollPane jScrollPane2;
     private javax.swing.JTable jTable1;
     private javax.swing.JLabel lblDate;
     private javax.swing.JLabel lblRecord;
     private javax.swing.JLabel lblTime;
     private javax.swing.JTable tblList;
     private javax.swing.JTextField txtAge;
     private javax.swing.JTextField txtEmail;
     private javax.swing.JTextField txtId;
     private javax.swing.JTextField txtName;
     private javax.swing.JTextField txtSalary;
     // End of variables declaration//GEN-END:variables

     private class ThreadImpl extends Thread {

          public ThreadImpl() {
          }

          public void run() {
               try {
                    while (true) {
                         Calendar calendar = Calendar.getInstance();

                         String hour = calendar.get(Calendar.HOUR_OF_DAY) > 9
                                 ? "" + String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)) + ""
                                 : "0" + String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
                         String minute = calendar.get(Calendar.MINUTE) > 9
                                 ? "" + String.valueOf(calendar.get(Calendar.MINUTE)) + ""
                                 : "0" + String.valueOf(calendar.get(Calendar.MINUTE));

                         String second = calendar.get(Calendar.SECOND) > 9
                                 ? "" + String.valueOf(calendar.get(Calendar.SECOND)) + ""
                                 : "0" + String.valueOf(calendar.get(Calendar.SECOND));
//                        String am_pm = calendar.get(Calendar.AM_PM) == 0 ? " AM" : " PM";
                         lblTime.setText(hour + ":" + minute + ":" + second);

                         String day = calendar.get(Calendar.DAY_OF_MONTH) > 9
                                 ? "" + String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)) + ""
                                 : "0" + String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));

                         String month = calendar.get(Calendar.MONTH) > 9
                                 ? "" + String.valueOf(calendar.get(Calendar.MONTH) + 1) + ""
                                 : "0" + String.valueOf(calendar.get(Calendar.MONTH) + 1);

                         String year = String.valueOf(calendar.get(Calendar.YEAR) % 100);

                         lblDate.setText(day + "/" + month + "/" + year);
                    }
               } catch (Exception e) {
               }
          }
     }

}

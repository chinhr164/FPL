package com.poly.lab2;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class StaffList extends javax.swing.JFrame {

    public StaffList() {
        initComponents();
        this.setTitle("Staff List");
        loadTable();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        staffList = new javax.swing.JLabel();
        scrollPanel = new javax.swing.JScrollPane();
        tblStaffList = new javax.swing.JTable();
        jButton_Load = new javax.swing.JButton();
        jButton_Store = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        staffList.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        staffList.setForeground(new java.awt.Color(0, 0, 255));
        staffList.setText("Staff List");

        tblStaffList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title1", "Title2", "Title3", "Title4", "Title5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStaffList.setRowHeight(20);
        scrollPanel.setViewportView(tblStaffList);
        if (tblStaffList.getColumnModel().getColumnCount() > 0) {
            tblStaffList.getColumnModel().getColumn(0).setMinWidth(50);
            tblStaffList.getColumnModel().getColumn(0).setMaxWidth(50);
            tblStaffList.getColumnModel().getColumn(2).setMinWidth(100);
            tblStaffList.getColumnModel().getColumn(2).setMaxWidth(100);
            tblStaffList.getColumnModel().getColumn(3).setMinWidth(80);
            tblStaffList.getColumnModel().getColumn(3).setMaxWidth(80);
            tblStaffList.getColumnModel().getColumn(4).setMinWidth(80);
            tblStaffList.getColumnModel().getColumn(4).setMaxWidth(80);
        }

        jButton_Load.setText("Load");

        jButton_Store.setText("Store");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(staffList)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton_Load)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Store)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(staffList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Load)
                    .addComponent(jButton_Store))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"ID", "FULLNAME", "COUNTRY","GENDER","STATUS"});
        
        model.addRow(new String[]{"NV01","Nguyễn Nghiệm","Việt Nam","Male","Married"});
        model.addRow(new String[]{"NV02","Lê Thị Hương Thảo","Singapore","Female","Married"});
        model.addRow(new String[]{"NV03","Nguyễn Đình Thiên Long","United States","Male","Single"});
        model.addRow(new String[]{"NV04","Nguyễn Đình Hoàng Long","Malaysia","Male","Single"});
        tblStaffList.setModel(model);
    }

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
            java.util.logging.Logger.getLogger(StaffEditon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffEditon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffEditon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffEditon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>      

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StaffList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Load;
    private javax.swing.JButton jButton_Store;
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JLabel staffList;
    private javax.swing.JTable tblStaffList;
    // End of variables declaration//GEN-END:variables
}

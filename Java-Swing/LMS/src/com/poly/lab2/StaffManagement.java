package com.poly.lab2;

import javax.swing.JFrame;

public class StaffManagement extends javax.swing.JFrame {

    public StaffManagement() {
        initComponents();
        this.setTitle("Staff Management");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpGender = new javax.swing.ButtonGroup();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        staffEdition = new javax.swing.JPanel();
        staffId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        fullname = new javax.swing.JLabel();
        txtFullname = new javax.swing.JTextField();
        country = new javax.swing.JLabel();
        cboCountry = new javax.swing.JComboBox<>();
        gender = new javax.swing.JLabel();
        rdoMale = new javax.swing.JRadioButton();
        rdoFemale = new javax.swing.JRadioButton();
        status = new javax.swing.JLabel();
        chkStatus = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNotes = new javax.swing.JTextArea();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        staffList = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStaffList = new javax.swing.JTable();
        btnLoad = new javax.swing.JButton();
        btnStore = new javax.swing.JButton();
        staffMangement = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        staffId.setText("Staff ID");

        fullname.setText("Fullname");

        country.setText("Country");

        cboCountry.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Việt Nam", "Lào", "Campuchia" }));

        gender.setText("Gender");

        grpGender.add(rdoMale);
        rdoMale.setSelected(true);
        rdoMale.setText("Male");

        grpGender.add(rdoFemale);
        rdoFemale.setText("Female");

        status.setText("Status");

        chkStatus.setSelected(true);
        chkStatus.setText("Single?");

        jLabel1.setText("Notes");

        txtNotes.setColumns(20);
        txtNotes.setRows(10);
        jScrollPane1.setViewportView(txtNotes);

        btnCreate.setText("Create");

        btnUpdate.setText("Update");

        btnDelete.setText("Delete");

        btnReset.setText("Reset");

        javax.swing.GroupLayout staffEditionLayout = new javax.swing.GroupLayout(staffEdition);
        staffEdition.setLayout(staffEditionLayout);
        staffEditionLayout.setHorizontalGroup(
            staffEditionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staffEditionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(staffEditionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(staffEditionLayout.createSequentialGroup()
                        .addGroup(staffEditionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(staffId)
                            .addComponent(fullname))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(staffEditionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFullname)
                            .addComponent(txtId))
                        .addContainerGap())
                    .addGroup(staffEditionLayout.createSequentialGroup()
                        .addGroup(staffEditionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(staffEditionLayout.createSequentialGroup()
                                .addGroup(staffEditionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(staffEditionLayout.createSequentialGroup()
                                        .addGroup(staffEditionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(country)
                                            .addComponent(gender))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(staffEditionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(staffEditionLayout.createSequentialGroup()
                                                .addComponent(rdoMale)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(rdoFemale))
                                            .addComponent(cboCountry, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(staffEditionLayout.createSequentialGroup()
                                        .addComponent(status)
                                        .addGap(18, 18, 18)
                                        .addComponent(chkStatus)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(staffEditionLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(staffEditionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(staffEditionLayout.createSequentialGroup()
                                        .addComponent(btnCreate)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnUpdate)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnDelete)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnReset)
                                        .addGap(0, 78, Short.MAX_VALUE))
                                    .addComponent(jScrollPane1))))
                        .addGap(10, 10, 10))))
        );
        staffEditionLayout.setVerticalGroup(
            staffEditionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staffEditionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(staffEditionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(staffId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(staffEditionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fullname)
                    .addComponent(txtFullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(staffEditionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(country)
                    .addComponent(cboCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(staffEditionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gender)
                    .addComponent(rdoMale)
                    .addComponent(rdoFemale))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(staffEditionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(status)
                    .addComponent(chkStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(staffEditionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(staffEditionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnReset))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Edition", staffEdition);

        tblStaffList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "FULLNAME", "COUNTRY", "GENDER", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblStaffList);

        btnLoad.setText("Load");

        btnStore.setText("Store");

        javax.swing.GroupLayout staffListLayout = new javax.swing.GroupLayout(staffList);
        staffList.setLayout(staffListLayout);
        staffListLayout.setHorizontalGroup(
            staffListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staffListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(staffListLayout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(btnLoad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStore)
                .addContainerGap(159, Short.MAX_VALUE))
        );
        staffListLayout.setVerticalGroup(
            staffListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staffListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(staffListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnStore)
                    .addComponent(btnLoad))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("List", staffList);

        staffMangement.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        staffMangement.setForeground(new java.awt.Color(0, 0, 255));
        staffMangement.setText("Staff Management");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(staffMangement)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(staffMangement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(StaffManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
   
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StaffManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnStore;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboCountry;
    private javax.swing.JCheckBox chkStatus;
    private javax.swing.JLabel country;
    private javax.swing.JLabel fullname;
    private javax.swing.JLabel gender;
    private javax.swing.ButtonGroup grpGender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JRadioButton rdoFemale;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JPanel staffEdition;
    private javax.swing.JLabel staffId;
    private javax.swing.JPanel staffList;
    private javax.swing.JLabel staffMangement;
    private javax.swing.JLabel status;
    private javax.swing.JTable tblStaffList;
    private javax.swing.JTextField txtFullname;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextArea txtNotes;
    // End of variables declaration//GEN-END:variables
}

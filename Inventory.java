import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Inventory extends javax.swing.JFrame {

    public Inventory() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnShow = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"CAR", "BMW M3 - 2019", "Available"},
                {"CAR", "Honda City - 4th Generation", "Available"},
                {"CAR", "Toyota Vios GR-S", "Available"},
                {"CAR", "Mitsubishi Mirage", "Available"},
                {"VAN", "Toyota Hiace Commuter", "Available"},
                {"VAN", "Nissan Urvan NV350", "Available"},
                {"VAN", "Hyundai Starex", "Available"},
                {"VAN", "Suzuki APV", "Available"},
                {"SUV", "Ford Everest", "Available"},
                {"SUV", "Toyota Fortuner", "Available"},
                {"SUV", "ISUZU MU-X", "Available"},
                {"SUV", "Mitsubishi Montero Sport", "Available"},
                {"MOTOR", "Honda Click 125i", "Available"},
                {"MOTOR", "uzuki Burgman Street", "Available"},
                {"MOTOR", "Vespa Primavera 150", "Available"},
                {"MOTOR", "Yamaha NMAX 155", "Available"},
                {"TRUCK", "Mitsubishi L300", "Available"},
                {"TRUCK", "Hino 300 Series", "Available"},
                {"TRUCK", "Isuzu Elf Dropside", "Available"},
                {"TRUCK", "Dongfeng Captain E", "Available"}
            },
            new String [] {
                "Vehicle Type", "Model", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 554, 430));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Admin Vehicle Inventory System");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 15, 550, 34));

        btnAdd.setBackground(new java.awt.Color(204, 204, 204));
        btnAdd.setText("Add Vehicle");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, 99, -1));

        btnUpdate.setBackground(new java.awt.Color(204, 204, 204));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 510, 102, -1));

        btnDelete.setBackground(new java.awt.Color(204, 204, 204));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 510, 99, -1));

        btnShow.setBackground(new java.awt.Color(204, 204, 204));
        btnShow.setText("Show");
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });
        getContentPane().add(btnShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 510, 99, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            String[] options = {"Available", "Unavailable"};
            int choice = JOptionPane.showOptionDialog(
            this,
            "Select the new status:",
            "Update Status",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]
        );
        if (choice != -1) {
            String newStatus = choice == 0 ? "Available" : "Unavailable";
            model.setValueAt(newStatus, selectedRow, 2);//Dito maa-update ang status
            JOptionPane.showMessageDialog(this, "Status updated successfully to " + newStatus + ".");
        }
            
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to update.");
        }
    
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            
        int confirm = JOptionPane.showConfirmDialog(
            this, 
            "Are you sure you want to delete this row?", 
            "Delete Confirmation", 
            JOptionPane.YES_NO_OPTION
        );
        
        if (confirm == JOptionPane.YES_OPTION) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.removeRow(selectedRow); //mawawala na ang row na sinelect
            JOptionPane.showMessageDialog(this, "Row deleted successfully.", "Delete Successful", JOptionPane.INFORMATION_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(this, "Delete action canceled.", "Action Canceled", JOptionPane.INFORMATION_MESSAGE);
        }
        } else {
        JOptionPane.showMessageDialog(this, "Please select a row to delete.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
    }
    
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        StringBuilder data = new StringBuilder();
        for (int i = 0; i < model.getRowCount(); i++) {
            String status = (String) model.getValueAt(i, 2);
            if ("Available".equals(status)) {
            data.append("Vehicle Type: ").append(model.getValueAt(i, 0))
                .append(", Model: ").append(model.getValueAt(i, 1))
                .append(", Status: ").append(status).append("\n");
            }
        }
        if (data.length() > 0) {
            JOptionPane.showMessageDialog(this, data.toString(), "Available Vehicles", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No vehicles are available.", "No Available Vehicles", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnShowActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String type = JOptionPane.showInputDialog(this, "Enter Vehicle Type:");
    String model = JOptionPane.showInputDialog(this, "Enter Vehicle Model:");
    if (type != null && model != null && !type.isEmpty() && !model.isEmpty()) {
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        tableModel.addRow(new Object[]{type, model, "Available"});
    } else {
        JOptionPane.showMessageDialog(this, "Invalid input! Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventory().setVisible(true);
            }
        });
    }

    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnShow;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
}

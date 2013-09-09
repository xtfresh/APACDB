/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbprogram;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Montek
 */
public class EmpMain extends javax.swing.JFrame {
    String shelter;
    String empNum;
    Connection con;
    /**
     * Creates new form EmpMain
     */
    public EmpMain(String shelter, String empNum, Connection conn) {
        this.shelter = shelter;
        this.empNum = empNum;
        con = conn;
        initComponents();
    }
    public EmpMain() {
        initComponents();
    }
    
    public void updateView(){
        empNumLabel.setText(empNum);
        shelterLabel.setText(shelter);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        empNumLabel = new javax.swing.JLabel();
        shelterLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        eventButton = new javax.swing.JButton();
        adoptionReportButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        sumReportButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        empNumLabel.setText("jLabel1");
        jPanel1.add(empNumLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 11, -1, -1));

        shelterLabel.setText("jLabel2");
        jPanel1.add(shelterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 0, -1, -1));

        jLabel1.setText("Employee:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 11, -1, -1));

        jLabel2.setText("Shelter:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 0, -1, -1));

        jButton1.setText("Add Pet");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 59, 114, -1));

        eventButton.setText("Add Event");
        eventButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventButtonActionPerformed(evt);
            }
        });
        jPanel1.add(eventButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 113, -1));

        adoptionReportButton.setText("Adoption Report");
        adoptionReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adoptionReportButtonActionPerformed(evt);
            }
        });
        jPanel1.add(adoptionReportButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 182, 147, -1));

        jButton2.setText("Assign Pet-Foster");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 223, 147, -1));

        jButton3.setText("Year Adoption Summary");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 264, -1, -1));

        jButton4.setText("Quarter Report");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 298, 147, -1));

        sumReportButton.setText("Summary Report");
        sumReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sumReportButtonActionPerformed(evt);
            }
        });
        jPanel1.add(sumReportButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 147, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 153, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AddPetFrame view = new AddPetFrame(con, shelter);
        try {
            view.updateView();
        } catch (SQLException ex) {
            Logger.getLogger(EmpMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        view.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void eventButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventButtonActionPerformed
        AddEventFrame view = new AddEventFrame(con, shelter);
        view.updateView();
        view.setVisible(true);
    }//GEN-LAST:event_eventButtonActionPerformed

    private void sumReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sumReportButtonActionPerformed
        SummaryReportFrame view = new SummaryReportFrame(con);
        try {
            view.updateView();
        } catch (SQLException ex) {
            Logger.getLogger(EmpMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        view.setVisible(true);
    }//GEN-LAST:event_sumReportButtonActionPerformed

    private void adoptionReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adoptionReportButtonActionPerformed
        AdoptionReportFrame view = new AdoptionReportFrame(con);
        try {
            view.updateView();
        } catch (SQLException ex) {
            Logger.getLogger(EmpMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        view.setVisible(true);
    }//GEN-LAST:event_adoptionReportButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        PetFosterForm view = new PetFosterForm(con, shelter);
        try {
            view.updateView();
        } catch (SQLException ex) {
            Logger.getLogger(EmpMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        view.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        YearPetSummary view = new YearPetSummary(con);
        try {
            view.updateView();
        } catch (SQLException ex) {
            Logger.getLogger(EmpMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        view.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        QuarterReportFrame view = new QuarterReportFrame(con);
        try {
            view.updateView();
        } catch (SQLException ex) {
            Logger.getLogger(EmpMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        view.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(EmpMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmpMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmpMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmpMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmpMain().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adoptionReportButton;
    private javax.swing.JLabel empNumLabel;
    private javax.swing.JButton eventButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel shelterLabel;
    private javax.swing.JButton sumReportButton;
    // End of variables declaration//GEN-END:variables
}
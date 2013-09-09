package dbprogram;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Montek
 */
public class LoginView extends javax.swing.JFrame {
    Connection con;
    /**
     * Creates new form LoginView
     */
    
    public LoginView(Connection conn) throws SQLException {
        con = conn;
        initComponents();
        
        
        
    }
    public LoginView() {
        initComponents();
    }
    
    public void updateShelters() throws SQLException{
        Statement st = con.createStatement();
        String sql = ("SELECT ShelterName FROM Shelter");
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            shelterMenu.add(rs.getString(1));
        }
    }
    
    public ResultSet getSQL() throws SQLException{
        Statement st = con.createStatement();
        String sql = ("SELECT     EmpNum, Password\n" +
                      "FROM       Employee\n"
                      );
        ResultSet rs = st.executeQuery(sql);
        return rs;
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
        GuestLabel = new javax.swing.JLabel();
        GuestLogin = new javax.swing.JButton();
        EmpLabel = new javax.swing.JLabel();
        shelterMenu = new java.awt.Choice();
        shelterLabel = new javax.swing.JLabel();
        empNumTxtField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        empPwdField = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        empLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        GuestLabel.setText("Guest");

        GuestLogin.setText("Login");
        GuestLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuestLoginActionPerformed(evt);
            }
        });

        EmpLabel.setText("Employee");

        shelterMenu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                shelterMenuItemStateChanged(evt);
            }
        });

        shelterLabel.setText("Shelter");

        jLabel1.setText("Emp Num");

        empPwdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empPwdFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Emp Pwd");

        empLogin.setText("Login");
        empLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GuestLabel)
                    .addComponent(EmpLabel))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(GuestLogin)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(shelterLabel)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(empLogin)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(empPwdField)
                                .addComponent(empNumTxtField)
                                .addComponent(shelterMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)))
                        .addGap(138, 138, 138))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GuestLabel)
                    .addComponent(GuestLogin))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(EmpLabel)
                            .addGap(21, 21, 21))
                        .addComponent(shelterLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(shelterMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(empNumTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(empPwdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(empLogin)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void empPwdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empPwdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empPwdFieldActionPerformed

    private void GuestLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuestLoginActionPerformed
            GuestZipSearchView view = new GuestZipSearchView(con);
        try {
            view.updateView();
        } catch (SQLException ex) {
            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
        }
            view.setVisible(true);
            
    }//GEN-LAST:event_GuestLoginActionPerformed

    private void shelterMenuItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_shelterMenuItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_shelterMenuItemStateChanged

    private void empLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empLoginActionPerformed
        String empNum = empNumTxtField.getText();
        String pwd = new String(empPwdField.getPassword());
        String shelter = shelterMenu.getSelectedItem();
        try {
            ResultSet rs = getSQL();
            while(rs.next()){
                if(empNum.equals(rs.getString(1)) && pwd.equals(rs.getString(2))){
                    loginSuccess(shelter, empNum);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_empLoginActionPerformed
    
    private void loginSuccess(String shelter, String empNum){
        EmpMain view = new EmpMain(shelter, empNum, con);
        view.updateView();
        view.setVisible(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new LoginView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EmpLabel;
    private javax.swing.JLabel GuestLabel;
    private javax.swing.JButton GuestLogin;
    private javax.swing.JButton empLogin;
    private javax.swing.JTextField empNumTxtField;
    private javax.swing.JPasswordField empPwdField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel shelterLabel;
    private java.awt.Choice shelterMenu;
    // End of variables declaration//GEN-END:variables
}
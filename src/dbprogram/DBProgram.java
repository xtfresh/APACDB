/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbprogram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;


/**
 *
 * @author Montek
 */
public class DBProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shelter", "root", "19082lol");
            Statement stmt = (Statement) con.createStatement();
        }catch (Exception e) {
             System.err.println("Exception: " + e.getMessage()); 
        } 
        
        LoginView view = new LoginView(con);
        view.updateShelters();
        view.setVisible(true);
    }
}

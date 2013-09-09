/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbprogram;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Montek
 */
public class YearPetSummary extends javax.swing.JFrame {
    Connection con;
    /**
     * Creates new form YearPetSummary
     */
    public YearPetSummary(Connection conn) {
        con = conn;
        initComponents();
    }
    public YearPetSummary() {
        initComponents();
    }
    
    public void updateView() throws SQLException{
        Statement st = con.createStatement();
        String sql = ("SELECT MONTH('2013-01-20') AS MONTH, COUNT( DISTINCT PDA.PetID ) AS DogsAdopted, COUNT( DISTINCT PDN.PetID) AS NewDogs, COUNT( DISTINCT PDS.PetID) AS DogsSheltered, COUNT(DISTINCT PDF.PetID) AS DogsFostered, COUNT(DISTINCT PCA.PetID) AS CatsAdopted, COUNT(DISTINCT PCN.PetID) AS NewCats, COUNT(DISTINCT PCS.PetID) AS CatsSheltered, \n" +
"COUNT(DISTINCT PCF.PetID) AS CatsFostered\n" +
"\n" +
"FROM Shelter AS S\n" +
"LEFT OUTER JOIN Pet AS PDA ON ( S.ShelterName = PDA.ShelterName AND PDA.Type = 'Dog'\n" +
"AND MONTH( PDA.ADate ) = MONTH( '2013-01-01' ) AND YEAR(PDA.ADate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PDN ON ( S.ShelterName = PDN.ShelterName AND PDN.Type = 'Dog'\n" +
"AND MONTH( PDN.SDate ) = 01  AND YEAR(PDN.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PDS ON ( S.ShelterName = PDS.ShelterName AND PDS.Type = 'Dog'\n" +
"AND MONTH( PDS.SDate ) <= 01 AND MONTH( PDS.ADate ) > 01  AND YEAR(PDS.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PDF ON ( S.ShelterName = PDF.ShelterName AND PDF.FName IS NOT NULL AND PDF.Type = 'Dog'\n" +
"AND MONTH( PDF.SDate ) <= 01  AND YEAR(PDF.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PCA ON ( S.ShelterName = PCA.ShelterName AND PCA.Type = 'Cat'\n" +
"AND MONTH( PCA.ADate ) = MONTH( '2013-01-01' ) AND YEAR(PCA.ADate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PCN ON ( S.ShelterName = PCN.ShelterName AND PCN.Type = 'Cat'\n" +
"AND MONTH( PCN.SDate ) = 01  AND YEAR(PCN.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PCS ON ( S.ShelterName = PCS.ShelterName AND PCS.Type = 'Cat'\n" +
"AND MONTH( PCS.SDate ) <= 01 AND MONTH( PCS.ADate ) > 01  AND YEAR(PCS.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PCF ON ( S.ShelterName = PCF.ShelterName AND PCF.FName IS NOT NULL AND PCF.Type = 'Cat'\n" +
"AND MONTH( PCF.SDate ) <= 01  AND YEAR(PCF.SDate) = YEAR(CURRENT_DATE))\n" +
"\n" +
"UNION\n" +
"\n" +
"SELECT MONTH('2013-02-20'), COUNT( DISTINCT PDA.PetID ), COUNT( DISTINCT PDN.PetID), COUNT( DISTINCT PDS.PetID), \n" +
"COUNT(DISTINCT PDF.PetID), COUNT(DISTINCT PCA.PetID) , COUNT(DISTINCT PCN.PetID) , COUNT(DISTINCT PCS.PetID), \n" +
"COUNT(DISTINCT PCF.PetID)\n" +
"\n" +
"FROM Shelter AS S\n" +
"LEFT OUTER JOIN Pet AS PDA ON ( S.ShelterName = PDA.ShelterName AND PDA.Type = 'Dog'\n" +
"AND MONTH( PDA.ADate ) = MONTH( '2023-02-02' ) AND YEAR(PDA.ADate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PDN ON ( S.ShelterName = PDN.ShelterName AND PDN.Type = 'Dog'\n" +
"AND MONTH( PDN.SDate ) = 02  AND YEAR(PDN.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PDS ON ( S.ShelterName = PDS.ShelterName AND PDS.Type = 'Dog'\n" +
"AND MONTH( PDS.SDate ) <= 02 AND MONTH( PDS.ADate ) > 02  AND YEAR(PDS.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PDF ON ( S.ShelterName = PDF.ShelterName AND PDF.FName IS NOT NULL AND PDF.Type = 'Dog'\n" +
"AND MONTH( PDF.SDate ) <= 02  AND YEAR(PDF.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PCA ON ( S.ShelterName = PCA.ShelterName AND PCA.Type = 'Cat'\n" +
"AND MONTH( PCA.ADate ) = MONTH( '2023-02-02' ) AND YEAR(PCA.ADate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PCN ON ( S.ShelterName = PCN.ShelterName AND PCN.Type = 'Cat'\n" +
"AND MONTH( PCN.SDate ) = 02  AND YEAR(PCN.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PCS ON ( S.ShelterName = PCS.ShelterName AND PCS.Type = 'Cat'\n" +
"AND MONTH( PCS.SDate ) <= 02 AND MONTH( PCS.ADate ) > 02  AND YEAR(PCS.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PCF ON ( S.ShelterName = PCF.ShelterName AND PCF.FName IS NOT NULL AND PCF.Type = 'Cat'\n" +
"AND MONTH( PCF.SDate ) <= 02  AND YEAR(PCF.SDate) = YEAR(CURRENT_DATE))\n" +
"\n" +
"\n" +
"UNION\n" +
"SELECT MONTH('2013-03-20'), COUNT( DISTINCT PDA.PetID ), COUNT( DISTINCT PDN.PetID), COUNT( DISTINCT PDS.PetID), \n" +
"COUNT(DISTINCT PDF.PetID), COUNT(DISTINCT PCA.PetID) , COUNT(DISTINCT PCN.PetID) , COUNT(DISTINCT PCS.PetID), \n" +
"COUNT(DISTINCT PCF.PetID)\n" +
"\n" +
"FROM Shelter AS S\n" +
"LEFT OUTER JOIN Pet AS PDA ON ( S.ShelterName = PDA.ShelterName AND PDA.Type = 'Dog'\n" +
"AND MONTH( PDA.ADate ) = MONTH( '2033-03-03' ) AND YEAR(PDA.ADate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PDN ON ( S.ShelterName = PDN.ShelterName AND PDN.Type = 'Dog'\n" +
"AND MONTH( PDN.SDate ) = 03  AND YEAR(PDN.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PDS ON ( S.ShelterName = PDS.ShelterName AND PDS.Type = 'Dog'\n" +
"AND MONTH( PDS.SDate ) <= 03 AND MONTH( PDS.ADate ) > 03  AND YEAR(PDS.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PDF ON ( S.ShelterName = PDF.ShelterName AND PDF.FName IS NOT NULL AND PDF.Type = 'Dog'\n" +
"AND MONTH( PDF.SDate ) <= 03  AND YEAR(PDF.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PCA ON ( S.ShelterName = PCA.ShelterName AND PCA.Type = 'Cat'\n" +
"AND MONTH( PCA.ADate ) = MONTH( '2033-03-03' ) AND YEAR(PCA.ADate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PCN ON ( S.ShelterName = PCN.ShelterName AND PCN.Type = 'Cat'\n" +
"AND MONTH( PCN.SDate ) = 03  AND YEAR(PCN.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PCS ON ( S.ShelterName = PCS.ShelterName AND PCS.Type = 'Cat'\n" +
"AND MONTH( PCS.SDate ) <= 03 AND MONTH( PCS.ADate ) > 03  AND YEAR(PCS.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PCF ON ( S.ShelterName = PCF.ShelterName AND PCF.FName IS NOT NULL AND PCF.Type = 'Cat'\n" +
"AND MONTH( PCF.SDate ) <= 03  AND YEAR(PCF.SDate) = YEAR(CURRENT_DATE))\n" +
"\n" +
"\n" +
"UNION\n" +
"SELECT MONTH('2013-04-20'), COUNT( DISTINCT PDA.PetID ), COUNT( DISTINCT PDN.PetID), COUNT( DISTINCT PDS.PetID), \n" +
"COUNT(DISTINCT PDF.PetID), COUNT(DISTINCT PCA.PetID) , COUNT(DISTINCT PCN.PetID) , COUNT(DISTINCT PCS.PetID), \n" +
"COUNT(DISTINCT PCF.PetID)\n" +
"\n" +
"FROM Shelter AS S\n" +
"LEFT OUTER JOIN Pet AS PDA ON ( S.ShelterName = PDA.ShelterName AND PDA.Type = 'Dog'\n" +
"AND MONTH( PDA.ADate ) = MONTH( '2043-04-04' ) AND YEAR(PDA.ADate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PDN ON ( S.ShelterName = PDN.ShelterName AND PDN.Type = 'Dog'\n" +
"AND MONTH( PDN.SDate ) = 04  AND YEAR(PDN.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PDS ON ( S.ShelterName = PDS.ShelterName AND PDS.Type = 'Dog'\n" +
"AND MONTH( PDS.SDate ) <= 04 AND MONTH( PDS.ADate ) > 04  AND YEAR(PDS.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PDF ON ( S.ShelterName = PDF.ShelterName AND PDF.FName IS NOT NULL AND PDF.Type = 'Dog'\n" +
"AND MONTH( PDF.SDate ) <= 04  AND YEAR(PDF.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PCA ON ( S.ShelterName = PCA.ShelterName AND PCA.Type = 'Cat'\n" +
"AND MONTH( PCA.ADate ) = MONTH( '2043-04-04' ) AND YEAR(PCA.ADate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PCN ON ( S.ShelterName = PCN.ShelterName AND PCN.Type = 'Cat'\n" +
"AND MONTH( PCN.SDate ) = 04  AND YEAR(PCN.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PCS ON ( S.ShelterName = PCS.ShelterName AND PCS.Type = 'Cat'\n" +
"AND MONTH( PCS.SDate ) <= 04 AND MONTH( PCS.ADate ) > 04  AND YEAR(PCS.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PCF ON ( S.ShelterName = PCF.ShelterName AND PCF.FName IS NOT NULL AND PCF.Type = 'Cat'\n" +
"AND MONTH( PCF.SDate ) <= 04  AND YEAR(PCF.SDate) = YEAR(CURRENT_DATE))\n" +
"\n" +
"\n" +
"UNION\n" +
"SELECT MONTH('2013-05-20'), COUNT( DISTINCT PDA.PetID ), COUNT( DISTINCT PDN.PetID), COUNT( DISTINCT PDS.PetID), \n" +
"COUNT(DISTINCT PDF.PetID), COUNT(DISTINCT PCA.PetID) , COUNT(DISTINCT PCN.PetID) , COUNT(DISTINCT PCS.PetID), \n" +
"COUNT(DISTINCT PCF.PetID)\n" +
"\n" +
"FROM Shelter AS S\n" +
"LEFT OUTER JOIN Pet AS PDA ON ( S.ShelterName = PDA.ShelterName AND PDA.Type = 'Dog'\n" +
"AND MONTH( PDA.ADate ) = MONTH( '2053-05-05' ) AND YEAR(PDA.ADate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PDN ON ( S.ShelterName = PDN.ShelterName AND PDN.Type = 'Dog'\n" +
"AND MONTH( PDN.SDate ) = 05  AND YEAR(PDN.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PDS ON ( S.ShelterName = PDS.ShelterName AND PDS.Type = 'Dog'\n" +
"AND MONTH( PDS.SDate ) <= 05 AND MONTH( PDS.ADate ) > 05  AND YEAR(PDS.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PDF ON ( S.ShelterName = PDF.ShelterName AND PDF.FName IS NOT NULL AND PDF.Type = 'Dog'\n" +
"AND MONTH( PDF.SDate ) <= 05  AND YEAR(PDF.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PCA ON ( S.ShelterName = PCA.ShelterName AND PCA.Type = 'Cat'\n" +
"AND MONTH( PCA.ADate ) = MONTH( '2053-05-05' ) AND YEAR(PCA.ADate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PCN ON ( S.ShelterName = PCN.ShelterName AND PCN.Type = 'Cat'\n" +
"AND MONTH( PCN.SDate ) = 05  AND YEAR(PCN.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PCS ON ( S.ShelterName = PCS.ShelterName AND PCS.Type = 'Cat'\n" +
"AND MONTH( PCS.SDate ) <= 05 AND MONTH( PCS.ADate ) > 05  AND YEAR(PCS.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PCF ON ( S.ShelterName = PCF.ShelterName AND PCF.FName IS NOT NULL AND PCF.Type = 'Cat'\n" +
"AND MONTH( PCF.SDate ) <= 05  AND YEAR(PCF.SDate) = YEAR(CURRENT_DATE))\n" +
"\n" +
"\n" +
"UNION\n" +
"SELECT MONTH('2013-06-20'), COUNT( DISTINCT PDA.PetID ), COUNT( DISTINCT PDN.PetID), COUNT( DISTINCT PDS.PetID), \n" +
"COUNT(DISTINCT PDF.PetID), COUNT(DISTINCT PCA.PetID) , COUNT(DISTINCT PCN.PetID) , COUNT(DISTINCT PCS.PetID), \n" +
"COUNT(DISTINCT PCF.PetID)\n" +
"\n" +
"FROM Shelter AS S\n" +
"LEFT OUTER JOIN Pet AS PDA ON ( S.ShelterName = PDA.ShelterName AND PDA.Type = 'Dog'\n" +
"AND MONTH( PDA.ADate ) = MONTH( '2063-06-06' ) AND YEAR(PDA.ADate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PDN ON ( S.ShelterName = PDN.ShelterName AND PDN.Type = 'Dog'\n" +
"AND MONTH( PDN.SDate ) = 06  AND YEAR(PDN.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PDS ON ( S.ShelterName = PDS.ShelterName AND PDS.Type = 'Dog'\n" +
"AND MONTH( PDS.SDate ) <= 06 AND MONTH( PDS.ADate ) > 06  AND YEAR(PDS.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PDF ON ( S.ShelterName = PDF.ShelterName AND PDF.FName IS NOT NULL AND PDF.Type = 'Dog'\n" +
"AND MONTH( PDF.SDate ) <= 06  AND YEAR(PDF.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PCA ON ( S.ShelterName = PCA.ShelterName AND PCA.Type = 'Cat'\n" +
"AND MONTH( PCA.ADate ) = MONTH( '2063-06-06' ) AND YEAR(PCA.ADate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PCN ON ( S.ShelterName = PCN.ShelterName AND PCN.Type = 'Cat'\n" +
"AND MONTH( PCN.SDate ) = 06  AND YEAR(PCN.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PCS ON ( S.ShelterName = PCS.ShelterName AND PCS.Type = 'Cat'\n" +
"AND MONTH( PCS.SDate ) <= 06 AND MONTH( PCS.ADate ) > 06  AND YEAR(PCS.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PCF ON ( S.ShelterName = PCF.ShelterName AND PCF.FName IS NOT NULL AND PCF.Type = 'Cat'\n" +
"AND MONTH( PCF.SDate ) <= 06  AND YEAR(PCF.SDate) = YEAR(CURRENT_DATE))\n" +
"\n" +
"\n" +
"UNION\n" +
"SELECT MONTH('2013-07-20'), COUNT( DISTINCT PDA.PetID ), COUNT( DISTINCT PDN.PetID), COUNT( DISTINCT PDS.PetID), \n" +
"COUNT(DISTINCT PDF.PetID), COUNT(DISTINCT PCA.PetID) , COUNT(DISTINCT PCN.PetID) , COUNT(DISTINCT PCS.PetID), \n" +
"COUNT(DISTINCT PCF.PetID)\n" +
"\n" +
"FROM Shelter AS S\n" +
"LEFT OUTER JOIN Pet AS PDA ON ( S.ShelterName = PDA.ShelterName AND PDA.Type = 'Dog'\n" +
"AND MONTH( PDA.ADate ) = MONTH( '2073-07-07' ) AND YEAR(PDA.ADate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PDN ON ( S.ShelterName = PDN.ShelterName AND PDN.Type = 'Dog'\n" +
"AND MONTH( PDN.SDate ) = 07  AND YEAR(PDN.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PDS ON ( S.ShelterName = PDS.ShelterName AND PDS.Type = 'Dog'\n" +
"AND MONTH( PDS.SDate ) <= 07 AND MONTH( PDS.ADate ) > 07  AND YEAR(PDS.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PDF ON ( S.ShelterName = PDF.ShelterName AND PDF.FName IS NOT NULL AND PDF.Type = 'Dog'\n" +
"AND MONTH( PDF.SDate ) <= 07  AND YEAR(PDF.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PCA ON ( S.ShelterName = PCA.ShelterName AND PCA.Type = 'Cat'\n" +
"AND MONTH( PCA.ADate ) = MONTH( '2073-07-07' ) AND YEAR(PCA.ADate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PCN ON ( S.ShelterName = PCN.ShelterName AND PCN.Type = 'Cat'\n" +
"AND MONTH( PCN.SDate ) = 07  AND YEAR(PCN.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PCS ON ( S.ShelterName = PCS.ShelterName AND PCS.Type = 'Cat'\n" +
"AND MONTH( PCS.SDate ) <= 07 AND MONTH( PCS.ADate ) > 07  AND YEAR(PCS.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PCF ON ( S.ShelterName = PCF.ShelterName AND PCF.FName IS NOT NULL AND PCF.Type = 'Cat'\n" +
"AND MONTH( PCF.SDate ) <= 07  AND YEAR(PCF.SDate) = YEAR(CURRENT_DATE))\n" +
"\n" +
"UNION\n" +
"\n" +
"\n" +
"SELECT YEAR(CURRENT_DATE), COUNT( DISTINCT PDA.PetID ), COUNT( DISTINCT PDN.PetID), COUNT( DISTINCT PDS.PetID), \n" +
"COUNT(DISTINCT PDF.PetID), COUNT(DISTINCT PCA.PetID) , COUNT(DISTINCT PCN.PetID) , COUNT(DISTINCT PCS.PetID), \n" +
"COUNT(DISTINCT PCF.PetID)\n" +
"\n" +
"FROM Shelter AS S\n" +
"LEFT OUTER JOIN Pet AS PDA ON ( S.ShelterName = PDA.ShelterName AND PDA.Type = 'Dog'\n" +
"AND YEAR(PDA.ADate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PDN ON ( S.ShelterName = PDN.ShelterName AND PDN.Type = 'Dog'\n" +
"AND YEAR(PDN.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PDS ON ( S.ShelterName = PDS.ShelterName AND PDS.Type = 'NULL'\n" +
"AND YEAR(PDS.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PDF ON ( S.ShelterName = PDF.ShelterName AND PDF.FName IS NOT NULL AND PDF.Type = 'NULL'\n" +
"AND MONTH( PDF.SDate ) <= 07  AND YEAR(PDF.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PCA ON ( S.ShelterName = PCA.ShelterName AND PCA.Type = 'Cat'\n" +
"AND YEAR(PCA.ADate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PCN ON ( S.ShelterName = PCN.ShelterName AND PCN.Type = 'Cat'\n" +
"AND YEAR(PCN.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PCS ON ( S.ShelterName = PCS.ShelterName AND PCS.Type = 'NULL'\n" +
"AND YEAR(PCS.SDate) = YEAR(CURRENT_DATE))\n" +
"LEFT OUTER JOIN Pet AS PCF ON ( S.ShelterName = PCF.ShelterName AND PCF.FName IS NOT NULL AND PCF.Type = 'NULL'\n" +
"AND MONTH( PCF.SDate ) <= 07  AND YEAR(PCF.SDate) = YEAR(CURRENT_DATE))"
                      );
        ResultSet rs = st.executeQuery(sql);
        int i = 0;
        while(rs.next()){
            jTable1.setValueAt(rs.getString(1), i, 0);
            jTable1.setValueAt(rs.getString(2), i, 1);
            jTable1.setValueAt(rs.getString(3), i, 2);
            jTable1.setValueAt(rs.getString(4), i, 3);
            jTable1.setValueAt(rs.getString(5), i, 4);
            jTable1.setValueAt(rs.getString(6), i, 5);
            jTable1.setValueAt(rs.getString(7), i, 6);
            jTable1.setValueAt(rs.getString(8), i, 7);
            jTable1.setValueAt(rs.getString(9), i, 8);
            i++;   
        } 
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Month", "Dogs Adopted", "New Dogs", "Dogs in Shelter", "Dogs in FH", "Cats Adopted", "New Cats", "Cats in Shelter", "Cats in FH"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(YearPetSummary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(YearPetSummary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(YearPetSummary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(YearPetSummary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new YearPetSummary().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

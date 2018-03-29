package com.mycompany.apollo;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 * @deprecated 
 * @author BramWeenink
 */
public class DBLoader extends ApolloGUI{
    
    /**
     * @deprecated 
     * @author BramWeenink
     */
    public void noData(){
        System.out.println("er is geen god");
        JOptionPane.showMessageDialog(null, "Functie niet compleet sorry ); ", "Sorry", JOptionPane.INFORMATION_MESSAGE);
    }
    /*
    public void dataRetriever() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {                                    //Exception handling voor vinden van de plugin
            e.printStackTrace();
        }
        Connection connect = null;                                              //Initialisatie v.d. connectie en statements
        
        String myUrl = "jdbc:oracle:thin:@cytosine.nl:1521:xe";
        String User = "owe7_pg10";
        String Password = "blaat1234";
        
        try {
            connect = DriverManager.getConnection(myUrl, User, Password);  //URL : Username : wachtwoord
            
            Statement statement;                                                //Initialisatie statement
            statement = connect.createStatement();
            
            String getseqID_Query = "SELECT * FROM entry"; //Query voor het ophalen van de grootste entry_ID
            ResultSet rs1 = statement.executeQuery(getseqID_Query);
            while (rs1.next()) {
                System.out.println(rs1.getInt("entry_ID")+", "+rs1.getString("sequence")+", "+rs1.getString("entry_name"));                                   //Waarde ophalen uit database
                }

    
       
            connect.close();                                                    //sluit de connectie met de database
            System.out.println("Wegschrijven is gelukt!");
            JOptionPane.showMessageDialog(null, "Het ORF met bijbehorende informatie is weggeschreven naar de database.", "Succes", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();                                                //Exception handling voor SQL fouten
            System.out.println("Fout in de SQL syntax.");
            JOptionPane.showMessageDialog(null, "Er is een fout opgetreden met het wegschrijven van de data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
*/
}

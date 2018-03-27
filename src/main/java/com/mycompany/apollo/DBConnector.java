/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apollo;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author BramWeenink
 */
public class DBConnector extends ApolloGUI {
    
    int entryID;  // entry is de naam die wie hebben gekozen voor de sequentie
    int orfID;
    int blastID;
    int blast_hitID;
    
    public void dbVuller(String dnaSeq, String header, int lengte, String ORF_sequentie, int start_positie, int stop_positie, int reading_frame, int hits, int e_value, int identity, String accesion_code, String link){
        System.out.println("dbvuller test");
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {                                    //Exception handling voor vinden van de plugin
//            e.printStackTrace();
//        }
        
        
        Connection connect = null;                                              //Initialisatie v.d. connectie en statements
        PreparedStatement preStatement1 = null;
        PreparedStatement preStatement2 = null; 
        PreparedStatement preStatement3 = null;
        PreparedStatement preStatement4 = null;
            
//        String myDriver = "com.mysql.jdbc.Driver";                              //Driver
        //String myUrl = "jdbc:mysql://www.cytosine.nl:3306/owe7/_pg10";               //Connection type : protocol : host : port : database
        String myUrl = "jdbc:mysql://85.214.90.171:80";
        String User = "owe7_pg10";
        String Password = "blaat1234";
//        String myUrl = "jdbc:mysql://localhost:3306"; 
        
        try {
            connect = DriverManager.getConnection(myUrl, User, Password);  //Username : wachtwoord
            //System.out.println(conn.getClientInfo());
            
            Statement statement;                                                //Initialisatie statement
            statement = connect.createStatement();
        
            String getseqID_Query = "SELECT MAX(entry_ID) as entry_ID from entry"; //Query voor het ophalen van de grootste entry_ID
            ResultSet rs1 = statement.executeQuery(getseqID_Query);             //Uitvoeren van de query
            while (rs1.next()) {
                entryID = rs1.getInt("entry_ID");                                   //Waarde ophalen uit database
                }
            entryID +=1;                                                          //1 wordt opgeteld bij de oude sequentie voor een niewe entry id.
            
            
            //query voor de seq_ID
            String getorfID_Query = "SELECT MAX(ORF_ID) as ORF_ID from ORF";    //Query voor het ophalen van de grootste ORF_ID
            ResultSet rs2 = statement.executeQuery(getorfID_Query);             //Uitvoeren van de query
            while (rs2.next()) {
                orfID = rs2.getInt("ORF_ID");                                   //waarde ophalen uit de database
                }      
            orfID +=1;                                                          //1 wordt opgeteld bij de oude sequentie van 
            
            
            //query voor het inserten in sequentie tabel
            String insertSeqQuery = "INSERT INTO entry(entry_ID, sequentie, header/name) VALUES(?,?,?)"; //query 2
            preStatement1 = connect.prepareStatement(insertSeqQuery);           //PreStatement1 wordt gekoppeld aan de sequenties query
            preStatement1.setInt    (1, entryID);                            //Getal staat voor de locatie in de query, object staat voor variabele in javav die moet worden opgeslagen
            preStatement1.setString (2, dnaSeq);
            preStatement1.setString (3, header);
            
            preStatement1.executeUpdate();                                      //update de tabel
             
            //query voor het inserten in ORF tabel
            String insertORFQuery = "INSERT INTO ORF(ORF_ID, entry_entry_ID, orf_sequence, start_loc , stop_loc, read_frame) VALUES(?,?,?,?,?)"; //Query
            preStatement2 = connect.prepareStatement(insertORFQuery);              //PreStatement2 wordt gekoppeld aan de ORF query
            preStatement2.setInt     (1, orfID);
            preStatement2.setInt     (2, entryID);
            preStatement2.setString  (3, ORF_sequentie);
            preStatement2.setInt     (4, start_positie);
            preStatement2.setInt     (5, stop_positie);
            preStatement2.setInt     (6, reading_frame);
            
            preStatement2.executeUpdate();                                      //update de tabel
            
            String insertBLASTQuery = "INSERT INTO BLAST_results(BLAST_ID, ORF_ORF_ID, hits)"; //query
            preStatement3 = connect.prepareStatement(insertBLASTQuery);
            preStatement3.setInt    (1, blastID);
            preStatement3.setInt    (2, orfID);
            preStatement3.setInt (3, hits);
            
            preStatement3.executeUpdate();
            
            String insertBLAST_hitQuery = "INSERT INTO BLAST_hit(BLAST_HIT_ID, E_Value, Identity, Accesion_code, Link)";
            preStatement4 = connect.prepareStatement(insertBLAST_hitQuery);
            preStatement4.setInt    (1, blast_hitID);
            preStatement4.setInt    (2, e_value);
            preStatement4.setInt    (3, identity);
            preStatement4.setString (4, accesion_code);
            preStatement4.setInt    (5, blastID);
            preStatement4.setString (6, link);
            
            preStatement4.executeUpdate();
            
            connect.close();                                                    //sluit de connectie met de database
            System.out.println("Wegschrijven is gelukt!");
            JOptionPane.showMessageDialog(null, "Het ORF met bijbehorende informatie is weggeschreven naar de database.", "Succes", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();                                                //Exception handling voor SQL fouten
            System.out.println("Fout in de SQL syntax.");
            JOptionPane.showMessageDialog(null, "Er is een fout opgetreden met het wegschrijven van de data.", "Error", JOptionPane.ERROR_MESSAGE);
        }   
    }   
}

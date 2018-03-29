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
 * DBConnector creëert een connectie met een oracle database en schrijft data daarin weg.
 * De database is te benaderen via Oracle sql developer. 
 */
public class DBConnector extends ApolloGUI {
    
    int entryID;    // entry is de naam die wie hebben gekozen voor de sequentie
    int orfID;
    int blastID;
    int blast_hitID;
    
    /**
     *
     * @param dnaSeq
     * @param header
     * @param lengte
     * @param ORF_sequentie
     * @param reading_frame
     * @param hits
     * @param e_value
     * @param eiwit
     * @param organisme
     * @param identity
     * @param accesion_code
     */
    public void dbVuller(String dnaSeq, String header, int lengte, String ORF_sequentie, int reading_frame, int hits, double e_value, double identity, String accesion_code, String eiwit, String organisme){
//        System.out.println("dbvuller test");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");                   // oracle jdbc driver nodig ojdbc8
        } catch (ClassNotFoundException e) {                                    //Exception handling voor vinden van de plugin
            e.printStackTrace();
        }
//        System.out.println("hoi");

        Connection connect = null;                                              //Initialisatie v.d. connectie en statements
        PreparedStatement preStatement1 = null;
        PreparedStatement preStatement2 = null; 
        PreparedStatement preStatement3 = null;
        PreparedStatement preStatement4 = null;
            
//        String myDriver = "com.mysql.jdbc.Driver";                              //Driver
              //Connection type : protocol : host : port : database
        String myUrl = "jdbc:oracle:thin:@cytosine.nl:1521:xe";
        String User = "owe7_pg10";
        String Password = "blaat1234";
        
        try {
            connect = DriverManager.getConnection(myUrl, User, Password);  //URL : Username : wachtwoord
//            System.out.println(connect.getClientInfo());
            
            Statement statement;                                                //Initialisatie statement
            statement = connect.createStatement();
            
        
            String getseqID_Query = "SELECT MAX(entry_ID) as entry_ID from entry"; //Query voor het ophalen van de grootste entry_ID
            ResultSet rs1 = statement.executeQuery(getseqID_Query);             //Uitvoeren van de query
            while (rs1.next()) {
                entryID = rs1.getInt("entry_ID");                                   //Waarde ophalen uit database
                }
            entryID +=1;                                                          //1 wordt opgeteld bij de oude sequentie voor een niewe entry id.
            
            
            //query voor de ORF_ID
            String getorfID_Query = "SELECT MAX(ORF_ID) as ORF_ID from ORF";    //Query voor het ophalen van de grootste ORF_ID
            ResultSet rs2 = statement.executeQuery(getorfID_Query);             //Uitvoeren van de query
            while (rs2.next()) {
                orfID = rs2.getInt("ORF_ID");                                   //waarde ophalen uit de database
                }      
            orfID +=1;                                                          //1 wordt opgeteld bij de oude sequentie van 
            
            String getBlastID_Query = "SELECT MAX(blast_ID) as blast_ID from Blast_results";
            ResultSet rs3 = statement.executeQuery(getBlastID_Query);
            while (rs3.next()){
                blastID = rs3.getInt("blast_ID");
            }
            blastID +=1;
            
            String getBlastHitID_Query = "SELECT MAX(Blast_hit_ID) as Blast_hit_ID from Blast_hit";
            ResultSet rs4 = statement.executeQuery(getBlastHitID_Query);
            while (rs4.next()){
                blast_hitID = rs4.getInt("Blast_hit_ID");
            }
            blast_hitID +=1;
            
            System.out.println("entry id "+entryID);
            //query voor het inserten in sequentie tabel
            String insertSeqQuery = "INSERT INTO entry(entry_ID, sequence, entry_name) VALUES(?,?,?)"; //query 2
            preStatement1 = connect.prepareStatement(insertSeqQuery);           //PreStatement1 wordt gekoppeld aan de sequenties query
            preStatement1.setInt    (1, entryID);                            //Getal staat voor de locatie in de query, object staat voor variabele in javav die moet worden opgeslagen
            preStatement1.setString (2, dnaSeq);
            preStatement1.setString (3, header);
            
            preStatement1.executeUpdate();                                      //update de tabel
            System.out.println("entry done");
            
            System.out.println("ORF id "+orfID);
            //query voor het inserten in ORF tabel
            String insertORFQuery = "INSERT INTO ORF(ORF_ID, entry_entry_ID, ORF_sequence, reading_frame) VALUES(?,?,?,?)"; //Query
            preStatement2 = connect.prepareStatement(insertORFQuery);              //PreStatement2 wordt gekoppeld aan de ORF query
            preStatement2.setInt     (1, orfID);
            preStatement2.setInt     (2, entryID);
            preStatement2.setString  (3, ORF_sequentie);
            preStatement2.setInt     (4, reading_frame);
            
            preStatement2.executeUpdate();                                      //update de tabel
            System.out.println("ORF done");
            
            System.out.println("blast id "+blastID);
            String insertBLASTQuery = "INSERT INTO Blast_results(blast_ID, ORF_ORF_ID, hits) VALUES(?,?,?)"; //query
            preStatement3 = connect.prepareStatement(insertBLASTQuery);
            preStatement3.setInt    (1, blastID);
            preStatement3.setInt    (2, orfID);
            preStatement3.setInt    (3, hits);
            
            preStatement3.executeUpdate();
            System.out.println("Blast result done");
            
            System.out.println("hit id"+blast_hitID);
            String insertBLAST_hitQuery = "INSERT INTO Blast_hit(Blast_hit_ID, E_Value, identity_score, accession_code, Blast_results_blast_ID, protein_name, organism_name) VALUES(?,?,?,?,?,?,?)";
            preStatement4 = connect.prepareStatement(insertBLAST_hitQuery);
            preStatement4.setInt    (1, blast_hitID);
            preStatement4.setDouble (2, e_value);
            preStatement4.setDouble (3, identity);
            preStatement4.setString (4, accesion_code);
            preStatement4.setInt    (5, blastID);
            preStatement4.setString (6, eiwit);
            preStatement4.setString (7, organisme);
            
            preStatement4.executeUpdate();
            System.out.println("blast hit done");
            
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

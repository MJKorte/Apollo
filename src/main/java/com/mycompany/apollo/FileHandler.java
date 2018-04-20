/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apollo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 *Deze class zortg ervoor dat het gekozen berstand kan worden ingelezen en de data uit het bestand kan worden opgeslagen
 * Deze sequentie word daarna door filebuilder in reading frames verdeeld
 * 
 * @author Rogier
*/
public class FileHandler {
    /**
     * declaratie van variabelen
     */
    private static String sequence;
    public static String header;
    /**
     * Door middel van een regular expression word de sequentie gescand op karakters die er niet in horen.
     * @return de inhoud van de file opgeslagen in een string
     */
    public static String FileOpener(){
        int returnVal = ApolloGUI.fileChooser.showOpenDialog(ApolloGUI.fileChooser);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = ApolloGUI.fileChooser.getSelectedFile();
            System.out.println(file);
            try {
                file.getAbsolutePath();
                sequence = ReadFile(file).toUpperCase();
                System.out.println("A1");
                sequence = checkSequence(sequence);
                System.out.println("A2");
                ApolloGUI.analyseProgressBar.setValue(0);
                return sequence;
            } catch (FileNotFoundException e) {
                System.out.println("problem accessing file." + file.getAbsolutePath());
            }
        } else {
            System.out.println("File access cancelled by user.");
        }
        return null;
    }
    
    /*
    *
    *  Majority of code taken from https://rosettacode.org/wiki/FASTA_format#Java
    */
    /**
     * Deze methode krijgt een bestandspad die door middel van een scanner het bestand inleest
     * @param file
     * @return sequentie
     * @throws FileNotFoundException 
     */
    public static String ReadFile(File file) throws FileNotFoundException{
        boolean first = true;
        String seq = "";
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (sc.hasNextLine()&&line.charAt(0) == '>') {
                    header = line;
                    if (first)
                        first = false;
                    else
                        seq += line;
                    //Print header:
                    //System.out.printf("%s: ", line.substring(1));
                } else {
                    seq += line;
                }
            }
        }
        return seq;
    }
    /**
     * Door middel van een regedit word de sequentie gecontroleerd door een regular expression
     * @param seq
     * @return de DNA sequentie
     */
    private static String checkSequence(String seq){
        if (seq.matches("[ATGCN]+")){
            return seq;
        } else if (seq.matches("[AUGCN]+")){
            return seq.replace("U", "T");
        }else{
            System.out.println("Sequence is not valid");
            return null;
        }
    }
}

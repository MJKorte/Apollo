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
 *
 * @author Rogier
*/
public class FileHandler {
    private static String sequence;
    public static String header;
    
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
    private static String ReadFile(File file) throws FileNotFoundException{
        boolean first = true;
        String seq = "";
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.charAt(0) == '>') {
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

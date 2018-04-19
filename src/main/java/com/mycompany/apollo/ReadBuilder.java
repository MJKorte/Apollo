/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apollo;

import java.util.ArrayList;

/**
 *Deze class zorgt ervoor dat de sequentie uit het sequentie bestand word verdeeld in 6 reading frames
 * @author rogie
 */
public class ReadBuilder { //Feel free to edit the name
    /**
     * Declaratie van variablen
     */
    private static ArrayList<String> reads = new ArrayList<>();
    private static ArrayList<String> temp = new ArrayList<>();
    /**
     * Deze methode neemt een sequentie aan en verdeeld deze in 6 verschillende RF's met forward en reverse
     * Vervolgens worden deze reading frames opgeslagen in een ArrayList
     * @param DNAseq
     * @return reads lijst met 6 verschillende reading frames
     */
    public static ArrayList<String> buildReads(String DNAseq){
        reads.clear();
        temp.clear();
        for(int i = 0; i <= 2; i++){
            reads.add(DNAseq.substring(i));
            temp.add(DNAseq.substring(i));
        }
        reads.addAll(temp);
        return reads;
    }
}

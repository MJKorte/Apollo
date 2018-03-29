/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apollo;

import java.util.ArrayList;

/**
 *
 * @author rogie
 */
public class ReadBuilder { //Feel free to edit the name
    
    private static ArrayList<String> reads = new ArrayList<>();
    private static ArrayList<String> temp = new ArrayList<>();
    
    /**
     *
     * @param DNAseq
     * @return
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

package com.mycompany.apollo;

import java.util.ArrayList;

/**
 * Readbuilder creates the 6 different reads from the original sequence.
 * @author Mark
 */
public class ReadBuilder { //Feel free to edit the name
    
    private static ArrayList<String> reads = new ArrayList<>();
    private static ArrayList<String> temp = new ArrayList<>();
    
    /**
     *
     * @param DNAseq  The original DNA sequence
     * @return reads  An arraylist with the 6 different reads  
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

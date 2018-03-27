/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apollo;

/**
 *
 * @author rogie
 */
public class ORF {
    public int orfID;
    public String sequentie;
    public int readNr;
    
    public ORF(int id, String seq, int read){
        orfID = id;
        sequentie = seq;
        readNr = read;
    }

    public int getSequenceLength() {
        return sequentie.length();
    }
    
    
    
}

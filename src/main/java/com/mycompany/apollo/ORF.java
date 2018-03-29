/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apollo;

/**
 * ORF is the object class for Open Reading Frames.
 * The ORF objects are instantiated when the ORF's are found.
 * When an ORF is blasted the blast results will be stored in its instance.
 * 
 * @author rogie
 */
public class ORF {

    public int orfID;
    public String sequentie;
    public int readNr;
    public boolean blasted;
    public double E_Value;

    public ORF(int id, String seq, int read) {
        orfID = id;
        sequentie = seq;
        readNr = read;
    }

    public int getSequenceLength() {
        return sequentie.length();
    }

    public void setBlastedTrue() {
        this.blasted = true;
    }

    public boolean getBlasted() {
        return this.blasted;
    }

    public void setE_Value(double e) {
        this.E_Value = e;
    }

    public double getE_Value() {
        return E_Value;
    }

}

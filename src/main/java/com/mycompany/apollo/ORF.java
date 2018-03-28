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

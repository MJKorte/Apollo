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
    
    /**
     * Declaratie van de variabelen
     */
    public int orfID;
    public String sequentie;
    public int readNr;
    public boolean blasted;
    public double E_Value;

    /**
     * Deze functie neemt de informattie over het ORF aan van ORFanalyzer
     * De informatie word opgeslagen in het object ORF
     * @param id
     * @param seq
     * @param read 
     */
    public ORF(int id, String seq, int read) {
        orfID = id;
        sequentie = seq;
        readNr = read;
    }
    /**
     * Getter
     * @return de lengte van de sequentie
     */
    public int getSequenceLength() {
        return sequentie.length();
    }
    
    /**
     * Setter om de status van de BLast op te slaan
     */
    public void setBlastedTrue() {
        this.blasted = true;
    }
    /**
     * Getter voor de Blaststatus
     * @return de status van de blast 
     */
    public boolean getBlasted() {
        return this.blasted;
    }
    /**
     * Setter voor de E-value
     * @param e 
     */
    public void setE_Value(double e) {
        this.E_Value = e;
    }
    /**
     * Getter voor de e-value
     * @return e-value
     */
    public double getE_Value() {
        return E_Value;
    }

}

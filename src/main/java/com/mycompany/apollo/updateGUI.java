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
public class updateGUI {

    /**
     *
     */
    public void updateReads() {

    }

    /**
     *
     * @param ORFid
     */
    public static void updateORFInfoPane(int ORFid) {
        String updatedText;
        ORF orf = ApolloGUI.ORFs.get(ORFid);
        updatedText = "Reading frame: " + orf.readNr;
        if (orf.blasted) {
            updatedText += "\nE_Value: " + orf.getE_Value();
        } else {
            updatedText += "\nNo blast results yet";
        }
        ApolloGUI.ORFInfoPane.setText(updatedText);
    }
}

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
    public void updateReads(){
        
    }
    
    public static void updateORFInfoPane(int ORFid){
        ORF orf = ApolloGUI.ORFs.get(ORFid);
        ApolloGUI.ORFInfoPane.setText("Reading frame: "+orf.readNr);
    }
}

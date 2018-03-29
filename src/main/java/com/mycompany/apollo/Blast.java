/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apollo;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rogie
 */
public class Blast extends Thread {
        private int ORFid;
    public Blast(int ORFid) {
        this.ORFid = ORFid;
        System.out.println("blasting ORF " + ORFid);
    }
    
    
    @Override
    public void run() {

            try {
                Process p = Runtime.getRuntime().exec("python blast.py");
                //end blast stuff
            } catch (IOException ex) {
                Logger.getLogger(Blast.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            ApolloGUI.ORFs.get(ORFid).setBlastedTrue();
            ApolloGUI.blastButton.setEnabled(true);
    }
}

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
            ApolloGUI.blastButton.setEnabled(false);
            System.out.println("cur: "+Thread.currentThread());
            Thread.sleep(5000);
            
            //Blast stuff here
            ApolloGUI.ORFs.get(ORFid).setE_Value(0.000001);
            try {
                Process p = Runtime.getRuntime().exec("C:\\ProgramData\\Anaconda3\\python.exe yourapp.py");
                //end blast stuff
            } catch (IOException ex) {
                Logger.getLogger(Blast.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            ApolloGUI.ORFs.get(ORFid).setBlastedTrue();
            ApolloGUI.blastButton.setEnabled(true);
        } catch (InterruptedException ex) {
            System.out.println("this aint happenin");
            Logger.getLogger(Blast.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

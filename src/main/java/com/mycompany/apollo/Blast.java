/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apollo;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class handles the interaction with the python script responsible for blasting.
 * 
 * @since 1.0
 * @author Rogier
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
            System.out.println("cur: " + Thread.currentThread());

            String file = FileHandler.FileOpener();

            while (true) {
                if (file.isEmpty()) {
                    Thread.sleep(10000);
                } else {
                    break;
                }
            }

            //Blast stuff here
            //end blast stuff
            ApolloGUI.ORFs.get(ORFid).setBlastedTrue();
            ApolloGUI.blastButton.setEnabled(true);
        } catch (InterruptedException ex) {
            Logger.getLogger(Blast.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Backup of test stuff
//        try {
//            ApolloGUI.blastButton.setEnabled(false);
//            System.out.println("cur: "+Thread.currentThread());
//            Thread.sleep(5000);
//            
//            //Blast stuff here
//            ApolloGUI.ORFs.get(ORFid).setE_Value(0.000001);
//            //end blast stuff
//            
//            ApolloGUI.ORFs.get(ORFid).setBlastedTrue();
//            ApolloGUI.blastButton.setEnabled(true);
//        } catch (InterruptedException ex) {
//            System.out.println("this aint happenin");
//            Logger.getLogger(Blast.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}

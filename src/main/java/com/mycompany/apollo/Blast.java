/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apollo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
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

        ApolloGUI.blastButton.setEnabled(false);
        System.out.println("cur: " + Thread.currentThread());
        try {
            Process p = Runtime.getRuntime().exec("python blast.py");
            read();
        } catch (IOException ex) {
            Logger.getLogger(Blast.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ApolloGUI.ORFs.get(ORFid).setBlastedTrue();
        //ApolloGUI.blastButton.setEnabled(true);
    }

    public ArrayList<String> read() throws FileNotFoundException {
        Boolean leeg = true;
        ArrayList<String> hits = new ArrayList<>();
        File file = new File("result.txt");
        while (leeg == true) {
            String result = ReadFile(file);
            if (result.isEmpty()) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            } else {
                String[] parts = result.split("/n");
                hits.addAll(Arrays.asList(parts));
                System.out.println(hits.size());
                leeg = false;
            }
        }

        return null;
    }
        public static String ReadFile(File file) throws FileNotFoundException{
        boolean first = true;
        String seq = "";
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                seq += line;
                }
            }
        return seq;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apollo;

import java.util.ArrayList;

/**
 *
 * @author Mark
 */
public class ORFanalyzer {

    //GG
    public static ArrayList<ORF> ORFs = new ArrayList<ORF>();
    public static ArrayList<String> htmlcode = new ArrayList<String>();
    public static double countMax;
    public static double countDone = 0;

    public static ArrayList<String> findORF(ArrayList<String> reads) {
        ORFs.clear();
        htmlcode.clear();
        countMax = ApolloGUI.getDnaSeq().length();
        countDone = 0;
        int idcounter = 0;
        for (int i = 0; i <= 2; i++) {
            boolean ORF = false;
            String html = "";
            String spatie = "&nbsp;&nbsp;";
            if (i == 1) {
                html += ".";
            }
            if (i == 2) {
                html += "..";
            }
            String currentORF = "";
            for (int x = 0; x < reads.get(i).length() / 3; x++) {
                countDone++;
                ApolloGUI.jProgressBar1.setValue((int) ((countDone / countMax) * 100));
                String protein = TranslatorFW.translate(reads.get(i).substring(3*x, 3*(x+1)));
                if (protein.equals("M") && ORF == false && reads.get(i).length()/3 - x > 100) {
                    ORF = true;
                    currentORF += String.format("<span><a href=%2d>", idcounter) + protein + spatie;
                } else if (protein.equals(".") && ORF == true) {
                    if (currentORF.length() <= 1300) {
                        currentORF += protein + spatie;
                    } else {
                        ORF = false;
                        currentORF += protein;
                        ORFs.add(new ORF(idcounter, currentORF.replace(spatie, ""), i + 1));
                        html += currentORF + "</a></span>" + spatie;
                        currentORF = "";
                        idcounter++;
                    }
                } else if (ORF == true) {
                    if (reads.get(i).length()/3 - x >= 2) {
                        currentORF += protein + spatie;
                    } else {
                        html += currentORF.replace(String.format("<span><a href=%2d>", idcounter), "");
                        html += protein + spatie;
                    }
                } else {
                    html += protein + spatie;
                }
            }
            html += "<br>";
            htmlcode.add(html);
        }
        for (int i = 3; i <= 5; i++) {
            System.out.println(reads.get(i).length());
            System.out.println(reads.get(i).length() / 3);
            boolean ORF = false;
            String html = "";
            String currentORF = "";
            html += "<br>";
            if (i == 4) {
                html += ".";
            }
            if (i == 5) {
                html += "..";
            }
            for (int x = 0; x < reads.get(i).length() / 3; x++) {
                String protein = TranslatorRE.translate(reads.get(i).substring(3*x, 3*(x+1)));
                String spatie = "&nbsp;&nbsp;";
                if (protein.equals(".") && ORF == false && reads.get(i).length()/3 - x > 100) {
                    ORF = true;
                    currentORF += String.format("<span><a href=%2d>", idcounter) + protein + spatie;
                } else if (protein.equals("M") && ORF == true) {
                    if (currentORF.length() <= 1300) {
                        currentORF += protein + spatie;
                    } else {
                        ORF = false;
                        currentORF += protein;
                        ORFs.add(new ORF(idcounter, currentORF.replace(spatie, ""), i + 1));
                        html += currentORF + "</a></span>" + spatie;
                        currentORF = "";
                        idcounter++;
                    }
                } else if (ORF == true) {
                    if (reads.get(i).length()/3 - x >= 2) {
                        currentORF += protein + spatie;
                    } else {
                        html += currentORF.replace(String.format("<span><a href=%2d>", idcounter), "");
                        html += protein + spatie;
                    }
                } else {
                    html += protein + spatie;
                }
            }
            htmlcode.add(html);
        }
        System.out.println("Totaal aantal ORFs: " + ORFs.size());
        ApolloGUI.ORFs = ORFs;
        ApolloGUI.progressScreen.setVisible(false);
        return htmlcode;

    }
}

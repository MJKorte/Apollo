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
            if(i==1){
               html += "."; 
            }
            if(i==2){
               html += ".."; 
            }            
            String currentORF = "";
            for (int x = 0; x < reads.get(i).length(); x++) {
                countDone++;
                ApolloGUI.jProgressBar1.setValue((int)((countDone/countMax)*100));
                System.out.println("value of "+countDone+"/"+countMax+" = "+(int)((countDone/countMax)*100));
                String protein = Character.toString(reads.get(i).charAt(x));
                if (protein.equals("M") && ORF == false && reads.get(i).length() - x > 100) {
                    ORF = true;
                    html += String.format("<span><a href=%2d>", idcounter) + protein + "&nbsp;&nbsp;";
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
                    if(reads.get(i).length() - x >= 2){
                        currentORF += protein + spatie;
                    }
                    else{
                        html+= currentORF.replace(">naps/<>a/<", "");
                        html+= protein + spatie;
                    }
                } else {
                    html += protein + spatie;
                }
            }
            html += "<br>";
            htmlcode.add(html);
        }
        for (int i = 3; i <= 5; i++) {
            boolean ORF = false;
            String html = "";
            String currentORF = "";
            for (int x = 0; x < reads.get(i).length(); x++) {
                String protein = Character.toString(reads.get(i).charAt(x));
                String spatie = new StringBuilder("&nbsp;&nbsp;").reverse().toString();
                if (protein.equals("M") && ORF == false && reads.get(i).length() - x > 100) {
                    ORF = true;
                    html +=  spatie + ">naps/<>a/<"+ protein;
                } else if (protein.equals(".") && ORF == true) {
                    if (currentORF.length() <= 1300) {
                        currentORF += spatie +  protein;
                    } else {
                        ORF = false;
                        currentORF += spatie +  protein;
                        ORFs.add(new ORF(idcounter, new StringBuilder(currentORF).reverse().toString().replace("&nbsp;&nbsp;", ""), i + 1));
                        html += currentORF + String.format(">%d=ferh a<>naps<", Integer.parseInt(new StringBuilder(String.valueOf(idcounter)).reverse().toString()));
                        currentORF = "";
                        idcounter++;
                    }
                } else if (ORF == true) {
                    if(reads.get(i).length() - x >= 2){
                        currentORF += spatie +  protein;
                    }
                    else{
                        html+= currentORF.replace(">naps/<>a/<", "");
                        html+= spatie + protein;
                    }
                } else {
                    html += spatie +  protein;
                }
            }
                if(i==4){
                    html += "."; 
                    }
                if(i==5){
                    html += "..";
                }
            html += ">rb<";
            htmlcode.add(new StringBuilder(html).reverse().toString());
        }
        //System.out.println("RF 1: " + htmlcode.get(0));
        //System.out.println("RF 2: " + htmlcode.get(1));
        //System.out.println("RF 3: " + htmlcode.get(2));
        //System.out.println("RF 4: " + htmlcode.get(3));
        //System.out.println("RF 5: " + htmlcode.get(4));
        //System.out.println("RF 6: " + htmlcode.get(5));
        System.out.println("Totaal aantal ORFs: " + ORFs.size());
        ApolloGUI.ORFs = ORFs;
        ApolloGUI.progressScreen.setVisible(false);
        return htmlcode;

    }
}
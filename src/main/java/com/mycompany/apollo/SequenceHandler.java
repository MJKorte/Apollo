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
public class SequenceHandler {


    public static String translate(String temp) {
        int i = 0;
        String result = "";
        while (i <= temp.length() - 3) {
            String triplet = temp.substring(i, i += 3);
            if (triplet.equals("TTT") || triplet.equals("TTC")) {
                result += 'F';
            }
            else if (triplet.equals("TTA") || triplet.equals("TTG")
                    || triplet.equals("CTT") || triplet.equals("CTC")
                    || triplet.equals("CTA") || triplet.equals("CTG")) {
                result += 'L';
            }
            else if (triplet.equals("ATT") || triplet.equals("ATC")
                    || triplet.equals("ATA")) {
                result += 'I';
            }
            else if (triplet.equals("ATG")) {
                result += 'M';
            }
            else if (triplet.equals("GTT") || triplet.equals("GTC")
                    || triplet.equals("GTA") || triplet.equals("GTG")) {
                result += 'V';
            }
            else if (triplet.equals("TCT") || triplet.equals("TCC")
                    || triplet.equals("TCA") || triplet.equals("TCG")) {
                result += 'S';
            }
            else if (triplet.equals("AGA") || triplet.equals("AGG")) {
                result += 'R';
            }
            else if (triplet.equals("AGT") || triplet.equals("AGC")) {
                result += 'S';
            }
            else if (triplet.equals("TGG")) {
                result += 'W';
            }
            else if (triplet.equals("TGT") || triplet.equals("TGC")) {
                result += 'C';
            }
            else if (triplet.equals("GAA") || triplet.equals("GAG")) {
                result += 'E';
            }
            else if (triplet.equals("GAT") || triplet.equals("GAC")) {
                result += 'D';
            }
            else if (triplet.equals("AAA") || triplet.equals("AAG")) {
                result += 'K';
            }
            else if (triplet.equals("AAT") || triplet.equals("AAC")) {
                result += 'N';
            }
            else if (triplet.equals("CAA") || triplet.equals("CAG")) {
                result += 'Q';
            }
            else if (triplet.equals("CAT") || triplet.equals("CAC")) {
                result += 'H';
            }
            else if (triplet.equals("TAT") || triplet.equals("TAC")) {
                result += 'Y';
            }
            else if (triplet.equals("CCG") || triplet.equals("CCA")
                    || triplet.equals("CCC") || triplet.equals("CCT")) {
                result += 'P';
            }
            else if (triplet.equals("ACG") || triplet.equals("ACA")
                    || triplet.equals("ACC") || triplet.equals("ACT")) {
                result += 'T';
            }
            else if (triplet.equals("GCG") || triplet.equals("GCA")
                    || triplet.equals("GCC") || triplet.equals("GCT")) {
                result += 'A';
            }
            else if (triplet.equals("CGG") || triplet.equals("CGA")
                    || triplet.equals("CGC") || triplet.equals("CGT")) {
                result += 'R';
            }
            else if (triplet.equals("GGG") || triplet.equals("GGA")
                    || triplet.equals("GGC") || triplet.equals("GGT")) {
                result += 'G';
            }
            else if (triplet.equals("TAG") || triplet.equals("TAA")
                    || triplet.equals("TGA")) {
                result += '.';
            }
            else{
                result += 'N';
            }
        }
        return result;
    }
}

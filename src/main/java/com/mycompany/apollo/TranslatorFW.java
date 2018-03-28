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
public class TranslatorFW {


    public static String translate(String triplet) {

        switch (triplet) {
            case "TTT":
            case "TTC":
                return "F";
            case "TTA":
            case "TTG":
            case "CTT":
            case "CTC":
            case "CTA":
            case "CTG":
                return "L";
            case "ATT":
            case "ATC":
            case "ATA":
                return "I";
            case "ATG":
                return "M";
            case "GTT":
            case "GTC":
            case "GTA":
            case "GTG":
                return "V";
            case "TCT":
            case "TCC":
            case "TCA":
            case "TCG":
                return "S";
            case "AGA":
            case "AGG":
                return "R";
            case "AGT":
            case "AGC":
                return "S";
            case "TGG":
                return "W";
            case "TGT":
            case "TGC":
                return "C";
            case "GAA":
            case "GAG":
                return "E";
            case "GAT":
            case "GAC":
                return "D";
            case "AAA":
            case "AAG":
                return "K";
            case "AAT":
            case "AAC":
                return "N";
            case "CAA":
            case "CAG":
                return "Q";
            case "CAT":
            case "CAC":
                return "H";
            case "TAT":
            case "TAC":
                return "Y";
            case "CCG":
            case "CCA":
            case "CCC":
            case "CCT":
                return "P";
            case "ACG":
            case "ACA":
            case "ACC":
            case "ACT":
                return "T";
            case "GCG":
            case "GCA":
            case "GCC":
            case "GCT":
                return "A";
            case "CGG":
            case "CGA":
            case "CGC":
            case "CGT":
                return "R";
            case "GGG":
            case "GGA":
            case "GGC":
            case "GGT":
                return "G";
            case "TAG":
            case "TAA":
            case "TGA":
                return ".";
            default:
                return "N";
        }
        }
    }

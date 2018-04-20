/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apollo;

/**
 *deze class bevat switch cases voor de het vertalen van de reverse sequentie
 * @author Mark
 */
public class TranslatorRE {

    public static String translate(String triplet) {

        switch (triplet) {
            case "TTT":
            case "CTT":
                return "F";
            case "ATT":
            case "GTT":
            case "TTC":
            case "CTC":
            case "ATC":
            case "GTC":
                return "L";
            case "TTA":
            case "CTA":
            case "ATA":
                return "I";
            case "GTA":
                return "M";
            case "TTG":
            case "CTG":
            case "ATG":
            case "GTG":
                return "V";
            case "TCT":
            case "CCT":
            case "ACT":
            case "GCT":
                return "S";
            case "AGA":
            case "GGA":
                return "R";
            case "TGA":
            case "CGA":
                return "S";
            case "GGT":
                return "W";
            case "TGT":
            case "CGT":
                return "C";
            case "AAG":
            case "GAG":
                return "E";
            case "TAG":
            case "CAG":
                return "D";
            case "AAA":
            case "GAA":
                return "K";
            case "TAA":
            case "CAA":
                return "N";
            case "AAC":
            case "GAC":
                return "Q";
            case "TAC":
            case "CAC":
                return "H";
            case "TAT":
            case "CAT":
                return "Y";
            case "GCC":
            case "ACC":
            case "CCC":
            case "TCC":
                return "P";
            case "GCA":
            case "ACA":
            case "CCA":
            case "TCA":
                return "T";
            case "GCG":
            case "ACG":
            case "CCG":
            case "TCG":
                return "A";
            case "GGC":
            case "AGC":
            case "CGC":
            case "TGC":
                return "R";
            case "GGG":
            case "AGG":
            case "CGG":
            case "TGG":
                return "G";
            case "GAT":
            case "AAT":
            case "AGT":
                return ".";
            default:
                return "N";
        }
    }
}

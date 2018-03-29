package com.mycompany.apollo;

/**
 * This class is used to update the  GUI when new information is available.
 * 
 * @author Rogier
 */
public class updateGUI {

    /**
     * @deprecated 
     */
    public void updateReads() {

    }

    /**
     * Updates the ORFInfoPane (second text area in the GUI).
     * It shows general ORF information. It also checks whether the ORF has 
     * blast results and displays them if it does.
     * @param ORFid     The id of the selected ORF in the GUI
     */
    public static void updateORFInfoPane(int ORFid) {
        String updatedText;
        ORF orf = ApolloGUI.ORFs.get(ORFid);
        updatedText = "Reading frame: " + orf.readNr;
        if (orf.blasted) {
            updatedText += "\nE_Value: " + orf.getE_Value();
        } else {
            updatedText += "\nNo blast results yet";
        }
        ApolloGUI.ORFInfoPane.setText(updatedText);
    }
}

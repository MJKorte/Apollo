/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apollo;

import static com.mycompany.apollo.ApolloGUI.dnaSeq;
import java.util.ArrayList;

/**
 *
 * @author rogie
 */
public class ProgressHandler extends Thread {

    @Override
    public void run() {
        ApolloGUI.jProgressBar1.setIndeterminate(true);
        ApolloGUI.jProgressBar1.setString("Loading reading frames");
        ApolloGUI.jProgressBar1.setStringPainted(true);
        ArrayList<String> buildReads = ReadBuilder.buildReads(dnaSeq);
        ApolloGUI.jProgressBar1.setIndeterminate(false);
        ApolloGUI.jProgressBar1.setStringPainted(false);
        ArrayList<String> readsHTML = ORFanalyzer.findORF(buildReads);
        ApolloGUI.sequencePane.setText(
                "<html>\n"
                + "<style type=\"text/css\">\n"
                + "span {\n"
                + "background-color: #f18973;\n"
                + "}\n"
                + "a{\n"
                + "color: black;\n"
                + "text-decoration: none;\n"
                + "}\n"
                + "</style>\n"
                + "<head>\n"
                + "</head>\n"
                + "<body>\n"
                + "<p style=\"margin-top: 0\">"
                + readsHTML.get(0)
                + readsHTML.get(1)
                + readsHTML.get(2)
                + dnaSeq
                + readsHTML.get(3)
                + readsHTML.get(4)
                + readsHTML.get(5) + "</p>"
                + "</body>"
                + "</html>"
        );
        ApolloGUI.sequencePane.setLocation(0, 0);
    }
}

package com.mycompany.apollo;

import static com.mycompany.apollo.ApolloGUI.dnaSeq;
import java.util.ArrayList;

/**
 * Progresshandler keeps track of the file loading process. Building the different
 * reads and translating them can take a while so a progressbar is used
 * to show the progress.
 * 
 * @author rogier
 */
public class ProgressHandler extends Thread {

    @Override
    public void run() {
        ApolloGUI.analyseProgressBar.setIndeterminate(true);
        ApolloGUI.analyseProgressBar.setString("Loading reading frames");
        ApolloGUI.analyseProgressBar.setStringPainted(true);
        ArrayList<String> buildReads = ReadBuilder.buildReads(dnaSeq);
        ApolloGUI.analyseProgressBar.setIndeterminate(false);
        ApolloGUI.analyseProgressBar.setStringPainted(false);
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

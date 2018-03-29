/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apollo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.event.HyperlinkListener;
import javax.swing.event.HyperlinkEvent;

/**
 * ApolloGUI is the main class of this project. It contains generated code for
 * the creating of the GUI. It is also responsible for handling user input by
 * calling methods or communicating with other classes.
 *
 * @author Rogier
 * @version %I%, %G%
 * @since 1.0
 */
public class ApolloGUI extends javax.swing.JFrame {

    /**
     *
     */
    public static String dnaSeq;

    /**
     *
     */
    public static ArrayList<ORF> ORFs = new ArrayList<ORF>();

    /**
     *
     */
    public static int currentORF;
    private boolean donotshowagain = false;
    private JCheckBox checkbox;
    private JPanel blastPopupPanel = new JPanel(new BorderLayout());
    private JTextArea blastPopupText;

    /**
     * This constructor is called when a new ApolloGUI is instantiated from
     * main(). It calls initComponents() which instantiates the components that
     * make up the GUI.
     * <p>
     * This method also prepares a pop-up that is shown when the user starts a
     * blast.
     *
     * @see main
     */
    public ApolloGUI() {
        checkbox = new JCheckBox("Do not show this message again.");
        String message = "Your blast has started!\nFeel free to continue using the application. You will be notified when your blast is complete.";
        blastPopupText = new JTextArea(message);
        blastPopupText.setEditable(false);
        blastPopupText.setBorder(null);
        blastPopupText.setBackground(new Color(UIManager.getColor("RootPane.background").getRGB()));
        blastPopupPanel.add(blastPopupText, BorderLayout.NORTH);
        blastPopupPanel.add(checkbox);

        initComponents();

        sequencePane.addHyperlinkListener(new MenuPaneHyperlinkListener());

    }

    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        progressScreen = new javax.swing.JFrame();
        analyseProgressBar = new javax.swing.JProgressBar();
        analyseButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sequencePane = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ORFInfoPane = new javax.swing.JTextPane();
        blastButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_File = new javax.swing.JMenu();
        menu_Open = new javax.swing.JMenuItem();
        menu_Database = new javax.swing.JMenu();
        menu_Save = new javax.swing.JMenuItem();
        menu_Load = new javax.swing.JMenuItem();

        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setCurrentDirectory(new java.io.File("C:\\Users\\Rogier\\OneDrive\\Documents\\Informatica\\Apollo"));
        fileChooser.setDialogTitle("Open Dialog Title errr");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Fasta files", "fasta"));

        progressScreen.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        progressScreen.setAlwaysOnTop(true);
        progressScreen.setBounds(new java.awt.Rectangle(600, 500, 600, 500));
        progressScreen.setResizable(false);

        analyseButton.setText("Analyse");
        analyseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analyseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout progressScreenLayout = new javax.swing.GroupLayout(progressScreen.getContentPane());
        progressScreen.getContentPane().setLayout(progressScreenLayout);
        progressScreenLayout.setHorizontalGroup(
            progressScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(progressScreenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(analyseProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(progressScreenLayout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(analyseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        progressScreenLayout.setVerticalGroup(
            progressScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(progressScreenLayout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(analyseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(analyseProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        sequencePane.setEditable(false);
        sequencePane.setContentType("text/html"); // NOI18N
        sequencePane.setFont(new java.awt.Font("Courier New", 0, 27)); // NOI18N
        sequencePane.setText("<html>\n\t<style type=\"text/css\">\n\t\tspan {\n\t\t\tbackground-color: #f18973;\n\n\t\t}\n\t\ta{\n\t\t\tcolor: black;\n\t\t\ttext-decoration: none;\n\t\t}\n\t</style>\n\t<head>\n   </head>\n   <body>\n     \t<p style=\"margin-top: 0\">\n\t\t\t<br>\n\t\t\tLoad a file to get started\n\t\t\t<br><br><br><br><br><br><br>\n\t\t</p>\n   \t</body>\n </html>");
        sequencePane.addHyperlinkListener(new javax.swing.event.HyperlinkListener() {
            public void hyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {
                sequencePaneHyperlinkUpdate(evt);
            }
        });
        jScrollPane1.setViewportView(sequencePane);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        ORFInfoPane.setEditable(false);
        ORFInfoPane.setText("Select an ORF to view details");
        jScrollPane2.setViewportView(ORFInfoPane);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
        );

        blastButton.setText("BLAST!");
        blastButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blastButtonActionPerformed(evt);
            }
        });

        menu_File.setText("File");

        menu_Open.setText("Open");
        menu_Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_OpenActionPerformed(evt);
            }
        });
        menu_File.add(menu_Open);

        jMenuBar1.add(menu_File);

        menu_Database.setText("Database");
        menu_Database.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_DatabaseMouseClicked(evt);
            }
        });
        menu_Database.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_DatabaseActionPerformed(evt);
            }
        });

        menu_Save.setText("Save");
        menu_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_SaveActionPerformed(evt);
            }
        });
        menu_Database.add(menu_Save);

        menu_Load.setText("Load");
        menu_Database.add(menu_Load);

        jMenuBar1.add(menu_Database);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1066, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(blastButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(blastButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Below are multiple ActionPerformed methods. These are generated by
     * the Form Editor. They handle user interaction with GUI components.
     * 
     * @param evt is an action event. The action events are automatically
     * sent to the action performed method and contain information about
     * the action event.
     */
    
    private void menu_OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_OpenActionPerformed
        dnaSeq = FileHandler.FileOpener();
        progressScreen.setVisible(true);
    }//GEN-LAST:event_menu_OpenActionPerformed

    private void sequencePaneHyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {//GEN-FIRST:event_sequencePaneHyperlinkUpdate
        System.out.println(evt.getDescription());
    }//GEN-LAST:event_sequencePaneHyperlinkUpdate

    private void analyseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analyseButtonActionPerformed
        ProgressHandler progressHandler = new ProgressHandler();
        progressHandler.start();

    }//GEN-LAST:event_analyseButtonActionPerformed

    private void menu_DatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_DatabaseActionPerformed

    }//GEN-LAST:event_menu_DatabaseActionPerformed


    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked

    }//GEN-LAST:event_jMenu2MouseClicked

    private void menu_DatabaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_DatabaseMouseClicked

    }//GEN-LAST:event_menu_DatabaseMouseClicked


    private void blastButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blastButtonActionPerformed
        Blast blast = new Blast(currentORF);
        blast.start();
        if (!donotshowagain) {
            JOptionPane.showMessageDialog(null, blastPopupPanel);
            donotshowagain = checkbox.isSelected();
        }
    }//GEN-LAST:event_blastButtonActionPerformed

    private void menu_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_SaveActionPerformed
        System.out.println("test");
        DBConnector database = new DBConnector();
        database.dbVuller("ACTGACTG", "dummie", 100, "GAC", 0, 5, 0.5, 7.5, "XX00", "asdfEiwit", "GebakkenEi");
        System.out.println("test2");
    }//GEN-LAST:event_menu_SaveActionPerformed

    /**
     * test
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            HashMap<Object, Object> progressDefaults = new HashMap<>();
            for (Map.Entry<Object, Object> entry : UIManager.getDefaults().entrySet()) {
                if (entry.getKey().getClass() == String.class && ((String) entry.getKey()).startsWith("ProgressBar")) {
                    progressDefaults.put(entry.getKey(), entry.getValue());
                }
            }

            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            for (Map.Entry<Object, Object> entry : progressDefaults.entrySet()) {
                UIManager.getDefaults().put(entry.getKey(), entry.getValue());
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ApolloGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApolloGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApolloGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApolloGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ApolloGUI().setVisible(true);
            }
        }
        );
    }

    /**
     *
     * @return dnaSeq   Other classes can call this getter to get the
     * current DNA sequence.
     */
    public static String getDnaSeq() {
        return dnaSeq;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextPane ORFInfoPane;
    private javax.swing.JButton analyseButton;
    public static javax.swing.JProgressBar analyseProgressBar;
    public static javax.swing.JButton blastButton;
    public static javax.swing.JFileChooser fileChooser;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenu menu_Database;
    private javax.swing.JMenu menu_File;
    private javax.swing.JMenuItem menu_Load;
    private javax.swing.JMenuItem menu_Open;
    private javax.swing.JMenuItem menu_Save;
    public static javax.swing.JFrame progressScreen;
    public static javax.swing.JTextPane sequencePane;
    // End of variables declaration//GEN-END:variables
}

class MenuPaneHyperlinkListener implements HyperlinkListener {

    @Override
    public void hyperlinkUpdate(HyperlinkEvent e) {
        if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            System.out.println("clicked: " + e.getDescription());
            ApolloGUI.currentORF = Integer.parseInt(e.getDescription());
            updateGUI.updateORFInfoPane(Integer.valueOf(e.getDescription()));
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 *
 * @author jessica.sobreviela
 */
public class VistaParecidos extends javax.swing.JFrame {

    private static String autor;
    private static String titulo;
    private static int k;
    private static String type;
    private static JList lista;
    static DefaultListModel model;
    private Map<String, ArrayList<String>> parecidos;
    public static CtrlPresentacio cp;

    /**
     * Creates new form VistaParecidos
     * @param cp
     * @param autor
     * @param titulo
     * @throws java.io.IOException
     */
    public VistaParecidos(CtrlPresentacio cp, String autor, String titulo) throws IOException{
        VistaParecidos.autor = autor;
        VistaParecidos.titulo = titulo;
        model = new DefaultListModel();
        VistaParecidos.lista = new JList(model);
        VistaParecidos.cp = cp;
        initComponents();
        ButtonGroup group = new ButtonGroup();
        group.add(FREC);
        group.add(TFIDF);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        textoNumDocs = new javax.swing.JLabel();
        textoResult = new javax.swing.JLabel();
        Consultar = new javax.swing.JButton();
        Aceptar = new javax.swing.JButton();
        scrollPaneResult = new JScrollPane(lista);
        textoBusqueda = new javax.swing.JLabel();
        FREC = new javax.swing.JRadioButton();
        TFIDF = new javax.swing.JRadioButton();
        textFieldNumDocs = new java.awt.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("\"k\" documentos más parecidos");
        setPreferredSize(new java.awt.Dimension(600, 500));
        getContentPane().setLayout(null);

        textoNumDocs.setText("Número de documentos:");
        getContentPane().add(textoNumDocs);
        textoNumDocs.setBounds(50, 61, 173, 17);

        textoResult.setText("Resultado:");
        getContentPane().add(textoResult);
        textoResult.setBounds(68, 207, 73, 17);

        Consultar.setText("Consultar");
        Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarActionPerformed(evt);
            }
        });
        getContentPane().add(Consultar);
        Consultar.setBounds(321, 170, 100, 29);

        Aceptar.setText("Aceptar");
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });
        getContentPane().add(Aceptar);
        Aceptar.setBounds(510, 400, 67, 29);
        getContentPane().add(scrollPaneResult);
        scrollPaneResult.setBounds(141, 228, 430, 150);

        textoBusqueda.setText("Método de búsqueda :");
        getContentPane().add(textoBusqueda);
        textoBusqueda.setBounds(50, 103, 155, 17);

        FREC.setText("Frecuencias");
        FREC.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                FRECComponentAdded(evt);
            }
        });
        FREC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FRECActionPerformed(evt);
            }
        });
        getContentPane().add(FREC);
        FREC.setBounds(217, 100, 110, 24);

        TFIDF.setText("Tf-Idf");
        TFIDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFIDFActionPerformed(evt);
            }
        });
        getContentPane().add(TFIDF);
        TFIDF.setBounds(217, 129, 65, 24);

        textFieldNumDocs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNumDocsActionPerformed(evt);
            }
        });
        getContentPane().add(textFieldNumDocs);
        textFieldNumDocs.setBounds(250, 59, 130, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarActionPerformed
        // TODO add your handling code here:
        textFieldNumDocsActionPerformed(evt);
        if (FREC.isSelected()) try {
            parecidos = cp.consultarParecidos(autor, titulo, k, "FREC");
        } catch (Exception ex) {
            Logger.getLogger(VistaParecidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        else try {
            parecidos = cp.consultarParecidos(autor, titulo, k, "TF-IDF");
        } catch (Exception ex) {
            Logger.getLogger(VistaParecidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (String autorParecido: parecidos.keySet()) {
            for (int i = 0; i < parecidos.get(autorParecido).size(); i++)
                model.addElement("Autor: "+autorParecido+". Título: "+ parecidos.get(autorParecido).get(i)+".");
        }        
    }//GEN-LAST:event_ConsultarActionPerformed

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_AceptarActionPerformed

    private void TFIDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFIDFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFIDFActionPerformed

    private void FRECActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FRECActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FRECActionPerformed

    private void FRECComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_FRECComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_FRECComponentAdded

    private void textFieldNumDocsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNumDocsActionPerformed
        // TODO add your handling code here:
        k = Integer.parseInt(textFieldNumDocs.getText());
    }//GEN-LAST:event_textFieldNumDocsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaParecidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaParecidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaParecidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaParecidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VistaParecidos(cp,autor,titulo).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(VistaParecidos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JButton Consultar;
    private javax.swing.JRadioButton FREC;
    private javax.swing.JRadioButton TFIDF;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JScrollPane scrollPaneResult;
    private java.awt.TextField textFieldNumDocs;
    private javax.swing.JLabel textoBusqueda;
    private javax.swing.JLabel textoNumDocs;
    private javax.swing.JLabel textoResult;
    // End of variables declaration//GEN-END:variables
}

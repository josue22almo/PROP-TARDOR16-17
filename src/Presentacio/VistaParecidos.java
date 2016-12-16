/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio;

import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author florencia.rimolo
 */
public class VistaParecidos extends javax.swing.JFrame {
    
    static String autor;
    static String titulo;
    private static int k;
    private static String type;
    private static JList lista;
    static DefaultListModel model;
    private ArrayList<String> parecidos;
    public static CtrlPresentacio cp;
    
    /**
     * Creates new form VistaParecidos
     * @param cp
     * @param autor
     * @param titulo
     * @throws java.io.IOException
     */
    public VistaParecidos(CtrlPresentacio cp, String autor, String titulo) {
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
        numk = new javax.swing.JLabel();
        labelMetodo = new javax.swing.JLabel();
        botonConsultar = new javax.swing.JButton();
        botonAceptar = new javax.swing.JButton();
        labelResultado = new javax.swing.JLabel();
        FREC = new javax.swing.JRadioButton();
        TFIDF = new javax.swing.JRadioButton();
        textFieldNumDocs = new javax.swing.JTextField();
        scrollPaneResult = new JScrollPane(lista);
        botonCancelar = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setTitle("Consultar parecidos");
        setMinimumSize(new java.awt.Dimension(750, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        numk.setText("Cantidad de documentos requeridos:");
        getContentPane().add(numk);
        numk.setBounds(49, 51, 257, 17);

        labelMetodo.setText("Método:");
        getContentPane().add(labelMetodo);
        labelMetodo.setBounds(49, 89, 59, 17);

        botonConsultar.setBackground(new java.awt.Color(174, 178, 194));
        botonConsultar.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        botonConsultar.setForeground(new java.awt.Color(0, 0, 0));
        botonConsultar.setText("Consultar");
        botonConsultar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(174, 178, 194), 1, true));
        botonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultarActionPerformed(evt);
            }
        });
        getContentPane().add(botonConsultar);
        botonConsultar.setBounds(400, 160, 120, 22);

        botonAceptar.setBackground(new java.awt.Color(174, 178, 194));
        botonAceptar.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        botonAceptar.setForeground(new java.awt.Color(0, 0, 0));
        botonAceptar.setText("Aceptar");
        botonAceptar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(174, 178, 194), 1, true));
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(botonAceptar);
        botonAceptar.setBounds(450, 550, 100, 22);

        labelResultado.setText("Resultado:");
        getContentPane().add(labelResultado);
        labelResultado.setBounds(49, 187, 110, 17);

        FREC.setText("Frecuencias");
        FREC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FRECActionPerformed(evt);
            }
        });
        getContentPane().add(FREC);
        FREC.setBounds(134, 86, 110, 23);

        TFIDF.setText("TF-IDF");
        TFIDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFIDFActionPerformed(evt);
            }
        });
        getContentPane().add(TFIDF);
        TFIDF.setBounds(134, 122, 71, 23);

        textFieldNumDocs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNumDocsActionPerformed(evt);
            }
        });
        getContentPane().add(textFieldNumDocs);
        textFieldNumDocs.setBounds(350, 40, 80, 29);
        getContentPane().add(scrollPaneResult);
        scrollPaneResult.setBounds(50, 230, 650, 240);

        botonCancelar.setBackground(new java.awt.Color(174, 178, 194));
        botonCancelar.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        botonCancelar.setForeground(new java.awt.Color(0, 0, 0));
        botonCancelar.setText("Cancelar");
        botonCancelar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(174, 178, 194), 1, true));
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(botonCancelar);
        botonCancelar.setBounds(590, 550, 110, 22);

        fondo.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("url:http://www.celer-comex.com.ar/images/fondo.jpg")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        fondo.setPreferredSize(new java.awt.Dimension(750, 600));
        getContentPane().add(fondo);
        fondo.setBounds(0, 0, 750, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultarActionPerformed
        // TODO add your handling code here:
        textFieldNumDocsActionPerformed(evt);
        model.clear();
        if (FREC.isSelected()) try {
            parecidos = cp.consultarParecidos(autor, titulo, k, "FREC");
        } catch (Exception ex) {
            String excepcion = "No hay ningún documento que cumpla los requisitos especificados..";
            JOptionPane.showMessageDialog(rootPane,excepcion); 
        }
        else try {
            parecidos = cp.consultarParecidos(autor, titulo, k, "TF-IDF");
        } catch (Exception ex) {
            String excepcion = "No hay ningún documento que cumpla los requisitos especificados..";
            JOptionPane.showMessageDialog(rootPane,excepcion); 
        }
        for (int i = 0; i < parecidos.size(); i++)
            model.addElement(parecidos.get(i));
    }//GEN-LAST:event_botonConsultarActionPerformed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void FRECActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FRECActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FRECActionPerformed

    private void TFIDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFIDFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFIDFActionPerformed

    private void textFieldNumDocsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNumDocsActionPerformed
        // TODO add your handling code here:
        k = Integer.parseInt(textFieldNumDocs.getText());
    }//GEN-LAST:event_textFieldNumDocsActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_botonCancelarActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaParecidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaParecidos(cp,autor,titulo).setVisible(true);
                model.addElement("hola");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton FREC;
    private javax.swing.JRadioButton TFIDF;
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonConsultar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel labelMetodo;
    private javax.swing.JLabel labelResultado;
    private javax.swing.JLabel numk;
    private javax.swing.JScrollPane scrollPaneResult;
    private javax.swing.JTextField textFieldNumDocs;
    // End of variables declaration//GEN-END:variables
}

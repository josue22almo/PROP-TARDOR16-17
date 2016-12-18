/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jessica.sobreviela
 */
public class VistaExprBooleana extends javax.swing.JFrame {
    
    public static CtrlPresentacio cp;
    private String listaDocumentos;
    private String expresion;
    private  ArrayList<String> documentos;
    
    /**
     * Creates new form VistaExprBooleana
     * @param cp
     */
    public VistaExprBooleana(CtrlPresentacio cp) {
        initComponents();
        VistaExprBooleana.cp = cp;
        this.documentos = new ArrayList<>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelExpresion = new javax.swing.JLabel();
        botonAceptar = new javax.swing.JButton();
        botonConsultar = new javax.swing.JButton();
        labelResultado = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        botonCancelar = new javax.swing.JButton();
        textFieldExp = new javax.swing.JTextField();
        fondo = new javax.swing.JLabel();

        setTitle("Expresión booleana");
        setMinimumSize(new java.awt.Dimension(700, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        labelExpresion.setBackground(new java.awt.Color(255, 255, 255));
        labelExpresion.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        labelExpresion.setForeground(new java.awt.Color(255, 255, 255));
        labelExpresion.setText("Expresión:");
        getContentPane().add(labelExpresion);
        labelExpresion.setBounds(34, 52, 100, 18);

        botonAceptar.setBackground(new java.awt.Color(174, 178, 194));
        botonAceptar.setForeground(new java.awt.Color(0, 0, 0));
        botonAceptar.setText("Aceptar");
        botonAceptar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(174, 178, 194), 1, true));
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(botonAceptar);
        botonAceptar.setBounds(460, 510, 100, 30);

        botonConsultar.setBackground(new java.awt.Color(174, 178, 194));
        botonConsultar.setForeground(new java.awt.Color(0, 0, 0));
        botonConsultar.setText("Consultar");
        botonConsultar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(174, 178, 194), 1, true));
        botonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultarActionPerformed(evt);
            }
        });
        getContentPane().add(botonConsultar);
        botonConsultar.setBounds(560, 50, 110, 30);

        labelResultado.setBackground(new java.awt.Color(255, 255, 255));
        labelResultado.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        labelResultado.setForeground(new java.awt.Color(255, 255, 255));
        labelResultado.setText("Resultado:");
        getContentPane().add(labelResultado);
        labelResultado.setBounds(34, 132, 100, 18);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(131, 139, 540, 330);

        botonCancelar.setBackground(new java.awt.Color(174, 178, 194));
        botonCancelar.setForeground(new java.awt.Color(0, 0, 0));
        botonCancelar.setText("Cancelar");
        botonCancelar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(174, 178, 194), 1, true));
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(botonCancelar);
        botonCancelar.setBounds(580, 510, 90, 30);

        textFieldExp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldExpActionPerformed(evt);
            }
        });
        getContentPane().add(textFieldExp);
        textFieldExp.setBounds(120, 49, 420, 30);

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
        getContentPane().add(fondo);
        fondo.setBounds(-40, 0, 3000, 1579);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void botonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultarActionPerformed
        // TODO add your handling code here:
        textFieldExpActionPerformed(evt);
        try {
            if (expresion == null) expresion = "";
            documentos = cp.consultarDocumentosExprBooleana(expresion);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane,ex);
        }
        for (int i=0; i<documentos.size(); i++) listaDocumentos+=(documentos.get(i));
        jTextArea1.setText(listaDocumentos);
    }//GEN-LAST:event_botonConsultarActionPerformed

    private void textFieldExpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldExpActionPerformed
        // TODO add your handling code here:
        this.expresion = textFieldExp.getText();
    }//GEN-LAST:event_textFieldExpActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaExprBooleana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaExprBooleana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaExprBooleana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaExprBooleana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VistaExprBooleana(cp).setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(VistaExprBooleana.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonConsultar;
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel labelExpresion;
    private javax.swing.JLabel labelResultado;
    private javax.swing.JTextField textFieldExp;
    // End of variables declaration//GEN-END:variables
}

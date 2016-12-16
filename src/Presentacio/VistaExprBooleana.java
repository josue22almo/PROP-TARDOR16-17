/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio;

import java.io.IOException;
import java.util.TreeMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author jessica.sobreviela
 */
public class VistaExprBooleana extends javax.swing.JFrame {
    
    private static CtrlPresentacio cp;
    private static String listaDocumentos;
    private static String expresion;
    private static Map< String, String> documentos;
    
    /**
     * Creates new form VistaExprBooleana
     * @param cp
     * @throws java.io.IOException
     */
    public VistaExprBooleana(CtrlPresentacio cp) throws Exception {
        initComponents();
        VistaExprBooleana.cp = cp;
        VistaExprBooleana.documentos = new TreeMap<>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelExpresion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoExpresion = new javax.swing.JTextPane();
        Aceptar = new javax.swing.JButton();
        Consultar = new javax.swing.JButton();
        Resultado = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        LabelExpresion.setBackground(new java.awt.Color(255, 255, 255));
        LabelExpresion.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        LabelExpresion.setForeground(new java.awt.Color(255, 255, 255));
        LabelExpresion.setText("Expresión:");
        getContentPane().add(LabelExpresion);
        LabelExpresion.setBounds(34, 52, 100, 18);

        jScrollPane1.setViewportView(textoExpresion);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(171, 48, 350, 30);

        Aceptar.setText("Aceptar");
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });
        getContentPane().add(Aceptar);
        Aceptar.setBounds(560, 510, 100, 25);

        Consultar.setText("Consultar");
        Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarActionPerformed(evt);
            }
        });
        getContentPane().add(Consultar);
        Consultar.setBounds(540, 50, 110, 25);

        Resultado.setBackground(new java.awt.Color(255, 255, 255));
        Resultado.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        Resultado.setForeground(new java.awt.Color(255, 255, 255));
        Resultado.setText("Resultado:");
        getContentPane().add(Resultado);
        Resultado.setBounds(34, 132, 100, 18);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(171, 139, 500, 330);

        jLabel1.setIcon(new javax.swing.JLabel() {
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
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-40, 0, 3000, 1579);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_AceptarActionPerformed

    private void ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarActionPerformed
        // TODO add your handling code here:
        VistaExprBooleana.expresion = textoExpresion.getText();
        
        try {
            if (expresion == null) expresion = "";
            documentos = cp.consultarDocumentosExprBooleana(expresion);
        } catch (Exception ex) {
            String excepcion = "La búsqueda no ha producido resultados.";
            JOptionPane.showMessageDialog(rootPane,excepcion);
        }
        for (String autor : documentos.keySet()) {
            String titulo = documentos.get(autor);
            listaDocumentos+=(titulo + ", " + autor + "\n");
        }
        jTextArea1.setText(listaDocumentos);
    }//GEN-LAST:event_ConsultarActionPerformed

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
    private javax.swing.JButton Aceptar;
    private javax.swing.JButton Consultar;
    private javax.swing.JLabel LabelExpresion;
    private javax.swing.JLabel Resultado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextPane textoExpresion;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author florencia.rimolo
 */
public class VistaModificarContenido extends javax.swing.JFrame {
    private static String a;
    private static String t;
    private static String c;
    private static CtrlPresentacio cp;
    private static String nuevo_contenido;
    /**
     * Creates new form VistaModificarContenido
     * @param cp
     * @param autor
     * @param titulo
     * @param contenido
     */
    public VistaModificarContenido(CtrlPresentacio cp, String autor, String titulo, String contenido) {
        VistaModificarContenido.a=autor;
        VistaModificarContenido.t=titulo;
        VistaModificarContenido.c=contenido;
        VistaModificarContenido.cp = cp;
        initComponents();
        textoContenido.setText("hola");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aceptar = new javax.swing.JButton();
        contenido = new javax.swing.JLabel();
        nuevocontenido = new javax.swing.JLabel();
        jScrollPane1 = new JScrollPane(textoContenido);
        textoContenido = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        textoNuevoContenido = new javax.swing.JTextPane();
        cancelar = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(618, 570));
        getContentPane().setLayout(null);

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        getContentPane().add(aceptar);
        aceptar.setBounds(405, 527, 67, 29);

        contenido.setBackground(new java.awt.Color(14, 115, 161));
        contenido.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        contenido.setForeground(new java.awt.Color(255, 255, 255));
        contenido.setText("Contenido:");
        getContentPane().add(contenido);
        contenido.setBounds(33, 37, 90, 18);

        nuevocontenido.setBackground(new java.awt.Color(14, 115, 161));
        nuevocontenido.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        nuevocontenido.setForeground(new java.awt.Color(255, 255, 255));
        nuevocontenido.setText("Nuevo contenido:");
        getContentPane().add(nuevocontenido);
        nuevocontenido.setBounds(33, 283, 140, 18);

        textoContenido.setEditable(false);
        jScrollPane1.setViewportView(textoContenido);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(33, 72, 544, 193);

        jScrollPane2.setViewportView(textoNuevoContenido);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(33, 318, 544, 192);

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(cancelar);
        cancelar.setBounds(492, 527, 74, 29);

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
        fondo.setBounds(0, 0, 620, 570);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        // TODO add your handling code here:
        VistaModificarContenido.nuevo_contenido = contenido.getText();
        if (nuevo_contenido != null && !nuevo_contenido.isEmpty()) try {
            cp.modificarContenido(a,t,nuevo_contenido);
            this.setVisible(false);
        } catch (IOException ex) {
            String excepcion = "Escriba un contenido.";
            JOptionPane.showMessageDialog(rootPane,excepcion);
            Logger.getLogger(VistaModificarAutor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_aceptarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_cancelarActionPerformed

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
            java.util.logging.Logger.getLogger(VistaModificarContenido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaModificarContenido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaModificarContenido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaModificarContenido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaModificarContenido(cp, a, t, c).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel contenido;
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nuevocontenido;
    private javax.swing.JTextPane textoContenido;
    private javax.swing.JTextPane textoNuevoContenido;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author jessica.sobreviela
 */
public class VistaModificarTitulo extends javax.swing.JFrame {
    private static String a;
    private static String t;
    public static CtrlPresentacio cp;
    private static String nuevo_titulo;
    public static Vista vista;
    /**
     * Creates new form VistaModificarTitulo
     * @param vista
     * @param cp
     * @param autor
     * @param titulo
     */
    public VistaModificarTitulo(Vista vista,CtrlPresentacio cp, String autor, String titulo) {
        VistaModificarTitulo.a=autor;
        VistaModificarTitulo.t=titulo;
        VistaModificarTitulo.cp = cp;
        VistaModificarTitulo.vista = vista;
        initComponents();
        textoTitulo.setText(titulo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        cancelar = new javax.swing.JButton();
        nuevotitulo = new javax.swing.JLabel();
        aceptar = new javax.swing.JButton();
        textoNuevoTitulo = new javax.swing.JTextField();
        textoTitulo = new javax.swing.JTextField();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(493, 240));
        setResizable(false);
        getContentPane().setLayout(null);

        titulo.setBackground(new java.awt.Color(11, 116, 163));
        titulo.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText("Título:");
        getContentPane().add(titulo);
        titulo.setBounds(41, 49, 60, 20);

        cancelar.setBackground(new java.awt.Color(174, 178, 194));
        cancelar.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        cancelar.setForeground(new java.awt.Color(0, 0, 0));
        cancelar.setText("Cancelar");
        cancelar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(174, 178, 194), 1, true));
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(cancelar);
        cancelar.setBounds(340, 190, 111, 30);

        nuevotitulo.setBackground(new java.awt.Color(11, 116, 163));
        nuevotitulo.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        nuevotitulo.setForeground(new java.awt.Color(255, 255, 255));
        nuevotitulo.setText("Nuevo Título:");
        getContentPane().add(nuevotitulo);
        nuevotitulo.setBounds(41, 131, 110, 20);

        aceptar.setBackground(new java.awt.Color(174, 178, 194));
        aceptar.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        aceptar.setForeground(new java.awt.Color(0, 0, 0));
        aceptar.setText("Aceptar");
        aceptar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(174, 178, 194), 1, true));
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        getContentPane().add(aceptar);
        aceptar.setBounds(200, 190, 110, 30);

        textoNuevoTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoNuevoTituloActionPerformed(evt);
            }
        });
        getContentPane().add(textoNuevoTitulo);
        textoNuevoTitulo.setBounds(169, 129, 282, 29);

        textoTitulo.setEditable(false);
        textoTitulo.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        getContentPane().add(textoTitulo);
        textoTitulo.setBounds(169, 45, 282, 32);

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
        fondo.setBounds(0, 0, 493, 240);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_cancelarActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        // TODO add your handling code here:
        try{ 
            textoNuevoTituloActionPerformed(evt);
            if (nuevo_titulo != null && !nuevo_titulo.isEmpty()){
                cp.modificarTitulo(a,t,nuevo_titulo);
                String exito = "Modificación realizada con éxito.";
                JOptionPane.showMessageDialog(rootPane,exito);
                this.setVisible(false);
                vista.limpiarTitulos();
            }
            else {
                String excepcion = "Escriba un título.";
                JOptionPane.showMessageDialog(rootPane,excepcion);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane,ex);
        }
    }//GEN-LAST:event_aceptarActionPerformed

    private void textoNuevoTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoNuevoTituloActionPerformed
        // TODO add your handling code here:
        VistaModificarTitulo.nuevo_titulo = textoNuevoTitulo.getText();
    }//GEN-LAST:event_textoNuevoTituloActionPerformed

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
            java.util.logging.Logger.getLogger(VistaModificarTitulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaModificarTitulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaModificarTitulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaModificarTitulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaModificarTitulo(vista,cp, a, t).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel nuevotitulo;
    private javax.swing.JTextField textoNuevoTitulo;
    private javax.swing.JTextField textoTitulo;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}

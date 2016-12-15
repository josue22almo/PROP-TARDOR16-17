/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jessica.sobreviela
 */
public class VistaModificar extends javax.swing.JFrame {
    
    private static String autor;
    private static String titulo;
    private static CtrlPresentacio cp;
    
    /**
     * Creates new form VistaModificar
     * @param cp
     * @param autor
     * @param titulo
     */
    public VistaModificar(CtrlPresentacio cp, String autor, String titulo) {
        initComponents();
        VistaParecidos.autor = autor;
        VistaParecidos.titulo = titulo;
        VistaParecidos.cp = cp;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Autor = new javax.swing.JLabel();
        Aceptar = new javax.swing.JButton();
        Titulo = new javax.swing.JLabel();
        Contenido = new javax.swing.JLabel();
        textFieldAutor = new javax.swing.JTextField();
        textFieldTitulo = new javax.swing.JTextField();
        textFieldContenido = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(750, 600));
        setPreferredSize(new java.awt.Dimension(750, 600));
        getContentPane().setLayout(null);

        Autor.setText("Nuevo Autor (opcional) :");
        getContentPane().add(Autor);
        Autor.setBounds(51, 49, 166, 17);

        Aceptar.setText("Aceptar");
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });
        getContentPane().add(Aceptar);
        Aceptar.setBounds(559, 470, 90, 31);

        Titulo.setText("Nuevo Título (opcional) :");
        getContentPane().add(Titulo);
        Titulo.setBounds(51, 97, 167, 17);

        Contenido.setText("Nuevo Contenido (opcional) :");
        getContentPane().add(Contenido);
        Contenido.setBounds(51, 140, 200, 17);

        textFieldAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldAutorActionPerformed(evt);
            }
        });
        getContentPane().add(textFieldAutor);
        textFieldAutor.setBounds(250, 39, 220, 40);
        getContentPane().add(textFieldTitulo);
        textFieldTitulo.setBounds(250, 90, 220, 40);

        textFieldContenido.setToolTipText("");
        getContentPane().add(textFieldContenido);
        textFieldContenido.setBounds(50, 170, 430, 180);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        try {
            // TODO add your handling code here:
            String nuevo_autor = textFieldAutor.getText();
            String nuevo_titulo = ModTitulo.getText();
            String nuevo_contenido = ModContenido.getText();
            if (!nuevo_autor.isEmpty()) cp.modificarAutor(autor,titulo,nuevo_autor);
            if (!nuevo_titulo.isEmpty()) cp.modificarTitulo(autor,titulo,nuevo_titulo);
            if (!nuevo_contenido.isEmpty()) cp.modificarContenido(autor,titulo,nuevo_contenido);
            this.setVisible(false);
        } catch (Exception ex) {
            Logger.getLogger(VistaModificar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AceptarActionPerformed

    private void textFieldAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldAutorActionPerformed

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
            java.util.logging.Logger.getLogger(VistaModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaModificar(cp,autor,titulo).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JLabel Autor;
    private javax.swing.JLabel Contenido;
    private javax.swing.JLabel Titulo;
    private javax.swing.JTextField textFieldAutor;
    private javax.swing.JTextField textFieldContenido;
    private javax.swing.JTextField textFieldTitulo;
    // End of variables declaration//GEN-END:variables
}
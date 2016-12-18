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

/**
 *
 * @author jessica.sobreviela
 */
public class VistaModificarAutor extends javax.swing.JFrame {
    private static String a;
    private static String t;
    private static CtrlPresentacio cp;
    private static String nuevo_autor;
    public static Vista vista;
    /**
     * Creates new form VistaModificarAutor
     * @param cp
     * @param autor
     * @param titulo
     */
    public VistaModificarAutor(Vista vista, CtrlPresentacio cp, String autor, String titulo) {
        VistaModificarAutor.a=autor;
        VistaModificarAutor.t=titulo;
        VistaModificarAutor.cp = cp;
        VistaModificarAutor.vista = vista;
        initComponents();
        textFieldAutor.setText(autor);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        autor = new javax.swing.JLabel();
        nuevoAutor = new javax.swing.JLabel();
        cancelar = new javax.swing.JButton();
        aceptar = new javax.swing.JButton();
        textFieldAutor = new javax.swing.JTextField();
        textFieldNuevoAutor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(500, 350));
        setResizable(false);
        getContentPane().setLayout(null);

        autor.setText("Autor:");
        getContentPane().add(autor);
        autor.setBounds(40, 70, 70, 17);

        nuevoAutor.setText("Nuevo autor:");
        getContentPane().add(nuevoAutor);
        nuevoAutor.setBounds(40, 140, 120, 17);

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(cancelar);
        cancelar.setBounds(350, 280, 110, 29);

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        getContentPane().add(aceptar);
        aceptar.setBounds(240, 280, 90, 29);

        textFieldAutor.setEditable(false);
        getContentPane().add(textFieldAutor);
        textFieldAutor.setBounds(150, 60, 300, 27);

        textFieldNuevoAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNuevoAutorActionPerformed(evt);
            }
        });
        getContentPane().add(textFieldNuevoAutor);
        textFieldNuevoAutor.setBounds(150, 130, 300, 27);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 500, 350);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_cancelarActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        // TODO add your handling code here: 
        try{ 
            textFieldNuevoAutorActionPerformed(evt);
            if (nuevo_autor != null && !nuevo_autor.isEmpty()){
                cp.modificarAutor(a,t,nuevo_autor);
                String excepcion = "Modificación realizada con éxito.";
                JOptionPane.showMessageDialog(rootPane,excepcion);
                this.setVisible(false);
                vista.actualizarAutores();
            }
            else {
                String excepcion = "Escriba un autor.";
                JOptionPane.showMessageDialog(rootPane,excepcion);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane,ex);
        }
    }//GEN-LAST:event_aceptarActionPerformed

    private void textFieldNuevoAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNuevoAutorActionPerformed
        VistaModificarAutor.nuevo_autor = textFieldNuevoAutor.getText();
    }//GEN-LAST:event_textFieldNuevoAutorActionPerformed

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
            java.util.logging.Logger.getLogger(VistaModificarAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaModificarAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaModificarAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaModificarAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaModificarAutor(vista,cp, a, t).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JLabel autor;
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel nuevoAutor;
    private javax.swing.JTextField textFieldAutor;
    private javax.swing.JTextField textFieldNuevoAutor;
    // End of variables declaration//GEN-END:variables
}

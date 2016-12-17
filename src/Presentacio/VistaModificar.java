/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jessica.sobreviela
 */
public class VistaModificar extends javax.swing.JFrame {
    
    private static String autor;
    private static String titulo;
    private String nuevo_autor;
    private String nuevo_titulo;
    private String nuevo_contenido;
    private static CtrlPresentacio cp;
    
    /**
     * Creates new form VistaModificar
     * @param cp
     * @param autor
     * @param titulo
     */
    public VistaModificar(CtrlPresentacio cp, String autor, String titulo) {
        initComponents();
        VistaModificar.autor = autor;
        VistaModificar.titulo = titulo;
        VistaModificar.cp = cp;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelAutor = new javax.swing.JLabel();
        botonAceptar = new javax.swing.JButton();
        labelTitulo = new javax.swing.JLabel();
        labelContenido = new javax.swing.JLabel();
        textFieldAutor = new javax.swing.JTextField();
        textFieldTitulo = new javax.swing.JTextField();
        textFieldContenido = new javax.swing.JTextField();
        botonCancelar = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setTitle("Modificar documento");
        setMinimumSize(new java.awt.Dimension(750, 600));
        setPreferredSize(new java.awt.Dimension(750, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        labelAutor.setBackground(new java.awt.Color(11, 116, 163));
        labelAutor.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        labelAutor.setForeground(new java.awt.Color(255, 255, 255));
        labelAutor.setText("Nuevo Autor (opcional) :");
        getContentPane().add(labelAutor);
        labelAutor.setBounds(51, 49, 177, 18);

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
        botonAceptar.setBounds(460, 535, 110, 30);

        labelTitulo.setBackground(new java.awt.Color(11, 116, 163));
        labelTitulo.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        labelTitulo.setText("Nuevo Título (opcional) :");
        getContentPane().add(labelTitulo);
        labelTitulo.setBounds(50, 100, 176, 18);

        labelContenido.setBackground(new java.awt.Color(11, 116, 163));
        labelContenido.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        labelContenido.setForeground(new java.awt.Color(255, 255, 255));
        labelContenido.setText("Nuevo Contenido (opcional) :");
        getContentPane().add(labelContenido);
        labelContenido.setBounds(51, 140, 230, 18);

        textFieldAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldAutorActionPerformed(evt);
            }
        });
        getContentPane().add(textFieldAutor);
        textFieldAutor.setBounds(250, 40, 220, 30);

        textFieldTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldTituloActionPerformed(evt);
            }
        });
        getContentPane().add(textFieldTitulo);
        textFieldTitulo.setBounds(250, 90, 220, 30);

        textFieldContenido.setToolTipText("");
        textFieldContenido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldContenidoActionPerformed(evt);
            }
        });
        getContentPane().add(textFieldContenido);
        textFieldContenido.setBounds(50, 170, 650, 350);

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
        botonCancelar.setBounds(590, 535, 110, 30);

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
        fondo.setBounds(0, 0, 780, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
            textFieldAutorActionPerformed(evt);
            textFieldTituloActionPerformed(evt);
            textFieldContenidoActionPerformed(evt);        
        try {
            // TODO add your handling code here:
            if (nuevo_autor != null && !nuevo_autor.isEmpty()) cp.modificarAutor(autor,titulo,nuevo_autor);
            if (nuevo_titulo != null && !nuevo_titulo.isEmpty()) cp.modificarTitulo(autor,titulo,nuevo_titulo);
            if (nuevo_contenido != null && !nuevo_contenido.isEmpty()) {
                cp.modificarContenido(autor,titulo,nuevo_contenido);
                System.out.println("no null");
                System.out.println(autor);
                System.out.println(titulo);
            }
            this.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(VistaModificar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void textFieldAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldAutorActionPerformed
        // TODO add your handling code here:
        this.nuevo_autor = textFieldAutor.getText();
    }//GEN-LAST:event_textFieldAutorActionPerformed

    private void textFieldTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldTituloActionPerformed
        // TODO add your handling code here:
        this.nuevo_titulo = textFieldTitulo.getText();
    }//GEN-LAST:event_textFieldTituloActionPerformed

    private void textFieldContenidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldContenidoActionPerformed
        // TODO add your handling code here:
        this.nuevo_contenido = textFieldContenido.getText();
    }//GEN-LAST:event_textFieldContenidoActionPerformed

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
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel labelAutor;
    private javax.swing.JLabel labelContenido;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JTextField textFieldAutor;
    private javax.swing.JTextField textFieldContenido;
    private javax.swing.JTextField textFieldTitulo;
    // End of variables declaration//GEN-END:variables
}

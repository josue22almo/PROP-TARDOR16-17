/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio;

import javax.swing.JOptionPane;

/**
 *
 * @author florencia.rimolo+
 */
public class VistaAñadirManualmente extends javax.swing.JFrame {
    public static Vista vista;
    public static CtrlPresentacio cp;
    private String autor;
    private String titulo;
    private String contenido;
    /**
     * Creates new form VistaAñadirManualmente
     * @param vista
     * @param cp
     */
    public VistaAñadirManualmente(Vista vista, CtrlPresentacio cp) {
        initComponents();
        VistaAñadirManualmente.vista = vista;
        VistaAñadirManualmente.cp = cp;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textFieldAutor = new javax.swing.JTextField();
        labelAutor = new javax.swing.JLabel();
        textFieldTitulo = new javax.swing.JTextField();
        labelTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textPaneContenido = new javax.swing.JTextPane();
        labelContenido = new javax.swing.JLabel();
        botonAceptar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setTitle("Añadir documento manualmente");
        setMinimumSize(new java.awt.Dimension(793, 538));
        setResizable(false);
        getContentPane().setLayout(null);

        textFieldAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldAutorActionPerformed(evt);
            }
        });
        getContentPane().add(textFieldAutor);
        textFieldAutor.setBounds(220, 50, 500, 27);

        labelAutor.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        labelAutor.setForeground(new java.awt.Color(255, 255, 255));
        labelAutor.setText("Introduzca autor:");
        getContentPane().add(labelAutor);
        labelAutor.setBounds(40, 50, 170, 30);

        textFieldTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldTituloActionPerformed(evt);
            }
        });
        getContentPane().add(textFieldTitulo);
        textFieldTitulo.setBounds(220, 100, 500, 27);

        labelTitulo.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        labelTitulo.setText("Introduzca título:");
        getContentPane().add(labelTitulo);
        labelTitulo.setBounds(40, 100, 150, 30);

        jScrollPane1.setViewportView(textPaneContenido);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(220, 150, 500, 290);

        labelContenido.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        labelContenido.setForeground(new java.awt.Color(255, 255, 255));
        labelContenido.setText("Introduzca contenido:");
        getContentPane().add(labelContenido);
        labelContenido.setBounds(30, 170, 180, 40);

        botonAceptar.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        botonAceptar.setForeground(new java.awt.Color(0, 0, 0));
        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(botonAceptar);
        botonAceptar.setBounds(484, 480, 100, 30);

        botonCancelar.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        botonCancelar.setForeground(new java.awt.Color(0, 0, 0));
        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(botonCancelar);
        botonCancelar.setBounds(620, 480, 100, 30);

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
        fondo.setBounds(0, 0, 800, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldAutorActionPerformed
        this.autor = textFieldAutor.getText();
    }//GEN-LAST:event_textFieldAutorActionPerformed

    private void textFieldTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldTituloActionPerformed
        this.titulo = textFieldTitulo.getText();
    }//GEN-LAST:event_textFieldTituloActionPerformed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        textFieldAutorActionPerformed(evt);
        if (this.autor == null) this.autor = "";
        textFieldTituloActionPerformed(evt);
        if (this.titulo == null) this.titulo = "";
        this.contenido = textPaneContenido.getText();
        if (this.contenido == null) this.contenido = "";
        try {
            VistaAñadirManualmente.cp.altaDocumentoManual(this.autor, this.titulo, this.contenido);
            JOptionPane.showMessageDialog(rootPane,"Documento añadido con éxito.");
            vista.actualizarAutores();
            vista.limpiarTitulos();
            this.setVisible(false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane,ex);
        }
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
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
            java.util.logging.Logger.getLogger(VistaAñadirManualmente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaAñadirManualmente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaAñadirManualmente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaAñadirManualmente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaAñadirManualmente(vista,cp).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAutor;
    private javax.swing.JLabel labelContenido;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JTextField textFieldAutor;
    private javax.swing.JTextField textFieldTitulo;
    private javax.swing.JTextPane textPaneContenido;
    // End of variables declaration//GEN-END:variables
}

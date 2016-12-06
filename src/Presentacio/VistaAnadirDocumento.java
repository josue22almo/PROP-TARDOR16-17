/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio;

import java.util.ArrayList;
import jdk.nashorn.internal.codegen.CompilerConstants;

/**
 *
 * @author florencia.rimolo
 */
public class VistaAnadirDocumento extends javax.swing.JFrame {
    private String autor;
    private String titulo;
    private String contenido;
    private boolean botonAceptarApretado;
    private boolean botonCancelarApretado;
    /**
     * Creates new form VistaAnadirDocumento
     */
    public VistaAnadirDocumento() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelAutor = new java.awt.Label();
        labelTitulo = new java.awt.Label();
        labelContenido = new java.awt.Label();
        textFieldAutor = new javax.swing.JTextField();
        textFieldTitulo = new javax.swing.JTextField();
        textFieldContenido = new javax.swing.JTextField();
        botonAceptar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Añadir documento");
        setPreferredSize(new java.awt.Dimension(1000, 500));

        labelAutor.setText("Autor:");

        labelTitulo.setText("Título:");

        labelContenido.setText("Contenido:");

        textFieldAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldAutorActionPerformed(evt);
            }
        });

        textFieldTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldTituloActionPerformed(evt);
            }
        });

        textFieldContenido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldContenidoActionPerformed(evt);
            }
        });

        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelContenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(textFieldAutor)
                                .addComponent(textFieldTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                            .addComponent(textFieldContenido)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(355, Short.MAX_VALUE)
                        .addComponent(botonAceptar)
                        .addGap(37, 37, 37)
                        .addComponent(botonCancelar)))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textFieldTitulo)
                    .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelContenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldContenido, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAceptar)
                    .addComponent(botonCancelar))
                .addGap(25, 25, 25))
        );

        labelContenido.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldTituloActionPerformed
        // TODO add your handling code here:
        this.titulo = textFieldTitulo.getText();
        botonAceptarApretado = false;
        botonCancelarApretado = false;
    }//GEN-LAST:event_textFieldTituloActionPerformed

    private void textFieldContenidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldContenidoActionPerformed
        // TODO add your handling code here:
        this.contenido = textFieldContenido.getText();
        botonAceptarApretado = false;
    }//GEN-LAST:event_textFieldContenidoActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        // TODO add your handling code here:
        botonAceptarApretado = false;
        botonCancelarApretado = true;
        this.setVisible(false);
        //System.exit(0);
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        // TODO add your handling code here:
        textFieldAutorActionPerformed(evt);
        textFieldTituloActionPerformed(evt);
        textFieldContenidoActionPerformed(evt);
        botonAceptarApretado = true;
        this.setVisible(false);
        
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void textFieldAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldAutorActionPerformed
        // TODO add your handling code here:
        botonAceptarApretado = false;
        botonCancelarApretado = false;
        this.autor = textFieldAutor.getText();
    }//GEN-LAST:event_textFieldAutorActionPerformed
    
    public ArrayList<String> getDocumento() {
        ArrayList<String> doc = new ArrayList<>();
        doc.add(this.autor);
        doc.add(this.titulo);
        doc.add(this.contenido);
        return doc;
    }
    
    public boolean botonAceptarApretado() {
        return this.botonAceptarApretado;
    }
    
    public boolean botonCancelarApretado() {
        return this.botonCancelarApretado;
    }
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
            java.util.logging.Logger.getLogger(VistaAnadirDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaAnadirDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaAnadirDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaAnadirDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaAnadirDocumento().setVisible(true);
                
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCancelar;
    private java.awt.Label labelAutor;
    private java.awt.Label labelContenido;
    private java.awt.Label labelTitulo;
    private javax.swing.JTextField textFieldAutor;
    private javax.swing.JTextField textFieldContenido;
    private javax.swing.JTextField textFieldTitulo;
    // End of variables declaration//GEN-END:variables
}

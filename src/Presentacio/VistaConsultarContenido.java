/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio;

/**
 *
 * @author jessica.sobreviela
 */
public class VistaConsultarContenido extends javax.swing.JFrame {
    private static String autor;
    private static String titulo;
    private static String contenido;
    
    /**
     * Creates new form VistaConsultarContenido
     * @param autor
     * @param titulo
     * @param contenido
     */
    public VistaConsultarContenido(String autor, String titulo, String contenido) {
        initComponents();
        setLocationRelativeTo(null);
        VistaConsultarContenido.autor=autor;
        VistaConsultarContenido.titulo=titulo;
        VistaConsultarContenido.contenido=contenido;
        textoAutor.setText(autor);
        textoTitulo.setText(titulo);
        textoContenido.setText(contenido);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        labelAutor = new javax.swing.JLabel();
        labelTitulo = new javax.swing.JLabel();
        botonAceptar = new javax.swing.JButton();
        labelContenido = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoAutor = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        textoTitulo = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        textoContenido = new javax.swing.JTextPane();
        fondo = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        setTitle("Consultar");
        setPreferredSize(new java.awt.Dimension(850, 510));
        setResizable(false);
        getContentPane().setLayout(null);

        labelAutor.setBackground(new java.awt.Color(11, 116, 163));
        labelAutor.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        labelAutor.setForeground(new java.awt.Color(255, 255, 255));
        labelAutor.setText("Autor:");
        getContentPane().add(labelAutor);
        labelAutor.setBounds(50, 30, 60, 30);

        labelTitulo.setBackground(new java.awt.Color(11, 116, 163));
        labelTitulo.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        labelTitulo.setText("Título:");
        getContentPane().add(labelTitulo);
        labelTitulo.setBounds(50, 87, 60, 20);

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
        botonAceptar.setBounds(639, 460, 110, 30);

        labelContenido.setBackground(new java.awt.Color(11, 116, 163));
        labelContenido.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        labelContenido.setForeground(new java.awt.Color(255, 255, 255));
        labelContenido.setText("Contenido:");
        getContentPane().add(labelContenido);
        labelContenido.setBounds(50, 140, 90, 18);

        textoAutor.setEditable(false);
        textoAutor.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jScrollPane1.setViewportView(textoAutor);
        textoAutor.getAccessibleContext().setAccessibleName("");

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(169, 38, 450, 30);

        textoTitulo.setEditable(false);
        textoTitulo.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jScrollPane3.setViewportView(textoTitulo);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(169, 82, 450, 30);

        textoContenido.setEditable(false);
        textoContenido.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jScrollPane4.setViewportView(textoContenido);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(169, 135, 580, 290);

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
        fondo.setBounds(0, 0, 1060, 550);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_botonAceptarActionPerformed

    
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
            java.util.logging.Logger.getLogger(VistaConsultarContenido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaConsultarContenido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaConsultarContenido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaConsultarContenido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaConsultarContenido(autor,titulo,contenido).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel labelAutor;
    private javax.swing.JLabel labelContenido;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JTextPane textoAutor;
    private javax.swing.JTextPane textoContenido;
    private javax.swing.JTextPane textoTitulo;
    // End of variables declaration//GEN-END:variables
}

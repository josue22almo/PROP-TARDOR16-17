/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio;

import Domini.CjtoDocumentos;
import Domini.Documento;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author florenciarf
 */
public class Vista extends javax.swing.JFrame {

    private static CtrlPresentacio cp;
    private static String autor;
    private static ArrayList<String> autoresPref;
    private static JList listaAutores;
    private static JList listaTitulos;
    static DefaultListModel modelAutores;
    static DefaultListModel modelTitulos;
    /**
     * Creates new form Vista
     * @throws java.io.IOException
     */
    public Vista() throws IOException {
        
        Vista.cp = new CtrlPresentacio();
        Vista.autoresPref = new ArrayList<>();
        modelAutores = new DefaultListModel();
        Vista.listaAutores = new JList(modelAutores);
        modelTitulos = new DefaultListModel();
        Vista.listaTitulos = new JList(modelTitulos);
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

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        buscar = new java.awt.Label();
        textFieldBuscaAutores = new javax.swing.JTextField();
        autores = new java.awt.Label();
        titulos = new java.awt.Label();
        botonAnadirDocumento = new javax.swing.JButton();
        scrollPaneAutores = new JScrollPane(listaAutores);
        botonAceptar = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        scrollPaneTitulos = new JScrollPane(listaTitulos);
        fondo = new javax.swing.JLabel();
        barraMenu = new javax.swing.JMenuBar();
        opcion1Menu = new javax.swing.JMenu();
        menuAnadir = new javax.swing.JMenuItem();
        menuCerrar = new javax.swing.JMenuItem();

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de documentos");
        setPreferredSize(new java.awt.Dimension(4000, 3000));
        getContentPane().setLayout(null);

        buscar.setBackground(new java.awt.Color(11, 116, 163));
        buscar.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        buscar.setForeground(new java.awt.Color(254, 254, 254));
        buscar.setText("Buscar autor:");
        getContentPane().add(buscar);
        buscar.setBounds(80, 170, 160, 26);
        buscar.getAccessibleContext().setAccessibleName("Buscar");

        textFieldBuscaAutores.setBackground(new java.awt.Color(174, 178, 194));
        textFieldBuscaAutores.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        textFieldBuscaAutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldAutor(evt);
            }
        });
        getContentPane().add(textFieldBuscaAutores);
        textFieldBuscaAutores.setBounds(250, 170, 290, 30);

        autores.setBackground(new java.awt.Color(14, 115, 161));
        autores.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        autores.setForeground(new java.awt.Color(255, 255, 255));
        autores.setText("Autores:");
        getContentPane().add(autores);
        autores.setBounds(80, 250, 90, 26);

        titulos.setBackground(new java.awt.Color(14, 115, 161));
        titulos.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        titulos.setForeground(new java.awt.Color(255, 255, 255));
        titulos.setText("Títulos:");
        getContentPane().add(titulos);
        titulos.setBounds(510, 250, 70, 20);

        botonAnadirDocumento.setBackground(new java.awt.Color(174, 178, 194));
        botonAnadirDocumento.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        botonAnadirDocumento.setForeground(new java.awt.Color(0, 0, 0));
        botonAnadirDocumento.setText("Añadir documento...");
        botonAnadirDocumento.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        botonAnadirDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anadirDocumento(evt);
            }
        });
        getContentPane().add(botonAnadirDocumento);
        botonAnadirDocumento.setBounds(950, 171, 190, 40);

        scrollPaneAutores.setBackground(new java.awt.Color(174, 178, 194));
        scrollPaneAutores.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        scrollPaneAutores.setForeground(new java.awt.Color(174, 178, 194));
        scrollPaneAutores.setToolTipText("");
        scrollPaneAutores.setEnabled(false);
        getContentPane().add(scrollPaneAutores);
        scrollPaneAutores.setBounds(80, 290, 290, 400);

        botonAceptar.setBackground(new java.awt.Color(174, 178, 194));
        botonAceptar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonAceptar.setText("Aceptar");
        botonAceptar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        getContentPane().add(botonAceptar);
        botonAceptar.setBounds(570, 170, 120, 30);

        logo.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        logo.setForeground(new java.awt.Color(255, 255, 255));
        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setToolTipText("");
        logo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(logo);
        logo.setBounds(170, -10, 980, 180);

        scrollPaneTitulos.setBackground(new java.awt.Color(174, 178, 194));
        scrollPaneTitulos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        scrollPaneTitulos.setForeground(new java.awt.Color(174, 178, 194));
        getContentPane().add(scrollPaneTitulos);
        scrollPaneTitulos.setBounds(510, 290, 320, 400);

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
        fondo.setBounds(-340, -220, 3000, 1579);

        barraMenu.setBackground(new java.awt.Color(11, 116, 163));
        barraMenu.setBorder(null);

        opcion1Menu.setBackground(new java.awt.Color(11, 116, 163));
        opcion1Menu.setForeground(new java.awt.Color(255, 255, 255));
        opcion1Menu.setText("Archivo");

        menuAnadir.setBackground(new java.awt.Color(11, 116, 163));
        menuAnadir.setForeground(new java.awt.Color(255, 255, 255));
        menuAnadir.setText("Añadir por carpeta...");
        menuAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionAnadirCarpeta(evt);
            }
        });
        opcion1Menu.add(menuAnadir);

        menuCerrar.setBackground(new java.awt.Color(11, 116, 163));
        menuCerrar.setForeground(new java.awt.Color(255, 255, 255));
        menuCerrar.setText("Cerrar");
        menuCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCerrarActionPerformed(evt);
            }
        });
        opcion1Menu.add(menuCerrar);

        barraMenu.add(opcion1Menu);

        setJMenuBar(barraMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCerrarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_menuCerrarActionPerformed

    private void accionAnadirCarpeta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionAnadirCarpeta
        // TODO add your handling code here:
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle("Seleccionar carpeta");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                
              System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
              System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
                try {
                    Vista.cp.altaCjtoDocsDirectorio(chooser.getSelectedFile().getCanonicalPath());
                    CjtoDocumentos cd = Vista.cp.getCtrlDomini().getCjtoDocumentos();
                    Map <Integer, Documento> vecDocumentos = cd.getVecDocumentos();
                    Iterator it = vecDocumentos.keySet().iterator();
                    while(it.hasNext()){
                        Integer id = (Integer) it.next();
                        Documento doc = vecDocumentos.get(id);
                        System.out.print("Id: " + id + '\n' + "Autor: " + doc.getAutor() + '\n');
                        System.out.println("Titulo: " + doc.getTitulo() + '\n' + "Contenido: " + doc.getContenidoOriginal());
                        //System.out.println();
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
              System.out.println("No Selection ");
            }
    }//GEN-LAST:event_accionAnadirCarpeta

    private void textFieldAutor(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldAutor
        // TODO add your handling code here:
        Vista.autor = textFieldBuscaAutores.getText();
    }//GEN-LAST:event_textFieldAutor


    @SuppressWarnings("empty-statement")
    private void anadirDocumento(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anadirDocumento
        // TODO add your handling code here:
        VistaAnadirDocumento vAD = new VistaAnadirDocumento();
        vAD.setVisible(true);
        /*while (!vAD.botonAceptarApretado()) {
            if (vAD.botonCancelarApretado()) break;
        }*/
        //System.out.println("Boton aceptar apretado");
        if (vAD.botonAceptarApretado()) {
            System.out.println("Boton aceptar apretado");
            ArrayList<String> doc = vAD.getDocumento();
            try {
                cp.altaDocumento(doc.get(0), doc.get(1), doc.get(2));
            } catch (Exception ex) {
                Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_anadirDocumento

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        // TODO add your handling code here:
        textFieldAutor(evt);
        modelAutores.clear();
        try {
            if (autor == null) autor = "";
            autoresPref = cp.getAutorPref(autor);
        } catch (Exception ex) {
            String excepcion = "La búsqueda no ha producido resultados.";
            JOptionPane.showMessageDialog(rootPane,excepcion);
        }
        for (String aut: autoresPref) {
            modelAutores.addElement(aut);
        }
        
    }//GEN-LAST:event_aceptarActionPerformed

    private static void mostrarTitulos() {
        String autor = listaAutores.getSelectedValue().toString();
        if (autor != null) System.out.println(autor);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Vista vista = new Vista();
                    vista.setVisible(true);
                    mostrarTitulos();
                    /*try {
                        cp.altaDocumento("flor", "h", "j");
                        cp.altaDocumento("jess", "d", "f");
                        autoresPref = cp.getAutorPref("");
                    } catch (Exception ex) {
                        Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    autoresPref.forEach((aut) -> {
                        model.addElement(aut);
                    });*/
                } catch (IOException ex) {
                    Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label autores;
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonAnadirDocumento;
    private java.awt.Label buscar;
    private javax.swing.JLabel fondo;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JLabel logo;
    private javax.swing.JMenuItem menuAnadir;
    private javax.swing.JMenuItem menuCerrar;
    private javax.swing.JMenu opcion1Menu;
    private javax.swing.JScrollPane scrollPaneAutores;
    private javax.swing.JScrollPane scrollPaneTitulos;
    private javax.swing.JTextField textFieldBuscaAutores;
    private java.awt.Label titulos;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;


/**
 *
 * @author florencia.rimolo
 */
public class Vista extends javax.swing.JFrame {

    public static CtrlPresentacio cp;
    private String autorBuscado;
    private ArrayList<String> autoresPref;
    private JList listaAutores;
    private JList listaTitulos;
    static DefaultListModel modelAutores;
    static DefaultListModel modelTitulos;
    private String autorSelect;
    private String tituloSelect;
    private static String rutaCarpeta;
    /**
     * Creates new form Vista
     */
    public Vista() {
        this.autoresPref = new ArrayList<>();
        modelAutores = new DefaultListModel();
        this.listaAutores = new JList(modelAutores);
        modelTitulos = new DefaultListModel();
        this.listaTitulos = new JList(modelTitulos);
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
        scrollPaneAutores = new JScrollPane(listaAutores);
        botonAceptar = new javax.swing.JButton();
        scrollPaneTitulos = new JScrollPane(listaTitulos);
        mostrarTitulos = new javax.swing.JButton();
        botonConsultar = new javax.swing.JButton();
        botonParecidos = new javax.swing.JButton();
        botonModificar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botonExpBool = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();
        barraMenu = new javax.swing.JMenuBar();
        opcion1Menu = new javax.swing.JMenu();
        menuAnadirDocManual = new javax.swing.JMenuItem();
        anadirDoc = new javax.swing.JMenuItem();
        menuAnadir = new javax.swing.JMenuItem();
        menuCerrar = new javax.swing.JMenuItem();
        ayuda = new javax.swing.JMenu();
        menuManual = new javax.swing.JMenuItem();

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de documentos");
        getContentPane().setLayout(null);

        buscar.setBackground(new java.awt.Color(11, 116, 163));
        buscar.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        buscar.setForeground(new java.awt.Color(254, 254, 254));
        buscar.setText("Buscar autor:");
        getContentPane().add(buscar);
        buscar.setBounds(80, 170, 160, 27);
        buscar.getAccessibleContext().setAccessibleName("Buscar");

        textFieldBuscaAutores.setForeground(new java.awt.Color(0, 0, 0));
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
        autores.setBounds(80, 250, 90, 27);

        titulos.setBackground(new java.awt.Color(14, 115, 161));
        titulos.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        titulos.setForeground(new java.awt.Color(255, 255, 255));
        titulos.setText("Títulos:");
        getContentPane().add(titulos);
        titulos.setBounds(590, 250, 70, 20);

        scrollPaneAutores.setBackground(new java.awt.Color(174, 178, 194));
        scrollPaneAutores.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        scrollPaneAutores.setForeground(new java.awt.Color(174, 178, 194));
        scrollPaneAutores.setToolTipText("");
        scrollPaneAutores.setEnabled(false);
        scrollPaneAutores.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        getContentPane().add(scrollPaneAutores);
        scrollPaneAutores.setBounds(80, 280, 290, 400);

        botonAceptar.setBackground(new java.awt.Color(174, 178, 194));
        botonAceptar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        botonAceptar.setForeground(new java.awt.Color(0, 0, 0));
        botonAceptar.setText("Aceptar");
        botonAceptar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(174, 178, 194), 1, true));
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        getContentPane().add(botonAceptar);
        botonAceptar.setBounds(570, 170, 120, 30);

        scrollPaneTitulos.setBackground(new java.awt.Color(174, 178, 194));
        scrollPaneTitulos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        scrollPaneTitulos.setForeground(new java.awt.Color(174, 178, 194));
        scrollPaneTitulos.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        getContentPane().add(scrollPaneTitulos);
        scrollPaneTitulos.setBounds(590, 280, 320, 410);

        mostrarTitulos.setBackground(new java.awt.Color(174, 178, 194));
        mostrarTitulos.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        mostrarTitulos.setForeground(new java.awt.Color(0, 0, 0));
        mostrarTitulos.setText("Mostrar títulos >>");
        mostrarTitulos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(174, 178, 194), 1, true));
        mostrarTitulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarTitulosActionPerformed(evt);
            }
        });
        getContentPane().add(mostrarTitulos);
        mostrarTitulos.setBounds(390, 450, 170, 30);

        botonConsultar.setBackground(new java.awt.Color(174, 178, 194));
        botonConsultar.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        botonConsultar.setForeground(new java.awt.Color(0, 0, 0));
        botonConsultar.setText("Consultar contenido");
        botonConsultar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(174, 178, 194), 1, true));
        botonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultarActionPerformed(evt);
            }
        });
        getContentPane().add(botonConsultar);
        botonConsultar.setBounds(980, 280, 190, 40);

        botonParecidos.setBackground(new java.awt.Color(174, 178, 194));
        botonParecidos.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        botonParecidos.setForeground(new java.awt.Color(0, 0, 0));
        botonParecidos.setText("Consultar parecidos");
        botonParecidos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(174, 178, 194), 1, true));
        botonParecidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonParecidosActionPerformed(evt);
            }
        });
        getContentPane().add(botonParecidos);
        botonParecidos.setBounds(980, 360, 190, 40);

        botonModificar.setBackground(new java.awt.Color(174, 178, 194));
        botonModificar.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        botonModificar.setForeground(new java.awt.Color(0, 0, 0));
        botonModificar.setText("Modificar");
        botonModificar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(174, 178, 194), 1, true));
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });
        getContentPane().add(botonModificar);
        botonModificar.setBounds(980, 440, 190, 40);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("LM Sans 10", 0, 65)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestión de documentos");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(350, 40, 880, 100);

        jLabel2.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("url:http://icdn.pro/images/es/d/o/documento-icono-3983-128.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        getContentPane().add(jLabel2);
        jLabel2.setBounds(210, 30, 130, 120);

        botonExpBool.setBackground(new java.awt.Color(174, 178, 194));
        botonExpBool.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        botonExpBool.setForeground(new java.awt.Color(0, 0, 0));
        botonExpBool.setText("Consultar expresión booleana");
        botonExpBool.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(174, 178, 194), 1, true));
        botonExpBool.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonExpBoolActionPerformed(evt);
            }
        });
        getContentPane().add(botonExpBool);
        botonExpBool.setBounds(910, 170, 260, 40);

        eliminar.setBackground(new java.awt.Color(174, 178, 194));
        eliminar.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        eliminar.setForeground(new java.awt.Color(0, 0, 0));
        eliminar.setText("Eliminar");
        eliminar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(174, 178, 194), 1, true));
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(eliminar);
        eliminar.setBounds(980, 520, 190, 40);

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
        opcion1Menu.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N

        menuAnadirDocManual.setBackground(new java.awt.Color(11, 116, 163));
        menuAnadirDocManual.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        menuAnadirDocManual.setForeground(new java.awt.Color(255, 255, 255));
        menuAnadirDocManual.setText("Añadir documento manualmente");
        menuAnadirDocManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAnadirDocManualActionPerformed(evt);
            }
        });
        opcion1Menu.add(menuAnadirDocManual);

        anadirDoc.setBackground(new java.awt.Color(11, 116, 163));
        anadirDoc.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        anadirDoc.setForeground(new java.awt.Color(255, 255, 255));
        anadirDoc.setText("Añadir documento por carpeta");
        anadirDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anadirDocActionPerformed(evt);
            }
        });
        opcion1Menu.add(anadirDoc);

        menuAnadir.setBackground(new java.awt.Color(11, 116, 163));
        menuAnadir.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        menuAnadir.setForeground(new java.awt.Color(255, 255, 255));
        menuAnadir.setText("Añadir conjunto de documentos por carpeta");
        menuAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionAnadirCarpeta(evt);
            }
        });
        opcion1Menu.add(menuAnadir);

        menuCerrar.setBackground(new java.awt.Color(11, 116, 163));
        menuCerrar.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        menuCerrar.setForeground(new java.awt.Color(255, 255, 255));
        menuCerrar.setText("Cerrar");
        menuCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCerrarActionPerformed(evt);
            }
        });
        opcion1Menu.add(menuCerrar);

        barraMenu.add(opcion1Menu);

        ayuda.setBackground(new java.awt.Color(11, 116, 163));
        ayuda.setForeground(new java.awt.Color(255, 255, 255));
        ayuda.setText("Ayuda");
        ayuda.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N

        menuManual.setBackground(new java.awt.Color(11, 116, 163));
        menuManual.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        menuManual.setForeground(new java.awt.Color(255, 255, 255));
        menuManual.setText("Manual de usuario");
        menuManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuManualActionPerformed(evt);
            }
        });
        ayuda.add(menuManual);

        barraMenu.add(ayuda);
        ayuda.getAccessibleContext().setAccessibleDescription("");

        setJMenuBar(barraMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuCerrarActionPerformed

    private void accionAnadirCarpeta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionAnadirCarpeta

            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle("Seleccionar carpeta");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                try {
                    Vista.cp.altaCjtoDocsDirectorio(chooser.getSelectedFile().getCanonicalPath(),true); 
                    String exito = "Documentos creados con éxito.";
                    actualizarAutores();
                    limpiarTitulos();
                    JOptionPane.showMessageDialog(rootPane,exito);  
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(rootPane,ex);
                }
            }
    }//GEN-LAST:event_accionAnadirCarpeta

    private void textFieldAutor(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldAutor
        this.autorBuscado = textFieldBuscaAutores.getText();
    }//GEN-LAST:event_textFieldAutor


    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        textFieldAutor(evt);
        modelAutores.clear();
        try {
            if (this.autorBuscado == null) this.autorBuscado = "";
            this.autoresPref = cp.consultarAutoresPorPrefijo(this.autorBuscado);
            for (String aut: autoresPref) {
            modelAutores.addElement(aut);
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(rootPane,"La búsqueda no ha producido resultados.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane,ex);
        }
        
    }//GEN-LAST:event_aceptarActionPerformed

    private void mostrarTitulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarTitulosActionPerformed
        ArrayList<String> titulosAutor = new ArrayList<>();
        modelTitulos.clear();
        if (listaAutores.getSelectedValue() == null) {
            String excepcion = "Primero seleccione un autor.";
            JOptionPane.showMessageDialog(rootPane,excepcion);            
        }
        else {
            this.autorSelect = listaAutores.getSelectedValue().toString();
            titulosAutor = Vista.cp.consultarTitulosAutor(this.autorSelect);
 
            for (String titulo: titulosAutor) {
                modelTitulos.addElement(titulo);
            }
        }
    }//GEN-LAST:event_mostrarTitulosActionPerformed

    private void botonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultarActionPerformed
        // TODO add your handling code here:
        String contenido = "";
        if (listaAutores.getSelectedValue() == null || listaTitulos.getSelectedValue() == null) {
            String excepcion = "Primero seleccione un autor y un título.";
            JOptionPane.showMessageDialog(rootPane,excepcion);            
        }
        else {
            try {
                this.autorSelect = listaAutores.getSelectedValue().toString();
                this.tituloSelect = listaTitulos.getSelectedValue().toString();
                contenido = Vista.cp.consultarContenido(this.autorSelect, this.tituloSelect);
                VistaConsultarContenido consCont = new VistaConsultarContenido(this.autorSelect, this.tituloSelect,contenido);
                consCont.setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane,ex);
            }
        }
    }//GEN-LAST:event_botonConsultarActionPerformed

    private void anadirDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anadirDocActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Seleccionar documento");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                if (chooser.getSelectedFile().getAbsolutePath().equals(rutaCarpeta)) {
                    Vista.cp.altaDocumentoPorRuta(chooser.getSelectedFile(),false);
                }
                else {
                    Vista.cp.altaDocumentoPorRuta(chooser.getSelectedFile(),true);
                }
                String exito = "Documento creado con éxito.";
                actualizarAutores();
                limpiarTitulos();
                JOptionPane.showMessageDialog(rootPane,exito);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane,ex);
            }
        }
    }//GEN-LAST:event_anadirDocActionPerformed

    private void botonParecidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonParecidosActionPerformed
        if (listaAutores.getSelectedValue() == null || listaTitulos.getSelectedValue() == null) {
            String excepcion = "Primero seleccione un autor y un título.";
            JOptionPane.showMessageDialog(rootPane,excepcion);            
        }
        else {
            this.autorSelect = listaAutores.getSelectedValue().toString();
            this.tituloSelect = listaTitulos.getSelectedValue().toString();
            VistaParecidos vp = new VistaParecidos(cp, this.autorSelect, this.tituloSelect);
            vp.setVisible(true);
        }
    }//GEN-LAST:event_botonParecidosActionPerformed

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
        if (listaAutores.getSelectedValue() == null || listaTitulos.getSelectedValue() == null) {
            String excepcion = "Primero seleccione un autor y un título.";
            JOptionPane.showMessageDialog(rootPane,excepcion);            
        }
        else {
            try {
                this.autorSelect = listaAutores.getSelectedValue().toString();
                this.tituloSelect = listaTitulos.getSelectedValue().toString();
                String contenido = Vista.cp.consultarContenido(this.autorSelect, this.tituloSelect);
                VistaModificar vm = new VistaModificar(this,cp, this.autorSelect, this.tituloSelect, contenido);
                vm.setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane,ex);
            }
        }
    }//GEN-LAST:event_botonModificarActionPerformed

    private void botonExpBoolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonExpBoolActionPerformed
        VistaExprBooleana veb = new VistaExprBooleana(cp);
        veb.setVisible(true);
    }//GEN-LAST:event_botonExpBoolActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        if (listaAutores.getSelectedValue() == null || listaTitulos.getSelectedValue() == null) {
            String excepcion = "Primero seleccione un autor y un título.";
            JOptionPane.showMessageDialog(rootPane,excepcion);            
        }
        else {
            try {
                this.autorSelect = listaAutores.getSelectedValue().toString();
                this.tituloSelect = listaTitulos.getSelectedValue().toString();
                Vista.cp.eliminarDocumento(this.autorSelect, this.tituloSelect);
                String excepcion = "El documento seleccionado ha sido eliminado con éxito.";
                JOptionPane.showMessageDialog(rootPane,excepcion);
                actualizarAutores();
                limpiarTitulos();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane,ex);
            }
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void menuManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuManualActionPerformed
        VistaManualDeUsuario vma = new VistaManualDeUsuario();
        vma.setVisible(true);
    }//GEN-LAST:event_menuManualActionPerformed

    private void menuAnadirDocManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAnadirDocManualActionPerformed
        VistaAñadirManualmente vam = new VistaAñadirManualmente(this, cp);
        vam.setVisible(true);
    }//GEN-LAST:event_menuAnadirDocManualActionPerformed

    public void actualizarAutores() {
        modelAutores.clear();
        aceptarActionPerformed(null);
    }
    
    public void limpiarTitulos() {
        modelTitulos.clear();
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
                    vista.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    vista.setVisible(true);
                    JFileChooser chooser = new JFileChooser();
                    chooser.setCurrentDirectory(new java.io.File("."));
                    chooser.setDialogTitle("Seleccione el directorio en el que desea guardar sus documentos:");
                    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    chooser.setAcceptAllFileFilterUsed(false);
                    int option = chooser.showOpenDialog(null);
                    while (true) {
                        if (option == JFileChooser.CANCEL_OPTION) {
                            String excepcion = "Debe seleccionar un directorio.";
                            JOptionPane.showMessageDialog(vista, excepcion);
                            option = chooser.showOpenDialog(null);
                        }
                        else if (option == JFileChooser.APPROVE_OPTION) {
                            Vista.rutaCarpeta = chooser.getSelectedFile().getAbsolutePath();
                            break;
                        }
                    }
                    File directorio = new File(rutaCarpeta);
                    File [] archivos;
                    archivos = directorio.listFiles();
                    Vista.cp = new CtrlPresentacio(rutaCarpeta);
                    if (archivos.length != 0) Vista.cp.altaCjtoDocsDirectorio(rutaCarpeta,false);
                } catch (Exception ex) {
                    Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem anadirDoc;
    private java.awt.Label autores;
    private javax.swing.JMenu ayuda;
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonConsultar;
    private javax.swing.JButton botonExpBool;
    private javax.swing.JButton botonModificar;
    private javax.swing.JButton botonParecidos;
    private java.awt.Label buscar;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem menuAnadir;
    private javax.swing.JMenuItem menuAnadirDocManual;
    private javax.swing.JMenuItem menuCerrar;
    private javax.swing.JMenuItem menuManual;
    private javax.swing.JButton mostrarTitulos;
    private javax.swing.JMenu opcion1Menu;
    private javax.swing.JScrollPane scrollPaneAutores;
    private javax.swing.JScrollPane scrollPaneTitulos;
    private javax.swing.JTextField textFieldBuscaAutores;
    private java.awt.Label titulos;
    // End of variables declaration//GEN-END:variables
}

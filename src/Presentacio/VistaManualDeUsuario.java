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
public class VistaManualDeUsuario extends javax.swing.JFrame {

    /**
     * Creates new form VistaManualDeUsuario
     */
    public VistaManualDeUsuario() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        fondo = new javax.swing.JLabel();

        setTitle("Manual de usuario");
        setMinimumSize(new java.awt.Dimension(1120, 660));
        setResizable(false);
        getContentPane().setLayout(null);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("Manual de usuario:\n\n1. Introducción:\n\nLo primero que le pedirá el programa al ejecutarlo, es seleccionar un directorio que será el directorio de trabajo. Una vez seleccionado,\nel programa dará de alta todos los documentos que se encuentren en esa carpeta, en el caso que los contenga.Verá como en la casilla \nAutores aparecerán todos los autores de los documentos que haya dado de alta.\n\nLas funcionalidades que ofrece este programa son las siguientes:\n\n- Dar de alta un documento\n\n- Dar de alta un conjunto de documentos dada la carpeta que los contiene\n\n- Mostrar autores\n\n- Mostrar los títulos de un autor\n\n- Consultar el contenido de un documento\n\n- Consultar los documentos más parecidos a un documento\n\n- Consultar los documentos que contienen una frase especificada como una expresión booleana\n\n- Modificar un documento\n\n- Eliminar un documento \n\nEn los siguientes apartados se explicará con detalle el procedimiento de cada una de estas funcionalidades.\n\n2. Dar de alta un documento\n\nPara dar de alta un documento, hay dos opciones: hacerlo manualmente introduciendo el autor, el título y el contenido o elegir\nun archivo que corresponde a un documento. \nPara la primera opción, haga clic en el menú que se encuentra en la esquina superior izquierda y luego en “Añadir documento\nmanualmente.”. Aparecerá una ventana donde deberá introducir los datos del documento. Una vez introducidos, en su directorio\nde trabajo verá que se ha creado un nuevo archivo que corresponde al documento que ha dado de alta. Aparecerá un mensaje diciendo\nque el documento se ha creado con éxito.\n\nPara la segunda opción, haga clic en el menú que se encuentra en la esquina superior izquierda y luego en “Añadir documento por carpeta.”.\nAparecerá una ventana donde deberá seleccionar el documento que desea dar de alta. Una vez seleccionado, en su directorio de trabajo\nverá que se ha creado un nuevo archivo que corresponde al documento que ha dado de alta. Aparecerá un mensaje diciendo que el documento\nse ha creado con éxito.\n\nJusto después, verá como la casilla Autores se actualizará y aparecerán todos los autores de los documentos que haya dado de alta.\n\nPara el correcto funcionamiento del programa, el formato del archivo txt del documento debe ser el siguiente:\nLa primera línea corresponde al autor, la segunda al título y el resto el contenido. \nEntre autor y título y entre título y contenido debe haber un salto de línea.\nTítulo y autor no deben contener interrogantes ni exclamaciones.\n\n3. Dar de alta un conjunto de documentos dada la carpeta que los contiene\n\nPara ello, haga clic en el menú que se encuentra en la esquina superior izquierda y luego en “Añadir carpeta...”. Aparecerá una ventana donde\ndeberá seleccionar el directorio donde se encuentra el conjunto de documentos que desea dar de alta. Una vez seleccionado, en su directorio de\ntrabajo verá que se ha creado un nuevo archivo por cada documento dado de alta. Cuando se haya realizado el alta, aparecerá un mensaje diciendo\nque los documentos se han creado con éxito. Justo después, verá como la casilla Autores se actualizará y aparecerán todos los autores de los documentos \nque haya dado de alta.\n\nSi el directorio que desea dar de alta ya lo ha dado de alta anteriormente, el programa dará de alta todos los documentos que se encuentren en ese \ndirectorio que no estén dados de alta. Si todos los documentos que hay en la carpeta ya existían, no se hará nada.\n\nEl formato de los documentos debe ser el mismo que el especificado en el apartado anterior.\n\n4. Mostrar autores\n\nUna vez dado de alta uno o más documentos, usted puede ver todos los autores que hay en el conjunto de documentos simplemente haciendo clic en\nel botón “Aceptar” (la barra de búsqueda debe estar vacía). Pero, por ejemplo, si desea buscar un autor en concreto o diversos autores que empiezan\npor las mismas letras, puede agilizar la búsqueda introduciendo en la barra de búsqueda el autor o las letras por las cuales empiezan los autores que\ndesee buscar. Una vez hecho clic en “Aceptar”, en el recuadro de autores aparecerán los autores encontrados según su criterio de búsqueda.\n\n5. Mostrar los títulos de un autor\n\nPara ello, primero debe seleccionar el autor. Hecho esto, haga clic en el botón “Mostrar títulos >>” y, en el recuadro de títulos, aparecerán todos los\ntítulos del autor seleccionado.\n\n6. Consultar el contenido de un documento\n\nPrimero deberá seleccionar el autor y el título del documento, tal y como se explica en los apartados 4 y 5. A continuación haga clic en el botón\n“Consultar contenido”, que se encuentra en la parte derecha de la ventana, y aparecerá una nueva ventana en la cual se muestra el contenido\ndel documento.\n\n7. Consultar los documentos más parecidos a un documento\n\nPrimero deberá seleccionar el autor y el título del documento, tal y como se explica en los apartados 4 y 5. A continuación haga clic en el botón\n“Consultar parecidos”, que se encuentra en la parte derecha de la ventana, y aparecerá una nueva ventana en la cual deberá introducir el número de\ndocumentos parecidos que desea y el método mediante el cual se obtendrán. A continuación haga clic en “Consultar” y, en el recuadro inferior,\naparecerán los autores y los títulos de los documentos más parecidos al documento anteriormente seleccionado, ordenados de mayor a menor semejanza.\n\n8. Consultar los documentos que contienen una frase especificada como una expresión booleana\n\nPrimero deberá seleccionar el autor y el título del documento, tal y como se explica en los apartados 4 y 5. A continuación haga clic en el botón “Consultar\nexpresión booleana”, que se encuentra en la parte derecha de la ventana, y aparecerá una nueva ventana en la cual deberá introducir la expresión. Una vez\nintroducida, haga clic en “Consultar” y, en el recuadro inferior, aparecerán los autores y títulos de los documentos que cumplan dicha expresión.\n\n9. Modificar un documento\n\nSe pueden modificar los 3 parámetros de un documento: el autor, el título y el contenido. Para cada uno de ellos, el método es similar:\n\nPrimero deberá seleccionar el autor y el título del documento, tal y como se explica en los apartados 4 y 5. A continuación haga clic en el botón “Modificar”,\nque se encuentra en la parte derecha de la ventana, y aparecerá una nueva ventana en la cual hay tres botones, “Modificar autor”, “Modificar título” y\n“Modificar contenido”. Haga clic en el que desee y se abrirá otra ventana en la cual deberá introducir el dato que desea modificar. Cuando haya finalizado,\nhaga clic en “Aceptar” y, una vez realizada la modificación, aparecerá un mensaje en la pantalla conforme ésta se ha realizado con éxito.\nSi ha modificado el autor, después de cerrarse la ventana, verá como la casilla Autores se actualizará y aparecerán todos los autores de los documentos \nque haya dado de alta. Si ha modificado el título, después de cerrarse la ventana, verá como la casilla Títulos se borrará y deberá (si el autor está seleccionado), \nhacer clic en el botón “Mostrar títulos >>” para ver los títulos actualizados.\n\n\n10. Eliminar un documento\n \nSeleccione el autor y el título del documento que desea eliminar, y luego pulse el botón Eliminar, que se encuentra a la derecha de la pantalla. Aparecerá\nun mensaje conforme la eliminación se ha realizado con éxito.\n\n11. Comentarios\n\nEl fondo del programa y el icono los hemos extraído de http://www.celer-comex.com.ar/images/fondo.jpg y \nurl:http://icdn.pro/images/es/d/o/documento-icono-3983-128.png , respectivamente.\n");
        jTextArea1.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 20, 1080, 620);

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
        fondo.setBounds(0, 0, 1120, 660);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(VistaManualDeUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaManualDeUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaManualDeUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaManualDeUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaManualDeUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}

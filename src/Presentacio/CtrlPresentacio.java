/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio;
import Domini.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author florencia.rimolo
 */
public class CtrlPresentacio {
    private CtrlDomini cd;
    
    public CtrlPresentacio() throws IOException {
        this.cd = new CtrlDomini();
    }
    
    public ArrayList<String> getAutorPref(String autor) throws Exception {
        return this.cd.consultarAutoresPorPrefijo(autor);
    }
    
    public void altaCjtoDocsDirectorio(String folder) throws Exception {
        this.cd.altaConjuntoDocumentosDirectorio(folder);
    }
    
    public void altaDocumento(String autor, String titulo, String contenido) throws Exception {
        this.cd.altaDocumento(autor, titulo, contenido);
    }
    
    public String consultarContenido(String autor, String titulo) throws Exception {
        return this.cd.consultarContenido(autor, titulo);
    }
    
    public ArrayList<String> consultarTitulosAutor(String autor) throws Exception {
        return this.cd.consultarTitulosAutor(autor);
    }
    
    public CtrlDomini getCtrlDomini() {
        return this.cd;
    }
}

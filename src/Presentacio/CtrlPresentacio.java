/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentacio;
import Domini.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author florencia.rimolo
 */
public class CtrlPresentacio {
    private CtrlDomini cd;
    private String ruta;
    
    public CtrlPresentacio(String ruta) throws IOException, Exception {
        this.cd = new CtrlDomini(ruta);
        this.ruta = ruta;
    }
    
    public ArrayList<String> getAutorPref(String autor) throws Exception {
        return this.cd.consultarAutoresPorPrefijo(autor);
    }
    
    public void altaCjtoDocsDirectorio(String folder) throws Exception {
        this.cd.altaConjuntoDocumentosDirectorio(folder);
    }
    
    public void altaDocumentoPorRuta (File archivo) throws Exception {
        this.cd.altaDocumentoPorRuta(archivo);
    } 
    
    public void altaDocumento(String autor, String titulo, String contenido) throws Exception {
        this.cd.altaDocumento(autor, titulo, contenido);
    }
    
    public String consultarContenido(String autor, String titulo) {
        return this.cd.consultarContenido(autor, titulo);
    }
    
    public Map<String,ArrayList<String>> consultarParecidos(String autor, String titulo, Integer k, String type) throws Exception {
        return this.cd.getDocumentosParecidos(autor, titulo, k, type);
    }
    
    public ArrayList<String> consultarTitulosAutor(String autor) throws Exception{
        return this.cd.consultarTitulosAutor(autor);
    }
    
    public Map<String,String> consultarDocumentosExprBooleana(String exprBooleana) throws Exception {
        return this.cd.getDocumentosBool(exprBooleana);
    }
    
    public void modificarAutor(String autor, String titulo, String autorModif) {
        cd.modificaAutorDoc(autor, titulo, autorModif);
    }
    
    public void modificarTitulo(String autor, String titulo, String tituloModif) {
        cd.modificaTituloDoc(autor, titulo, tituloModif);
    }
    
    public void modificarContenido(String autor, String titulo, String contenidoModif) {
        cd.modificaContenidoDoc(autor, titulo, contenidoModif);
    }
    
    public CtrlDomini getCtrlDomini() {
        return this.cd;
    }
}

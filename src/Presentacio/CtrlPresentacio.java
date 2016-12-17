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

/**
 *
 * @author florencia.rimolo
 */
public class CtrlPresentacio {
    private CtrlDomini cd;
    
    public CtrlPresentacio(String ruta) throws Exception {
        this.cd = new CtrlDomini(ruta);
    }
    
    public void altaCjtoDocsDirectorio(String folder, boolean guardar) throws Exception {
        this.cd.altaConjuntoDocumentosDirectorio(folder, guardar);
    }
    
    public void altaDocumentoPorRuta (File archivo, boolean guardar) throws Exception {
        System.out.println("presentacio");
        this.cd.altaDocumentoPorRuta(archivo,guardar);
    }
    
    public void eliminarDocumento(String autor, String titulo){
        cd.bajaDocumento(autor, titulo);
    }
    
    public void modificarAutor(String autor, String titulo, String autorModif) throws IOException {
        cd.modificaAutorDoc(autor, titulo, autorModif);
    }
    
    public void modificarTitulo(String autor, String titulo, String tituloModif) throws IOException {
        cd.modificaTituloDoc(autor, titulo, tituloModif);
    }
    
    public void modificarContenido(String autor, String titulo, String contenidoModif) throws IOException {
        cd.modificaContenidoDoc(autor, titulo, contenidoModif);
    }
    
    public String consultarContenido(String autor, String titulo) {
        return this.cd.consultarContenido(autor, titulo);
    }
    
    public ArrayList<String> consultarParecidos(String autor, String titulo, Integer k, String type) throws Exception {
        return this.cd.getDocumentosParecidos(autor, titulo, k, type);
    }
    
    public ArrayList<String> consultarTitulosAutor(String autor) throws Exception{
        return this.cd.consultarTitulosAutor(autor);
    }
    
    public ArrayList<String> consultarDocumentosExprBooleana(String exprBooleana) throws Exception {
        return this.cd.getDocumentosBool(exprBooleana);
    }
    
    public ArrayList<String> consultarAutoresPorPrefijo(String autor) throws Exception {
        return this.cd.consultarAutoresPorPrefijo(autor);
    }
}

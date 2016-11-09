/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author florencia.rimolo
 */
public class CtrlDomini {
    
    private CjtoDocumentos cd = new CjtoDocumentos();
    
    public CtrlDomini(){}
    
    public void altaDocumento(String autor, String titulo, String contenido) throws Exception {
        cd.altaDocumento(autor, titulo, contenido);
    }
    
    public void bajaDocumento(String autor, String titulo) throws Exception {
        cd.bajaDocumento(autor, titulo);
    }
    
    public void modificaAutorDoc(String autor, String titulo, String autorModif) throws Exception{
        cd.modificaAutorDoc(autor, titulo, autorModif);
    }
    
    public void modificaTituloDoc(String autor, String titulo, String tituloModif) throws Exception{
        cd.modificaTituloDoc(autor, titulo, tituloModif);
    }
    
    public void modificaContenidoDoc(String autor, String titulo, String contenidoModif) throws Exception{
        cd.modificaContenidoDoc(autor, titulo, contenidoModif);
    }
    
    public ArrayList<String> consultarTitulosAutor(String autor) throws Exception{
        return cd.consultarTitulosAutor(autor);        
    }
    
    public ArrayList<String> consultarAutores(String prefijo) throws Exception{
        return cd.consultarAutores(prefijo);
    }
    
    public String consultarContenido(String autor, String titulo) throws Exception{
        return cd.consultarContenido(autor, titulo);
    }
    
    public Map<String,String> getDocumentosParecidos(String autor, String titulo, int k, String type) throws Exception{
        Map<String,String> m = new HashMap<>();
        ArrayList <Documento> l = cd.getDocumentosParecidos(autor, titulo, k,type);
        l.stream().forEach((d) -> {
            m.put(d.getTitulo(),d.getAutor());
        });
        return m;
    }
    
    public Map<String,String> getDocumentosBool(String frase) throws Exception{
        Map<String,String> m = new HashMap<>();
        ArrayList <Documento> l = cd.getDocumentosBool(frase);
        l.stream().forEach((d) -> {
            m.put(d.getTitulo(),d.getAutor());
        });
        return m;
    }
    
    public void print(){        
        cd.print();
    }
    
    
}
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
 * @author jessica
 */
public class DocList extends ArrayList{
    private ArrayList<Documento> vecDocumentos;
    public DocList() {
        vecDocumentos= new ArrayList<>();
    }
    
    public boolean contains(Documento dc) {
        for(Documento doc : vecDocumentos){
            if (doc.equals(dc)) return true;
        }
        return false; 
    } 
    
    public void print(){
        for(Documento doc : vecDocumentos){
            System.out.println(doc.getId() + " " + doc.getAutor() + " " + doc.getTitulo());
        }
        System.out.println("---------------------");
    }
    
    public void add(Documento doc){
        vecDocumentos.add(doc);
    }
    
    public void delete(Documento doc){
        for(int i = 0; i < vecDocumentos.size(); i++){
            if (vecDocumentos.get(i).equals(doc)) {
                vecDocumentos.remove(i);
                break;      // salir del for cuando ya lo ha borrado
            }
        }
    }
    
    public void modificarAutor(Documento doc, String au) throws ExceptionDomini{
        int i = vecDocumentos.indexOf(doc);
        try {
        if (i != -1) {
            vecDocumentos.get(i).setAutor(au);
        }
        else throw new ExceptionDomini("No existe ningún documento para este autor");
        }
        catch (ExceptionDomini ed) {
            System.out.println(ed);
        }
    }
    
    public void modificarTitulo(Documento doc,String titulo){
        int i = vecDocumentos.indexOf(doc);
        try {
        if (i != -1) {
            vecDocumentos.get(i).setTitulo(titulo);
        }
        else throw new ExceptionDomini("No existe ningún documento con este título");
        }
        catch (ExceptionDomini ed){
            System.out.println(ed);
        }
    }
    
    public void modificarContenido(Documento doc, String contenido){
        int i = vecDocumentos.indexOf(doc);
        try {
        if (i != -1) {
            vecDocumentos.get(i).setContenido(contenido);
        }
        else throw new ExceptionDomini("No existe ningún documento con este contenido");
        }
        catch (ExceptionDomini ed) {
            System.out.println(ed);
        }
    }
}

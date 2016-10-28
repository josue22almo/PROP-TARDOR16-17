/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;
import java.util.ArrayList;

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
    
    public void modificarAutor(Documento doc, String au){
        int i = vecDocumentos.indexOf(doc);
        if (i != -1) {
            vecDocumentos.get(i).setAutor(au);
        }
        else System.out.println("No existe ningún documento para este autor");   // excepción??   
    }
    
    public void modificarTitulo(Documento doc,String titulo){
        int i = vecDocumentos.indexOf(doc);
        if (i != -1) {
            vecDocumentos.get(i).setTitulo(titulo);
        }
        else System.out.println("No existe ningún documento con este título");
    }
    
    public void modificarContenido(Documento doc, String contenido){
        int i = vecDocumentos.indexOf(doc);
        if (i != -1) {
            vecDocumentos.get(i).setContenido(contenido);
        }
        else System.out.println("No existe ningún documento con este contenido");
    }
}
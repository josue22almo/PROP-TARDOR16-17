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
            if (vecDocumentos.get(i).equals(doc)) vecDocumentos.remove(i);
        }
    }
    
    public void modificarAutor(Documento doc){
        for(int i = 0; i < vecDocumentos.size(); i++){
            if (vecDocumentos.get(i).equals(doc)){
                //falta
            }
        }
    }
    
    public void modificarTitulo(Documento doc){
        for(int i = 0; i < vecDocumentos.size(); i++){
            if (vecDocumentos.get(i).equals(doc)){
                //falta
            }
        }
    }
    
    public void modificarContenido(Documento doc){
        for(int i = 0; i < vecDocumentos.size(); i++){
            if (vecDocumentos.get(i).equals(doc)){
                //falta
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author josue.inaldo.alcantara
 */
public class CjtoDocumentos {
    private DocList vecDocumentos;
    private int id;
    
    
    public CjtoDocumentos(){
        vecDocumentos = new DocList();
        id = 0;
    }
    
    public void altaDocumento(String autor, String titulo, String contenido) throws ExceptionDomini{

        Documento doc = new Documento(autor,titulo,contenido,id);
        try{    
            if (vecDocumentos.contains(doc)){
                throw new ExceptionDomini("El documento ya existe");
            }else{
                vecDocumentos.add(doc);
                ++id;
            }
        } catch(ExceptionDomini e){
            System.out.println(e.getMessage());
        }
        vecDocumentos.print();
    }
    
    
    public void eliminarDocumento(){
    }
   
}

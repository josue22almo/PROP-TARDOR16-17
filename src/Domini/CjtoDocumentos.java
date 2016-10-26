/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author josue.inaldo.alcantara
 */
public class CjtoDocumentos {
    private DocList vecDocumentos;
    private int id;
    private ArrayList<String> español;
    private ArrayList<String> catalan;
    private ArrayList<String> ingles;
    
    public CjtoDocumentos() throws IOException, FileNotFoundException{
        vecDocumentos = new DocList();
        id = 0;
        CtrlDomini ctrlDomini = new CtrlDomini();
        español = new ArrayList<>();
        catalan = new ArrayList<>();
        ingles = new ArrayList<>();
        ctrlDomini.leerPalabras(español, catalan, ingles);
    }
    
    public void altaDocumento(String autor, String titulo, String contenido) throws ExceptionDomini{

        Documento doc;
        doc = new Documento(autor,titulo,contenido,id,español,catalan,ingles);
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

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
    private int numDocs;
    private ArrayList<String> español;
    private ArrayList<String> catalan;
    private ArrayList<String> ingles;
    
    public CjtoDocumentos() throws IOException, FileNotFoundException{
        vecDocumentos = new DocList();
        id = 0;
        numDocs = 0;
        CtrlDomini ctrlDomini = new CtrlDomini();
        español = new ArrayList<>();
        catalan = new ArrayList<>();
        ingles = new ArrayList<>();
        ctrlDomini.leerPalabras(español, catalan, ingles);
    }
    
    public ArrayList<Titulo> consultarTitulosAutor(Autor autor){
        
    }
    
    public ArrayList<Autor> consultarAutores(String prefijo){
        
    }
    
    public Contenido consultarContenido(Autor autor, Titulo titulo){
        
    }
    
    public ArrayList<Documento> getDocumentosParecidosFrecs(Documento T, int k){
    
    }
    
    public ArrayList<Documento> getDocumentosParecidosTfDf(Documento T, int k){
        
    }
    
    public ArrayList<Documento> getDocumentosBool(ArrayList<String> frase){
        
    }
    
    
    public void altaDocumento(Autor autor, Titulo titulo, Contenido contenido) throws ExceptionDomini{

        Documento doc;
        doc = new Documento(autor,titulo,contenido,id,español,catalan,ingles); //arreglar
        try{    
            int pos = vecDocumentos.indexOf(doc);
            if (pos >= 0){
                throw new ExceptionDomini("El documento ya existe");
            }else{
                vecDocumentos.add(doc);
                ++id;
                ++numDocs;
            }
        } catch(ExceptionDomini e){
            System.out.println(e.getMessage());
        }
        vecDocumentos.print();
    }
    
    public void bajaDocumento(Autor autor, Titulo titulo, Contenido contenido) throws ExceptionDomini{

        Documento doc;
        doc = new Documento(autor,titulo,contenido,id,español,catalan,ingles); //arreglar + id
        try{    
            int pos = vecDocumentos.indexOf(doc);
            if (pos==-1){
                throw new ExceptionDomini("El documento no existe");
            }else{
                vecDocumentos.remove(pos);
                --numDocs;
            }
        } catch(ExceptionDomini e){
            System.out.println(e.getMessage());
        }
        vecDocumentos.print();
    }
    
    public void modificaAutorDoc(Autor autor, Titulo titulo, Contenido contenido, String autorModif) throws ExceptionDomini{

        Documento doc;
        doc = new Documento(autor,titulo,contenido,id,español,catalan,ingles); //arreglar + id
        try{    
            int pos = vecDocumentos.indexOf(doc);
            if (pos==-1){
                throw new ExceptionDomini("El documento no existe");
            }else{
                vecDocumentos.modificarAutor(doc);
            }
        } catch(ExceptionDomini e){
            System.out.println(e.getMessage());
        }
        vecDocumentos.print();
    }
    
    public void modificaTituloDoc(Autor autor, Titulo titulo, Contenido contenido, String TituloModif) throws ExceptionDomini{

        Documento doc;
        doc = new Documento(autor,titulo,contenido,id,español,catalan,ingles); //arreglar + id
        try{    
            int pos = vecDocumentos.indexOf(doc);
            if (pos==-1){
                throw new ExceptionDomini("El documento no existe");
            }else{
                vecDocumentos.modificarTitulo(doc);
            }
        } catch(ExceptionDomini e){
            System.out.println(e.getMessage());
        }
        vecDocumentos.print();
    }
    
    public void modificaContenidoDoc(Autor autor, Titulo titulo, Contenido contenido, String contenidoModif) throws ExceptionDomini{

        Documento doc;
        doc = new Documento(autor,titulo,contenido,id,español,catalan,ingles); //arreglar + id
        try{  
            int pos = vecDocumentos.indexOf(doc);
            if (pos==-1){
                throw new ExceptionDomini("El documento no existe");
            }else{
                vecDocumentos.modificarContenido(doc);
            }
        } catch(ExceptionDomini e){
            System.out.println(e.getMessage());
        }
        //vecDocumentos.print();
    }
   
}

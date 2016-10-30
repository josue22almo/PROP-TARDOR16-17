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
 * @author jessica.sobreviela
 */
public class CjtoDocumentos {
    private ArrayList<Documento> vecDocumentos;
    private int id;
    private int numDocs;
    
    public CjtoDocumentos() throws IOException, FileNotFoundException{
        vecDocumentos = new ArrayList<Documento>();
        id = 0;
        numDocs = 0;
    }
    
    public ArrayList<String> consultarTitulosAutor(String autor){
        
        ArrayList<String> titulos = new ArrayList<>();
        for (int i=0; i < vecDocumentos.size(); ++i){
            if (vecDocumentos.get(i).getAutor()==autor)
                titulos.add(vecDocumentos.get(i).getTitulo());
        }
        return titulos;
    }
    
    public ArrayList<String> consultarAutores(String prefijo){
        
        ArrayList<String> autores = new ArrayList<>();
        for (int i=0; i < vecDocumentos.size(); ++i){
            if (vecDocumentos.get(i).getAutor().contains(prefijo))
                autores.add(vecDocumentos.get(i).getAutor());
        }
        return autores;
    }
    
    public Contenido consultarContenido(String autor, String titulo){
        
        Contenido cont = new Contenido();
        for (int i=0; i < vecDocumentos.size(); ++i){
            if (vecDocumentos.get(i).getAutor()==autor && vecDocumentos.get(i).getTitulo()==titulo)
                cont = vecDocumentos.get(i).getContenido();
        }
        return cont;
    }
    
    public ArrayList<Documento> getDocumentosParecidosFrecs(String autor, String titulo, String k){
    
    }
    
    public ArrayList<Documento> getDocumentosParecidosTfDf(String autor, String titulo, String k){
        
    }
    
    public ArrayList<Documento> getDocumentosBool(ArrayList<String> frase){
        
    }
    
    
    public void altaDocumento (String autor, String titulo, String contenido) throws ExceptionDomini, IOException{

        Documento doc;
        doc = new Documento(autor,titulo,contenido,VariablesGlobales.id);
        try{    
            int pos = vecDocumentos.indexOf(doc);
            if (pos >= 0){
                throw new ExceptionDomini("El documento ya existe");
            }else{
                vecDocumentos.add(doc);
                ++VariablesGlobales.id;
                ++numDocs;
            }
        } catch(ExceptionDomini e){
            System.out.println(e.getMessage());
        }
    }
    
    public void bajaDocumento(String autor, String titulo) throws ExceptionDomini{

        try{    
            int pos = contiene(autor, titulo);
            if (pos==-1){
                throw new ExceptionDomini("El documento no existe");
            }else{
                vecDocumentos.remove(pos);
                --numDocs;
            }
        } catch(ExceptionDomini e){
            System.out.println(e.getMessage());
        }
    }
    
    public void modificaAutorDoc(String autor, String titulo, String autorModif) throws ExceptionDomini{

        try{    
            int pos = contiene(autor, titulo);
            if (pos==-1){
                throw new ExceptionDomini("El documento no existe");
            }else{
                vecDocumentos.get(pos).setAutor(autorModif);
            }
        } catch(ExceptionDomini e){
            System.out.println(e.getMessage());
        }
    }
    
    public void modificaTituloDoc(String autor, String titulo, String tituloModif) throws ExceptionDomini{

        try{    
            int pos = contiene(autor, titulo);
            if (pos==-1){
                throw new ExceptionDomini("El documento no existe");
            }else{
                vecDocumentos.get(pos).setTitulo(tituloModif);
            }
        } catch(ExceptionDomini e){
            System.out.println(e.getMessage());
        }
    }
    
    public void modificaContenidoDoc(String autor, String titulo, String contenido, String contenidoModif) throws ExceptionDomini{

        try{  
            int pos = contiene(autor, titulo);
            if (pos==-1){
                throw new ExceptionDomini("El documento no existe");
            }else{
                vecDocumentos.get(pos).setContenido(contenidoModif);
            }
        } catch(ExceptionDomini e){
            System.out.println(e.getMessage());
        }
    }
    
    private int contiene(String autor, String titulo) {
        
        for(int i=0; i<vecDocumentos.size(); i++){
            if (vecDocumentos.get(i).equals(autor, titulo)) return i;
        }
        return -1;
    }
    
    void print(){
        
        for(Documento doc : vecDocumentos){
            System.out.println(doc.getId() + " " + doc.getAutor() + " " + doc.getTitulo() + " " + doc.getContenido());
        }
        System.out.println("---------------------");
    }

    void getDocumentosBool(String abc__def) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
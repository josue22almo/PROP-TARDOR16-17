/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jessica.sobreviela
 */
public class CjtoDocumentos {
    
    private ArrayList<Documento> vecDocumentos; //para getDocumentosParecidos
    private class Autor_Titulo {
        String autor;
        String titulo;
    } 
    private Map<Autor_Titulo, String> vecDoc1; //para consultarContenido 
    private Map<String, ArrayList<String> > vecDoc2; //para consultarTitulosAutor i contiene
    private int numDocs;
    
    public CjtoDocumentos() {
        
        vecDocumentos = new ArrayList<>();
        Map<Autor_Titulo, String> vecDoc1 = new HashMap<>(); 
        Map<String, ArrayList<String> > vecDoc2 = new HashMap<>(); 
        numDocs = 0;
    }
    
      public void altaDocumento (String autor, String titulo, String contenido) throws Exception{

        Documento doc;
        doc = new Documento(autor,titulo,contenido);  
        int pos = vecDocumentos.indexOf(doc);
        if (pos >= 0){
            throw new Exception("El documento ya existe");
        }else{
           //Se da de alta en vecDocumentos
           vecDocumentos.add(doc);
           
           //Se da de alta en vecDoc1
           Autor_Titulo aux = new Autor_Titulo();
           aux.autor=autor;
           aux.titulo=titulo;
           vecDoc1.put(aux,contenido);
           
           //Se da de alta en vecDoc2
           ArrayList<String> titulos = vecDoc2.get(autor);
           titulos.add(titulo);
           vecDoc2.put(autor,titulos);
           ++numDocs;
        }
    }
    
    public void bajaDocumento(String autor, String titulo) throws Exception{

        if (!contiene(autor, titulo)){
            throw new Exception("El documento no existe");
        }else{
            //Se da de baja en vecDocumentos
            int pos = posicion(autor, titulo);
            vecDocumentos.remove(pos);
            
            //Se da de baja en vecDoc1
            Autor_Titulo aux = new Autor_Titulo();
            aux.autor=autor;
            aux.titulo=titulo;
            vecDoc1.remove(aux);
            
            //Se da de baja en vecDoc2
            ArrayList<String> titulos = vecDoc2.get(autor);
            titulos.remove(titulo);
            vecDoc2.put(autor,titulos);
            
            --numDocs;
        }
    }
    
    public void modificaAutorDoc(String autor, String titulo, String autorModif) throws Exception{

        if (!contiene(autor, titulo)){
            throw new Exception("El documento no existe");
        }else{
            //Se modifica en vecDocumentos
            int pos = posicion(autor, titulo);
            vecDocumentos.get(pos).setAutor(autorModif);
            
            //Se modifica en vecDoc1
            Autor_Titulo aux = new Autor_Titulo();
            aux.autor=autor;
            aux.titulo=titulo;
            String contenido = vecDoc1.get(aux);
            vecDoc1.remove(aux);
            Autor_Titulo aux2 = new Autor_Titulo();
            aux2.autor=autorModif;
            aux2.titulo=titulo;
            vecDoc1.put(aux2,contenido);
            
            //Se modifica en vecDoc2
            ArrayList<String> titulos = vecDoc2.get(autor);
            titulos.remove(titulo);
            vecDoc2.put(autor,titulos);
            
            ArrayList<String> titulos2 = vecDoc2.get(autorModif);
            titulos2.add(titulo);
            vecDoc2.put(autor,titulos2);
        }
    }
    
    public void modificaTituloDoc(String autor, String titulo, String tituloModif) throws Exception{

        if (!contiene(autor, titulo)){
            throw new Exception("El documento no existe");
        }else{
            //Se modifica en vecDocumentos
            int pos = posicion(autor, titulo);
            vecDocumentos.get(pos).setTitulo(tituloModif);
            
            //Se modifica en vecDoc1
            Autor_Titulo aux = new Autor_Titulo();
            aux.autor=autor;
            aux.titulo=titulo;
            String contenido = vecDoc1.get(aux);
            vecDoc1.remove(aux);
            Autor_Titulo aux2 = new Autor_Titulo();
            aux2.autor=autor;
            aux2.titulo=tituloModif;
            vecDoc1.put(aux2,contenido);
            
            //Se modifica en vecDoc2
            ArrayList<String> titulos = vecDoc2.get(autor);
            titulos.remove(titulo);
            titulos.add(tituloModif);
            vecDoc2.put(autor,titulos);
        }
    }
    
    public void modificaContenidoDoc(String autor, String titulo, String contenidoModif) throws Exception{

        if (!contiene(autor, titulo)){
            throw new Exception("El documento no existe");
        }else{
            //Se modifica en vecDocumentos
            int pos = posicion(autor, titulo);
            vecDocumentos.get(pos).setContenido(contenidoModif);
            
            //Se modifica en vecDoc1
            Autor_Titulo aux = new Autor_Titulo();
            aux.autor=autor;
            aux.titulo=titulo;
            vecDoc1.remove(aux);
            vecDoc1.put(aux,contenidoModif);
        }
    }
    
    public ArrayList<String> consultarTitulosAutor(String autor){
        
        /*ArrayList<String> titulos = new ArrayList<>();
        for (int i=0; i < vecDocumentos.size(); ++i){
            if (vecDocumentos.get(i).getAutor()==autor)
                titulos.add(vecDocumentos.get(i).getTitulo());
        }
        return titulos;*/
        return vecDoc2.get(autor);
    }
    
    public ArrayList<String> consultarAutores(String prefijo){
        
        ArrayList<String> autores = new ArrayList<>();
        for (int i=0; i < vecDocumentos.size(); ++i){
            if (vecDocumentos.get(i).getAutor().contains(prefijo)) //cambiar
                autores.add(vecDocumentos.get(i).getAutor());
        }
        return autores;
    }
    
    public String consultarContenido(String autor, String titulo){
        
        /*Contenido cont = new Contenido();
        for (int i=0; i < vecDocumentos.size(); ++i){
            if (vecDocumentos.get(i).getAutor()==autor && vecDocumentos.get(i).getTitulo()==titulo)
                cont = vecDocumentos.get(i).getContenido();
                break;
        }
        return cont;*/
        Autor_Titulo aux = new Autor_Titulo();
        aux.autor=autor;
        aux.titulo=titulo;
        return vecDoc1.get(aux);
    }
    
    public ArrayList<Documento> getDocumentosParecidosFrecs(String autor, String titulo, int k) throws Exception{
        
        ArrayList<Documento> v_docs =  new ArrayList<>(); 
        int pos = posicion(autor, titulo);
        if (pos==-1){
            throw new Exception("El documento no existe");
        }else{
            Documento origen = vecDocumentos.get(pos);
            //Se calcula la distancia de los otros documentos respecto al documento T
            for (int i = 0; i < vecDocumentos.size(); i++){
                if (i != pos) {
                    double dist = origen.getDistancia(vecDocumentos.get(i));
                    vecDocumentos.get(i).setDistancia(dist);
                }    
            }
            //v_docs=(ArrayList<Documento>) vecDocumentos.clone();
            //ordenar vecDocumentos segun su distancia (de menor a mayor)
            /*Collections.sort(vecDocumentos, new Comparator(){
                @Override
                public int compare(Documento doc1, Documento doc2) {
                   return new Integer(doc1.getDistancia()).compareTo(new Integer(doc2.getDistancia()));
                }
            });*/
        }
        //retornar solo los k primeros elementos
        if (vecDocumentos.size() < k)
            for (int i = 0; i < vecDocumentos.size(); ++i) v_docs.add(vecDocumentos.get(i));
        else 
            for (int i = 0; i < k; ++i) v_docs.add(vecDocumentos.get(i));
        return v_docs;
    }
    
    public ArrayList<Documento> getDocumentosParecidosTfDf(String autor, String titulo, Integer k){
        
        ArrayList<Documento> v_docs =  new ArrayList<>();
        
        
        
        return v_docs;
    }
    
    public ArrayList<Documento> getDocumentosBool(String frase){
        
        ArrayList<Documento> v_docs =  new ArrayList<>();
        
        
        
        return v_docs;
    }
    
    private int posicion(String autor, String titulo) {
        
        for(int i=0; i<vecDocumentos.size(); i++){
            if (vecDocumentos.get(i).equals(autor, titulo)) return i;
        }
        return -1;
    }
    
    private boolean contiene(String autor, String titulo){
        
        if (vecDoc2.containsKey(autor)){
            ArrayList<String> titulos = vecDoc2.get(autor);
            return titulos.contains(titulo);
        }
        return false;
    }
    
    public void print(){
        
        for(Documento doc : vecDocumentos){
            System.out.println( doc.getAutor() + " " + doc.getTitulo() + " " + doc.getContenido().getContenidoOriginal());
        }
    }
}
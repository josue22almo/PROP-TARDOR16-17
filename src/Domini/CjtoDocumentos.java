/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author jessica.sobreviela
 */
public class CjtoDocumentos {
	
    private ArrayList<Documento> vecDocumentos; //para getDocumentosParecidos
    private Map<String, String> vecDoc1; //para consultarContenido 
    private Map<String, ArrayList<String> > vecDoc2; //para consultarTitulosAutor, consultarAutores
                                                     // i contien
    private int numDocs;
    
    public CjtoDocumentos() {
        
        this.vecDocumentos = new ArrayList<>();
        this.vecDoc1 = new HashMap<>(); 
        this.vecDoc2 = new HashMap<>(); 
        this.numDocs = 0;
    }
    
    public void altaDocumento (String autor, String titulo, String contenido) throws Exception{
        Documento doc = new Documento(autor,titulo,contenido);
        if (existeDocumenteo(autor, titulo))
            throw new Exception("El documento ya existe"); 
        //Se da de alta en vecDocumentos
        altaVecDocumentos(doc);
        //Se da de alta en vecDoc1
        altaVecDoc1(autor,titulo,contenido);
        //Se da de alta en vecDoc2
        altaVecDoc2(autor,titulo);
        //Añadimos palabras al diccionario
        VariablesGlobales.diccionario.anadirPalabras(doc.getContenidoReducido());
        ++numDocs; //Documento nuevo
        //calculamos el peso de todos los documentos
        calcularTFiDFtodosLosDocumentos();
    }      
    
    public void bajaDocumento(String autor, String titulo) throws Exception{
        comprobarSiDocumentoExistente(autor,titulo);
        //Se da de baja en vecDocumentos y eliminamos las palabras de su contenido del diccionario
        bajaVecDocumentos(autor,titulo);
        //Se da de baja en vecDoc1, no funciona
        bajaVecDoc1(autor,titulo);
        //Se da de baja en vecDoc2
        bajaVecDoc2(autor,titulo);
        //Documento eliminado           
        --numDocs;
    }
    
    public void modificaAutorDoc(String autor, String titulo, String autorModif) throws Exception{
        comprobarSiDocumentoExistente(autor,titulo);
        //Se modifica en vecDocumentos       
        String at = autor + " " + titulo;
        String contenido = vecDoc1.get(at);
        bajaDocumento(autor,titulo);
        altaDocumento(autorModif,titulo,contenido);        
    }
    
    public void modificaTituloDoc(String autor, String titulo, String tituloModif) throws Exception{
        comprobarSiDocumentoExistente(autor,titulo);
        String at = autor + " " + titulo;
        String contenido = vecDoc1.get(at);
        bajaDocumento(autor,titulo);
        altaDocumento(autor,tituloModif,contenido);          
    }    
    
    public void modificaContenidoDoc(String autor, String titulo, String contenidoModif) throws Exception{
        comprobarSiDocumentoExistente(autor,titulo);
        bajaDocumento(autor,titulo);
        altaDocumento(autor,titulo,contenidoModif);   
    }
    
    public ArrayList<String> consultarTitulosAutor(String autor) throws Exception{
        if (vecDoc2.get(autor) == null)
        	throw new Exception("No existe el autor");
        return vecDoc2.get(autor);
    }
   
    public ArrayList<String> consultarAutoresPorPrefijo(String prefijo) throws Exception{
        
         return null;
    }
    
    public String consultarContenido(String autor, String titulo) throws Exception{
        comprobarSiDocumentoExistente(autor,titulo);
        String at = autor + " " + titulo;
        return vecDoc1.get(at);        
    }
   
    public ArrayList<Documento> getDocumentosParecidos(String autor, String titulo, int k, String type) throws Exception{
    	if (!type.equals("TF-IDF") && !type.equals("FREC"))
    		throw new Exception("El tipo que ha especificado no es válido. Ha de ser FREC o TF-IDF.");
        Map<Double,ArrayList<Documento>> docs;
        docs = new TreeMap<>();
        comprobarSiDocumentoExistente(autor,titulo);
        int pos = posicion(autor, titulo);        
        Documento origen = vecDocumentos.get(pos);
        //Se calcula la distancia de los otros documentos respecto al documento T
        for (int i = 0; i < vecDocumentos.size(); i++){
            if (i != pos) {
                double dist = origen.calcularDistancia(vecDocumentos.get(i),type);
                //añadimos al treemap la distancia y el documento y ya queda ordenado 
                if (!docs.containsKey(dist)) {// si en el map no hay documentos con distancia = dist
                    ArrayList<Documento> d = new ArrayList<>();
                    d.add(vecDocumentos.get(i));
                    docs.put(dist,d);
                }
                else {
                    ArrayList<Documento> d = docs.get(dist);
                    d.add(vecDocumentos.get(i));
                }
            }
        }
        
        //retornar solo los k primeros elementos
        ArrayList<Documento> v_docs = new ArrayList<>();
        Iterator it = docs.keySet().iterator();
        int aux = k;
        while(it.hasNext() && aux > 0){
            Double key = (Double) it.next();
            ArrayList<Documento> dd = docs.get(key);
            for (int i = 0; i< dd.size() && aux > 0; i++ ){
                v_docs.add(dd.get(i));
                --aux;
            }
        }
        return v_docs;
    }
    
    public ArrayList<Documento> getDocumentosBool(String frase) throws Exception{
        
        ArrayList<Documento> v_docs =  new ArrayList<>();
        
        
        
        return v_docs;
    }  
    
    public void print(){
        System.out.println("vecDocumentos es:");
        for(Documento doc : vecDocumentos){
            System.out.println("Autor: " + doc.getAutor() + " Titulo: " + doc.getTitulo() + " Contenido: " + doc.getContenidoOriginal());
        }
        System.out.println("vecDoc1 es:");
        for(String t : vecDoc1.keySet()){
            System.out.println("Autor y titulo: " + t + " Contenido: " + vecDoc1.get(t));
        }
        System.out.println("Titulos de autor:");
        for(String a : vecDoc2.keySet()){
            for (int i = 0; i < vecDoc2.get(a).size(); ++i)
                System.out.println("Autor: " + a + " Titulo: " + vecDoc2.get(a).get(i));
        }
    }
    
    private boolean empieza_por (String autor, String prefijo){
        int i = 0;
        while(i < autor.length()){
            boolean saltar = false;
            int j = 0;
            while (j < prefijo.length() && !saltar && i < autor.length()) {
                if (autor.charAt(i)==prefijo.charAt(j)){
                    ++i;
                    ++j;
                    if (prefijo.length()==j) return true;
                }
                else saltar=true;
            }
            while (saltar && i < autor.length()) {
                if (autor.charAt(i) == ' ') saltar=false;  
                ++i;
            }
        }
        return false;
    }

    private int posicion(String autor, String titulo) {
        
        for(int i=0; i<vecDocumentos.size(); i++){
            if (vecDocumentos.get(i).equals(autor, titulo)) return i;
        }
        return -1;
    }

    private void altaVecDocumentos(Documento doc) {
        vecDocumentos.add(doc);
    }
    
    private void altaVecDoc1(String autor, String titulo, String contenido) {
        String at = autor + " " + titulo;
        vecDoc1.put(at,contenido);
    }

    private void altaVecDoc2(String autor, String titulo) {
        if (vecDoc2.get(autor) == null) {  // si el autor no esta en el map
            ArrayList<String> titulos = new ArrayList<String>();
            titulos.add(titulo);
            vecDoc2.put(autor,titulos);
        }
        else {
            ArrayList<String> titulos = vecDoc2.get(autor);
            titulos.add(titulo);
        }
    }

    private void bajaVecDocumentos(String autor, String titulo) {
        int pos = posicion(autor, titulo);
        Documento doc = vecDocumentos.get(pos);
        VariablesGlobales.diccionario.eliminarPalabras(doc.getContenidoReducido());
        vecDocumentos.remove(pos);
    }

    private void bajaVecDoc1(String autor, String titulo) {
        String at = autor + " " + titulo;
        vecDoc1.remove(at);
    }

    private void bajaVecDoc2(String autor, String titulo) {
        ArrayList<String> titulos = vecDoc2.get(autor);
        titulos.remove(titulo);
        //if (titulos.size() == 0) vecDoc2.remove(autor);
    }
    
    private boolean existeDocumenteo(String autor, String titulo){        
        if (vecDoc2.containsKey(autor)){
            ArrayList<String> titulos = vecDoc2.get(autor);
            return titulos.contains(titulo);
        }
        return false;
    }

    private void calcularTFiDFtodosLosDocumentos() {
        for (Documento doc : vecDocumentos){
        	doc.calcularTFiDF(numDocs);
        }
    }

    private void comprobarSiDocumentoExistente(String autor, String titulo) throws Exception{
        if (!existeDocumenteo(autor, titulo))
            throw new Exception("El documento no existe"); 
    }
}
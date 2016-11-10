
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
    private Map<String, ArrayList<String> > vecDoc2; //para consultarTitulosAutor 
    private Trie triePrefijosAutor; //para consultarAutoresPorPrefijo
    private static Diccionario diccionario;
    private int numDocs; 
    
    public CjtoDocumentos() {        
        
        this.vecDocumentos = new ArrayList<>();
        this.vecDoc1 = new HashMap<>(); 
        this.vecDoc2 = new HashMap<>();
        this.triePrefijosAutor = new Trie();
        this.diccionario = new Diccionario();
        this.numDocs = 0;
    }
    
    public void altaDocumento (String autor, String titulo, String contenido) throws Exception {
        
        if (existeDocumento(autor, titulo))
            throw new Exception("El documento ya existe"); 
        
        if (vecDoc2.get(autor) == null)//no existe el autor, lo añadimos a nuestro trie
        	triePrefijosAutor.anadirPrefijo(autor);
        
        Documento doc = new Documento(autor,titulo,contenido);
        
        //Se da de alta en vecDocumentos
        altaVecDocumentos(doc);
        
        //Se da de alta en vecDoc1
        altaVecDoc1(autor,titulo,contenido);
        
        //Se da de alta en vecDoc2
        altaVecDoc2(autor,titulo);
        
        //Añadimos palabras al diccionario
        diccionario.anadirPalabras(doc.getContenidoReducido());
        
        //Un documento más
        ++numDocs;
        
        //calculamos el peso de todos los documentos
        calcularTFIDFtodosLosDocumentos();
    }      
    
    public void bajaDocumento(String autor, String titulo) throws Exception {
        
        comprobarSiDocumentoExiste(autor,titulo);
        
        //Se da de baja en vecDocumentos y eliminamos las palabras de su contenido del diccionario
        bajaVecDocumentos(autor,titulo);
        
        //Se da de baja en vecDoc1
        bajaVecDoc1(autor,titulo);
        
        //Se da de baja en vecDoc2
        bajaVecDoc2(autor,titulo);
        
        //Si después de eliminar el documento ya no existe el autor, lo eliminamos de nuestro trie:
        if (vecDoc2.get(autor) == null)
            triePrefijosAutor.eliminarPrefijo(autor);
        
        //Un documento menos
        --numDocs; 
        
        //calculamos el peso de todos los documentos
        calcularTFIDFtodosLosDocumentos();
    }
    
    public void modificaAutorDoc(String autor, String titulo, String autorModif) throws Exception {
        
        comprobarSiDocumentoExiste(autor,titulo);
        
        //Se modifica en vecDocumentos       
        String at = autor + " " + titulo;
        String contenido = vecDoc1.get(at);
        bajaDocumento(autor,titulo);
        altaDocumento(autorModif,titulo,contenido);        
    }
    
    public void modificaTituloDoc(String autor, String titulo, String tituloModif) throws Exception {
        
        comprobarSiDocumentoExiste(autor,titulo);
        
        //Se modifica en vecDocumentos  
        String at = autor + " " + titulo;
        String contenido = vecDoc1.get(at);
        bajaDocumento(autor,titulo);
        altaDocumento(autor,tituloModif,contenido);          
    }    
    
    public void modificaContenidoDoc(String autor, String titulo, String contenidoModif) throws Exception{
        
        comprobarSiDocumentoExiste(autor,titulo);
        bajaDocumento(autor,titulo);
        altaDocumento(autor,titulo,contenidoModif);   
    }
    
    public ArrayList<String> consultarTitulosAutor(String autor) throws Exception {
        
        if (vecDoc2.get(autor) == null)
        	throw new Exception("No existe el autor");
        return vecDoc2.get(autor);
    }
   
    public ArrayList<String> consultarAutoresPorPrefijo(String prefijo) throws Exception {
         
        return triePrefijosAutor.consultarListaDelPrefijo(prefijo);
    }
    
    public String consultarContenido(String autor, String titulo) throws Exception {
        
        comprobarSiDocumentoExiste(autor,titulo);
        
        String at = autor + " " + titulo;
        return vecDoc1.get(at);   
    }
   
    public ArrayList<Documento> getDocumentosParecidos(String autor, String titulo, int k, String type) throws Exception {
    	
        if (!type.equals("TF-IDF") && !type.equals("FREC"))
    		throw new Exception("El tipo que ha especificado no es válido. Ha de ser FREC o TF-IDF.");
        
        Map<Double,ArrayList<Documento>> docs;
        docs = new TreeMap<>();
        
        comprobarSiDocumentoExiste(autor,titulo);
        
        int pos = posicion(autor, titulo);        
        Documento origen = vecDocumentos.get(pos);
        
        //Se calcula la distancia de los otros documentos respecto al documento T
        for (int i = 0; i < vecDocumentos.size(); i++){
            if (i != pos) {
                double dist = origen.calcularDistancia(vecDocumentos.get(i),type);
                
                //Añadimos al TreeMap la distancia y el documento y ya queda ordenado 
                
                //Si en el map no hay documentos con distancia = dist:
                if (!docs.containsKey(dist)) {
                    ArrayList<Documento> d = new ArrayList<>();
                    d.add(vecDocumentos.get(i));
                    docs.put(dist,d);
                }
                //Si en el map ya hay documentos con distancia = dist:
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
            for (int i = 0; i < dd.size() && aux > 0; i++ ){
                v_docs.add(dd.get(i));
                --aux;
            }
        }
        return v_docs;
    }
    
    public ArrayList<Documento> getDocumentosBool(String frase) throws Exception {
        
        ArrayList<Documento> v_docs =  new ArrayList<>();
        
        
        
        return v_docs;
    }

    private int posicion(String autor, String titulo) {        
        
        for(int i = 0; i< vecDocumentos.size(); i++){
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
        
        //Si el autor no esta en el map:
        if (vecDoc2.get(autor) == null) {
            ArrayList<String> titulos = new ArrayList<String>();
            titulos.add(titulo);
            vecDoc2.put(autor,titulos);
        }
        //Si el autor ya esta en el map:
        else {
            ArrayList<String> titulos = vecDoc2.get(autor);
            titulos.add(titulo);
        }
    }

    private void bajaVecDocumentos(String autor, String titulo) {
        
        //Eliminamos las palabras no repetidas en otros documentos del diccionario
        int pos = posicion(autor, titulo);
        Documento doc = vecDocumentos.get(pos);
        diccionario.eliminarPalabras(doc.getContenidoReducido());
        
        vecDocumentos.remove(pos);
    }

    private void bajaVecDoc1(String autor, String titulo) {
        
        String at = autor + " " + titulo;
        vecDoc1.remove(at);
    }

    private void bajaVecDoc2(String autor, String titulo) {
        
        ArrayList<String> titulos = vecDoc2.get(autor);
        titulos.remove(titulo);
    }
    
    private boolean existeDocumento(String autor, String titulo) {        
        
        if (vecDoc2.containsKey(autor)){
            if (vecDoc2.get(autor) == null) return false;
            else {
                ArrayList<String> titulos = vecDoc2.get(autor);
                return titulos.contains(titulo);
            }
        }
        return false;
    }

    private void calcularTFIDFtodosLosDocumentos() {
       
        for (Documento doc : vecDocumentos){
        	doc.calcularTFIDF(numDocs,diccionario);
        }
    }

    private void comprobarSiDocumentoExiste(String autor, String titulo) throws Exception {
        
        if (!existeDocumento(autor, titulo))
            throw new Exception("El documento no existe");
    }
    
    public void print() {
        
        System.out.println("vecDocumentos es:");
        for(Documento doc : vecDocumentos){
            System.out.println("Autor: " + doc.getAutor() + " Titulo: " + doc.getTitulo() + " Contenido: " + doc.getContenidoOriginal());
        }
        System.out.println("vecDoc1 es:");
        for(String t : vecDoc1.keySet()){
            System.out.println("Autor y titulo: " + t + " Contenido: " + vecDoc1.get(t));
        }
        System.out.println("vecDoc2 es:");
        for(String a : vecDoc2.keySet()){
            for (int i = 0; i < vecDoc2.get(a).size(); ++i)
                System.out.println("Autor: " + a + " Titulo: " + vecDoc2.get(a).get(i));
        }
    }
}
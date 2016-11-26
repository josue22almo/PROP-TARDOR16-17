
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
    
    private Map <Integer, Documento> vecDocumentos; // Integer-> ID
    //private Map<String, String> vecDoc1; //para consultarContenido 
    //private Map<String, ArrayList<String> > vecDoc2; //para consultarTitulosAutor
    private ArrayList< TreeMap < ArrayList <Double> , Integer > > dists; // Double-> distancia, Integer->ID
    private Map<String, Map<String,Integer> > ids; // 1rString -> autor, 2nString -> titulo, Integer-> ID
    private Trie triePrefijosAutor; //para consultarAutoresPorPrefijo
    private static Diccionario diccionario;
    private int numDocs; 
    
    public CjtoDocumentos() {        
        this.ids = new HashMap<> ();
        this.vecDocumentos = new TreeMap<>();
        this.dists = new ArrayList<> ();
        //this.vecDoc1 = new HashMap<>(); 
        //this.vecDoc2 = new HashMap<>();
        this.triePrefijosAutor = new Trie();
        this.diccionario = new Diccionario();
        this.numDocs = 0;
    }
    
    public void altaDocumento (String autor, String titulo, String contenido) throws Exception {
        
        if (existeDocumento(autor, titulo))
            throw new Exception("El documento ya existe"); 
        
        //Calculamos el id
        int id;
        if (vecDocumentos == null) id = 1;
        else id = vecDocumentos.get(vecDocumentos.size()-1).getID();
        Documento doc = new Documento(id,autor,titulo,contenido);
        
        //Se da de alta en vecDocumentos
        vecDocumentos.put(id,doc);
        
        if (dists == null) {
            dists.add(id-1,null);
            //calcularDistancias();
        }
        else {
            /*for (int i = 0; i < dists.size(); i++) {
                TreeMap < ArrayList <Double>, Integer > d = new TreeMap<> ();
                dists.add(i, d);                   // en cada posicion del array vamos a tener que 
                                                   // recalcularlo todo, por eso "borramos" todo lo que habia
            }*/
            dists.add(id-1,null);
            
            //calcularTFIDFtodosLosDocumentos(id-1);
        }
        
        // Lo metemos en el map de IDs
        if (ids.containsKey(autor)) {
            Map<String,Integer> titulos_autor = ids.get(autor);
            titulos_autor.put(titulo, id);
        }
        else {
            Map<String,Integer> titulos_autor = new HashMap<>();
            titulos_autor.put(titulo,id);
            ids.put(autor, titulos_autor);
        }
        
        //Añadimos palabras al diccionario
        diccionario.anadirPalabras(doc.getContenidoReducido());
        
        /*if (vecDoc2.get(autor) == null)//no existe el autor, lo añadimos a nuestro trie
        	triePrefijosAutor.anadirPrefijo(autor);*/
        
        //Un documento más
        ++numDocs;
        
        //Calculamos todas las distancias de todos los documentos respecto a todos los otros
        calcularDistancias();
    }      
    
    public void bajaDocumento(String autor, String titulo) throws Exception {
        
        if (!existeDocumento(autor, titulo))
            throw new Exception("El documento no existe");
        
        //Eliminamos las palabras no repetidas en otros documentos del diccionario
        int id = ids.get(autor).get(titulo);
        Documento doc = vecDocumentos.get(id);
        diccionario.eliminarPalabras(doc.getContenidoReducido());
        //Finalmente se da de baja en vecDocumentos
        vecDocumentos.remove(id);
        
        //Se da de baja en ids
        Map <String, Integer> titulos_e_ids = ids.get(autor);
        titulos_e_ids.remove(titulo);
        if (!ids.containsKey(autor)) ids.remove(autor);
        
        //Si después de eliminar el documento ya no existe el autor, lo eliminamos de nuestro trie:
        /*if (vecDoc2.get(autor) == null)
            triePrefijosAutor.eliminarPrefijo(autor);*/
        
        //Un documento menos
        --numDocs; 
        
        //Calculamos todas las distancias de todos los documentos respecto a todos los otros
        calcularDistancias();
        
    }
    
    public void modificaAutorDoc(String autor, String titulo, String autorModif) throws Exception {
        
        if (!existeDocumento(autor, titulo))
            throw new Exception("El documento no existe");
         
        /*String at = autor + " " + titulo;
        String contenido = vecDoc1.get(at);
        bajaDocumento(autor,titulo);
        altaDocumento(autorModif,titulo,contenido);*/
        
        //Se modifica en vecDocumentos
        int id = ids.get(autor).get(titulo);
        vecDocumentos.get(id).setAutor(autorModif);
        
        //Se modifica en ids
        Map <String, Integer> titulos_e_ids_AnteriorAutor = ids.get(autor);
        
        if (ids.containsKey(autorModif)) {
            Map<String,Integer> titulos_e_ids_NuevoAutor = ids.get(autorModif);
            titulos_e_ids_NuevoAutor.put(titulo, id);
        }
        else {
            Map<String,Integer> titulos_e_ids_NuevoAutor = new HashMap<>();
            titulos_e_ids_NuevoAutor.put(titulo,id);
            ids.put(autor, titulos_e_ids_NuevoAutor);
        }
        titulos_e_ids_AnteriorAutor.remove(titulo);
    }
    
    public void modificaTituloDoc(String autor, String titulo, String tituloModif) throws Exception {
        
        if (!existeDocumento(autor, titulo))
            throw new Exception("El documento no existe");  
        
        /*String at = autor + " " + titulo;
        String contenido = vecDoc1.get(at);
        bajaDocumento(autor,titulo);
        altaDocumento(autor,tituloModif,contenido);*/
        
        //Se modifica en vecDocumentos
        int id = ids.get(autor).get(titulo);
        Documento doc = vecDocumentos.get(id);
        String contenido = doc.getContenidoOriginal();
        doc.setTitulo(tituloModif);
        
        //Se modifica en ids
        ids.get(autor).remove(titulo);
        ids.get(autor).put(tituloModif,id);
    }    
    
    public void modificaContenidoDoc(String autor, String titulo, String contenidoModif) throws Exception{
        
        if (!existeDocumento(autor, titulo))
            throw new Exception("El documento no existe");
        
        //bajaDocumento(autor,titulo);
        //altaDocumento(autor,titulo,contenidoModif); 
        
        int id = ids.get(autor).get(titulo);
        Documento doc = vecDocumentos.get(id);
        doc.setContenido(contenidoModif);
        calcularDistancias(); 
    }
    
    public ArrayList<String> consultarTitulosAutor(String autor) throws Exception {
        
        if (ids.get(autor) == null)
        	throw new Exception("No existe el autor");
        
        ArrayList<String> titulos = new ArrayList<>();
        Map<String,Integer> titulos_e_ids = ids.get(autor);
        
        Iterator it = titulos_e_ids.keySet().iterator();
        while(it.hasNext()){
            String ti = (String) it.next();
            titulos.add(ti);
        }
        return titulos;
    }
   
    public ArrayList<String> consultarAutoresPorPrefijo(String prefijo) throws Exception {
         
        return triePrefijosAutor.consultarListaDelPrefijo(prefijo);
    }
    
    public String consultarContenido(String autor, String titulo) throws Exception {
        
        if (!existeDocumento(autor, titulo))
            throw new Exception("El documento no existe");
        
        int id = ids.get(autor).get(titulo);
        Documento doc = vecDocumentos.get(id);
        return doc.getContenidoOriginal();
    }
   
    public ArrayList<Documento> getDocumentosParecidos(String autor, String titulo, int k, String type) throws Exception {
    	
        if (!type.equals("TF-IDF") && !type.equals("FREC"))
    		throw new Exception("El tipo que ha especificado no es válido. Ha de ser FREC o TF-IDF.");
        
        Map<Double,ArrayList<Documento>> docs;
        docs = new TreeMap<>();
        
        if (!existeDocumento(autor, titulo))
            throw new Exception("El documento no existe");
        
        int id = ids.get(autor).get(titulo);        
        Documento origen = vecDocumentos.get(id);
        
        /*//Se calcula la distancia de los otros documentos respecto al documento T
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
        }*/
        
        dists.get(i);
        
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
    
    public void calcularDistancias() {
        //Map<Double,ArrayList<Documento>> docs;
        //docs = new TreeMap<>();
        
        
        //int pos = posicion(autor, titulo);        
        //Documento origen = vecDocumentos.get(0);
        
        //Se calcula la distancia de todos los documentos respecto a todos los documentos
        for (int i = 0; i < vecDocumentos.size(); i++){
            for (int j = 0; j < vecDocumentos.size(); j++) {
                if (i != j) {
                    double distFrec = vecDocumentos.get(i).calcularDistancia(vecDocumentos.get(j),"FREC");
                    vecDocumentos.get(i).calcularTFIDF(numDocs, diccionario);
                    double distTfIDf = vecDocumentos.get(i).calcularDistancia(vecDocumentos.get(j),"TF-IDF");
                    int idDoc = vecDocumentos.get(i).getID();
                    ArrayList<Double> distancias= new ArrayList<> ();
                    distancias.add(distFrec);
                    distancias.add(distTfIDf);
                    dists.get(i).put(distancias, idDoc);
                }
            }
        }  
    }
    
    public boolean existeDocumento(String autor, String titulo) {                
        return (ids.containsKey(autor) && ids.get(autor).containsKey(titulo));
    }

    /*private int posicion(String autor, String titulo) {        
        
        for(int i = 0; i< vecDocumentos.size(); i++){
            if (vecDocumentos.get(i).equals(autor, titulo)) return i;
        }
        return -1;
    }*/

    /*private void altaVecDocumentos(Documento doc) {
      
        vecDocumentos.add(doc);
    }*/
    
    /*private void altaVecDoc1(String autor, String titulo, String contenido) {
        
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
    }*/

    /*private void bajaVecDocumentos(String autor, String titulo) {
        
        //Eliminamos las palabras no repetidas en otros documentos del diccionario
        int id = ids.get(autor).get(titulo);
        Documento doc = vecDocumentos.get(id);
        diccionario.eliminarPalabras(doc.getContenidoReducido());
        //Finalmente eliminamos el Documento de vecDocumentos
        vecDocumentos.remove(id);
    }*/

    /*private void bajaVecDoc1(String autor, String titulo) {
        
        String at = autor + " " + titulo;
        vecDoc1.remove(at);
    }

    private void bajaVecDoc2(String autor, String titulo) {
        
        ArrayList<String> titulos = vecDoc2.get(autor);
        titulos.remove(titulo);
    }*/
    

    /*private void calcularTFIDFtodosLosDocumentos(int ids) {
       
        for (Documento doc : vecDocumentos){
        	doc.calcularTFIDF(numDocs,diccionario);
        }
    }*/


    /*private void comprobarSiDocumentoExiste(String autor, String titulo) throws Exception {
        
        if (!existeDocumento(autor, titulo))
            throw new Exception("El documento no existe");
    }*/
    
    
    /*public void print() {
        
        System.out.println("vecDocumentos es:");
        for(Documento doc : vecDocumentos){
            System.out.println("Autor: " + doc.getAutor() + '\n'+ " Titulo: " + doc.getTitulo() + '\n' + " Contenido: " + doc.getContenidoOriginal());
        }
        System.out.println("vecDoc1 es:");
        for(String t : vecDoc1.keySet()){
            System.out.println("Autor y titulo: " + '\n' + t + " Contenido: " + vecDoc1.get(t));
        }
        System.out.println("vecDoc2 es:");
        for(String a : vecDoc2.keySet()){
            for (int i = 0; i < vecDoc2.get(a).size(); ++i)
                System.out.println("Autor: " + a + '\n'+ " Titulo: " + vecDoc2.get(a).get(i));
        }
    }*/
}
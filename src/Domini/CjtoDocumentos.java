
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
    private Map < Integer, TreeMap < Double , Integer > > distsFrec; // Double-> distancia, Integer->ID
    private Map < Integer, TreeMap < Double , Integer > > distsTFIDF;
    private Map < String, Map<String,Integer> > ids; // 1rString -> autor, 2nString -> titulo, Integer-> ID
    private Trie trie; //para consultarAutoresPorPrefijo
    private static Diccionario diccionario;
    private int numDocs;
    private int histDocs;
    
    public CjtoDocumentos() {      
        this.ids = new HashMap<> ();
        this.vecDocumentos = new TreeMap<>();
        this.distsFrec = new TreeMap<> ();
        this.distsTFIDF = new TreeMap<> ();
        this.trie = new Trie();
        this.diccionario = new Diccionario();
        this.numDocs = 0;
    }
    
    public void altaDocumento (String autor, String titulo, String contenido) throws Exception {
        
        if (existeDocumento(autor, titulo))
            throw new Exception("El documento ya existe"); 
        
        //Calculamos el id
        ++histDocs;
        int id = histDocs;
        Documento doc = new Documento(histDocs,autor,titulo,contenido);
       
        //Se da de alta en vecDocumentos
        Integer idInt = (Integer) id;
        vecDocumentos.put(idInt,doc);
        
        // Se añade en dists 
        distsFrec.put(id,new TreeMap<>());
        distsTFIDF.put(id,new TreeMap<>());
        
        // Lo metemos en el map de IDs
        if (ids.containsKey(autor)) {
            Integer id2 = (Integer) id;
            ids.get(autor).put(titulo, id2);
        }
        else {
            Map<String,Integer> titulos_autor = new HashMap<>();
            Integer id2 = (Integer) id;
            titulos_autor.put(titulo,id2);
            ids.put(autor, titulos_autor);

            //Si no existe el autor, lo añadimos a nuestro trie
            trie.añadirAutor(autor);
        }
        
        //Añadimos palabras al diccionario
        diccionario.anadirPalabras(doc.getContenidoReducido());
        
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
        
        //Si el autor ya no tiene documentos, se elimina
        if (ids.get(autor).isEmpty()){
            ids.remove(autor);
            
            //Lo eliminamos de nuestro trie:
            trie.eliminarAutor(autor);
        }
        
        //Un documento menos
        --numDocs; 
        
        //Calculamos todas las distancias de todos los documentos respecto a todos los otros
        calcularDistancias();
        
        /*//Recalculamos id's
            //en vecDocumentos
        for (int id_nou = id; id_nou < vecDocumentos.size(); id_nou++){
            Documento documento = vecDocumentos.get(id_nou);
            vecDocumentos.remove(id_nou);
            vecDocumentos.put(id_nou-1,documento);
        }
            //en ids
        Iterator it = ids.keySet().iterator();
        while(it.hasNext()){
            String aut = (String) it.next();
            Iterator it2 = ids.get(aut).keySet().iterator();
            while(it2.hasNext()){
                String tit = (String) it2.next();
                int id2 = ids.get(aut).get(tit);
                if (id2 > id){
                    ids.get(autor).remove(tit);
                    ids.get(aut).put(tit,id2-1);
                }
            }
        }*/
        
    }
    
    public void modificaAutorDoc(String autor, String titulo, String autorModif) throws Exception {
        
        if (!existeDocumento(autor, titulo))
            throw new Exception("El documento no existe");
        
        //Se modifica en vecDocumentos
        int id = ids.get(autor).get(titulo);
        vecDocumentos.get(id).setAutor(autorModif);
        
        //Se modifica en ids
        Map<String,Integer> titulos_e_ids_NuevoAutor;
        
        if (ids.containsKey(autorModif)) {
            titulos_e_ids_NuevoAutor = ids.get(autorModif);
            titulos_e_ids_NuevoAutor.put(titulo, id);
        }
        else {
            //Si no existe autorModif, lo añadimos a nuestro trie
            trie.añadirAutor(autorModif);
            
            titulos_e_ids_NuevoAutor = new HashMap<>();
            titulos_e_ids_NuevoAutor.put(titulo,id);
            ids.put(autorModif, titulos_e_ids_NuevoAutor);
        }
        Map <String, Integer> titulos_e_ids_AnteriorAutor = ids.get(autor);
        titulos_e_ids_AnteriorAutor.remove(titulo);
        
        //Si el autor anterior ya no tiene documentos, se elimina
        if (ids.get(autor).isEmpty()){
            ids.remove(autor);
            
            //Lo eliminamos de nuestro trie:
            trie.eliminarAutor(autor);
        }
    }
    
    public void modificaTituloDoc(String autor, String titulo, String tituloModif) throws Exception {
        
        if (!existeDocumento(autor, titulo))
            throw new Exception("El documento no existe");  
        
        //Se modifica en vecDocumentos
        int id = ids.get(autor).get(titulo);
        Documento doc = vecDocumentos.get(id);
        doc.setTitulo(tituloModif);
        
        //Se modifica en ids
        ids.get(autor).remove(titulo);
        ids.get(autor).put(tituloModif,id);
    }    
    
    public void modificaContenidoDoc(String autor, String titulo, String contenidoModif) throws Exception{
        
        if (!existeDocumento(autor, titulo))
            throw new Exception("El documento no existe");
        
        int id = ids.get(autor).get(titulo);
        Documento doc = vecDocumentos.get(id);
        doc.setContenido(contenidoModif);
        calcularDistancias(); 
    }
    
    public ArrayList<String> consultarTitulosAutor(String autor) throws Exception {
        
        if (!ids.containsKey(autor))
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
        
        return trie.consultarListaDelPrefijo(prefijo);
    }
    
    public String consultarContenido(String autor, String titulo) throws Exception {
        
        if (!existeDocumento(autor, titulo))
            throw new Exception("El documento no existe");
        
        int id = ids.get(autor).get(titulo);
        Documento doc = vecDocumentos.get(id);
        return doc.getContenidoOriginal();
    }
   
    public void calcularDistancias() {
        //Map<Double,ArrayList<Documento>> docs;
        //docs = new TreeMap<>();
        
        //Documento origen = vecDocumentos.get(0);
        
        //Se calcula la distancia de todos los documentos respecto a todos los documentos
        for (Integer doc1: vecDocumentos.keySet()){
            for (Integer doc2: vecDocumentos.keySet()) {
                if (doc1 != doc2) {
                    double distFrec = vecDocumentos.get(doc1).calcularDistancia(vecDocumentos.get(doc2),"FREC");
                    vecDocumentos.get(doc1).calcularTFIDF(numDocs, diccionario);
                    double distTfIDf = vecDocumentos.get(doc1).calcularDistancia(vecDocumentos.get(doc2),"TF-IDF");
                    //int idDoc = vecDocumentos.get(doc1).getID();
                    //int idDoc2 = vecDocumentos.get(doc2).getID();
                    distsFrec.get(doc1).put(distFrec, doc2);
                    distsTFIDF.get(doc1).put(distTfIDf, doc2);
                }
            }
        }  
    }
    
    public boolean existeDocumento(String autor, String titulo) {                
        return (ids.containsKey(autor) && ids.get(autor).containsKey(titulo));
    }

    public Map <Integer, Documento> getVecDocumentos(){
        return this.vecDocumentos;
    }
    
    public Map<Integer, TreeMap < Double , Integer > > getDistsFrec(){
        return this.distsFrec;
    }
    
    public Map<Integer, TreeMap < Double , Integer > > getDistsTFIDF(){
        return this.distsTFIDF;
    }    
    
    public Map<String, Map<String,Integer> > getIds(){
        return this.ids;
    }
    
    public Trie getTriePrefijosAutor(){
        return this.trie;
    }
    
    public int getNumDocs(){
        return this.numDocs;
    }   
}
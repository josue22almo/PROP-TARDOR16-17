
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
    private Map < Integer, TreeMap < Double , Integer > > distsFrec; // Double-> distancia, Integer->ID
    private Map < Integer, TreeMap < Double , Integer > > distsTFIDF;
    private Map < String, Map<String,Integer> > ids; // 1rString -> autor, 2nString -> titulo, Integer-> ID
    private Trie trie; //para consultarAutoresPorPrefijo
    private static Diccionario diccionario;
    private int numDocs; 
    
    public CjtoDocumentos() {        
        this.ids = new HashMap<> ();
        this.vecDocumentos = new TreeMap<>();
        this.distsFrec = new TreeMap<> ();
        this.distsTFIDF = new TreeMap<> ();
        //this.vecDoc1 = new HashMap<>(); 
        //this.vecDoc2 = new HashMap<>();
        this.trie = new Trie();
        this.diccionario = new Diccionario();
        this.numDocs = 0;
    }
    
    public void altaDocumento (String autor, String titulo, String contenido) throws Exception {
        
        if (existeDocumento(autor, titulo))
            throw new Exception("El documento ya existe"); 
        
        //Calculamos el id
        int id;
        if (vecDocumentos.isEmpty()) id = 1;
        else id = numDocs-1;
        Documento doc = new Documento(id,autor,titulo,contenido);
        
        //Si no existe el autor, lo añadimos a nuestro trie
        /*if (ids.get(autor) == null) {
            trie.añadirAutor(autor);
        }*/
        

        
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
            trie.añadirAutor(autor);
            Map<String,Integer> titulos_autor = new HashMap<>();
            Integer id2 = (Integer) id;
            titulos_autor.put(titulo,id2);
            ids.put(autor, titulos_autor);
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
        if (!ids.containsKey(autor)) ids.remove(autor);
        
        //Si después de eliminar el documento ya no existe el autor, lo eliminamos de nuestro trie:
        if (ids.get(autor) == null) trie.eliminarAutor(autor);
        
        //Un documento menos
        --numDocs; 
        
        //Calculamos todas las distancias de todos los documentos respecto a todos los otros
        calcularDistancias();
        
        //Recalculamos id's
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
        }
        
    }
    
    public void modificaAutorDoc(String autor, String titulo, String autorModif) throws Exception {
        
        if (!existeDocumento(autor, titulo))
            throw new Exception("El documento no existe");
         
        /*String at = autor + " " + titulo;
        String contenido = vecDoc1.get(at);
        bajaDocumento(autor,titulo);
        altaDocumento(autorModif,titulo,contenido);*/
        
        //Si no existe autorModif, lo añadimos a nuestro trie
        if (ids.get(autorModif) == null) trie.añadirAutor(autorModif);
        
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
        
        //Si despúes de eliminar autor ya no existe, lo eliminamos de nuestro trie
        if (ids.get(autor) == null) trie.eliminarAutor(autor);
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
                    int idDoc2 = vecDocumentos.get(j).getID();
                    distsFrec.get(idDoc).put(distFrec, idDoc2);
                    distsTFIDF.get(idDoc).put(distTfIDf, idDoc2);
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

    /*private void bajaVecDoc1(String autor, String titulo) {
        
        String at = autor + " " + titulo;
        vecDoc1.remove(at);
    }

    private void bajaVecDoc2(String autor, String titulo) {
        
        ArrayList<String> titulos = vecDoc2.get(autor);
        titulos.remove(titulo);
    }*/ 
    
    
    
}
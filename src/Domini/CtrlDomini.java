package Domini;

import Persistencia.CtrlPersistencia;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
/**
 *
 * @author florencia.rimolo
 */
public class CtrlDomini {
    
    private CtrlPersistencia ctrlPersistencia = new CtrlPersistencia();
    private CjtoDocumentos cd = new CjtoDocumentos();
    public static ArrayList<String> espanol;
    public static ArrayList<String> catalan;
    public static ArrayList<String> ingles;
    public CtrlDomini () throws IOException {
        espanol = ctrlPersistencia.leerPalabrasFuncionales("src/Texto/sp.txt");
        catalan = ctrlPersistencia.leerPalabrasFuncionales("src/Texto/cat.txt");
        ingles = ctrlPersistencia.leerPalabrasFuncionales("src/Texto/eng.txt");
    }
  
    public void altaConjuntoDocumentosDirectorio(String folder) throws Exception{       
        
        ArrayList<BufferedReader> docs = ctrlPersistencia.leerCarpeta(folder);
        for (int i = 0; i < docs.size(); ++i){
            String autor = docs.get(i).readLine();
            docs.get(i).readLine();
            String titulo = docs.get(i).readLine();
            docs.get(i).readLine();
            String contenido = "";
            String aux;                
            while ((aux = docs.get(i).readLine()) != null){
                contenido += aux;
                contenido += '\n';
            }
            cd.altaDocumento(autor, titulo, contenido);
        }
    }
    
    public void altaDocumento(String autor, String titulo, String contenido) throws Exception {
        
        cd.altaDocumento(autor, titulo, contenido);
    }
    
    public void bajaDocumento(String autor, String titulo) throws Exception {
        
        cd.bajaDocumento(autor, titulo);
    }
    
    public void modificaAutorDoc(String autor, String titulo, String autorModif) throws Exception{
        
        cd.modificaAutorDoc(autor, titulo, autorModif);
    }
    
    public void modificaTituloDoc(String autor, String titulo, String tituloModif) throws Exception{
        
        cd.modificaTituloDoc(autor, titulo, tituloModif);
    }
    
    public void modificaContenidoDoc(String autor, String titulo, String contenidoModif) throws Exception{
        
        cd.modificaContenidoDoc(autor, titulo, contenidoModif);
    }
    
    public ArrayList<String> consultarTitulosAutor(String autor) throws Exception{
        
        return cd.consultarTitulosAutor(autor);        
    }
    
    public String consultarContenido(String autor, String titulo) throws Exception{
        
        return cd.consultarContenido(autor, titulo);
    }
    
    public Map<String,String> getDocumentosParecidos(String autor, String titulo, int k, String type) throws Exception {
        
        if (!type.equals("TF-IDF") && !type.equals("FREC"))
            throw new Exception("El tipo que ha especificado no es válido. Ha de ser FREC o TF-IDF.");
        
        if (!cd.existeDocumento(autor, titulo))
            throw new Exception("El documento no existe.");
        
        // Cogemos el id que corresponde a este autor y titulo
        int id = cd.getIds().get(autor).get(titulo); 
                                                        
        // Cogemos el map con las distancias respecto al documento con id = id
        Map < Double, Integer > docs;
        Map < String, String > m = new TreeMap<>();
        if ("FREC".equals(type)) {
            docs = cd.getDistsFrec().get(id);
        }
        else {
            docs = cd.getDistsTFIDF().get(id);
        }
        //Retornar solo los k primeros elementos
        Map < Integer, Documento > vecDocumentos = cd.getVecDocumentos();
        Iterator it = docs.keySet().iterator();
        int aux = 0;
        while(it.hasNext() && aux < k){
            Double key = (Double) it.next();
            Documento doc = vecDocumentos.get(docs.get(key));
            m.put(doc.getAutor(),doc.getTitulo());
            ++aux;
        } 
        return m;
    }
    
    public ArrayList<String> consultarAutoresPorPrefijo(String prefijo) throws Exception{
         
        return cd.consultarAutoresPorPrefijo(prefijo);
    }
    
    public Map<String,String> getDocumentosBool(String expresion) throws Exception{
        
        Map<String,String> result = new HashMap<>();
        BooleanTree tree = new BooleanTree(expresion);
        Map <Integer, Documento> m = cd.getVecDocumentos();
        for (Integer id : m.keySet()) {
            Documento d = m.get(id);
            if (tree.satisfyExpression(d)) result.put(d.getAutor(),d.getTitulo());
        }
        return result;
    }
    
    public CjtoDocumentos getCjtoDocumentos(){
        
        return cd;
    }
    
}

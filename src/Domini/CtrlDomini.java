package Domini;

import Persistencia.CtrlPersistencia;
import java.io.BufferedReader;
import java.io.File;
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
    
    private CtrlPersistencia ctrlPersistencia;
    private CjtoDocumentos cd = new CjtoDocumentos();
    public static ArrayList<String> espanol;
    public static ArrayList<String> catalan;
    public static ArrayList<String> ingles;
    
    public CtrlDomini (String ruta) throws Exception {
        espanol = ctrlPersistencia.leerPalabrasFuncionales("src/Texto/sp.txt");
        catalan = ctrlPersistencia.leerPalabrasFuncionales("src/Texto/cat.txt");
        ingles = ctrlPersistencia.leerPalabrasFuncionales("src/Texto/eng.txt");
        this.ctrlPersistencia = new CtrlPersistencia(ruta);
        cargarDocumentos();
    }
  
    public void altaConjuntoDocumentosDirectorio(String folder) throws Exception {    
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
    
    public void altaDocumentoPorRuta(File archivo) throws Exception {
        BufferedReader doc = ctrlPersistencia.leerDocumento(archivo);
            String autor = doc.readLine();
            doc.readLine();
            String titulo = doc.readLine();
            doc.readLine();
            String contenido = "";
            String aux;                
            while ((aux = doc.readLine()) != null){
                contenido += aux;
                contenido += '\n';
            }
            cd.altaDocumento(autor, titulo, contenido);        
    }
    
    public void altaDocumento(String autor, String titulo, String contenido) throws Exception {
        
        cd.altaDocumento(autor, titulo, contenido);
    }
    
    public void bajaDocumento(String autor, String titulo) {
        
        cd.bajaDocumento(autor, titulo);
    }
    
    public void modificaAutorDoc(String autor, String titulo, String autorModif) {
        
        cd.modificaAutorDoc(autor, titulo, autorModif);
    }
    
    public void modificaTituloDoc(String autor, String titulo, String tituloModif) {
        
        cd.modificaTituloDoc(autor, titulo, tituloModif);
    }
    
    public void modificaContenidoDoc(String autor, String titulo, String contenidoModif) {        
        cd.modificaContenidoDoc(autor, titulo, contenidoModif);
    }
    
    public ArrayList<String> consultarTitulosAutor(String autor) throws Exception {        
        return cd.consultarTitulosAutor(autor);        
    }
    
    public String consultarContenido(String autor, String titulo) {        
        return cd.consultarContenido(autor, titulo);
    }
    
    public ArrayList<String> consultarAutoresPorPrefijo(String prefijo) throws Exception{
         
        return cd.consultarAutoresPorPrefijo(prefijo);
    }
    
    public Map<String,ArrayList<String>> getDocumentosParecidos(String autor, String titulo, int k, String type) throws Exception {
        
        /*if (!type.equals("TF-IDF") && !type.equals("FREC"))
            throw new Exception("El tipo que ha especificado no es válido. Ha de ser FREC o TF-IDF.");
        
        if (!cd.existeDocumento(autor, titulo))
            throw new Exception("El documento no existe.");*/
        
        // Cogemos el id que corresponde a este autor y titulo
        int id = cd.getIds().get(autor).get(titulo); 
                                                        
        // Cogemos el map con las distancias respecto al documento con id = id
        Map < Double, ArrayList<Integer> > docs;
        Map < String, ArrayList<String> > m = new TreeMap<>();
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
        while(it.hasNext() && aux <= k){
            Double key = (Double) it.next();
            /*Documento doc = vecDocumentos.get(docs.get(key));
            m.put(doc.getAutor(),doc.getTitulo());
            ++aux;*/
            ArrayList <Integer> d = docs.get(key);
            for (int i = 0; i < d.size() && aux < k; ++i){
                Integer j = d.get(i);
                Documento doc = vecDocumentos.get(j);
                ArrayList<String> tit;
                if (m.containsKey(doc.getAutor())){
                    tit = m.get(autor);
                    tit.add(doc.getTitulo());
                }
                else {
                    tit = new ArrayList<>();
                    tit.add(doc.getTitulo());
                    m.put(doc.getAutor(),tit);   
                }
                ++aux;
            }
        }
        if (m.isEmpty()) throw new Exception("No hay ningún documento que cumpla los requisitos especificados.");
        return m;
    }
    
    public Map<String,String> getDocumentosBool(String expresion) throws Exception{
        
        Map<String,String> result = new HashMap<>();
        BooleanTree tree = new BooleanTree(expresion);
        Map <Integer, Documento> m = cd.getVecDocumentos();
        for (Integer id : m.keySet()) {
            Documento d = m.get(id);
            boolean b = tree.satisfyExpression(d);
            if (b) 
                result.put(d.getAutor(),d.getTitulo());
        }
        if (m.isEmpty()) throw new Exception("No hay ningún documento que cumpla la expresión");
        return result;
    }
    
    public CjtoDocumentos getCjtoDocumentos(){        
        return cd;
    }
    
    public void guardarDocumentos() throws IOException{
        Map <Integer, Documento> vecDocumentos = cd.getVecDocumentos();
        boolean first = true;
        for (Integer key : vecDocumentos.keySet()){
            Documento doc = vecDocumentos.get(key);
            String autor = doc.getAutor();
            String titulo = doc.getTitulo();
            String contenido = doc.getContenidoOriginal();
            ctrlPersistencia.guardarDocumento(autor, titulo, contenido);
            first = false;
        }
    }
    
    private void cargarDocumentos() throws IOException, Exception{
        ArrayList<BufferedReader> docs = ctrlPersistencia.leerCarpeta("Datos");
        for (int i = 0; i < docs.size(); ++i){
            String autor = docs.get(i).readLine();
            String titulo = docs.get(i).readLine();
            String contenido = "";
            String aux;                
            while ((aux = docs.get(i).readLine()) != null){
                contenido += aux;
                contenido += '\n';
            }
            cd.altaDocumento(autor, titulo, contenido);
        }
    }
}

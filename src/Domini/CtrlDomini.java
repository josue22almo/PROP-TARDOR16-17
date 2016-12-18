package Domini;

import Persistencia.CtrlPersistencia;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
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
        ctrlPersistencia  = new CtrlPersistencia(ruta);
        espanol = ctrlPersistencia.leerPalabrasFuncionales("src/Texto/sp.txt");
        catalan = ctrlPersistencia.leerPalabrasFuncionales("src/Texto/cat.txt");
        ingles = ctrlPersistencia.leerPalabrasFuncionales("src/Texto/eng.txt");
    }
  
    public void altaConjuntoDocumentosDirectorio(String folder, boolean guardar) throws Exception{    
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
            if (!this.cd.existeDocumento(autor, titulo)) {
            cd.altaDocumento(autor, titulo, contenido);
            if (guardar) ctrlPersistencia.guardarDocumento(autor, titulo, contenido);
            }
        }
    }
    
    public void altaDocumentoPorRuta(File archivo, boolean guardar) throws Exception {
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
            if (guardar) {
                ctrlPersistencia.guardarDocumento(autor, titulo, contenido);
            }
    }
    
    public void bajaDocumento(String autor, String titulo) throws Exception {
        cd.bajaDocumento(autor, titulo);
        ctrlPersistencia.eliminarDocumento(autor, titulo);
    }
    
    public void modificaAutorDoc(String autor, String titulo, String autorModif) throws IOException, Exception {
        String contenido = cd.consultarContenido(autor, titulo);
        cd.modificaAutorDoc(autor, titulo, autorModif);
        ctrlPersistencia.eliminarDocumento(autor, titulo);
        ctrlPersistencia.guardarDocumento(autorModif, titulo, contenido);
    }
    
    public void modificaTituloDoc(String autor, String titulo, String tituloModif) throws IOException, Exception {
        String contenido = cd.consultarContenido(autor, titulo);
        cd.modificaTituloDoc(autor, titulo, tituloModif);
        ctrlPersistencia.eliminarDocumento(autor, titulo);
        ctrlPersistencia.guardarDocumento(autor, tituloModif, contenido);
    }
    
    public void modificaContenidoDoc(String autor, String titulo, String contenidoModif) throws IOException, Exception {        
        cd.modificaContenidoDoc(autor, titulo, contenidoModif);
        ctrlPersistencia.eliminarDocumento(autor, titulo);
        ctrlPersistencia.guardarDocumento(autor, titulo, contenidoModif);
    }
    
    public ArrayList<String> consultarTitulosAutor(String autor) {        
        return cd.consultarTitulosAutor(autor);        
    }
    
    public String consultarContenido(String autor, String titulo) throws Exception {        
        return cd.consultarContenido(autor, titulo);
    }
    
    public ArrayList<String> consultarAutoresPorPrefijo(String prefijo) throws Exception{
        return cd.consultarAutoresPorPrefijo(prefijo);
    }
    
    public ArrayList<String> getDocumentosParecidos(String autor, String titulo, int k, String type) throws Exception {
        // Cogemos el id que corresponde a este autor y titulo
        if (!this.cd.existeDocumento(autor, titulo)) throw new Exception("El documento seleccionado no existe");
        int id = cd.getIds().get(autor).get(titulo); 
                                                        
        // Cogemos el map con las distancias respecto al documento con id = id
        Map < Double, ArrayList<Integer> > docs;
        ArrayList<String> m = new ArrayList<>();
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
            ArrayList <Integer> d = docs.get(key);
            for (int i = 0; i < d.size() && aux < k; ++i){
                Integer j = d.get(i);
                Documento doc = vecDocumentos.get(j);
                m.add("Autor: " + doc.getAutor() + ". Titulo: " + doc.getTitulo() + "." + "\n");
                ++aux;
            }
        }
        if (m.isEmpty()) throw new Exception("No hay ningún documento que cumpla los requisitos especificados.");
        return m;
    }
    
    public ArrayList<String> getDocumentosBool(String expresion) throws Exception{
        
        ArrayList<String> result = new ArrayList<>();
        BooleanTree tree = new BooleanTree(expresion);
        Map <Integer, Documento> m = cd.getVecDocumentos();
        for (Integer id : m.keySet()) {
            Documento d = m.get(id);
            boolean b = tree.satisfyExpression(d);
            if (b) 
                result.add("Autor: " + d.getAutor() + ". Titulo: " + d.getTitulo() + "." + "\n");
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

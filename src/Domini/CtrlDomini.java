package Domini;

import Persistencia.CtrlPersistencia;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author florencia.rimolo
 */
public class CtrlDomini {
    
    private CtrlPersistencia ctrlPersistencia = new CtrlPersistencia();
    private CjtoDocumentos cd = new CjtoDocumentos();
    
    public CtrlDomini(){}
    
    public void altarConjuntoDocumentos (String path) throws Exception{
        ArrayList<BufferedReader> docs = ctrlPersistencia.leerCarpeta(path);
        for (int i = 0; i < docs.size(); ++i){
                String autor = docs.get(i).readLine();
                String titulo = docs.get(i).readLine();
                String contenido = "";
                String aux;                
                 while ((aux = docs.get(i).readLine()) != null){
                    contenido += aux;
                    contenido += '\n';
                }
                System.out.println(autor + '\n' + titulo + "\n" + contenido);
            }
    }
    
    public void altaConjuntoDocumentosDirectorio(String folder) throws Exception{
        ArrayList<BufferedReader> docs = ctrlPersistencia.leerCarpeta(folder);        
        for (int i = 0; i < docs.size();++i){
            BufferedReader b = docs.get(i);
            String autor = b.readLine();
            String titulo = b.readLine();
            String contenido = "";
            while((contenido = b.readLine())!=null) {
                System.out.println(contenido);
             }
            cd.altaDocumento(autor, titulo, contenido);
            b.close();
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
    
    public ArrayList<String> consultarAutores(String prefijo) throws Exception{
        return cd.consultarAutoresPorPrefijo(prefijo);
    }
    
    public String consultarContenido(String autor, String titulo) throws Exception{
        return cd.consultarContenido(autor, titulo);
    }
    
    public Map<String,String> getDocumentosParecidos(String autor, String titulo, int k, String type) throws Exception{
        Map<String,String> m = new HashMap<>();
        ArrayList <Documento> l = cd.getDocumentosParecidos(autor, titulo, k,type);
        for (Documento d : l)
            m.put(d.getAutor(),d.getTitulo());
        return m;
    }
    
    public ArrayList<String> consultarAutoresPorPrefijo(String prefijo) throws Exception{
         return cd.consultarAutoresPorPrefijo(prefijo);
    }
    
    public Map<String,String> getDocumentosBool(String frase) throws Exception{
        Map<String,String> m = new HashMap<>();
        ArrayList <Documento> l = cd.getDocumentosBool(frase);
        for (Documento d : l)
            m.put(d.getAutor(),d.getTitulo());
        return m;
    }
    
    public void print(){        
        cd.print();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

/**
 *
 * @author jessica
 */
public class MapDoc extends HashMap{
    private Map <Autor, ArrayList<Documento>> mapDocumentos;
    public MapDoc() {
        mapDocumentos= new HashMap<>();
    }
    
    public boolean containsKey(Autor autor) {
        Iterator it = mapDocumentos.keySet().iterator();
        while(it.hasNext()){
            Autor key = it.next();
        }
        return false;
    }
    
    public ArrayList<Documento> getDocumentos(Autor autor){
        return mapDocumentos.get(autor);
    }
    
    public boolean containsValue(Documento doc){
        ArrayList<Documento> documentos = getDocumentos(doc.getAutor());
        if (documentos== null) return false;
        for (int i = 0; i < documentos.size(); ++i){
            if (documentos.get(i).equals(doc)) return true;
        }
        return false;
    }
    
    public void addAutorDocumento(Autor autor, Documento doc){
        ArrayList<Documento> docs = new ArrayList<>();
        docs.add(doc);
        mapDocumentos.put(doc.getAutor(), docs);
    }

    public void addDocumento(Autor autor, Documento doc) {
        mapDocumentos.get(autor).add(doc);
    }
    
}

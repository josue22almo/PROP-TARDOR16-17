
package Domini;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
/**
 *
 * @author josue.inaldo.alcantara
 */
public class Trie {
    private Map <String,ArrayList<String>> trie = new TreeMap<>();
    
    public Trie(){}
    
    public void anadirPrefijo(String prefijo){
        for (int i = 0; i < prefijo.length(); ++i){
            String subPrefijo = prefijo.substring(0, i);
            if (trie.get(subPrefijo) == null) {  
                ArrayList<String> titulos = new ArrayList<>();
                titulos.add(prefijo);
                trie.put(subPrefijo,titulos);
            }
            else {
                ArrayList<String> titulos = trie.get(subPrefijo);
                titulos.add(prefijo);
            }
        }
    }
    
    public void eliminarPrefijo(String prefijo){
        for (int i = 0; i < prefijo.length(); ++i){
            String subPrefijo = prefijo.substring(0, i);
            ArrayList<String> list = trie.get(subPrefijo);
            list.remove(prefijo);
        }
    }
    
    public ArrayList<String> consultarListaDelPrefijo(String prefijo) throws Exception{
        if (trie.get(prefijo) != null) 
            return trie.get(prefijo);
        else throw new Exception("No existen autores con el prefijo " + prefijo +  " prefijo");
    }
    
    public void print(){
        for (String key : trie.keySet()){
            System.out.println("El prefijo " + key + " contiene:");
            for (int i=0; i < trie.get(key).size(); ++i){
                System.out.println(trie.get(key).get(i));
            } 
            System.out.println();
            System.out.println();
        }
    }
}


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
        if (trie.get(prefijo) == null) {  
                ArrayList<String> titulos = new ArrayList<>();
                titulos.add(prefijo);
                trie.put(prefijo,titulos);
            }
            else {
                ArrayList<String> titulos = trie.get(prefijo);
                titulos.add(prefijo);
            }
    }
    
    public void eliminarPrefijo(String prefijo){
        for (int i = 0; i < prefijo.length(); ++i){
            String subPrefijo = prefijo.substring(0, i);
            ArrayList<String> list = trie.get(subPrefijo);
            list.remove(prefijo);
            if (list.isEmpty()) trie.remove(subPrefijo);
        }
        trie.remove(prefijo);
    }
    
    public ArrayList<String> consultarListaDelPrefijo(String prefijo) throws Exception{
        if (trie.containsKey(prefijo)) 
            return  trie.get(prefijo);
        throw new Exception("No existen autores con el prefijo " + prefijo +  " prefijo");
    }
    
    public void print(){
        if (trie.isEmpty()) 
            System.out.println("El trie está vacío");
        else{
            for (String key : trie.keySet()){
                System.out.println("El prefijo " + key + " tiene ");
                for (int i=0; i < trie.get(key).size(); ++i){
                    System.out.println(trie.get(key).get(i));
                } 
            }
        }
    }
}


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
    
    public void añadirPrefijo(String prefijo){
        for (int i = 0; i < prefijo.length() -1; ++i){
            String subPrefijo = prefijo.substring(0, i+1);
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
        System.out.println(prefijo.length());
        for (int i = 0; i < prefijo.length()-1; ++i){
            String subPrefijo = prefijo.substring(0, i+1);
            trie.remove(subPrefijo);
        }
    }
    
    public ArrayList<String> consultarListaDelPrefijo(String prefijo) throws Exception{
        if (trie.get(prefijo) != null) 
            return trie.get(prefijo);
        else throw new Exception("No existe el prefijo");
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


package Domini;

import java.util.TreeMap;
import java.util.Map;

/**
 *
 * @author josue.inaldo.alcantara
 */
public class Diccionario {
    private Map <String,Integer> diccionario = new TreeMap<>();

    public Diccionario() {}
    
    public void anadirPalabras(Map<String,Palabra> v){
        for (String key : v.keySet()){
            if (diccionario.containsKey(key)){
                Integer c = diccionario.get(key) + 1;
                diccionario.put(key, c);  
            }else{
                Integer c = 1;
                diccionario.put(key, c);  
            }
        }
    }
    
    public void eliminarPalabras(Map<String,Palabra> v){
        for (String key : v.keySet()){
            if (diccionario.containsKey(key)){
                Integer c = diccionario.get(key) - 1;
                if (c.equals(0))
                    diccionario.remove(key);
                else
                    diccionario.put(key, c);  
            }
        }
    }
    
    public int getNumAparicionesPalabra(String key){
    	return diccionario.get(key);
    }
    
    void print() {
        System.out.println("Tamaño del diccionario " + diccionario.size());
        for (String key : diccionario.keySet())
            System.out.println(key + " aparece en " + diccionario.get(key));
    }
}
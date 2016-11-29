
package Domini;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
/**
 *
 * @author jessica.sobreviela
 */
public class Trie {
    private Map <String,ArrayList<String>> trie;
    private Nodo raiz;
    
    public Trie(){
        this.trie = new TreeMap<>();
        this.raiz = new Nodo(null);
    }
    
    public void añadirAutor(String autor) {
        Nodo n = raiz;
        for(int i=0; i < autor.length(); i++) {
            char c = autor.charAt(i);
            Nodo sub = n.getHijo(c);
            if (sub != null) n = sub;
            else {
                //if (i == autor.length()-1) n.añadeHijoSinMap(c, n);
                //else 
                n.añadeHijo(c, new Nodo(n));
                n = n.getHijo(c);
            }
            if (i == autor.length()-1) n.setFi(true);
        }
    }
    
    public void eliminarAutor(String autor){
        Nodo n = raiz;
        boolean aux = false, acabado = false;
        Nodo aux_padre = n;
        char aux_c = autor.charAt(0);
        for(int i=0; i < autor.length() && !acabado; i++) {
            char c = autor.charAt(i);
            Nodo sub = n.getHijo(c);
            if (sub != null){
                if (sub.getFi() && i == autor.length()-1) {
                    acabado=true;
                }
                else if (!sub.getFi() && i == autor.length()-1){
                    aux_padre.eliminarHijo(aux_c);
                    acabado = true;
                }
                else if (sub.getFi()){
                    aux_padre = n;
                    aux_c = c;
                    n = sub;
                }
            }
            else n.eliminarHijo(c);
        }
    }
 
    public ArrayList<String> consultarListaDelPrefijo(String prefijo) {
        ArrayList<String> aux = new ArrayList<>();
        Nodo n = raiz;
        for(int i=0; i < prefijo.length(); i++) {
            char c = prefijo.charAt(i);
            Nodo sub = n.getHijo(c);
            if (sub == null) return null;
            else if (i == prefijo.length()-1) aux = consultarSubArbol(prefijo, sub);
        }
        return aux;
    }
    
    public ArrayList<String> consultarSubArbol(String prefijo, Nodo sub) {
        ArrayList<String> aux = new ArrayList<>();
        Iterator it = sub.getMapHijo().keySet().iterator();
        while(it.hasNext()){
            Character c = (Character) it.next();
            Nodo a = sub.getHijo(c);
            String autor = consultarAutor(prefijo, sub);
            aux.add(autor);
        }
        return aux;
    }
    
        /*inorden(nodo)
        si nodo == nulo entonces retorna
        inorden(nodo.izquierda)
        imprime nodo.valor
        inorden(nodo.derecha)*/
    
    public String consultarAutor(String prefijo, Nodo a){
        if (a != null){
            String autor="";
            Iterator it = a.getMapHijo().keySet().iterator();
            while(it.hasNext()){
                Character c = (Character) it.next();
                Nodo aa = a.getHijo(c);
                autor = consultarAutor(prefijo, aa);
            }
            return prefijo+autor;
        }
        return null;
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

/*public void anadirAutor(String prefijo){
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
    
    public void eliminarAutor(String prefijo){
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
        throw new Exception("No existen autores con el prefijo " + prefijo);
    }*/
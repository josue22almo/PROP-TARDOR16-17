
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
    //private Map <String,ArrayList<String>> trie;
    private Nodo raiz;
    
    public Trie(){
        //this.trie = new TreeMap<>();
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
            if (i == autor.length()-1){
                n.añadeHijo(c, new Nodo(n));
                n.setFi(true);
            }
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
        if (prefijo==""){
            consultarSubArbol(n, aux, prefijo);
            return aux;
        }
        for(int i=0; i < prefijo.length(); i++) {
            char c = prefijo.charAt(i);
            Nodo sub = n.getHijo(c);
            n = sub;
            if (i == prefijo.length()-1) consultarSubArbol(sub, aux, prefijo);
        }
        return aux;
    }
    
    public void consultarSubArbol(Nodo sub, ArrayList<String> aux, String autor){
        if (sub != null){
            Iterator it = sub.getMapHijo().keySet().iterator();
            while(it.hasNext()){
                Character c = (Character) it.next();
                autor+=c;
                Nodo a = sub.getHijo(c);
                consultarSubArbol(a, aux, autor);
                if (a.getFi()) aux.add(autor);
            }
        }
    }
}
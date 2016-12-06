
package Domini;

import java.util.ArrayList;
import java.util.Iterator;
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
    
    /**
     *
     * @param autor
     */
    public void añadirAutor(String autor) {
        Nodo n = raiz;
        for(int i=0; i < autor.length(); i++) {
            char c = autor.charAt(i);
            //Nodo sub = n.getHijo(c);
            if (!n.getMapHijo().containsKey(c)) n.añadeHijo(c, new Nodo(n));
            n = n.getHijo(c);
            //if (i == autor.length()-1) n.setFi(true);
        }
        n.setFi(true);
    }
    
    public void eliminarAutor(String autor){
        Nodo n = raiz;
        boolean aux = false, acabado = false;
        Nodo aux_padre = n;
        char aux_c = autor.charAt(0);
        for(int i=0; i < autor.length() && !acabado; i++) {
            char c = autor.charAt(i);
            Nodo sub = n.getHijo(c);
            //if (sub != null){
            if (!n.getMapHijo().isEmpty()) {
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
        if ("".equals(prefijo)){
            consultarSubArbol(n, aux, "");
            return aux;
        }
        for(int i=0; i < prefijo.length(); i++) {
            char c = prefijo.charAt(i);
            Nodo sub = n.getHijo(c);
            n = sub;
            //if (sub == null) return null;
            if (n.getMapHijo().isEmpty()) return null;
            if (i == prefijo.length()-1) consultarSubArbol(sub, aux, prefijo);
        }
        return aux;
    }
    
    public void consultarSubArbol(Nodo sub, ArrayList<String> aux, String autor){
        if (sub.getFi()) aux.add(autor);
        //if (sub != null){
        if (!sub.getMapHijo().isEmpty()){
            for (Character c : sub.getMapHijo().keySet()) {
                autor+=c;
                Nodo a = sub.getHijo(c);
                consultarSubArbol(a, aux, autor); 
            }
        }
    }
}
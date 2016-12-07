
package Domini;

import java.util.ArrayList;
/**
 *
 * @author jessica.sobreviela
 */
public class Trie {
    private Nodo raiz;
    
    public Trie(){
        this.raiz = new Nodo(null);
    }
    
    public void añadirAutor(String autor) {
        Nodo n = raiz;
        for(int i=0; i < autor.length(); i++) {
            char c = autor.charAt(i);
            if (!n.getMapHijo().containsKey(c)) n.añadeHijo(c, new Nodo(n));
            n = n.getHijo(c);
        }
        n.setFi(true);
    }
    
    public void eliminarAutor(String autor){
        Nodo n = raiz;
        Nodo nodoaux = n;
        char aux_c = autor.charAt(0);
        for(int i = 0; i < autor.length(); i++) {
            char c = autor.charAt(i);
            Nodo sub = n.getHijo(c);
            if (sub.getFi() && i <= autor.length()-2){
                nodoaux = n;
                aux_c = c;
            }
            if (n.getMapHijo().size() > 1){
                nodoaux = n;
                aux_c = c;
            }
            n = sub;
        }
        if (n.getMapHijo().isEmpty()) nodoaux.eliminarHijo(aux_c);
    }
 
    public ArrayList<String> consultarListaDelPrefijo(String prefijo) {
        ArrayList<String> aux = new ArrayList<>();
        Nodo n = raiz;
        if ("".equals(prefijo)){
            consultarSubArbol(n, aux, "");
            return aux;
        }
        Nodo sub = n.getHijo(prefijo.charAt(0));
        for(int i=0; i < prefijo.length(); i++) {
            char c = prefijo.charAt(i);
            sub = n.getHijo(c);
            if (n.getMapHijo().isEmpty()) return null;
            n = sub;
        }
        consultarSubArbol(sub, aux, prefijo);
        return aux;
    }
    
    public void consultarSubArbol(Nodo sub, ArrayList<String> aux, String autor){
        if (sub.getFi()) aux.add(autor);
        if (!sub.getMapHijo().isEmpty()){
            for (Character c : sub.getMapHijo().keySet()) {
                String aut=autor;
                autor+=c;
                Nodo a = sub.getHijo(c);
                consultarSubArbol(a, aux, autor);
                autor=aut;
            }
        }
    }
}
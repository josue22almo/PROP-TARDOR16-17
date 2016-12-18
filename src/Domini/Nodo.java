
package Domini;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author jessica.sobreviela
 */
public class Nodo {
    private boolean fi;
    private Map< Character,Nodo > hijo;
            
    public Nodo() {
        this.hijo = new TreeMap<>();
        this.fi = false;
    }
 
    public Nodo getHijo(char c) {
        return hijo.get(c);
    }
    
    public Map <Character, Nodo> getMapHijo(){
        return this.hijo;
    }
 
    public void añadeHijo(char c, Nodo n) {
        hijo.put(c,n);
    }
    
    public void eliminarHijo(char c){
        hijo.remove(c);
    }
    
    public boolean getFi(){
        return this.fi;
    }
    
    public void setFi(boolean f){
        this.fi = f;
    }
}

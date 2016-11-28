/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author jessica
 */
public class Nodo {
    private char letra;
    private boolean fi;
    private Nodo padre;
    private final Map< Character , Nodo> hijo;
            
    public Nodo(char c, Nodo padre)
    {
        this.letra = c;
        this.padre = padre;
        this.hijo = new TreeMap<>();
    }
 
    public Nodo getHijo(char c) {
        return hijo.get(c);
    }
 
    public void añadeHijo(Nodo n) {
        hijo.put(n.letra,n);
    }
    
    public void eliminarHijo(Nodo n){
        hijo.remove(n.letra);
    }
    
    public boolean getFi(){
        return this.fi;
    }
    
    public void setFi(boolean f){
        this.fi = f;
    }
    
    public Integer getSize(){
        return hijo.size();
    }
}

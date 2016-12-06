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
 * @author jessica.sobreviela
 */
public class Nodo {
    //private char letra;
    private boolean fi;
    private Nodo padre;
    private Map< Character,Nodo > hijo;
            
    public Nodo(Nodo padre)
    {
        //this.letra = c;
        this.padre = padre;
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
    
    /*public Integer getSize(){
        return hijo.size();
    }*/
}

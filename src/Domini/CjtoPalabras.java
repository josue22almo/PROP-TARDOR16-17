/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.util.ArrayList;
/**
 *
 * @author josue.inaldo.alcantara
 */
public class CjtoPalabras{
    
    private ArrayList<Palabra> list;
    
    public CjtoPalabras() {
        list = new ArrayList<>();
    }
    
    public boolean contains(Palabra palabra){
        for(Palabra p : list){
            if (p.equals(palabra)) return true;
        }
        return false; 
    }
    
    
    public void incrementarPalabra(String palabra){
        for (Palabra p : list){
            if (p.equals(palabra)){
                p.incrementarFrecuencia();
                break;
            }
        }
    }
}

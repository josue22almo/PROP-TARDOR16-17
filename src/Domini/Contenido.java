/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.util.ArrayList;
/**
 *
 * @author florenciarf
 */
public class Contenido {
    private String contenidoOriginal;
    private CjtoPalabras contenidoReducido;

    public Contenido(){
    }
    
    public Contenido(String contenidoOriginal,ArrayList<String> español,ArrayList<String> catalan, ArrayList<String> ingles) {
        this.contenidoOriginal = contenidoOriginal;
        calcularContenidoReducido(español,catalan,ingles);
    }

    public String getContenidoOriginal() {
        return contenidoOriginal;
    }

    public void setContenidoOriginal(String contenidoOriginal) {
        this.contenidoOriginal = contenidoOriginal;
    }

    public CjtoPalabras getContenidoReducido() {
        return contenidoReducido;
    }
    
    private void calcularContenidoReducido(ArrayList<String> español,ArrayList<String> catalan, ArrayList<String> ingles){
        String palabra = new String();
        for(int i = 0; i < contenidoOriginal.length(); ++i){
            if (!esSignoPuntuacion(contenidoOriginal.charAt(i)))
                palabra = palabra + contenidoOriginal.charAt(i);
            else{
                Palabra p = new Palabra(palabra);
                if (contenidoReducido.contains(palabra) && !español.contains(palabra) && !catalan.contains(palabra) && !ingles.contains(palabra)) 
                    contenidoReducido.incrementarPalabra(palabra);
                else contenidoReducido.add(p);
                palabra = "";
            }
        } 
    }
    
    private boolean esSignoPuntuacion(char a){
        //if ()
            return true;
        //return false;
        
    }
    
}

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
            if (esValido(contenidoOriginal.charAt(i)))
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
    
    private boolean esValido(char a){ 
        //los numeros se consideran validos, los carácteres son válidos en el alfabeto español, catalan e inglés
        //MAYUSCULAS de 65 a 90, minusculas de 97 a 122
        int value = Integer.parseInt("" + a);
        if (value >= 0 && value <= 47) return false;
        if (value >= 58 && value <= 64) return false;
        if (value >= 91 && value <= 96) return false;
        if (value >= 123 && value <= 126) return false;
        if (value == 130) return true; //é
        if (value == 133) return true; //à
        if (value == 135) return true; //ç
        if (value == 138) return true; //è
        if (value == 139) return true; //ï
        if (value == 149) return true; //ò
        if (value == 151) return true; //ú
        if (value == 154) return true; //Ü
        if (value >= 160 && value <= 165) return true; // á,í,ó,ú,ñ,Ñ
        return false;
    }
    
}

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
    private ArrayList<Palabra> contenidoReducido;

    public Contenido(){
    }
        
    public Contenido(String contenidoOriginal) {
        this.contenidoOriginal = contenidoOriginal;
        calcularContenidoReducido();
    }

    public String getContenidoOriginal() {
        return contenidoOriginal;
    }

    public void setContenidoOriginal(String contenidoOriginal) {
        this.contenidoOriginal = contenidoOriginal;
    }

    public ArrayList<Palabra> getContenidoReducido() {
        return contenidoReducido;
    }
    
    private void calcularContenidoReducido(){
        String palabra = new String();
        contenidoReducido = new ArrayList<>();
        for(int i = 0; i < contenidoOriginal.length(); ++i){
            if (esValido(contenidoOriginal.charAt(i))){
                palabra = palabra + contenidoOriginal.charAt(i);
            }
            else{
                Palabra p = new Palabra(palabra);
                palabra = "";
                int j = existPalabra(p);
                if (j != -1){
                     
                  //  incrementarPalabra(palabra);
                //else 
               
                    contenidoReducido.get(j).incrementarFrecuencia();
                } else contenidoReducido.add(p);
            }
        } 
    }
    
    private boolean esValido(char a){ 
        //los numeros se consideran validos, los carácteres son válidos en el alfabeto español, catalan e inglés
        //MAYUSCULAS de 65 a 90, minusculas de 97 a 122, no sabemos diferenciar los puntos suspensivos
        int value = (int)a;
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
        if (value == 8230) return false; //...
        if (value >= 160 && value <= 165) return true; // á,í,ó,ú,ñ,Ñ
        return true;
    }
    
    
    private int existPalabra(Palabra palabra){
         for (int i = 0; i < contenidoReducido.size(); ++i)
             //System.out.println(contenidoReducido.get(i).getPalabra());
             if (contenidoReducido.get(i).equals(palabra)) return i;
         //System.out.println("------------------");
         return -1;
    }
}

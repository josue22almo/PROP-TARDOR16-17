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
public class Contenido {
    private String contenidoOriginal;
    private ArrayList<Palabra> contenidoReducido = new ArrayList<>();

    public Contenido(){
        contenidoOriginal = "";
    }
    
    //Crea un contenido con contenidoOriginal y a partir de contenidoOriginal calula contenidoReducido
    public Contenido(String contenidoOriginal){
      //  System.out.println("Creadora paso contenido");
        this.contenidoOriginal = contenidoOriginal;
        calcularContenidoReducido();
    }

    //Obtenemos el contenido original
    public String getContenidoOriginal() {
        return contenidoOriginal;
    }

    //cambia el contenidoOriginal 
    public void setContenidoOriginal(String contenidoOriginal) {
       // System.out.println("Set contenido original");
        this.contenidoOriginal = contenidoOriginal; 
        contenidoReducido.clear();
        calcularContenidoReducido();
    }

    /*retorna contenidoReducido*/
    public ArrayList<Palabra> getContenidoReducido() {
        return (ArrayList)contenidoReducido.clone();
    } 
    
    public double calcularDistancia (ArrayList<Palabra> v){
        if (v.isEmpty() || contenidoReducido.isEmpty()) return 0;
        double escalar = productEscalar(v,contenidoReducido);
        double modU = module(contenidoReducido);
        double modV = module(v);
        return escalar/(modU*modV);
    }
    
    private void calcularContenidoReducido(){
        String palabra = new String();
        for(int i = 0; i < contenidoOriginal.length(); ++i){
            if (charValido(contenidoOriginal.charAt(i))){
                palabra = palabra + contenidoOriginal.charAt(i);
            }
            else{
                //System.out.println(palabra);
                if (palabraValida(palabra) && palabra.length() > 0){
                    addPalabra(palabra);
                }
                palabra = "";
            }
        }
        if (palabra.length() > 0){
            addPalabra(palabra);
        }
    }
    
    /*Mira si la palabra ya está añadida. 
    Si lo está suma 1 a su frecuencia, si no lo está la añade*/
    private void addPalabra(String palabra){
        Palabra p = new Palabra(palabra.toLowerCase());
            int j = existPalabra(p);
            if (j != -1){
                contenidoReducido.get(j).incrementarFrecuencia();
            } else contenidoReducido.add(p);
    }
    
    /*los numeros se consideran validos, los carácteres son válidos en el alfabeto español, catalan e inglés
    MAYUSCULAS de 65 a 90, minusculas de 97 a 122, no sabemos diferenciar los puntos suspensivos*/
    private boolean charValido(char a){ 
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
    
    
    //Una palabra es válida si no está en ninguna de las listas de español, catalan ni inglés
    private boolean palabraValida(String p){
        return !(VariablesGlobales.catalan.contains(p.toLowerCase()) || VariablesGlobales.espanol.contains(p.toLowerCase()) || VariablesGlobales.english.contains(p.toLowerCase()));
    }
    
    
    //nos dice si la palanra ya ha aparecido anteriormente en el texto
    private int existPalabra(Palabra palabra){
         for (int i = 0; i < contenidoReducido.size(); ++i)
             //System.out.println(contenidoReducido.get(i).getPalabra());
             if (contenidoReducido.get(i).equals(palabra)) return i;
            //System.out.println("------------------");
         return -1;
    }

    private double productEscalar(ArrayList<Palabra> v, ArrayList<Palabra> u) {
        double cont = 0.0;
        for (Palabra p : v){
            int i = isIn(p,u);
            if (i != -1){ //u contiene p
                cont += (p.getFrecuencia() * u.get(i).getFrecuencia());
            }
        }
        return cont;
    }

    private int isIn(Palabra p, ArrayList<Palabra> u) {
         for (int i = 0; i < u.size(); ++i)
             if (u.get(i).equals(p)) return i;
         return -1;
    }

    private double module(ArrayList<Palabra> v) {
        double cont = 0.0;
        for (Palabra p : v){
            cont += (p.getFrecuencia() * p.getFrecuencia());
        }        
        return Math.sqrt(cont);
    }   
}

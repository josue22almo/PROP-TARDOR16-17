
package Domini;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
/**
 *
 * @author josue.inaldo.alcantara
 */
public class Contenido {
    
    private String contenidoOriginal;
    private Map<String,Palabra> contenidoReducido;
    

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
        if (!contenidoOriginal.isEmpty())
            contenidoReducido.clear();
        calcularContenidoReducido();
    }

    /*retorna contenidoReducido*/
    public Map<String,Palabra> getContenidoReducido() {
        return contenidoReducido;
    } 
    
    public double calcularDistancia(Map<String,Palabra> v, String type){
        if (v.isEmpty() && contenidoReducido.isEmpty()) return 0.0;
        if (v.isEmpty() || contenidoReducido.isEmpty()) return 1.0;
        double escalar = productEscalar(v,contenidoReducido,type);
        double modU = module(contenidoReducido,type);
        double modV = module(v,type);
        double cos = escalar/(modU*modV);
        return 1.0 - cos;
    }
    
    public void calcularTFIDF(int numDocs, Diccionario diccionario) {
        for (String key : contenidoReducido.keySet())	{
                int numApariciones = diccionario.getNumAparicionesPalabra(key);
                contenidoReducido.get(key).calcularTFIDF(numDocs, numApariciones);
        }	
    }
    
    private void calcularContenidoReducido(){
        String palabra = new String();
        this.contenidoReducido = new HashMap<>();
        for(int i = 0; i < contenidoOriginal.length(); ++i){
            if (charValido(contenidoOriginal.charAt(i))){
                palabra = palabra + contenidoOriginal.charAt(i);
            }
            else{
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
        if (this.contenidoReducido.containsKey(palabra)){
                this.contenidoReducido.get(palabra).incrementarFrecuencia();
        }else this.contenidoReducido.put(palabra, p);
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
        return !(CtrlDomini.catalan.contains(p.toLowerCase()) || CtrlDomini.espanol.contains(p.toLowerCase()) || CtrlDomini.ingles.contains(p.toLowerCase()));
    }
    
    private double productEscalar(Map<String,Palabra> v, Map<String,Palabra> u, String type) {
        double cont = 0.0;
        for (String key : v.keySet()) {
            if (u.containsKey(key)){
            	if (type.equals("FREC"))
            		cont += v.get(key).getFrecuencia()*u.get(key).getFrecuencia();
            	else{
            		cont += v.get(key).getTFIDF()*u.get(key).getTFIDF();
        		}
            }
        }
        return cont;
    }
    
    private double module(Map<String,Palabra> v, String type) {
        double cont = 0.0;
        for (String key : v.keySet()) {
        	if (type.equals("FREC"))
        		cont += v.get(key).getFrecuencia()*v.get(key).getFrecuencia();
        	else{
        		cont += v.get(key).getTFIDF()*v.get(key).getTFIDF();
    		}
        }
       return Math.sqrt(cont);
    }

   /* public void printContenidoReducido() {
        for (String key : contenidoReducido.keySet())
                System.out.println("key: " + key + " frecs = " + contenidoReducido.get(key).getFrecuencia() + " TF-IDF: " + contenidoReducido.get(key).getTFIDF());
    }*/
}
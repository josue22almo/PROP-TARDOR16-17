/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

/**
 *
 * @author josue.inaldo.alcantara
 */
public class Palabra {
    private String palabra;
    private double TfDf;
    private int frecuencia;

    
    public Palabra(){
        palabra = null;
        TfDf = 0;
        frecuencia  = 0;
    }
    
    public Palabra(String palabra){
        this.palabra = palabra;
        TfDf = 0;
        frecuencia  = 0;
    }
    
    public void setPalabra(String palabra){
        this.palabra = palabra;
    }
    
    public String getPalabra() {
        return palabra;
    }
    
    public void setPesoFrec(int pesoFrec) {
        this.TfDf = pesoFrec;
    }
    
    public void setPesoTfDs(double pesoTfDf) {
        this.TfDf = pesoTfDf;
    }

    public int getPesoFrec() {
        return frecuencia;
    }

    public double getPesoTfDf() {
        return TfDf;
    }

    public void incrementarFrecuencia(){
        frecuencia++;
    }
    
    public boolean equals(String palabra){
        return this.palabra.equals(palabra);
    }
}
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
    private int TfDf;
    private int frecuencia;

    
    public Palabra(){
        palabra = "";
        TfDf = 0;
        frecuencia  = 0;
    }
    
    public Palabra(String palabra){
        this.palabra = palabra;
        TfDf = 0;
        frecuencia  = 1;
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
    
    public void setPesoTfDf(int pesoTfDf) { //no funciona con TfDf double
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
    
    public boolean equals(Palabra palabra){
        return this.palabra.equals(palabra.getPalabra());
    }
}
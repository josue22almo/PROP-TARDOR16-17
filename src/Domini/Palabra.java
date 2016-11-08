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
    private double frecuencia;

    
    public Palabra(){
        palabra = "";
        TfDf = 0;
        frecuencia  = 0;
    }
    
    public Palabra(String palabra){
        this.palabra = palabra;
        TfDf = 0.0;
        frecuencia  = 1.0;
    }
    
    public void setPalabra(String palabra){
        this.palabra = palabra;
    }
    
    public String getPalabra() {
        return palabra;
    }
        
    public void calcularTfDf(int numDocs, int numApariciones) { 
        this.TfDf = frecuencia*Math.log(numDocs/numApariciones);
    }

    public double getFrecuencia() {
        return frecuencia;
    }

    public double getTfDf() {
        return TfDf;
    }

    public void incrementarFrecuencia(){
        frecuencia++;
    }
    
    public boolean equals(Palabra palabra){
        return this.palabra.equals(palabra.getPalabra());
    }
}
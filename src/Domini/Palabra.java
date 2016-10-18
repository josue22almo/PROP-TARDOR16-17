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
    private double pesoTfDf;
    private int pesoFrec;

    
    public Palabra(){
        palabra = null;
        pesoTfDf = 0;
        pesoFrec  = 0;
    }
    
    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public double getPesoTfDs() {
        return pesoTfDf;
    }

    public void setPesoTfDs(double pesoTfDf) {
        this.pesoTfDf = pesoTfDf;
    }

    public int getPesoFrec() {
        return pesoFrec;
    }

    public void setPesoFrec(int pesoFrec) {
        this.pesoFrec = pesoFrec;
    }
    
    
}

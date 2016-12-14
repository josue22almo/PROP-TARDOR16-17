
package Domini;

/**
 *
 * @author florencia.rimolo
 */
public class Palabra {
    private String palabra;
    private double tfidf;
    private double frecuencia;

    
    public Palabra(){
        palabra = "";
        tfidf = 0;
        frecuencia  = 0;
    }
    
    public Palabra(String palabra){
        this.palabra = palabra;
        tfidf = 0.0;
        frecuencia  = 1.0;
    }
    
    public void setPalabra(String palabra){
        this.palabra = palabra;
    }
    
    public String getPalabra() {
        return palabra;
    }
        
    public void calcularTFIDF(double numDocs, double numApariciones) {
        this.tfidf = frecuencia*Math.log(numDocs/numApariciones);      
    }

    public double getFrecuencia() {
        return frecuencia;
    }

    public double getTFIDF() {
        return tfidf;
    }

    public void incrementarFrecuencia(){
        frecuencia++;
    }
    
    public boolean equals(Palabra palabra){
        return this.palabra.equals(palabra.getPalabra());
    }
}
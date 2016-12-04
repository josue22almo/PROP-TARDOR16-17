
package Domini;


import java.util.Map;
import java.util.ArrayList;
/**
 *
 * @author florencia.rimolo
 */
public class Documento {
    private String autor;
    private String titulo;
    private Contenido contenido;
    private int id;
    
    public Documento(){}
    
    public Documento(int id, String autor, String titulo, String contenido) throws Exception{
        
        if (autor.isEmpty() || titulo.isEmpty() || contenido.isEmpty())
            throw new Exception("Uno o más parámetros del documento está vacío");
        
        this.id = id;
        this.autor = autor;
        this.titulo = titulo;  
        this.contenido = new Contenido(contenido);
    }

    public void setAutor(String autor) {
        
        this.autor = autor;
    }

    public void setTitulo(String titulo) {
        
        this.titulo = titulo;
    }

    public void setContenido(String contenido) {
        
        this.contenido.setContenidoOriginal(contenido);
    }
    
    public int getID () {
        return this.id;
    }
    public String getAutor() {
        
        return this.autor;
    }

    public String getTitulo() {
        
        return this.titulo;
    }
    
    public Contenido getContenido(){
        return contenido;
    }
    
    public String getContenidoOriginal(){
        
        return this.contenido.getContenidoOriginal();
    }
    
    public Map<String,Palabra> getContenidoReducido(){
        
        return this.contenido.getContenidoReducido();
    }
    
    public double calcularDistancia(Documento doc, String type){
        
    	return this.contenido.calcularDistancia(doc.contenido.getContenidoReducido(),type);
    }
      
    public boolean equals(String au, String tit){
        
        return autor.equals(au) && titulo.equals(tit);
    }
    
    public ArrayList<Frase> getFrases(){
        return contenido.getFrases();
    }

    public void calcularTFIDF(int numDocs, Diccionario diccionario) {
        
	contenido.calcularTFIDF(numDocs,diccionario);
    }
	
}

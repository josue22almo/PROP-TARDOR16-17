/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;


import java.util.Map;

/**
 *
 * @author florencia.rimolo
 */
public class Documento {
    private String autor;
    private String titulo;
    private Contenido contenido;
    
    public Documento(){}
    
    public Documento(String autor, String titulo, String contenido) {
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
        
    public String getAutor() {
        return this.autor;
    }

    public String getTitulo() {
        return this.titulo;
    }
    
    public String getContenidoOriginal(){
        return this.contenido.getContenidoOriginal();
    }
    
    public Map<String,Palabra> getContenidoReducido(){
        return this.contenido.getContenidoReducido();
    }
    public Contenido getContenido(){
        return contenido;
    }
    
    public double calcularDistancia(Documento doc, String type){
    	return this.contenido.calcularDistancia(doc.contenido.getContenidoReducido(),type);
    }
      
    public boolean equals(String au, String tit){
        return autor.equals(au) && titulo.equals(tit);
    }

	public void calcularTFiDF(int numDocs) {
		contenido.calcularTFiDF(numDocs);
	}
	
	public void printContenidoReducido(){
		System.out.println("Autor: " + autor + " titulo: " + titulo);
		contenido.printContenidoReducido();
	}
}

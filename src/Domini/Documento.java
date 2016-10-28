/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.util.ArrayList;

/**
 *
 * @author florencia.rimolo
 */
public class Documento {
    private String autor;
    private String titulo;
    private Contenido contenido;
    private final int id;
    private int distancia;
    private ArrayList<Integer> frecs;
    private ArrayList<Integer> tfIdf;
    
    public Documento() {
        autor= null;
        titulo = null;
        contenido = new Contenido();
        distancia = 0;
        frecs = null;
        tfIdf = null;
        id = 0;
    }
    
    public Documento(String autor, String titulo, String contenido, int id, ArrayList<String> español,ArrayList<String> catalan, ArrayList<String> ingles) {
        this.autor = autor;
        this.titulo = titulo;
        this.contenido = new Contenido(contenido,español,catalan,ingles);
        this.id = id;
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
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getId() {
        return id;
    }
       
    public boolean equals(Documento d){
        return autor.equals(d.autor) && titulo.equals(d.titulo);
    }
    
}

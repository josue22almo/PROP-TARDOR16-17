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
    private Autor autor;
    private Titulo titulo;
    private Contenido contenido;
    private final int id;
    private int distancia;
    private ArrayList<Integer> frecs;
    private ArrayList<Integer> tfIdf;
    
    public Documento() {
        autor= new Autor();
        titulo = new Titulo();
        contenido = new Contenido();
        distancia = 0;
        frecs = null;
        tfIdf = null;
        id = 0;
    }
    
    
    public Documento(Autor autor, Titulo titulo, Contenido contenido, int id) {
        this.autor = autor;
        this.titulo = titulo;
        this.contenido = contenido;
        this.id = id;
    }
    
    public Documento(String autor, String titulo, String contenido, int id) {
        this.autor = new Autor();
        this.titulo = new Titulo();
        this.contenido = new Contenido();
        this.autor.setAutor(autor); 
        this.titulo.setTitulo(titulo); 
        this.id = id;
        this.contenido.setContenidoOriginal(contenido);
    }
    

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }
    
    
    public Autor getAutor() {
        return autor;
    }

    public Titulo getTitulo() {
        return titulo;
    }
    
    public String getAutorString() {
        return autor.getAutor();
    }

    public String getTituloString() {
        return titulo.getTitulo();
    }

    public int getId() {
        return id;
    }
       
    public boolean equals(Documento d){
        return autor.getAutor().equals(d.getAutorString()) && titulo.getTitulo().equals(d.getTituloString());
    }
    
}

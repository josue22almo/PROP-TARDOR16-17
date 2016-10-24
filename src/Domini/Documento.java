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
    }
    
    
    public Documento(Autor autor, Titulo titulo, Contenido contenido) {
       this.autor = autor;
        this.titulo = titulo;
        this.contenido = contenido;
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
    
}

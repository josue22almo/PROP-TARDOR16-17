/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.util.ArrayList;

/**
 *
 * @author florenciarf
 */
public class Documento {
    private ArrayList<String> autor;
    private ArrayList<String> titulo;
    private Contenido contenido;
    private int distancia;
    private ArrayList<Integer> frecs;
    private ArrayList<Integer> tfIdf;
    
    public Documento() {
        autor= null;
        titulo=null;
        contenido=null;
        distancia=0;
        frecs=null;
        tfIdf=null;
    }
    
    public Documento(ArrayList<String> autor, ArrayList<String> titulo, Contenido contenido) {
        this.autor = autor;
        this.titulo = titulo;
        this.contenido = contenido;
        
    }
    

    public void setAutor(ArrayList<String> autor) {
        this.autor = autor;
    }

    public void setTitulo(ArrayList<String> titulo) {
        this.titulo = titulo;
    }
    
    
    public ArrayList<String> getAutor() {
        return autor;
    }

    public ArrayList<String> getTitulo() {
        return titulo;
    }
    
}

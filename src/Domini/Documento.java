/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author florencia.rimolo
 */
public class Documento {
    private String autor;
    private String titulo;
    private Contenido contenido;
    private final int id;
    private double distancia;
    /*private static ArrayList<String> español;
    private static ArrayList<String> catalan;
    private static ArrayList<String> ingles;*/
    
    public Documento(String autor, String titulo, String contenido, int id) throws IOException{
        this.autor = autor;
        this.titulo = titulo;        
        this.id = id;
        CtrlDomini ctrlDomini = new CtrlDomini();
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
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }
    
    public String getContenidoOriginal(){
        return contenido.getContenidoOriginal();
    }
    
    public ArrayList<Palabra> getContenidoReducido(){
        return contenido.getContenidoReducido();
    }
    
    public Contenido getContenido(){
        return contenido;
    }
    
    public double getDistancia(Documento doc){
        return this.contenido.distancia(doc.contenido.getContenidoReducido());
    }

    public int getId() {
        return id;
    }
       
    public boolean equals(String au, String tit){
        return autor.equals(au) && titulo.equals(tit);
    }
}

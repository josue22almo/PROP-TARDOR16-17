/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.io.IOException;
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
    private static ArrayList<String> español;
    private static ArrayList<String> catalan;
    private static ArrayList<String> ingles;
    
    public Documento()  {
        autor= null;
        titulo = null;
        contenido = new Contenido();
        distancia = 0;
        frecs = null;
        tfIdf = null;
        id = 0;
       
    }
    
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
    
    public void setID(int id) {
        this.id = id;
    }
        
    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }
    
    public Contenido getContenido(){
        return contenido;
    }
    
    public int getDistancia(){
        return distancia;
    }
    
    public ArrayList<Integer> getFreqs() {
        return frecs;
    }
    
    public ArrayList<Integer> getFfIdf(){
        return tfIdf;
    }

    public int getId() {
        return id;
    }
    
    /*public void computeFrecs(){
        
    }
 
    public void computeTfDf(){
        
    }*/
       
    public boolean equals(String au, String tit){
        return autor.equals(au) && titulo.equals(tit);
    }
    
    /*public void calcularDistancia(ArrayList<int> dist_palabras){
    
    }*/
}

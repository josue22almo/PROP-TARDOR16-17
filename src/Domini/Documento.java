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
        español = ctrlDomini.leerPalabras("/home2/users/alumnes/1192783/dades/PROP/proj/palabras_cast.txt");
        catalan = ctrlDomini.leerPalabras("/home2/users/alumnes/1192783/dades/PROP/proj/paraules_cat.txt");
        ingles = ctrlDomini.leerPalabras("/home2/users/alumnes/1192783/dades/PROP/proj/words_en.txt");
        this.contenido = new Contenido(contenido,español,catalan,ingles);
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
       
    public boolean equals(String au, String tit){
        return autor.equals(au) && titulo.equals(tit);
    }
    
}

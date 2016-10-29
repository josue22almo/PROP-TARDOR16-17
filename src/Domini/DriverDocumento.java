/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.io.IOException;

/**
 *
 * @author florencia.rimolo
 */
public class DriverDocumento {
    public static void main(String[] args) throws IOException{
        Documento doc1 = new Documento("Flor","Prueba","Esto es una prueba",1);
        System.out.println("Autor: " + doc1.getAutor());
        System.out.println("Título: " + doc1.getTitulo());
        System.out.println("Contenido: " + doc1.getContenidoOriginal());
    }
}

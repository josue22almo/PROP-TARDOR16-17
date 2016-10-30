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
public class DriverDocumento {
    public static void main(String[] args) throws IOException{
        Documento doc1 = new Documento("Flor","Prueba","Esto es una prueba",1);
        System.out.println("Autor: " + doc1.getAutor());
        System.out.println("Título: " + doc1.getTitulo());
        System.out.println("Contenido: " + doc1.getContenidoOriginal());
        System.out.println("ID: " + doc1.getId());
        // Contenido reducido
        int i;
        ArrayList<Palabra> contRed = doc1.getContenidoReducido();
        for (i = 0; i < contRed.size(); i++) {
            System.out.println("Contenido reducido: " + contRed.get(i).getPalabra());
        }
        //Distancia
        Documento doc2 = new Documento("Flor","Prueba2","Esto es una una prueba. Hola.",2);
        System.out.println("Distancia: " + doc1.getDistancia(doc2));
    }
}

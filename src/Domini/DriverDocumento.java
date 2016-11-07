/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author florencia.rimolo
 */
public class DriverDocumento {
    public static void main(String[] args) throws IOException,RuntimeException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Primero, cree un documento.");
        System.out.println("Introduzca el autor del documento:");
        String autor = sc.next();
        System.out.println("Introduzca el título del documento:");
        String titulo = sc.next();
        System.out.println("Introduzca el contenido del documento:");
        String contenido = sc.next();
        Documento doc = new Documento(autor,titulo,contenido);
        while (true) {
            System.out.println("Indique qué desea hacer:");
            System.out.println("1. Modificar documento");
            System.out.println("2. Mostrar autor");
            System.out.println("3. Mostrar título");
            System.out.println("4. Mostrar contenido original");
            System.out.println("5. Mostrar contenido reducido");
            System.out.println("6. Obtener distancia respecto a otro documento");
            System.out.println("7. Establecer distancia");
            System.out.println("8. Salir");
            int op;
            op = sc.nextInt();
            switch(op){
                case 1:
                    System.out.println("¿Qué desea modificar?");
                    System.out.println("1. Autor");
                    System.out.println("2. Título");
                    System.out.println("3. Contenido");
                    int op1=sc.nextInt();
                    switch(op1) {
                        case 1:
                            System.out.println("Introduzca el nuevo autor:");
                            autor = sc.nextLine();
                            doc.setAutor(autor);
                        case 2:
                            System.out.println("Introduzca el nuevo título:");
                            titulo = sc.nextLine();
                            doc.setTitulo(titulo);
                        case 3:
                            System.out.println("Introduzca el nuevo contenido:");
                            contenido = sc.nextLine();
                            doc.setContenido(contenido);
                    }
                case 2:
                    System.out.println(doc.getAutor());
                case 3:
                    System.out.println(doc.getTitulo());
                case 4:
                    System.out.println(doc.getContenidoOriginal());
                case 5:
                    int i;
                    ArrayList<Palabra> contRed = doc.getContenidoReducido();
                    for (i = 0; i < contRed.size(); i++) {
                        System.out.println(contRed.get(i).getPalabra());
                    }
                case 6:
                    System.out.println("Introduzca autor, título y contenido del documento respecto al que quiere calcular la distancia");
                    String autor2 = sc.next();
                    String titulo2 = sc.next();
                    String contenido2 = sc.next();
                    Documento doc2 = new Documento(autor2, titulo2, contenido2);
                    System.out.println("Distancia: " + doc.getDistancia(doc2));
                case 7:
                    System.out.println("Introduzca la nueva distancia:");
                    double dist = sc.nextDouble();
                    doc.setDistancia(dist);
                case 8:
                    break;
            }
        }
    }
}

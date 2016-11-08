/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author florencia.rimolo
 */
public class DriverDocumento {
    public static void main(String[] args) throws IOException,RuntimeException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Primero, cree un documento.");
        System.out.println("Introduzca el autor del documento:(la entrada acaba con un punto)");
        String autor = "";
        String j = sc.next();
        while (!j.equals(".")){
            autor += j;
            autor += " ";
            j = sc.next();
        }
        System.out.println("Introduzca el título del documento:(la entrada acaba con un punto)");
        String titulo = "";
        j = sc.next();
        while (!j.equals(".")){
            titulo += j;
            titulo += " ";
            j = sc.next();
        }
        System.out.println("Introduzca el contenido del documento:(la entrada acaba con un punto)");
        String contenido = "";
        j = sc.next();
        while (!j.equals(".")){
            contenido += j;
            contenido += " ";
            j = sc.next();
        }
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
                            autor = "";
                            j = sc.next();
                            while (!j.equals(".")){
                                autor += j;
                                autor += " ";
                                j = sc.next();
                            }
                            doc.setAutor(autor);
                            break;
                        case 2:
                            System.out.println("Introduzca el nuevo título:");
                            titulo = "";
                            j = sc.next();
                            while (!j.equals(".")){
                                titulo += j;
                                titulo += " ";
                                j = sc.next();
                            }
                            doc.setTitulo(titulo);
                            break;
                        case 3:
                            System.out.println("Introduzca el nuevo contenido:");
                            contenido = "";
                            j = sc.next();
                            while (!j.equals(".")){
                                contenido += j;
                                contenido += " ";
                                j = sc.next();
                            }
                            doc.setContenido(contenido);
                            break;
                    }
                case 2:
                    System.out.println(doc.getAutor());
                    break;
                case 3:
                    System.out.println(doc.getTitulo());
                    break;
                case 4:
                    System.out.println(doc.getContenidoOriginal());
                    break;
                case 5:
                    int i;
                    Map<String,Palabra> contRed = doc.getContenidoReducido();
                    for (String key : contRed.keySet()) {
                        System.out.println(contRed.get(key).getPalabra() + " con una frecuencia " + contRed.get(key).getFrecuencia() + " y un TF-IDF " + contRed.get(key).getTfDf());
                    }
                    break;
                case 6:
                    System.out.println("Introduzca autor, título y contenido del documento respecto al que quiere calcular la distancia");
                    String autor2 = "";
                    j = sc.next();
                    while (!j.equals(".")){
                        autor2 += j;
                        autor2 += " ";
                        j = sc.next();
                    }
                    String titulo2 = "";
                    j = sc.next();
                    while (!j.equals(".")){
                        titulo2 += j;
                        titulo2 += " ";
                        j = sc.next();
                    }
                    String contenido2 = "";
                    j = sc.next();
                    while (!j.equals(".")){
                        contenido2 += j;
                        contenido2 += " ";
                        j = sc.next();
                    }
                    Documento doc2 = new Documento(autor2, titulo2, contenido2);
                    System.out.println("Distancia: " + doc.getDistancia(doc2));
                    break;
                case 7:
                    System.out.println("Introduzca la nueva distancia:");
                    double dist = sc.nextDouble();
                    doc.setDistancia(dist);
                    break;
                case 8:
                    return;
            }
        }
    }
}

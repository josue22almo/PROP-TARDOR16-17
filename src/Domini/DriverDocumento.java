/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

//import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;

/**
 *
 * @author florencia.rimolo
 */
public class DriverDocumento {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el autor del documento:(la entrada acaba con un punto)");
        String autor = "";
        String aux;
        aux = sc.next();
        while (!aux.equals(".")){
            autor += " ";
            autor += aux;
            aux = sc.next();
        }
        sc.nextLine();
        System.out.println("Introduzca el título del documento:(la entrada acaba con un punto)");
        String titulo = "";
        aux = sc.next();
        while (!aux.equals(".")){
            titulo += " ";
            titulo += aux;
            aux = sc.next();
        }
        sc.nextLine();
        System.out.println("Introduzca el contenido del documento:(la entrada acaba con un punto)");
        String contenido = "";
        aux = sc.next();
        while (!aux.equals(".")){
            contenido += " ";
            contenido += aux;
            aux = sc.next();
        }
        sc.nextLine();
        Documento doc = new Documento(autor,titulo,contenido);
        //sc.nextLine();
        
        while (true) {
            System.out.println("Indique qué desea hacer:");
            System.out.println("1. Modificar autor");
            System.out.println("2. Modificar título");
            System.out.println("3. Modificar contenido");
            System.out.println("4. Mostrar autor");
            System.out.println("5. Mostrar título");
            System.out.println("6. Mostrar contenido original");
            System.out.println("7. Mostrar contenido reducido");
            System.out.println("8. Obtener distancia respecto a otro documento");
            System.out.println("9. Salir");
            int op;
            op = sc.nextInt();
            switch(op){
                case 1:
                    System.out.println("Introduzca el nuevo autor(la entrada acaba con un punto):");
                    autor = "";
                    aux = sc.next();
                    while (!aux.equals(".")){
                        autor += " ";
                        autor += aux;
                        aux = sc.next();
                    }
                    sc.nextLine();
                    doc.setAutor(autor);
                    System.out.println("Autor cambiado con éxito.");
                    break;
                case 2:
                    System.out.println("Introduzca el nuevo título(la entrada acaba con un punto):");
                     titulo = "";
                    aux = sc.next();
                    while (!aux.equals(".")){
                        titulo += " ";
                        titulo += aux;
                        aux = sc.next();
                    }
                    sc.nextLine();
                    doc.setTitulo(titulo);
                    System.out.println("Título cambiado con éxito.");
                    break;
                case 3:
                    System.out.println("Introduzca el nuevo contenido(la entrada acaba con un punto):");
                    contenido = "";
                    aux = sc.next();
                    while (!aux.equals(".")){
                        contenido += " ";
                        contenido += aux;
                        aux = sc.next();
                    }
                    sc.nextLine();
                    doc.setContenido(contenido);
                    System.out.println("Contenido cambiado con éxito.");
                    break;
                case 4:
                    System.out.println("Autor: " + doc.getAutor());
                    break;
                case 5:
                    System.out.println("Título: " + doc.getTitulo());
                    break;
                case 6:
                    System.out.println("Contenido original: " + doc.getContenidoOriginal());
                    break;
                case 7:
                    if (doc.getContenidoReducido() != null) {
                        Map<String, Palabra> contRed = doc.getContenidoReducido();
                        for (String palabra : contRed.keySet()) {
                            System.out.println(contRed.get(palabra).getPalabra());
                        }
                    }
                    break;
                case 8:
                    System.out.println("Introduzca autor, título y contenido del documento respecto al que quiere calcular la distancia");
                    System.out.println("Introduzca el autor del documento:(la entrada acaba con un punto)");
                    autor = "";
                    aux = sc.next();
                    while (!aux.equals(".")){
                        autor += " ";
                        autor += aux;
                        aux = sc.next();
                    }
                    sc.nextLine();
                    System.out.println("Introduzca el título del documento:(la entrada acaba con un punto)");
                    titulo = "";
                    aux = sc.next();
                    while (!aux.equals(".")){
                        titulo += " ";
                        titulo += aux;
                        aux = sc.next();
                    }
                    sc.nextLine();
                    System.out.println("Introduzca el contenido del documento:(la entrada acaba con un punto)");
                    contenido = "";
                    aux = sc.next();
                    while (!aux.equals(".")){
                        contenido += " ";
                        contenido += aux;
                        aux = sc.next();
                    }
                    sc.nextLine();
                    Documento doc2 = new Documento(autor, titulo, contenido);
                    System.out.println("Distancia con FREC: " + doc.calcularDistancia(doc2, "FREC"));
                    System.out.println("Distancia con TF-IDF: " + doc.calcularDistancia(doc2, "TF-IDF")); //da 0 porque se calcula en CjtoDocumentos cada 
                    																				// vez que se da de alta a un documento
                    break;
                case 9:
                    return;
            }
            System.out.println("¿Desea realizar otra operación? (s/n)");
            String resp = sc.next();
            if (resp.equals("n")) return;
            sc.nextLine();
        }
    }
}
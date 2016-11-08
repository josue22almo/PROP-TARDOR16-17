/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author josue.inaldo.alcantara
 */
public class DriverPalabra {
    public static void main(String[] args) throws IOException {
        Palabra p = new Palabra();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Indique qué desea hacer:");
            System.out.println("1. Instanciar palabra vacía");
            System.out.println("2. Instanciar palabra con un String");
            System.out.println("3. Dar valor al atributo palabra de p");
            System.out.println("4. Get palabra");
            System.out.println("5. Set TF-IDF");
            System.out.println("6. Get frecuencia");
            System.out.println("7. Get TF-IDF"); 
            System.out.println("8. Incrementar frecuencia");
            System.out.println("9. Consultar si es igual a otra palabra");
            System.out.println("10. Salir");
            int op = sc.nextInt();
            String s;
             switch(op){
                 case 1:
                    System.out.print("Instanciar palabra vacia");
                    p = new Palabra();
                    break;
                case 2:
                    System.out.print("2. Instanciar palabra con un string, escribre una palabra y apreta enter ");
                    s = sc.next();
                    p = new Palabra(s);
                    break;
                case 3:
                    System.out.print("3. Dar valor al atributo palabra de p, escribre una palabra y apreta enter ");
                    s = sc.next();
                    p = new Palabra(s);
                    break;
                case 4:
                    System.out.print("4. Get palabra");
                    System.out.println("La palabra es " + p.getPalabra());
                    break;
                case 5:
                    System.out.print("5. Calcular TF-IDF. Escribe un double ");
                    int numDocs = sc.nextInt();
                    int numApariciones = sc.nextInt();
                    p.calcularTfDf(numDocs,numApariciones);                    
                  break;
                case 6:
                    System.out.print("6. Get frecuencia");
                    System.out.println("La frecuencia de la palabra es " + p.getFrecuencia());                    
                    break;
                case 7:
                    System.out.print("7. Get TF-IDF"); 
                    System.out.println("El TF-IDF de la palabra es " + p.getTfDf()); 
                    break;
                case 8:
                    System.out.print("8. Incrementar frecuencia");
                    p.incrementarFrecuencia();
                    break;
                case 9:
                    System.out.print("9. Consultar si es igual a otra palabra. Escribe la palabra a comparar ");
                    s = sc.next();
                    Palabra p2 = new Palabra(s);
                    if (p2.equals(p)) System.out.println("Son iguales");
                    else System.out.println("Son diferentes");
                    break;
                case 10:
                    System.out.println("Salir");                    
                    return;
             }                
        }       
    }
}

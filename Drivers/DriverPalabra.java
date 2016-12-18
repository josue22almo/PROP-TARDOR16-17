
package driverpalabra;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author florencia.rimolo
 */
public class DriverPalabra {
    public static void main(String[] args) throws IOException {
        Palabra p = new Palabra();
        Scanner sc = new Scanner(System.in);
        try {
        while(true){
            System.out.println("Indique qué desea hacer:");
            System.out.println("1. Instanciar palabra vacía");
            System.out.println("2. Instanciar palabra con un String");
            System.out.println("3. Modificar palabra");
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
                    System.out.println("Instanciar palabra vacia");
                    p = new Palabra();
                    break;
                case 2:
                    System.out.println("Palabra:");
                    s = sc.next();
                    p = new Palabra(s);
                    break;
                case 3:
                    System.out.println("Nueva palabra:");
                    s = sc.next();
                    p = new Palabra(s);
                    break;
                case 4:
                    System.out.println("La palabra es " + p.getPalabra());
                    break;
                case 5:
                    System.out.println("Escribe un ejemplo de cantidad de documentos:");
                    int numDocs = sc.nextInt();
                    System.out.println("Escribe un ejemplo de cantidad de documentos en los que aparece la palabra:");
                    int numApariciones = sc.nextInt();
                    p.calcularTFIDF(numDocs,numApariciones);                    
                  break;
                case 6:
                    System.out.println("La frecuencia de la palabra es " + p.getFrecuencia());                    
                    break;
                case 7: 
                    System.out.println("El TF-IDF de la palabra es " + p.getTFIDF()); 
                    break;
                case 8:
                    System.out.println("Incrementamos frecuencia"); 
                    p.incrementarFrecuencia();
                    break;
                case 9:
                    System.out.println("Escribe la palabra a comparar:");
                    s = sc.next();
                    Palabra p2 = new Palabra(s);
                    if (p2.equals(p)) System.out.println("Son iguales");
                    else System.out.println("Son diferentes");
                    break;
                case 10:
                    System.out.println("Salir");                    
                    return;
                default:
                    System.out.println("Operación incorrecta");  
                    break;
            }            
            System.out.println("¿Desea realizar otra operación? (s/n)");
            String resp = sc.next();
            if (resp.equals("n")) return;
            sc.nextLine();
        }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author josue.inaldo.alcantara
 */
public class DriverContenido {
    

    public static void main(String[] args){

        
        Scanner sc = new Scanner(System.in);
        Contenido cont = new Contenido();
        while(true){
            System.out.println("Indique qué desea hacer:");
            System.out.println("1. Instanciar contenido vacío");
            System.out.println("2. Instanciar contenido con un String");
            System.out.println("3. Get contenidoOriginal");
            System.out.println("4. Set contenidoOriginal con un String");
            System.out.println("5. Get contenidoReducido");
            System.out.println("6. Calcular distancia respecto a otro contenido");
            System.out.println("7. Salir");
            int op = sc.nextInt();
            String s;
            String j;
             switch(op){
                 case 1:
                    System.out.println("Instanciar contenido vacio");
                    cont = new Contenido();
                    break;
                case 2:
                    System.out.print("2.Instanciar cotenido con un string, escriba un contenido (la entrada acaba con un punto)");
                    j = sc.next();
                    s = "";
                    while (!j.equals(".")){
                        s += j;
                        s += " ";
                        j = sc.next();
                    }
                    cont = new Contenido(s);
                    break;
                case 3:
                    System.out.println("3.Get contenidoOriginal");
                    System.out.println("El contenido original es:");
                    System.out.println(cont.getContenidoOriginal());
                    break;
                case 4:
                    System.out.println("4.Set contenidoOriginal con un String, escriba un contenido (la entrada acaba con un punto)");
                    j = sc.next();
                    s = "";
                    while (!j.equals(".")){
                        s += j;
                        s += " ";
                        j = sc.next();
                    }
                    cont.setContenidoOriginal(s);
                    break;
                case 5:
                    System.out.println("5.Get contenidoReducido(resultado es un map, lo imprime por pantalla)");
                    Map <String,Palabra> m = cont.getContenidoReducido();
                    for (String key : m.keySet()){
                        System.out.println(key + " con frecuencia " + m.get(key).getFrecuencia() + " y TF-IDF " + m.get(key).getTfDf());
                    }
                  break;
                case 6:
                    System.out.println("6. Calcular distancia respecto a otro contenido, escriba el contenido para este nuevo contenido (la entrada acaba con un punto)");
                    j = sc.next();
                    s = "";
                    while (!j.equals(".")){
                        s += j;
                        s += " ";
                        j = sc.next();
                    }
                    Contenido cont2 = new Contenido(s);
                    System.out.println("La distancia (con la frecuencia) respecto a cont es " + cont.calcularDistancia(cont2.getContenidoReducido(),"FREC"));
                    System.out.println("La distancia (con TF-IDF) respecto a cont es " + cont.calcularDistancia(cont2.getContenidoReducido(),"TF-IDF"));
                    break;
                case 7:
                    System.out.println("Salir");                    
                    return;
             }
             sc.close();
        }        
    }   
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author josue.inaldo.alcantara
 */
public class DriverDiccionario {
    public static void main(String[] args){
        Diccionario diccionario = new Diccionario();
        Scanner sc = new Scanner(System.in);
        
        while(true){
            System.out.println("Indique qué desea hacer:");
            System.out.println("1. Añadir palabras al diccionario (la entrada acaba en un .)");
            System.out.println("2. Eliminar palabras del diccionario");
            System.out.println("3. Escribir diccionario");
            System.out.println("4. Salir");
            int op = sc.nextInt();
            String j;
            Map <String,Palabra> m;
            switch(op){
                case 1: 
                    m = new TreeMap<>();
                    j= sc.next();
                    while (!j.equals(".")){
                        j = sc.next();
                        Palabra p = new Palabra (j);
                        m.put(j, p);
                    }
                    diccionario.anadirPalabras(m);
                    break;
                case 2:
                    m = new TreeMap<>();
                    j= sc.next();
                    while (!j.equals(".")){
                        j = sc.next();
                        Palabra p = new Palabra (j);
                        m.put(j, p);
                    }
                    diccionario.eliminarPalabras(m);
                    break;
                case 3:
                    diccionario.print();
                    break;
                case 4:
                    return;
            }
        }
    }    
}
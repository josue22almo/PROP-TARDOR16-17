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
 * @author josue.inaldo.alcantara
 */
public class DriverTrie {
 
    public static void main(String[] args) throws IOException, Exception{
        Trie trie = new Trie();
        Scanner sc = new Scanner(System.in);
        while(true){
            try{
                String prefijo,aux;
                System.out.println("Escriba prefijo");
                prefijo = sc.nextLine();
                aux = sc.next();
                while (!aux.equals(".")){
                    prefijo += aux;
                    prefijo += " ";
                    aux = sc.next();
                }
                prefijo = prefijo.substring(0, prefijo.length()-1);
                System.out.println("Indique qué desea hacer con el prefijo:");
                System.out.println("1. Añadir prefijo");
                System.out.println("2. Eliminar prefijo");
                System.out.println("3. Consultar lista del prefijo");
                System.out.println("4. Escribir trie");
                System.out.println("5. Salir");
                int op = sc.nextInt();
                switch(op){
                    case 1:
                        trie.añadirPrefijo(prefijo);
                        System.out.println("Prefijo añadido");
                        break;
                    case 2:
                        trie.eliminarPrefijo(prefijo);
                        System.out.println("Prefijo eliminado");
                        break;
                    case 3:  
                        ArrayList<String> list = trie.consultarListaDelPrefijo(prefijo);
                        for (int i=0; i < list.size(); ++i){
                                System.out.println( list.get(i));
                        }   
                        break;
                    case 4:
                        trie.print();;
                        System.out.println("Lista imprimida");
                        break;
                    case 5:
                        return;
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}

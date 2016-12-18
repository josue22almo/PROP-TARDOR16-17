
package drivertrie;

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
        try{
            while(true){
                System.out.println("Indique qué desea hacer y aprete enter:");
                System.out.println("1. Añadir prefijo");
                System.out.println("2. Eliminar prefijo");
                System.out.println("3. Consultar lista del prefijo");
                System.out.println("4. Escribir trie");  
                System.out.println("5. Salir");  
                int op = sc.nextInt(); 
                sc.nextLine();                
                switch(op){
                    case 1:
                        System.out.println("Escribar el prefijo");
                        String prefijo = sc.nextLine();
                        trie.anadirPrefijo(prefijo);
                        break;
                    case 2:
                        System.out.println("Escribar el prefijo");
                        prefijo = sc.nextLine();
                        trie.eliminarPrefijo(prefijo);
                        break;
                    case 3:
                        System.out.println("Escribar el prefijo");
                        prefijo = sc.nextLine();
                        System.out.println("La lista del prefijo " + prefijo + " es:");
                        ArrayList <String> list = trie.consultarListaDelPrefijo(prefijo);
                        for (int i = 0; i < list.size(); ++i){
                            System.out.println(list.get(i));
                        }
                        break;
                    case 4: 
                        trie.print();
                        break;
                    case 5:
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
        }catch(Exception e){
            System.out.println(e.getMessage());
        }    
    }
}

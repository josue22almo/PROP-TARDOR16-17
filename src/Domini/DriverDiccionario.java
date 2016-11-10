
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
            System.out.println("Escriba las palabras(enter para finalizar entrada)");
            String j;
            Map <String,Palabra> m = new TreeMap<>();
            while (!(j = sc.next()).isEmpty()){
                Palabra p = new Palabra (j);
                m.put(j, p);
            }
            System.out.println("Indique qué desea hacer:");
            System.out.println("1. Añadir palabras al diccionario");
            System.out.println("2. Eliminar palabras del diccionario");
            System.out.println("3. Escribir diccionario");
            System.out.println("4. Salir");
            int op = sc.nextInt();
            switch(op){
                case 1:                     
                    diccionario.anadirPalabras(m);
                    break;
                case 2:                    
                    diccionario.eliminarPalabras(m);
                    break;
                case 3:
                    diccionario.print();
                    break;
                case 4:
                    return;
            }
            System.out.println("¿Desea realizar otra operación? (s/n)");
            String resp = sc.next();
            if (resp.equals("n")) return;
            sc.nextLine();
        }
    }    
}
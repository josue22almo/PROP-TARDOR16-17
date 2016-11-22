
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
        try {
            Diccionario diccionario = new Diccionario();
            Scanner sc = new Scanner(System.in);
            while(true){
                System.out.println("Indique qué desea hacer:");
                System.out.println("1. Añadir palabras al diccionario");
                System.out.println("2. Eliminar palabras del diccionario");
                System.out.println("3. Consultar diccionario");
                System.out.println("4. Salir");
                String j;
                Map <String,Palabra> m = new TreeMap<>();
                int op = sc.nextInt();
                sc.nextLine();
                switch(op){
                    case 1:
                        System.out.println("Escriba las palabras que desea añadir, cada una en una linea (la entrada debe acabar con una linea vacía):");
                        while (!(j = sc.nextLine()).isEmpty()){
                            Palabra p = new Palabra (j);
                            m.put(j, p);
                        }
                        diccionario.anadirPalabras(m);
                        break;
                    case 2:
                        System.out.println("Escriba las palabras que desea eliminar, cada una en una linea (la entrada debe acabar con una linea vacía):");
                        m = new TreeMap<>();
                        while (!(j = sc.nextLine()).isEmpty()){
                            Palabra p = new Palabra (j);
                            m.put(j, p);
                        }
                        diccionario.eliminarPalabras(m);
                        break;
                    case 3:
                        //diccionario.print();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Operación incorrecta");
                        break;
                }
                System.out.println("¿Desea realizar otra operación? (s/n)");
                String resp = sc.nextLine();
                if (resp.equals("n")) return;
                sc.nextLine();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }    
}
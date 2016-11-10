
package Domini;

import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author josue.inaldo.alcantara
 */
public class DriverContenido {
    public static void main(String[] args){
        Contenido cont = new Contenido();
        Scanner sc = new Scanner(System.in);
        try {
            while(true){            
                System.out.println();
                System.out.println("Indique qué desea hacer:");
                System.out.println("1. Instanciar contenido vacío");
                System.out.println("2. Instanciar contenido con un String");
                System.out.println("3. Get contenidoOriginal");
                System.out.println("4. Set contenidoOriginal con un String");
                System.out.println("5. Get contenidoReducido");
                System.out.println("6. Calcular distancia respecto a otro contenido");
                System.out.println("7. Salir");
                int op = sc.nextInt();
                sc.nextLine();
                switch(op){
                     case 1:
                        cont = new Contenido();
                        break;
                    case 2:
                        System.out.println("Escriba un contenido:");
                        String contenido = "";
                        String aux = "";
                        while (!(aux=sc.nextLine()).isEmpty()){
                            contenido += aux;
                            contenido += '\n';
                        }
                        cont = new Contenido(contenido);
                        break;
                    case 3:
                        System.out.println("El contenido original es:");
                        System.out.println(cont.getContenidoOriginal());
                        break;
                    case 4:
                        System.out.println("El nuevo contenido original sera:");
                        contenido = "";
                        aux = "";
                        //sc.nextLine();
                        while (!(aux=sc.nextLine()).isEmpty()){
                            contenido += aux;
                            contenido += '\n';
                        }
                        cont.setContenidoOriginal(contenido);
                        break;
                    case 5:
                        Map <String,Palabra> m = cont.getContenidoReducido();
                        if (m.isEmpty())
                            System.out.println("El contenido reducido está vacío");
                        else{
                            for (String key : m.keySet()){
                                System.out.println(key + " con frecuencia " + m.get(key).getFrecuencia() + " y TF-IDF " + m.get(key).getTFIDF());
                            }
                        }
                      break;
                    case 6:
                        System.out.println("Escriba el contenido respecto al cual quiere calcular la distancia:");
                        contenido = "";
                        aux = "";
                        //sc.nextLine();
                        while (!(aux=sc.nextLine()).isEmpty()){
                            contenido += aux;
                            contenido += '\n';
                        }
                        Contenido cont2 = new Contenido(contenido);
                        System.out.println("La distancia (con la frecuencia) respecto a cont es " + cont.calcularDistancia(cont2.getContenidoReducido(),"FREC"));
                        System.out.println("La distancia (con TF-IDF) respecto a cont es " + cont.calcularDistancia(cont2.getContenidoReducido(),"TF-IDF"));
                        break;
                    case 7:
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
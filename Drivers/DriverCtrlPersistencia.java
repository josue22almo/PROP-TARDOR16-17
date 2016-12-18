
package Persistencia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author florencia.rimolo
 */
public class DriverCtrlPersistencia {
    
    public static void main(String[] args) throws IOException{
        CtrlPersistencia ctrl = new CtrlPersistencia();

      /*  String folder = "/home/florenciarf/Dropbox/Informatica/prop/proj/Documentos";
        ArrayList<BufferedReader> list = ctrl.leerCarpeta(folder);
        for (int i = 0; i < list.size(); ++i){
            String autor = list.get(i).readLine();
            list.get(i).readLine();
            autor += '\n';
            String titulo = list.get(i).readLine();
            list.get(i).readLine();
            titulo += '\n';
            String contenido = "";
            String aux;                
            while ((aux = list.get(i).readLine()) != null){
                contenido += aux;
                contenido += '\n';
            }
            System.out.println(autor + '\n' + titulo + "\n" + contenido);
            System.out.println("------------------------------------------" + '\n');
        }*/
    }
}

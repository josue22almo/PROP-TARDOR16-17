
package Persistencia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author josue.inaldo.alcantara
 */
public class DriverCtrlPersistencia {
    
    public static void main(String[] args) throws Exception{
        CtrlPersistencia ctrl = new CtrlPersistencia();
        try{
            String folder = "/home2/users/alumnes/1193805/dades/Tercer/Q1/PROP/PROP-TARDOR16-17/Documentos/";
            ArrayList<BufferedReader> list = ctrl.leerCarpeta(folder);
            for (int i = 0; i < list.size(); ++i){
                String autor = list.get(i).readLine();
                String titulo = list.get(i).readLine();
                String contenido = "";
                String aux;                
                 while ((aux = list.get(i).readLine()) != null){
                    contenido += aux;
                    contenido += '\n';
                }
                System.out.println(autor + '\n' + titulo + "\n" + contenido);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

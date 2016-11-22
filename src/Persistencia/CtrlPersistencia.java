
package Persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author florencia.rimolo
 */
public class CtrlPersistencia {

    public CtrlPersistencia(){
    }

    public ArrayList<BufferedReader> leerCarpeta(String folder) throws IOException{
        File fichero = null;
        File[] archivos = null;
        ArrayList<BufferedReader> result = new ArrayList<>();
        BufferedReader b = null;
        try {
            fichero = new File(folder);
            archivos = fichero.listFiles();
            for (int i = 0; i < archivos.length; ++i){
                b = new BufferedReader(new FileReader(archivos[i].getPath()));
                result.add(b);
            }
            
        } catch (NullPointerException e) {
            System.out.println("La dirección que ha pasado no corresponde a un directorio.");
        }
        return result;
    }
    
    public ArrayList<String> leerPalabrasFuncionales(String archivo) throws IOException {
      String cadena;
      ArrayList<String> pf = new ArrayList<>();
      try {
      FileReader f = new FileReader(archivo);
      BufferedReader b = new BufferedReader(f);
      while((cadena = b.readLine())!=null) {
          pf.add(cadena);
      }
      b.close();
      } catch (FileNotFoundException e) {
          System.out.println("El fichero no existe.");
      }
      return pf;
    } 
}


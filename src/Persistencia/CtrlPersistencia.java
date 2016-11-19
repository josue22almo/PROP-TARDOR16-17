
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

    public ArrayList<BufferedReader> leerCarpeta(String folder) throws FileNotFoundException, IOException{
        File fichero = new File(folder);
        //if (!fichero.isDirectory())
        //    throw new Exception("La direccion que ha pasado no corresponde a un directorio.");
        File[] archivos = fichero.listFiles();
        ArrayList<BufferedReader> result = new ArrayList<>();
        for (int i = 0; i < archivos.length; ++i){
            FileReader f = new FileReader(archivos[i].getPath());
            BufferedReader b = new BufferedReader(f);
            result.add(b);
        }
        return result;
    }
}

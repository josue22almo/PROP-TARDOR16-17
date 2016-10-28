
package Persistencia;

import java.io.BufferedReader;
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

    public ArrayList<String> leerPalabras(String archivo) throws FileNotFoundException, IOException{
        ArrayList<String> l = new ArrayList<>();
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while(b.readLine()!=null) {
            l.add(b.readLine());
        }
        b.close();
        return l;
    }
}

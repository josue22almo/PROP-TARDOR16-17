
package Persistencia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author josue.inaldo.alcantara
 */
public class DriverCtrlPersistencia {
    
    public static void main(String[] args) throws IOException, FileNotFoundException{
        CtrlPersistencia ctrlPersistencia = new CtrlPersistencia();
        ArrayList<String> l = ctrlPersistencia.leerPalabras("/home2/users/alumnes/1193805/dades/Tercer/Q1/PROP/PROP-TARDOR16-17/palabras_cast.txt");
        for (String s : l){
            System.out.println(s);
        }
    }
}

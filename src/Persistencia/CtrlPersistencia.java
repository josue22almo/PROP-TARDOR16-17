
package Persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 *
 * @author florencia.rimolo
 */
public class CtrlPersistencia {

    public CtrlPersistencia(){
    }

    public ArrayList<BufferedReader> leerCarpeta(String rutaCarpeta) throws IOException{
        File directorio;
        File[] archivos;
        ArrayList<BufferedReader> result = new ArrayList<>();
        BufferedReader b;
        try {
            directorio = new File(rutaCarpeta);
            archivos = directorio.listFiles();
            for (int i = 0; i < archivos.length; ++i){
                b = new BufferedReader(new FileReader(archivos[i].getPath()));
                result.add(b);
            }
            
        } catch (NullPointerException e) {
            System.out.println("No se ha encontrado ningún documento en este directorio.");
        }
        return result;
    }
    
    public BufferedReader leerDocumento (File archivo) throws FileNotFoundException {
        return new BufferedReader(new FileReader(archivo));
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
    
    public void guardarDocumento (String autor, String titulo, String contenido, boolean first){
        if (first) eliminarDatos();
        try{
            PrintWriter writer = new PrintWriter("Datos/" + autor + "-" + titulo + ".txt", "UTF-8");
            writer.println(autor);
            writer.println(titulo);
            writer.println(contenido);
            writer.close();
        }catch(IOException e){
        
        }
    }
     
    private void eliminarDatos(){
        File folder = new File("Datos");
        File[] files = folder.listFiles();
        for (File file : files){
            file.delete();
        }
    }
}


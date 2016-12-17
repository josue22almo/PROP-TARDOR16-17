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

    private String path;
    
    public CtrlPersistencia(String path){
        this.path = path;
    }

    /*public void setPath(String path) {
        this.path = path;
    }*/

    public ArrayList<BufferedReader> leerCarpeta(String rutaCarpeta) throws FileNotFoundException {
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
    
    public ArrayList<String> leerPalabrasFuncionales(String archivo) throws Exception {
      String cadena;
      ArrayList<String> pf = new ArrayList<>();
      try {
      FileReader f = new FileReader(archivo);
      if (f == null) throw new Exception("No existe el fichero " + archivo);
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
    
    public void guardarDocumento (String autor, String titulo, String contenido) throws IOException{
        File txt = new File(path, titulo + "," + autor);
        System.out.println(path);
        txt.createNewFile();
        try ( PrintWriter writer = new PrintWriter(txt)) {
            //PrintWriter writer = new PrintWriter(path + autor + "-" + titulo + ".txt", "UTF-8")) {
            //File txt = new File(path, titulo);
            writer.println(autor);
            writer.println();
            writer.println(titulo);
            writer.println();
            writer.println(contenido);
            writer.flush();
            writer.close();
        }
    }
     
    public void eliminarDocumento(String autor, String titulo){
        File file = new File(path,titulo + "," + autor);
        if (file.delete())
            System.out.println("El fichero ha sido borrado satisfactoriamente");
        else
            System.out.println("El fichero no puede ser borrado");
    }
}
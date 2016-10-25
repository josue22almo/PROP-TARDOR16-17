/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author josue.inaldo.alcantara
 */
public class CjtoDocumentos {
    private MapDoc mapDocumentos;
    private ArrayList<Documento> vecDocumentos;
    private int numDocs;
    
    
    public CjtoDocumentos(){
        mapDocumentos = new MapDoc();
        vecDocumentos = new ArrayList<>();
        numDocs = 0;
    }
    
    public void altaDocumento() throws ExceptionsDomini{
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el nombre del autor del documento");
        String au = sc.nextLine();
        Autor autor = new Autor(au);
        System.out.println("Escribe el título del documento");
        String tit = sc.nextLine();
        Titulo titulo = new Titulo(tit);
        System.out.println("Escribe el contenido del documento");
        String cont = new String();
        int conta = 1;
        while(sc.hasNext() && conta < 2){ //leemos el contenido
            cont += sc.nextLine();
            conta += 1;
        }
        Contenido contenido = new Contenido(cont);
        
        Documento doc = new Documento(autor,titulo,contenido);
        System.out.println(autor.getAutor());
        
        if (mapDocumentos.containsKey(autor)){
            System.out.println("Existe el autor");//el autor ya existe
            if (mapDocumentos.containsValue(doc)){
                System.out.println("Existe el documento");
            } //no se añade el documento 
            else{
                System.out.println("Añadimos documento");
                mapDocumentos.addDocumento(autor,doc);
            }
        }else{
            System.out.println("Añadimos documento y autor");
            mapDocumentos.addAutorDocumento(autor,doc);
        }
    }
    
    
    public void eliminarDocumento(){
        System.out.println("Escribe el nombre del autor y el título del documento");
    }
   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author josue.inaldo.alcantara
 */
public class CjtoDocumentos {
    private Map <Autor, ArrayList<Documento>> mapDocumentos;
    private ArrayList<Documento> vecDocumentos;
    private int numDocs;
    
    
    public CjtoDocumentos(){
        mapDocumentos = new HashMap <>();
        vecDocumentos = new ArrayList<>();
        numDocs = 0;
    }
    
    private boolean existDoc(Documento doc){
        for (int i = 0; i < mapDocumentos.get(doc.getAutor()).size(); ++i){
            if (mapDocumentos.get(doc.getAutor()).equals(i)) return true;
        }
        return false;
    }
    
    public void altaDocumento() throws ExceptionsDomini{
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el nombre del autor del documento");
        String au = sc.nextLine();
        Autor autor = new Autor(au);
        System.out.println("Escribe título del documento");
        String tit = sc.nextLine();
        Titulo titulo = new Titulo(tit);
        System.out.println("Escribe el contenido del documento");
        String cont = new String();
        int conta = 1;
        while(sc.hasNext() && conta < 4){ //leemos el contenido
            cont += sc.nextLine();
            conta += 1;
        }
        Contenido contenido = new Contenido(cont);
        
        Documento doc = new Documento(autor,titulo,contenido);
        System.out.println(autor.getAutor());
      //  try{
        //    if (vecDocumentos.contains(doc)){ //el documento ya existe
          //      throw new ExceptionsDomini("El documento dado ya existe");
            //}else{
             //   System.out.println("Documento añadido a un autor no existente");
              // ArrayList<Documento> vd = new ArrayList<>();
              //  vd.add(doc);
               // mapDocumentos.put(autor, vd);
         //   }
          //  vecDocumentos.add(doc);
           // numDocs += 1;
      //  }catch(ExceptionsDomini e){
        //    System.out.println(e.getMessage());
        //} 
        if (!vecDocumentos.contains(doc))
            vecDocumentos.add(doc);
        else System.out.print("Ya existe el documento");
    }
    
    public void eliminarDocumento(){
        System.out.println("Escribe el nombre del autor y el título del documento");
    }
   
}

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
    private DocList vecDocumentos;
    private int id;
    
    
    public CjtoDocumentos(){
        vecDocumentos = new DocList();
        id = 0;
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
        while(sc.hasNext() && conta < 1){ //leemos el contenido
            cont += sc.nextLine();
            conta += 1;
        }
        Contenido contenido = new Contenido(cont);
        
        Documento doc = new Documento(autor,titulo,contenido,id);
        System.out.println(autor.getAutor());
        
        if (vecDocumentos.contains(doc)){
            //el documento ya existe
            System.out.println("Ya existe el documento");
        }else{
            System.out.println("Documento nuevo");
            vecDocumentos.add(doc);
            ++id;
        }
        vecDocumentos.print();
    }
    
    
    public void eliminarDocumento(){
        System.out.println("Escribe el nombre del autor y el título del documento");
    }
   
}

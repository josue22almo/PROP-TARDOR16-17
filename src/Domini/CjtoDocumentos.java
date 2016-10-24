/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;
import java.util.*;

/**
 *
 * @author josue.inaldo.alcantara
 */
public class CjtoDocumentos {
    private final Map <Autor, ArrayList<Documento>> mapDocumentos;
    private final ArrayList<Documento> vecDocumentos;
    private int numDocs;
    
    
    public CjtoDocumentos(){
        mapDocumentos = new HashMap <>();
        vecDocumentos = new ArrayList<>();
        numDocs = 0;
    }
    
    public void crearDocumento() throws ExceptionsDomini{
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el nombre del autor del documento");
        String au = sc.nextLine();
        Autor autor = new Autor(au);
        System.out.println("Escribe el nombre del título del documento");
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
        
        try{
        if (mapDocumentos.containsKey(autor)){ //al autor ya existe en el CjtoDocumentos
            if(!mapDocumentos.get(autor).add(doc))
                throw new ExceptionsDomini("El documento dado ya existe");
        }else{
            ArrayList<Documento> vd = new ArrayList<>();
            vd.add(doc);
            mapDocumentos.put(autor, vd);
        }
        vecDocumentos.add(doc);
        numDocs += 1;
        } catch(ExceptionsDomini e){
            System.out.println(e.getMessage());
        } 
    }
    
    public void eliminarDocumento(){
        System.out.println("Escribe el nombre del autor y el título del documento");
    }
}

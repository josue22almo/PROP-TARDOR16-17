/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.io.IOException;

/**
 *
 * @author jessica.sobreviela
 */
public class DriverCjtoDocumentos {
    public static void main(String[] args) throws IOException, ExceptionDomini{
        CjtoDocumentos c = new CjtoDocumentos();
        //Damos de alta un documento
        c.altaDocumento("Jessica","Prueba","abc");
        System.out.println("c = ");
        c.print();
        //Cambiamos el autor de un documento
        c.modificaAutorDoc("Jessica","Prueba","Jessica Sobreviela"); 
        System.out.println("c = ");
        c.print();
        //Cambiamos el titulo de un documento 
        c.modificaTituloDoc("Jessica Sobreviela","Prueba","Prueba2"); 
        System.out.println("c = ");
        c.print();
        //Cambiamos el contenido de un documento
        c.modificaContenidoDoc("Jessica Sobreviela","Prueba2","cba"); 
        System.out.println("c = ");
        c.print();
        //Damos de baja un documento
        c.bajaDocumento("Jessica Sobreviela","Prueba2");
        System.out.println("c = ");
        c.print();
        
        //Damos de alta un par de documentos para comprobar consultas
        c.altaDocumento("Jessica","Prueba","Abc.");
        c.altaDocumento("Jessica","Prueba2","Cba.");
        c.altaDocumento("Jessica Sobreviela","Prueba3", "Abc def.");
        
        //Cosultamos los titulos de los documentos de un autor en concreto
        c.consultarTitulosAutor("Jessica");
        //Consultamos los autores que coincidan con un prefijo determinado
        c.consultarAutores("Jess");
        //Consultamos el contenido de un documento
        c.consultarContenido("Jessica", "Prueba");
        //Consultamos los "2" documentos más parecidos al documento 
        //con autor = "Jessica" y titulo = "Prueba" por el método
        //de frecuencias
        c.getDocumentosParecidosFrecs("Jessica","Prueba","2");
        //Consultamos los "2" documentos más parecidos al documento 
        //con autor = "Jessica" y titulo = "Prueba" por el método
        //de TfDf
        c.getDocumentosParecidosTfDf("Jessica","Prueba","2");
        //Consultamos los documentos que contengan frases con  
        c.getDocumentosBool("abc & !def");
    }
}

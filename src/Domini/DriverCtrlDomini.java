
package Domini;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author jessica.sobreviela
 */
public class DriverCtrlDomini {
    public static void main(String[] args) throws IOException, Exception{
        CtrlDomini c = new CtrlDomini();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Indique qué desea hacer:");
            System.out.println("1. Dar de alta un documento");
            System.out.println("2. Dar de baja un documento");
            System.out.println("3. Modificar autor de un documento");
            System.out.println("4. Modificar titulo de un documento");
            System.out.println("5. Modificar contenido de un documento");
            System.out.println("6. Consultar titulos de los documentos de un autor");
            System.out.println("7. Consultar autores que empiezan por un prefijo");
            System.out.println("8. Consultar contenido de un documento"); 
            System.out.println("9. Consultar lista de los k documentos más parecidos a T por frecuencia");
            System.out.println("10. Consultar lista de los k documentos más parecidos a T por TfiDf");
            System.out.println("11. Consultar lista de los documentos con una expresión booleana");
            System.out.println("12. Escribir conjunto");
            System.out.println("13. Salir");
            String autor;
            String titulo;
            String contenido;
            String aux;
            int k;
            int op;
            op = sc.nextInt();
            switch(op){
                case 1:
                    System.out.println("Alta documento");
                    System.out.println("Autor:");
                    autor = sc.next();
                    System.out.println("Titulo:");
                    titulo = sc.next();
                    System.out.println("Contenido:");
                    contenido = sc.next();
                    try{
                        c.altaDocumento(autor,titulo,contenido);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Eliminar documento");
                    System.out.println("Autor:");
                    autor = sc.next();
                    System.out.println("Titulo:");
                    titulo = sc.next();
                    try{
                        c.bajaDocumento(autor,titulo); 
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Modificar autor");
                    System.out.println("Autor:");
                    autor = sc.next();
                    System.out.println("Titulo:");
                    titulo = sc.next();
                    System.out.println("Autor modificado:");
                    aux = sc.next();
                    try{
                        c.modificaAutorDoc(autor,titulo,aux); 
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Modificar titulo");
                   System.out.println("Autor:");
                   autor = sc.next();
                    System.out.println("Titulo:");
                    titulo = sc.next();
                    System.out.println("Titulo modificado:");
                    aux = sc.next();
                    try{
                        c.modificaTituloDoc(autor,titulo,aux); 
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Modificar contenido");
                    System.out.println("Autor:");
                    autor = sc.next();
                    System.out.println("Titulo:");
                    titulo = sc.next();
                    System.out.println("Contenido modificado:");
                    aux = sc.next();
                    try{
                        c.modificaContenidoDoc(autor,titulo,aux); 
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                  break;
                case 6:
                    System.out.println("Consular títulos autor");
                    System.out.println("Autor:");
                    autor = sc.next();
                    try{
                        c.consultarTitulosAutor(autor); 
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("Consulta por prefijo");
                    System.out.println("Prefijo:");
                    aux = sc.next();
                    try{
                        c.consultarAutores(aux); 
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    System.out.println("Consultar contenido");
                    System.out.println("Autor:");
                    autor = sc.next();
                    System.out.println("Titulo:");
                    titulo = sc.next();
                    try{
                        c.consultarContenido(autor,titulo); 
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 9:
                    System.out.println("Consultar k mas parecidos Frec");
                    System.out.println("Autor:");
                    autor = sc.next();
                    System.out.println("Titulo:");
                    titulo = sc.next();
                    System.out.println("Número de documentos:");
                    aux = sc.next();
                    k = Integer.parseInt(aux);
                    try{
                        c.getDocumentosParecidos(autor,titulo,k,"FREC"); 
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 10:
                    System.out.println("Consultar k mas parecidos TF-IDF");
                    System.out.println("Autor:");
                    autor = sc.next();
                    System.out.println("Titulo:");
                    titulo = sc.next();
                    System.out.println("Número de documentos:");
                    aux = sc.next();
                    k = Integer.parseInt(aux);
                    try{
                        c.getDocumentosParecidos(autor,titulo,k,"TF-IDF"); 
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 11:
                    System.out.println("Consulta expresion booleana");
                    System.out.println("Frase booleana:");
                    aux = sc.next();
                    try{
                        c.getDocumentosBool(aux);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 12: 
                    System.out.println("Escribir conjunto");
                    c.print();
                    return;     
                case 13: 
                    System.out.println("Salir");
                    return;               
            }
            System.out.println();
        }
    }
}


package Domini;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
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
            System.out.println("Indique quÃ© desea hacer:");
            System.out.println("1. Dar de alta conjunto de documentos con una carpeta");
            System.out.println("2. Dar de alta un documento");
            System.out.println("3. Dar de baja un documento");
            System.out.println("4. Modificar autor de un documento");
            System.out.println("5. Modificar titulo de un documento");
            System.out.println("6. Modificar contenido de un documento");
            System.out.println("7. Consultar titulos de los documentos de un autor");
            System.out.println("8. Consultar autores que empiezan por un prefijo");
            System.out.println("9. Consultar contenido de un documento"); 
            System.out.println("10. Consultar lista de los k documentos mÃ¡s parecidos a T");
            System.out.println("11. Consultar lista de los documentos con una expresiÃ³n booleana");
            System.out.println("12. Consultar todo el conjunto de documentos");
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
                    System.out.println("Dar de alta conjunto de documentos con una carpeta");
                    System.out.println("Direccion de la carpeta");
                    sc.nextLine();
                    String folder = sc.nextLine();
                    c.altaConjuntoDocumentosDirectorio(folder);
                case 2:
                    System.out.println("Alta documento");
                    System.out.println("Autor:");
                    sc.nextLine();
                    autor = sc.nextLine();
                    System.out.println("Titulo:");
                    sc.nextLine();
                    titulo = sc.nextLine();
                    System.out.println("Contenido (la entrada debe acabar con una linea vacÃ­a):");
                    sc.nextLine();
                    contenido = "";
                    aux = "";
                    while (!(aux=sc.nextLine()).isEmpty()){
                        contenido += aux;
                        contenido += '\n';
                    }
                    try{
                        c.altaDocumento(autor,titulo,contenido);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Baja documento");
                    System.out.println("Autor:");
                    sc.nextLine();
                    autor = sc.nextLine();
                    System.out.println("Titulo:");
                    sc.nextLine();
                    titulo = sc.nextLine();
                    try{
                        c.bajaDocumento(autor,titulo); 
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Modificar autor");
                    System.out.println("Autor:");
                    sc.nextLine();
                    autor = sc.nextLine();
                    System.out.println("Titulo:");
                    sc.nextLine();
                    titulo = sc.nextLine();
                    System.out.println("Autor modificado:");
                    sc.nextLine();
                    String autorAux = sc.nextLine();
                    try{
                        c.modificaAutorDoc(autor,titulo,autorAux); 
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Modificar titulo");
                    System.out.println("Autor:");
                    sc.nextLine();
                    autor = sc.nextLine();
                    System.out.println("Titulo:");
                    sc.nextLine();
                    titulo = sc.nextLine();
                    System.out.println("Titulo modificado:");
                    sc.nextLine();
                    String tituloAux = sc.nextLine();;
                    try{
                        c.modificaTituloDoc(autor,titulo,tituloAux); 
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("Modificar contenido");
                    System.out.println("Autor:");
                    sc.nextLine();
                    autor = sc.nextLine();
                    System.out.println("Titulo:");
                    sc.nextLine();
                    titulo = sc.nextLine();
                    System.out.println("Contenido modificado (la entrada debe acabar con una linea vacÃ­a):");
                    sc.nextLine();
                    String contAux = "";
                    aux = "";
                    while (!(aux=sc.nextLine()).isEmpty()){
                        contAux += aux;
                        contAux += '\n';
                    }
                    try{
                        c.modificaContenidoDoc(autor,titulo,contAux); 
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("Consular tÃ­tulos autor");
                    sc.nextLine();
                    autor = sc.nextLine();
                    try{
                        ArrayList<String> tit = c.consultarTitulosAutor(autor); 
                        for (int i=0; i < tit.size(); ++i){
                            System.out.println(tit.get(i));
                        }
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    System.out.println("Consultar autores por prefijo");
                    System.out.println("Prefijo:");
                    sc.nextLine();
                    String prefijo = "";
                    if (!(aux = sc.nextLine()).isEmpty())
                        prefijo = aux;
                    
                    try{
                        ArrayList<String> aut = c.consultarAutoresPorPrefijo(prefijo); 
                        for (int i=0; i < aut.size(); ++i){
                            System.out.println(aut.get(i));
                        }
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 9:
                    System.out.println("Consultar contenido");
                    System.out.println("Autor:");
                    sc.nextLine();
                    autor = sc.nextLine();
                    System.out.println("Titulo:");
                    sc.nextLine();
                    titulo = sc.nextLine();
                    try{
                        contenido = c.consultarContenido(autor,titulo); 
                        System.out.println(contenido);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 10:
                    System.out.println("Consultar k mas parecidos a T");
                    System.out.println("Autor:");
                    sc.nextLine();
                    autor = sc.nextLine();
                    System.out.println("Titulo:");
                    sc.nextLine();
                    titulo = sc.nextLine();
                    System.out.println("NÃºmero de documentos:");
                    sc.nextLine();
                    k = sc.nextInt();
                    System.out.println("Escribe FREC o TFIDF");
                    sc.nextLine();
                    aux = sc.nextLine();
                    try{
                        Map<String,String> docs = c.getDocumentosParecidos(autor,titulo,k,aux); 
                        for (String key : docs.keySet()){
                            System.out.println("Autor: " + key);
                            System.out.println("Titulo: " + docs.get(key));
                            System.out.println();
                        } 
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 11:
                    System.out.println("Consultar expresion booleana");
                    System.out.println("Frase booleana:");
                    sc.nextLine();
                    String booleano = sc.nextLine();
                    try{
                        c.getDocumentosBool(booleano);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                   break;
                case 12: 
                    System.out.println("Consultar todo el conjunto de documentos");
                    c.print();
                    break;
                case 13:
                    System.out.println("Salir");
                    return;   
                default:
                    System.out.println("OperaciÃ³n incorrecta");
                    break;
            }
            System.out.println();
        }
    }
}

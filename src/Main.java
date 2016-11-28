
package Domini;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author jessica.sobreviela
 */
public class Main {
    public static void main(String[] args) throws IOException, Exception{
        CtrlDomini c = new CtrlDomini();
        Scanner sc = new Scanner(System.in);
        try {
            while(true){
                System.out.println("Indique qué desea hacer:");
                System.out.println("1. Dar de alta a un conjunto de documentos dado un directorio");
                System.out.println("2. Dar de alta un documento");
                System.out.println("3. Dar de baja un documento");
                System.out.println("4. Modificar autor de un documento");
                System.out.println("5. Modificar titulo de un documento");
                System.out.println("6. Modificar contenido de un documento");
                System.out.println("7. Consultar titulos de los documentos de un autor");
                System.out.println("8. Consultar autores que empiezan por un prefijo");
                System.out.println("9. Consultar contenido de un documento"); 
                System.out.println("10. Consultar lista de los k documentos más parecidos a T");
                System.out.println("11. Consultar lista de los documentos con una expresión booleana");
                System.out.println("12. Consultar todo el conjunto de documentos");
                System.out.println("13. Salir");
                String autor;
                String titulo;
                String contenido;
                String aux;
                int k;
                int op;
                op = sc.nextInt();
                sc.nextLine();
                switch(op){
                    case 1:
                        System.out.println("Escriba la dirección");
                        String directorio = sc.nextLine();
                            c.altaConjuntoDocumentosDirectorio(directorio);
                    case 2:
                        System.out.println("Alta documento");
                        System.out.println("Autor:");
                        autor = sc.nextLine();
                        System.out.println("Titulo:");
                        titulo = sc.nextLine();
                        System.out.println("Contenido (la entrada debe acabar con una linea vacía):");
                        contenido = "";
                        aux = "";
                        while (!(aux=sc.nextLine()).isEmpty()){
                            contenido += aux;
                            contenido += '\n';
                        }
                        c.altaDocumento(autor,titulo,contenido);
                        break;
                    case 3:
                        System.out.println("Baja documento");
                        System.out.println("Autor:");
                        autor = sc.nextLine();
                        System.out.println("Titulo:");
                        titulo = sc.nextLine();
                        c.bajaDocumento(autor,titulo); 
                        break;
                    case 4:
                        System.out.println("Modificar autor");
                        System.out.println("Autor:");
                        autor = sc.nextLine();
                        System.out.println("Titulo:");
                        titulo = sc.nextLine();
                        System.out.println("Autor modificado:");
                        String autorAux = sc.nextLine();
                        c.modificaAutorDoc(autor,titulo,autorAux); 
                        break;
                    case 5:
                        System.out.println("Modificar titulo");
                        System.out.println("Autor:");
                        autor = sc.nextLine();
                        System.out.println("Titulo:");
                        titulo = sc.nextLine();
                        System.out.println("Titulo modificado:");
                        String tituloAux = sc.nextLine();;
                        c.modificaTituloDoc(autor,titulo,tituloAux); 
                        break;
                    case 6:
                        System.out.println("Modificar contenido");
                        System.out.println("Autor:");
                        autor = sc.nextLine();
                        System.out.println("Titulo:");
                        titulo = sc.nextLine();
                        System.out.println("Contenido modificado (la entrada debe acabar con una linea vacía):");
                        String contAux = "";
                        aux = "";
                        while (!(aux=sc.nextLine()).isEmpty()){
                            contAux += aux;
                            contAux += '\n';
                        }
                        c.modificaContenidoDoc(autor,titulo,contAux); 
                        break;
                    case 7:
                        System.out.println("Consular títulos autor");
                        autor = sc.nextLine();
                        ArrayList<String> tit = c.consultarTitulosAutor(autor); 
                        for (int i=0; i < tit.size(); ++i){
                            System.out.println(tit.get(i));
                        }
                        break;
                    case 8:
                        System.out.println("Consultar autores por prefijo");
                        System.out.println("Prefijo:");
                        String prefijo = "";
                        if (!(aux = sc.nextLine()).isEmpty())
                            prefijo = aux;
                        ArrayList<String> aut = c.consultarAutoresPorPrefijo(prefijo); 
                        for (int i=0; i < aut.size(); ++i){
                            System.out.println(aut.get(i));
                        }
                        break;
                    case 9:
                        System.out.println("Consultar contenido");
                        System.out.println("Autor:");
                        autor = sc.nextLine();
                        System.out.println("Titulo:");
                        titulo = sc.nextLine();
                        contenido = c.consultarContenido(autor,titulo); 
                        System.out.println(contenido);
                        break;
                    case 10:
                        System.out.println("Consultar k mas parecidos a T");
                        System.out.println("Autor:");
                        autor = sc.nextLine();
                        System.out.println("Titulo:");
                        titulo = sc.nextLine();
                        System.out.println("Número de documentos:");
                        k = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Escribe FREC o TFIDF:");
                        aux = sc.nextLine();
                        Map<String,String> docs = c.getDocumentosParecidos(autor,titulo,k,aux); 
                        for (String key : docs.keySet()){
                            System.out.println("Autor: " + key);
                            System.out.println("Titulo: " + docs.get(key));
                            System.out.println();
                        } 
                        break;
                    case 11:
                        System.out.println("Consultar expresion booleana");
                        System.out.println("Frase booleana:");
                        String booleano = sc.nextLine();
                        c.getDocumentosBool(booleano);
                        break;
                    case 12: 
                        System.out.println("Consultar todo el conjunto de documentos");
//                        c.print();
                        break;
                    case 13:
                        System.out.println("Salir");
                        return;   
                    default:
                        System.out.println("Operación incorrecta.");
                        break;
                }
                System.out.println("¿Desea realizar otra operación? (s/n)");
                String resp = sc.nextLine();
                if (resp.equals("n")) return;
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());          
        }    
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jessica.sobreviela
 */
public class DriverCjtoDocumentos {
    public static void main(String[] args) throws IOException, Exception{
        CjtoDocumentos c = new CjtoDocumentos();
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
           // System.out.println("12. Escribir palabras del diccionario");
            System.out.println("12. Escribir todo el conjunto de documentos");
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
                    autor = "";
                    aux = sc.next();
                    while (!aux.equals(".")){
                        autor += aux;
                        autor += " ";
                        aux = sc.next();
                    }
                    System.out.println("Titulo:");
                    titulo = "";
                    aux = sc.next();
                    while (!aux.equals(".")){
                        titulo += aux;
                        titulo += " ";
                        aux = sc.next();
                    }
                    System.out.println("Contenido:");
                    contenido = "";
                    aux = sc.next();
                    while (!aux.equals(".")){
                        contenido += aux;
                        contenido += " ";
                        aux = sc.next();
                    }
                    try{
                        c.altaDocumento(autor,titulo,contenido);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Baja documento");
                    System.out.println("Autor:");
                    autor = "";
                    aux = sc.next();
                    while (!aux.equals(".")){
                        autor += aux;
                        autor += " ";
                        aux = sc.next();
                    }
                    System.out.println("Titulo:");
                    titulo = "";
                    aux = sc.next();
                    while (!aux.equals(".")){
                        titulo += aux;
                        titulo += " ";
                        aux = sc.next();
                    }
                    try{
                        c.bajaDocumento(autor,titulo); 
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Modificar autor");
                    System.out.println("Autor:");
                    autor = "";
                    aux = sc.next();
                    while (!aux.equals(".")){
                        autor += aux;
                        autor += " ";
                        aux = sc.next();
                    }
                    System.out.println("Titulo:");
                    titulo = "";
                    aux = sc.next();
                    while (!aux.equals(".")){
                        titulo += aux;
                        titulo += " ";
                        aux = sc.next();
                    }
                    System.out.println("Autor modificado:");
                    aux = sc.next();
                    String autorAux = "";
                    while (!aux.equals(".")){
                        autorAux += aux;
                        autorAux += " ";
                        aux = sc.next();
                    }
                    try{
                        c.modificaAutorDoc(autor,titulo,autorAux); 
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Modificar titulo");
                    System.out.println("Autor:");
                    autor = "";
                    aux = sc.next();
                    while (!aux.equals(".")){
                        autor += aux;
                        autor += " ";
                        aux = sc.next();
                    }
                    System.out.println("Titulo:");
                    titulo = "";
                    aux = sc.next();
                    while (!aux.equals(".")){
                        titulo += aux;
                        titulo += " ";
                        aux = sc.next();
                    }
                    System.out.println("Titulo modificado:");
                    aux = sc.next();
                    String tituloAux = "";
                    while (!aux.equals(".")){
                        tituloAux += aux;
                        tituloAux += " ";
                        aux = sc.next();
                    }
                    try{
                        c.modificaTituloDoc(autor,titulo,tituloAux); 
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Modificar contenido");
                    System.out.println("Autor:");
                    autor = "";
                    aux = sc.next();
                    while (!aux.equals(".")){
                        autor += aux;
                        autor += " ";
                        aux = sc.next();
                    }
                    System.out.println("Titulo:");
                    titulo = "";
                    aux = sc.next();
                    while (!aux.equals(".")){
                        titulo += aux;
                        titulo += " ";
                        aux = sc.next();
                    }
                    System.out.println("Contenido modificado:");
                    aux = sc.next();
                    String contAux = "";
                    while (!aux.equals(".")){
                        contAux += aux;
                        contAux += " ";
                        aux = sc.next();
                    }
                    try{
                        c.modificaContenidoDoc(autor,titulo,contAux); 
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("Consular títulos autor");
                    autor = "";
                    aux = sc.next();
                    while (!aux.equals(".")){
                        autor += aux;
                        autor += " ";
                        aux = sc.next();
                    }
                    try{
                        ArrayList<String> tit = c.consultarTitulosAutor(autor); 
                        for (int i=0; i < tit.size(); ++i){
                            System.out.println(tit.get(i));
                        }
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("Consultar autores por prefijo");
                    System.out.println("Prefijo:");
                    String prefijo = "";
                    aux = sc.next();
                    while (!aux.equals(".")){
                        prefijo += aux;
                        prefijo += " ";
                        aux = sc.next();
                    }
                    try{
                        ArrayList<String> aut = c.consultarAutoresPorPrefijo(prefijo); 
                        for (int i=0; i < aut.size(); ++i){
                            System.out.println(aut.get(i));
                        }
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    System.out.println("Consultar contenido");
                    System.out.println("Autor:");
                    autor = "";
                    aux = sc.next();
                    while (!aux.equals(".")){
                        autor += aux;
                        autor += " ";
                        aux = sc.next();
                    }
                    System.out.println("Titulo:");
                    titulo = "";
                    aux = sc.next();
                    while (!aux.equals(".")){
                        titulo += aux;
                        titulo += " ";
                        aux = sc.next();
                    }
                    try{
                        contenido = c.consultarContenido(autor,titulo); 
                        System.out.println(contenido);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 9:
                    System.out.println("Consultar k mas parecidos a T por Frec");
                    System.out.println("Autor:");
                    autor = "";
                    aux = sc.next();
                    while (!aux.equals(".")){
                        autor += aux;
                        autor += " ";
                        aux = sc.next();
                    }
                    System.out.println("Titulo:");
                    titulo = "";
                    aux = sc.next();
                    while (!aux.equals(".")){
                        titulo += aux;
                        titulo += " ";
                        aux = sc.next();
                    }
                    System.out.println("Número de documentos:");
                    k = sc.nextInt();
                    try{
                        ArrayList<Documento> docs = c.getDocumentosParecidos(autor,titulo,k,"FREC"); 
                        for (int i=0; i < docs.size(); ++i){
                            System.out.println("Autor: " + docs.get(i).getAutor());
                            System.out.println("Titulo: " + docs.get(i).getTitulo());
                            System.out.println("Contenido: " + docs.get(i).getContenidoOriginal());
                            System.out.println();
                        } 
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 10:
                    System.out.println("Consultar k mas parecidos a T por TF-IDF");
                    System.out.println("Autor:");
                    autor = "";
                    aux = sc.next();
                    while (!aux.equals(".")){
                        autor += aux;
                        autor += " ";
                        aux = sc.next();
                    }
                    System.out.println("Titulo:");
                    titulo = "";
                    aux = sc.next();
                    while (!aux.equals(".")){
                        titulo += aux;
                        titulo += " ";
                        aux = sc.next();
                    }
                    System.out.println("Escribe k:");
                    k = sc.nextInt();
                    try{
                    	ArrayList<Documento> docs = c.getDocumentosParecidos(autor, titulo, k, "TF-IDF"); 
                        //c.print();
                        for (int i=0; i < docs.size(); ++i){
                            System.out.println("Autor: " + docs.get(i).getAutor());
                            System.out.println("Titulo: " + docs.get(i).getTitulo());
                            System.out.println("Contenido: " + docs.get(i).getContenidoOriginal());
                            System.out.println();
                        } 
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 11:
                    System.out.println("Consultar expresion booleana");
                    System.out.println("Frase booleana:");
                    String booleano = "";
                    aux = sc.next();
                    while (!aux.equals(".")){
                        booleano += aux;
                        booleano += " ";
                        aux = sc.next();
                    }
                    try{
                        c.getDocumentosBool(booleano);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                   break;
                case 12: 
                    System.out.println("Escribir todo el conjunto de documentos");
                    c.print();
                    break;
                case 13:
                    System.out.println("Salir");
                    return;   
            }
            System.out.println();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;
import java.util.Scanner;

/**
 *
 * @author florencia.rimolo
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        CjtoDocumentos  cjD= new CjtoDocumentos();
        while(true){
            System.out.println("Indique que quiere hacer:");
            System.out.println("1. Dar alta documento");
            System.out.println("2. Eliminar documento");
            System.out.println("3.Modificar documento");
            System.out.println("4.Lista de títulos de un autor");
            System.out.println("5.Lista de autores que empiezan por un prefijo");
            System.out.println("6.Contenido de un documento dado su título"); 
            System.out.println("7.Lista de los k documentos más parecidos a T");
            System.out.println("8.Lista de los documentos con una expresión booleana");
            System.out.println("9.Salir");
            int op;
            op = sc.nextInt();
            switch(op){
                case 1:
                    cjD.crearDocumento();
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9: break;               
            }
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.util.ArrayList;

/**
 *
 * @author josue.inaldo.alcantara
 */
public class DriverContenido {
    

    public static void main(String[] args){
       /* String s = "Después de estar lejos de casa, horas trascurridas, momentos que no podría olvidar pero serán meramente recuerdos en la memoria.\n" +
"\n" +
"Los días transcurren normalmente y la continuidad de la monotonía se interrumpe mientras las palabras alegres de personas queridas invaden espacios vacios esperando ser llenados.\n" +
"El cansancio físico no dispone el cuerpo a continuar mientras las ganas de seguir le impulsan y continua siguiendo…\n" +
"\n" +
"Hay un rostro conocido, distante pero inusualmente extrañado. Sin la confianza del que posee, queriendo conquistar un espacio jamás visitado, pretendiendo alcanzar la mano de alguien que no estará, extrañando la presencia de alguien que no ha estado cerca jamás. Es sentir la compañía de la soledad compartida por otra.\n" +
"\n" +
"Queriendo, añorando, deseando. En la soledad de la compañía de cientos que no hablarán.\n" +
"Sin desearlo, la perdición del que anhela sin alcanzar lo deseado, llegando desde lejano sitio, el cariño despoja la razón mientras la añoranza tortura la tranquilidad del alma apacible, tranquila que sin sobresaltos descansaba en el letargo de la singularidad.";*/
        String s = "aaa aaa aaa bbb bbb bbb ccc ccc ddd ddd eee";
        
        Contenido cont = new Contenido();
        Contenido cont2 = new Contenido ("aaa aaa bbb bbb ccc ddd aaa bbb ccc ddd");
             
        //tiene que dar 0 porque cont no tiene nada
        double d = cont.calcularDistancia(cont2.getContenidoReducido());
        double d2 = cont2.calcularDistancia(cont.getContenidoReducido());
        System.out.println("Producto escalar = " + d  + " o " + d2);
        //actualizamosel contenidoOriginal
        cont.setContenidoOriginal(s); 
        //volvemos a calcular la distancia
        d = cont.calcularDistancia(cont2.getContenidoReducido());
        d2 = cont2.calcularDistancia(cont.getContenidoReducido());
        System.out.println("Producto escalar = " + d  + " o " + d2);
        //comparamos el contenidoOriginal con s
        System.out.println("Parecido de los contenidos " + s.equals(cont2.getContenidoOriginal()));
    } 
    
      
}

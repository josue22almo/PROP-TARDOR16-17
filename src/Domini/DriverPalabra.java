/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.io.IOException;

/**
 *
 * @author josue.inaldo.alcantara
 */
public class DriverPalabra {
    public static void main(String[] args) throws IOException {
        Palabra p = new Palabra();
        p.setPalabra("Hola");
        //Escribimos el valor de p
        System.out.println("p = " + p.getPalabra());
        //Cambiamos el valor de la frecuencia
        p.setFrecuencia(15);
        //Imprimimos el valor de la frecuencia
        System.out.println("p frec= " + p.getFrecuencia());
        //Cambiamos el valor de la TfDf
        p.setTfDf(5);
        //Imprimimos el valor de la frecuencia
        System.out.println("p frec= " + p.getTfDf());
        //incrementamos la frecuencia
        p.incrementarFrecuencia();
        //Imprimimos el valor de la nuevafrecuencia
        System.out.println("p frec= " + p.getFrecuencia());
        //Creamos un Palabra con la otra creadora y las comparamos 
        Palabra p2 = new Palabra("Adios");
        System.out.println("p y p2 son " + p.equals(p2));
    }
}

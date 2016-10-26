/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import Persistencia.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author florencia.rimolo
 */
public class CtrlDomini {

    public CtrlDomini(){}
    
    public void leerPalabras(ArrayList<String> español,ArrayList<String> catalan,ArrayList<String> ingles) throws IOException, FileNotFoundException{
        CtrlPersistencia ctrlPersistencia = new CtrlPersistencia();
        español = ctrlPersistencia.leerPalabras("/home2/users/alumnes/1193805/dades/Tercer/Q1/PROP/PROP-TARDOR16-17/palabras_cast.txt");
        catalan = ctrlPersistencia.leerPalabras("/home2/users/alumnes/1193805/dades/Tercer/Q1/PROP/PROP-TARDOR16-17/words_en.txt");
        ingles = ctrlPersistencia.leerPalabras("/home2/users/alumnes/1193805/dades/Tercer/Q1/PROP/PROP-TARDOR16-17/palaures_cat.txt");
    }
    
}

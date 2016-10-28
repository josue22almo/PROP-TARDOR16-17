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
    
    public ArrayList<String> leerPalabras(String path) throws IOException, FileNotFoundException{
        CtrlPersistencia ctrlPersistencia = new CtrlPersistencia();
        ArrayList<String> list = ctrlPersistencia.leerPalabras(path);
        return list;
    }
    
}

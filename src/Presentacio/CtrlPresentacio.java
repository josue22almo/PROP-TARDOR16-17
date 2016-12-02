/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio;
import Domini.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author florencia.rimolo
 */
public class CtrlPresentacio {
    private CtrlDomini cd;
    
    public CtrlPresentacio() throws IOException {
        this.cd = new CtrlDomini();
    }
    
    public ArrayList<String> getAutorPref(String autor) throws Exception {
        return this.cd.consultarAutoresPorPrefijo(autor);
    }
}

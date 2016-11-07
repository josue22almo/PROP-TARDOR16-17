/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import Persistencia.*;
import java.util.ArrayList;
/**
 *
 * @author florencia.rimolo
 */
public class CtrlDomini {
    private CjtoDocumentos cd = new CjtoDocumentos();
    
    public CtrlDomini(){}
    
    public void altaDocumento(String autor, String titulo, String contenido) {
        cd.altaDocumento(autor, titulo, contenido);
    }
    
    public void bajaDocumento(String autor, String titulo) {
        cd.bajaDocumento(autor, titulo);
    }
    
    
    
}

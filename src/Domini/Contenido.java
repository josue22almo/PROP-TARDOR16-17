/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

/**
 *
 * @author florenciarf
 */
public class Contenido {
    private String[] contenidoOriginal;
    private String[] contenidoReducido;

    public Contenido(){
    }
    
    public Contenido(String[] contenidoOriginal) {
        this.contenidoOriginal = contenidoOriginal;
        calcularContenidoReducido();
    }

    public String[] getContenidoOriginal() {
        return contenidoOriginal;
    }

    public void setContenidoOriginal(String[] contenidoOriginal) {
        this.contenidoOriginal = contenidoOriginal;
    }

    public String[] getContenidoReducido() {
        return contenidoReducido;
    }
    
    private void calcularContenidoReducido(){
    }
    
}

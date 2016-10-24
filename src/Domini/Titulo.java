/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

/**
 *
 * @author josue.inaldo.alcantara
 */
public class Titulo {
    private String titulo;
    
    public Titulo(){
        titulo = new String();
    }
    
    public Titulo (String titulo){
        this.titulo = titulo;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
}

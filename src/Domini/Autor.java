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
public class Autor {
    
    private String autor;

    public Autor(String autor) {
        this.autor = autor;
    }

    public Autor(){
        this.autor = new String();
    }


    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public boolean equals(Autor a){
        return this.autor.equals(a.getAutor());
    }        
}

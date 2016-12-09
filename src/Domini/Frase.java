
package Domini;
/**
 *
 * @author Josue Inaldo Alcantara Moreno
 */
import java.util.ArrayList;

public class Frase {
    private ArrayList<String> frase;
    private boolean first;
    private String stringFrase;
    
    public Frase() {
        this.frase = new ArrayList<>();
        first = true;
        stringFrase = "";
    }
        
    public void addPalabra (String palabra){
        frase.add(palabra);
        if(first){
            stringFrase += palabra;
            first = false;
        }else stringFrase += " " + palabra;
    }
    
    public ArrayList<String> getFrase(){
        return frase;
    }

    boolean contains(String frase) {
        boolean b = stringFrase.contains(frase);
        return b;
    }
    
    boolean contains(ArrayList<String> words) {
        boolean b = true;
        for (int i = 0; i < words.size() && b;++i){
            b = frase.contains(words.get(i));
        }
        return b;
    }
}


package Domini;

import java.util.ArrayList;

/**
 *
 * @author Josue Inaldo Alcantara Moreno
 */
public class SetExpressionNode extends ValueExpressionNode{
    
    private ArrayList<String> words;

    
    public SetExpressionNode(){
        super();
        words = new ArrayList<>();
    }

    SetExpressionNode(ArrayList<String> words) {
        this.words = (ArrayList)words.clone();
    }
    
    @Override
    public int getType() {
        return Values.SET_NODE;
    }

    @Override
    public boolean getValue(Frase frase) {
        return frase.contains(words);
    }   
}

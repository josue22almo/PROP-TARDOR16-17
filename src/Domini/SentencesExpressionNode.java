
package Domini;

/**
 *
 * @author josue.inaldo.alcantara
 */
public class SentencesExpressionNode extends ValueExpressionNode{

    private String frase;
    private boolean first = true;
    
    public SentencesExpressionNode(){
        super();
        frase = "";
    }

    SentencesExpressionNode(String frase) {
        this.frase = frase;
    }
 
    @Override
    public int getType() {
        return Values.SENTENCES_NODE;
    }

    @Override
    public boolean getValue(Frase f) {
        return f.contains(frase);
    }
    
}


package Domini;
/**
 *
 * @author josue.inaldo.alcantara
 */
public class AndNode extends OperationExpressionNode{
    
     public AndNode() {
        super();
      }

      public AndNode(ExpressionNode node,boolean signed) {
        super(node, signed);
      }
    
    @Override
    public int getType() {
        return Values.AND_NODE;
    }

    @Override
    public boolean getValue(Frase frase) {
       boolean b = true;
       for(Term term : terms){
           if (term.negated) 
               b = b && !term.expression.getValue(frase);
           else b = b && term.expression.getValue(frase);
       }
       return b;
    }
    
}

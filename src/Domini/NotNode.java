
package Domini;


/**
 *
 * @author Josue Inaldo Alcantara Moreno
 */
public class NotNode extends OperationExpressionNode {

    public NotNode() {
    }

    NotNode(ExpressionNode exp, boolean signed) {
        super(exp,signed);
    }
    
    @Override
    public int getType() {
        return Values.OPERATION_NODE;
    }

    @Override
    public boolean getValue(Frase frase) {
        boolean b = false;
        for(Term term : terms){
            if (term.negated)
                b = !term.expression.getValue(frase);
            else b = term.expression.getValue(frase);
        }
        return b;
    }
    
}

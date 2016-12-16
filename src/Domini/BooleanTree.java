
package Domini;

/**
 *
 * @author Josue Inaldo Alcántara Moreno
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jdk.nashorn.internal.runtime.ParserException;

public class BooleanTree {
       
    private LinkedList<Token> tokensOriginal;
    private LinkedList<Token> tokens;
    private ArrayList<TokenInfo> tokenInfos;
    private ExpressionNode tree;
    private class TokenInfo {
        public final Pattern regex;
        public final int token;

        public TokenInfo(Pattern regex, int token) {
          super();
          this.regex = regex;
          this.token = token;
        }
    }
    private Token top;

    public BooleanTree(String str) throws Exception{
        tokens = new LinkedList<>();
        tokenInfos = new ArrayList<>();
        tokensOriginal = new LinkedList<>();
        add("\\(", 1); // open bracket
        add("\\)", 2); // close bracket
        add("\\}", 3); // close curly bracket
        add("\\{", 4); // open curly bracket
        add("\\&", 5); // and
        add("\\|", 6); // or
        add("\\!", 7); // not
        add("\"", 8); // comillas dobles 	
        add("[a-zA-Z][a-zA-Z0-9_]*", 9); // letters and numbers
        add("\\x20", 10); //space
        analizarExpresion(str);
        tree = createTree();
    }
  
    public boolean satisfyExpression(Documento doc){
        ArrayList<Frase> frases = doc.getFrases();
        boolean b = false;
        for (int i = 0; i < frases.size() && !b;++i){
            Frase frase = frases.get(i);
            b = tree.getValue(frase);
        }
        return b;
    }
    private ExpressionNode createTree() throws Exception{
        this.tokens = (LinkedList)tokensOriginal.clone();
        top = this.tokens.get(0);
        ExpressionNode result = expression();
        if (top.token != Values.EPSILON)
          throw new Exception("Símbolo inesperado" +  top.sequence);
        return result;
    }
    
    private void analizarExpresion(String str) throws ParserException{
        String s = preparedString(str);
        tokensOriginal.clear();
        String tok = "";    
        char t = ' ';
        while(!s.equals("")){
            boolean finded = false;
            for (TokenInfo tokenInfo : tokenInfos){
                Matcher m = tokenInfo.regex.matcher(s);                
                t = s.charAt(0);
                if (m.find()){
                    finded = true;
                    tok = m.group().trim();
                    if(tokenInfo.token != Values.ESPACIO)
                        tokensOriginal.add(new Token(tokenInfo.token,tok));
                    s = m.replaceFirst("");
                    break;
                }
            }
            String j = "" + t;
            if (!finded) throw new ParserException("Caràcter inesperat en l'entrada: " + j);
        }
    }
    
    private ExpressionNode expression()throws Exception{
        // expression -> signed_term op
        ExpressionNode exp = signed_term();
        ExpressionNode result = op(exp);
        return result;
    } 
    
    private ExpressionNode signed_term() throws Exception{
        ExpressionNode result;
        if (top.token == Values.NOT){
            //signed_term -> NOT term()
            nextToken();
            ExpressionNode term = term();
            result = new NegatedNode(term,true);
        }else result = term();  //signed_term -> term
        return result; 
    }
    
    private ExpressionNode op(ExpressionNode exp) throws Exception{
        if (top.token == Values.AND || top.token == Values.OR){
            //op -> AND term expression
            OperationExpressionNode result;
            if (top.token == Values.AND){
                result = new AndNode(exp,false);
            }else{
                result = new OrNode(exp,false);
            }
            boolean signed = top.sequence.equals("!");
            nextToken();
            ExpressionNode e = expression();
            result.add(e, signed);
            return result;
        }
        return exp;//epsilon
    }
    
    private ExpressionNode term() throws Exception{
        ExpressionNode exp;
        switch (top.token){
            case Values.COMA:
                //term -> COMA argument COMA
                nextToken();
                exp = argument_comas();
                if (top.token != Values.COMA) 
                    throw new Exception("No se han encontrado las comillas de cierre");
                nextToken();                
                break;
            case Values.OC_BRACKET:
                //term -> OC_BRACKET argument CC_BRACKET
                nextToken();
                exp = argument_curly_brackets();
                //argument_curly_brackets();
                if (top.token != Values.CC_BRACKET) 
                    throw new Exception("No se han cerrado alguno de los curly brackets {}");
                nextToken();
                break;
            case Values.OPEN_BRACKET:
                //term -> OPEN_BRACKET expression CLOSE_BRACKET
                nextToken();
                exp = expression();
                if(top.token != Values.CLOSE_BRACKET)
                    throw new Exception("No se han cerrado alguno de los parentesis");
                nextToken();
                break;
            default:
                //term -> argument
                exp = argument_curly_brackets();
                break;
        }
        return exp;
    }
    
    private ExpressionNode argument_curly_brackets(){
        ArrayList<String> words = new ArrayList<>();
        while (top.token == Values.WORD){
            //argument -> WORD argument
            words.add(top.sequence);
            nextToken();
        } 
        SetExpressionNode result = new SetExpressionNode(words);
        return result;
    }
    
    private ExpressionNode argument_comas(){
        String frase = "";
        boolean first = false;
        while (top.token == Values.WORD){
            //argument -> WORD argument
            if(first){
                frase += top.sequence;
                first = false;
            }else frase += " " + top.sequence;
            nextToken();
        } 
        SentencesExpressionNode result = new SentencesExpressionNode(frase);
        return result;
    }
    
    private void nextToken(){
        tokens.pop();
        // at the end of input we return an epsilon token
        if (tokens.isEmpty())
          top = new Token(Values.EPSILON,"");
        else
          top = tokens.getFirst();
    }
    
    private String preparedString(String str){
        String especialChars = "áàäéèëíìïóòöúùñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
        String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
        String s = str;        
        for (int j = 0; j < especialChars.length();++j){
            String t = "" + especialChars.charAt(j);
            while(s.contains(t)){
                String y = "" + s.charAt(s.indexOf(t));
                String replace = "" + ascii.charAt(j);
                s = s.replace(y, replace);
            }
        }        
        return s;
    }
                
    private void add(String regex, int token) {
        tokenInfos.add(new TokenInfo(Pattern.compile("^("+regex+")"), token));
    }   
}

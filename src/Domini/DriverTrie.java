
package Domini;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author josue.inaldo.alcantara
 */
public class DriverTrie {
 
    public static void main(String[] args) throws IOException, Exception{
        Trie trie = new Trie();
        try{
	        System.out.println("Añadimos varios prefijos");
	        trie.anadirPrefijo("Juan");
	        trie.anadirPrefijo("Judas");
	        trie.anadirPrefijo("Josue");
	        trie.anadirPrefijo("Joseas");
	        trie.anadirPrefijo("Jose");
	        trie.anadirPrefijo("Jordania");
	        trie.anadirPrefijo("Jota");
	        trie.anadirPrefijo("Joselito");
	        trie.anadirPrefijo("Josele");
	        trie.anadirPrefijo("Joan");
	        trie.anadirPrefijo("Ana");
	        trie.anadirPrefijo("Ana Simon");
	        trie.anadirPrefijo("Ana Maria");
	        trie.anadirPrefijo("Ana Gloria");
	        trie.anadirPrefijo("Anna");
	       
	        System.out.println("Listamos varios prefijos");	       
	        ArrayList<String> list = trie.consultarListaDelPrefijo("");
	        System.out.println("Lista del prefijo vacio");
	        for (int i = 0; i < list.size();++i)
	        	System.out.println(list.get(i));
	        System.out.println();
	        
	        list = trie.consultarListaDelPrefijo("J");
	        System.out.println("Lista del prefijo J");
	        for (int i = 0; i < list.size();++i)
	        	System.out.println(list.get(i));
	        System.out.println();
	        
	        list = trie.consultarListaDelPrefijo("Ju");
	        System.out.println("Lista del prefijo Ju");
	        for (int i = 0; i < list.size();++i)
	        	System.out.println(list.get(i));
	        System.out.println();
	        
	        list = trie.consultarListaDelPrefijo("Jos");
	        System.out.println("Lista del prefijo Jos");
	        for (int i = 0; i < list.size();++i)
	        	System.out.println(list.get(i));
	        System.out.println();
	        
	        list = trie.consultarListaDelPrefijo("Jose");
	        System.out.println("Lista del prefijo Jose");
	        for (int i = 0; i < list.size();++i)
	        	System.out.println(list.get(i));
	        System.out.println();
	        
	        list = trie.consultarListaDelPrefijo("An");
	        System.out.println("Lista del prefijo An");
	        for (int i = 0; i < list.size();++i)
	        	System.out.println(list.get(i));
	        System.out.println();
	        
	        list = trie.consultarListaDelPrefijo("A");
	        System.out.println("Lista del prefijo A");
	        for (int i = 0; i < list.size();++i)
	        	System.out.println(list.get(i));
	        System.out.println();
	        
	        System.out.println("Eliminamos varios prefijos");
	        trie.eliminarPrefijo("Josue");
	        trie.eliminarPrefijo("Jordania");
	        trie.eliminarPrefijo("Jota");
	        trie.eliminarPrefijo("Ana");
	        System.out.println();
	        
	        System.out.println("Listamos varios prefijos");
	        list = trie.consultarListaDelPrefijo("");
	        System.out.println("Lista del prefijo vacio");
	        for (int i = 0; i < list.size();++i)
	        	System.out.println(list.get(i));
	        System.out.println();
	        list = trie.consultarListaDelPrefijo("J");
	        System.out.println("Lista del prefijo J");
	        for (int i = 0; i < list.size();++i)
	        	System.out.println(list.get(i));
	        System.out.println();
	       
	        list = trie.consultarListaDelPrefijo("A");
	        System.out.println("Lista del prefijo A");
	        for (int i = 0; i < list.size();++i)
	        	System.out.println(list.get(i));
	        System.out.println();
	        list = trie.consultarListaDelPrefijo("Josue");
	        System.out.println("Lista del prefijo Josue");
	        for (int i = 0; i < list.size();++i)
	        	System.out.println(list.get(i));
	        System.out.println();
        } catch(Exception e){
    	   System.out.println(e.getMessage());
        }
    }
}

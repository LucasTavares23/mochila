import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Integer;
import java.util.Comparator;
import java.util.Collections;
public class mochila {
    public static void main(String[] args) {
         Comparator<Map<String, Integer>> mapComparator = new Comparator<Map<String, Integer>>() {
            public int compare(Map<String, Integer> m1, Map<String, Integer> m2) {
                return m2.get("cxb").compareTo(m1.get("cxb"));
            }
        };

        //declaração de variáveis
        int bagMax = 15;
        int bagAtual = 0;
        Map<String,Integer> item1=new HashMap<String,Integer>();
        item1.put("id",(Integer)1);
        item1.put("peso",(Integer)12);
        item1.put("valor",(Integer)4);
        Map<String,Integer> item2=new HashMap<String,Integer>();
        item2.put("id",(Integer)2);
        item2.put("peso",(Integer)2);
        item2.put("valor",(Integer)2);
        Map<String,Integer> item3=new HashMap<String,Integer>();
        item3.put("id",(Integer)3);
        item3.put("peso",(Integer)1);
        item3.put("valor",(Integer)1);
        Map<String,Integer> item4=new HashMap<String,Integer>();
        item4.put("id",(Integer)4);
        item4.put("peso",(Integer)4);
        item4.put("valor",(Integer)10);
        Map<String,Integer> item5=new HashMap<String,Integer>();
        item5.put("id",(Integer)4);
        item5.put("peso",(Integer)1);
        item5.put("valor",(Integer)2);
        List<Map<String,Integer>> lista=new ArrayList<Map<String,Integer>>();
        lista.add(item1);
        lista.add(item2);
        lista.add(item3);
        //Sistema de Ranking
        List<Integer> raking=new ArrayList<Integer>();
        for(Map<String,Integer>item :lista){
        item.put("cxb",item.get("valor")/item.get("peso"));

        }
        Collections.sort(lista, mapComparator);

        List<Integer> mochila=new ArrayList<Integer>();
        for(Map<String,Integer>item :lista){
          if(bagAtual+item.get("peso")<=bagMax){
         bagAtual=bagAtual+item.get("peso");
         mochila.add(item.get("id"));

          }
        }//mensagem aparece na tela
        System.out.println("lista de itens: "+lista);
        System.out.println("peso atual da mochila: "+bagAtual);
        System.out.println("lista de itens na mochila: "+mochila);
    }
}
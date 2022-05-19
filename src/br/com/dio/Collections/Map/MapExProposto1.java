package br.com.dio.Collections.Map;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

/*Dada a população estimada de alguns estados do NE brasileiro, faça:
Estado = PE - População = 9.616.621
Estado = AL - População = 3.351.543
Estado = CE - População = 9.187.103
Estado = RN - População = 3.534.265
Crie um dicionário e relacione os estados e suas populações;
Substitua a população do estado do RN por 3.534.165;
Confira se o estado PB está no dicionário, caso não adicione: PB -
4.039.277;
Exiba a população PE;
Exercícios Propostos
Exiba todos os estados e suas populações na ordem que foi
informado;
Exiba os estados e suas populações em ordem alfabética;
Exiba o estado com o menor população e sua quantidade;
Exiba o estado com a maior população e sua quantidade;
Exiba a soma da população desses estados;
Exiba a média da população deste dicionário de estados;
Remova os estados com a população menor que 4.000.000;
Apague o dicionário de estados;
Confira se o dicionário está vazio.*/

public class MapExProposto1 {
    public static void main(String[] args) {
        Map<String,Integer>  estadosNE = new HashMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};

        System.out.println(estadosNE);

        estadosNE.put("RN", 3534165);

        System.out.println(estadosNE);

        if(!estadosNE.keySet().contains("PB")){
            estadosNE.put("PB", 4039277);
        }

        System.out.println(estadosNE);

        System.out.println("População de PE: " + estadosNE.get("PE"));

        Map<String,Integer>  estadosNE1 = new LinkedHashMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};

        System.out.println("--\tOrdem Inserção\t--");
        System.out.println(estadosNE1);

        Map<String,Integer>  estadosNE2 = new TreeMap<>(estadosNE);
        System.out.println("--\tOrdem alfabética estados\t--");
        System.out.println(estadosNE2);

        System.out.println("--\tExiba o estado com o menor população e sua quantidade\t--");

        Integer menorPopulacao = Collections.min(estadosNE2.values());
        Set<Entry<String, Integer>> estadosEntry = estadosNE2.entrySet();

        for (Entry<String,Integer> entry : estadosEntry) {
            if(entry.getValue() == menorPopulacao){
                System.out.println("Menor população: " + entry.getKey() + " " + entry.getValue());
            }
        }

        System.out.println("--\tExiba o estado com a maior população e sua quantidade\t--");
        Integer maiorPopulacao = Collections.max(estadosNE2.values());

        for (Entry<String,Integer> entry : estadosEntry) {
            if(entry.getValue() == maiorPopulacao){
                System.out.println("Maior populacao: " + entry.getKey() + " " +entry.getValue());
            }
        }

        System.out.println("--\tExiba a soma da população desses estados;\t--");
        int somaPopulacao = 0 ;
        for (Entry<String,Integer> entry : estadosEntry) {
            somaPopulacao += entry.getValue();
        }
        System.out.println("Soma: " + somaPopulacao);
        System.out.println("Media: " + somaPopulacao/estadosEntry.size());

        Iterator<Entry<String, Integer>> iterator = estadosEntry.iterator();
        while(iterator.hasNext()){
            if(iterator.next().getValue() < 4000000){
                iterator.remove();;
            }
        }
        System.out.println("--\tRemova estados com a pop menor que 4 milhoes\t--");
        System.out.println(estadosEntry);

        estadosEntry.clear();

        if(estadosEntry.isEmpty()){
            System.out.println("Dicionario estados Vazio");
        }

    }

}

class Estado {
    private String sigla;
    private int populacao;

    public Estado(String sigla, int populacao) {
        this.sigla = sigla;
        this.populacao = populacao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public int getPopulacao() {
        return populacao;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + populacao;
        result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Estado other = (Estado) obj;
        if (populacao != other.populacao)
            return false;
        if (sigla == null) {
            if (other.sigla != null)
                return false;
        } else if (!sigla.equals(other.sigla))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Estado [populacao=" + populacao + ", sigla=" + sigla + "]";
    }

}
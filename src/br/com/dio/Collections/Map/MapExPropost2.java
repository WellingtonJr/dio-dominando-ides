package br.com.dio.Collections.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.lang.model.SourceVersion;

import java.util.Random;
import java.util.Set;

/*
Faça um programa que simule um lançamento de dados. Lance o dado 100 vezes e armazene.
Depois, mostre quantas vezes cada valor foi conseguido.
 */
public class MapExPropost2 {
    public static void main(String[] args) {

        Map<Integer, Integer> dadoMap = new HashMap<>() {
            {
                put(1, 0);
                put(2, 0);
                put(3, 0);
                put(4, 0);
                put(5, 0);
                put(6, 0);
            }
        };

        Random random = new Random();
        int numero;
        for (int i = 0; i < 100; i++) {
            numero = random.nextInt(6)+1;
            dadoMap.put(numero, (dadoMap.get(numero).intValue() + 1));
        }
        System.out.println(dadoMap);
        Set<Entry<Integer, Integer>> dadoEntrySet = dadoMap.entrySet();
        for (Entry<Integer, Integer> entry : dadoEntrySet) {
            System.out.println("Lado do dado: " + entry.getKey() + " qtd vezes: " + entry.getValue());
            
        }

        Map<Integer,String> teste = new HashMap<>(){{
            put(1, "asd");
            put(2, "teste");
            put(3, "asdss");
        }};

        System.out.println(teste.get(2).toString());
    }

}

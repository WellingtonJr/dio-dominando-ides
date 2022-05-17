package br.com.dio.Collections.Set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
Crie uma conjunto contendo as cores do arco-íris e:
a) Exiba todas as cores o arco-íris uma abaixo da outra;
b) A quantidade de cores que o arco-íris tem;
c) Exiba as cores em ordem alfabética;
d) Exiba as cores na ordem inversa da que foi informada;
e) Exiba todas as cores que começam com a letra ”v”;
f) Remova todas as cores que não começam com a letra “v”;
g) Limpe o conjunto;
h) Confira se o conjunto está vazio;
 */
public class SetExProposto1 {

    public static void rodarSetExProposto1() {
        System.out.println("Crie uma conjunto contendo as cores do arco-íris: ");
        Set<String> coresArcoIris = new HashSet<>();
        coresArcoIris.add("violeta");
        coresArcoIris.add("anil");
        coresArcoIris.add("azul");
        coresArcoIris.add("verde");
        coresArcoIris.add("amarelo");
        coresArcoIris.add("laranja");
        coresArcoIris.add("vermelho");
        System.out.println(coresArcoIris);

        // a
        Iterator<String> iterator = coresArcoIris.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //b
        System.out.println(coresArcoIris.size());

        //c
        Set<String> coresArcorIris2 = new TreeSet<>(coresArcoIris);
        System.out.println(coresArcorIris2);

        //d
        LinkedHashSet<String> coresArcoIrisLinkedHashSet = new LinkedHashSet<>(
            Arrays.asList("violeta", "anil", "azul", "verde", "amarelo", "laranja", "vermelho"));

        List <String> coresArcoIrisList = new ArrayList<>(coresArcoIrisLinkedHashSet);
        System.out.println(coresArcoIrisList);
        Collections.reverse(coresArcoIrisList);
        System.out.println(coresArcoIrisList);

        //e
        for (String cor : coresArcoIris) {
            if(cor.startsWith("v")) System.out.println(cor);
        }

       
        //f
        Iterator<String> iterator2 = coresArcoIris.iterator();
        while(iterator2.hasNext()){
            if(!iterator2.next().startsWith("v")) iterator2.remove();
        }
        System.out.println(coresArcoIris);
        
        //g
        coresArcoIris.clear();

        //h
        if(coresArcoIris.isEmpty()){
            System.out.println("Conjunto vazio");
        }
    }


}

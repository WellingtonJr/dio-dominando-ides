package br.com.dio.Collections.StreamAPI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import br.com.dio.model.Gato;

public class EstudoStreamAPI {
    public static void main(String[] args) {
        List<Gato> gatos = new ArrayList<>(){{
            add( new Gato("ciclano","preto",10));
            add( new Gato("fulano","azul",12));
            add( new Gato("beltrano","vemelho",5));
        }};

        System.out.println(gatos);

        gatos.sort(Comparator.comparing(Gato::getNome));

        System.out.println(gatos);

        gatos.sort(Comparator.comparing(Gato::getCor));
        System.out.println(gatos);
        gatos.sort(Comparator.comparing(Gato::getIdade));
        System.out.println(gatos);

        System.out.println("streeam api");
        gatos.stream()
            .map(t -> t.toString())
            .collect(Collectors.toList())
            .forEach(System.out::println);

    }
}

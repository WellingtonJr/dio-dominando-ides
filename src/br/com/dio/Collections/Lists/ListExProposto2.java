package br.com.dio.Collections.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Utilizando listas, faça um programa que faça 5 perguntas para uma pessoa sobre um crime. As perguntas são:
1. "Telefonou para a vítima?"
2. "Esteve no local do crime?"
3. "Mora perto da vítima?"
4. "Devia para a vítima?"
5. "Já trabalhou com a vítima?"
Se a pessoa responder positivamente a 2 questões ela deve ser classificada como "Suspeita", entre 3 e 4 como
"Cúmplice" e 5 como "Assassina". Caso contrário, ele será classificado como "Inocente".
*/
public class ListExProposto2 {
    public static void rodarExProposto2() {
        int qtdSim = 0;
        String resposta;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Responda com S para sim e N para não.");

        List<String> perguntas = new ArrayList<>() {
            {
                add(new String("Telefonou para a vítima? (S/N)"));
                add(new String("Esteve no local do crime? (S/N)"));
                add(new String("Mora perto da vítima? (S/N)"));
                add(new String("Devia para a vítima? (S/N)"));
                add(new String("Já trabalhou com a vítima? (S/N)"));
            }
        };

        for (String string : perguntas) {
            System.out.println(string);
            resposta = scanner.next();

            if (resposta.equalsIgnoreCase("s")) {
                qtdSim++;
            }
        }


        System.out.println();
        System.out.println(classificaPessoa(qtdSim));

    }

    public static String classificaPessoa(int qtdSim) {

        switch (qtdSim) {
            case 2:
                return "SUSPEITA";

            case 3:
            case 4:
                return "CÚMPLICE";
            case 5:
                return "ASSASSINA";
            default:
                return "INOCENTE";
        }

    }

}

package br.com.dio.Collections.Lists;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// Faça um programa que receba a temperatura média dos 6
// primeiros meses do ano e armazene-as em uma lista.
// Após isto, calcule a média semestral das temperaturas e
// mostre todas as temperaturas acima desta média, e em que
// mês elas ocorreram (mostrar o mês por extenso: 1 – Janeiro, 2
// – Fevereiro e etc).
public class ListExProposto1 {

    public static void rodarExProposto1() {
        List<Double> listaTempMedia = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Double somaTemperaturas = 0d;
        Double min, max;
        min = 18d;
        max = 38d;
        Double random = new Random().nextDouble();
        Double randomGerado;

        for (int i = 0; i < 6; i++) {
            // System.out.println("Informe a temperatura do mês "+(i+1)+": ");
            // listaTempMedia.add(scanner.nextDouble());
            randomGerado = min + (random * (max - min));
            random = new Random().nextDouble();

            listaTempMedia.add(formatadorDuasCasas(randomGerado));
            somaTemperaturas += listaTempMedia.get(i);
        }

        // listaTempMedia.forEach(t -> System.out.println(t + "")); // outra forma de imprimir uma lista
        System.out.println(listaTempMedia.toString());
        Double temperaturaMedia = formatadorDuasCasas(somaTemperaturas/listaTempMedia.size());

        System.out.println("\nA temperatura média de Janeiro a Junho foi de: " + temperaturaMedia
                + " graus");

        System.out.println("Meses em que a temperatura foi mais alta do que a média: ");
        for (int i = 0; i < listaTempMedia.size(); i++) {
            if(listaTempMedia.get(i) > temperaturaMedia){
                System.out.println((i+1)+" - "+retornaNomeMes((i+1)));
            }
        }

    }

    public static Double formatadorDuasCasas(Double n) {
        return (double) Math.round(n * 10.0) / 10.0;
    }

    public static String retornaNomeMes(int numeroMes) {

        switch (numeroMes) {
            case 1:
               return "Janeiro";
            case 2:
                return "Fereveiro";
            case 3:
                return "Março";
            case 4:
                return "Abril";
            case 5:
                return "Maio";
            case 6:
                return "Junho";
            default:
            return "Mes inválido";
        }

    }

}

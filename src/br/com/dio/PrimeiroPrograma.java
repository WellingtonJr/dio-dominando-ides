package br.com.dio;

import java.util.Scanner;

import br.com.dio.model.Gato;

public class PrimeiroPrograma {

	public static void main(String[] args) {
		Gato gato = new Gato("a","b",2);
		Livros livros = new Livros();
		
		System.out.println("Informe dois numeros:" );
		
		Scanner scanner = new Scanner(System.in);;
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		
		float divisao = divisao(a,b);
		System.out.println(divisao);
	}
	
	
	public static float divisao(int a, int b) {
		return  (float)a / (float)b;
	}
}

class Livros{
	private String nome;
	private String npag;
	
}

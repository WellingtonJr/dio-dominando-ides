package br.com.dio;

import br.com.dio.model.Gato;

public class PrimeiroPrograma {

	public static void main(String[] args) {
		Gato gato = new Gato("a","b",2);
		Livros livros = new Livros();
		
		System.out.println(gato);
		
	}

}

class Livros{
	private String nome;
	private String npag;
	
}

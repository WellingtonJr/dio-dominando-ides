package br.com.dio.Collections.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EstudoList {

	public static void printaEstudoList() {
		List<Livro> livros = new ArrayList<>(){{
			add(new Livro("Bruna",2));
			add(new Livro("Arão",21));
			add(new Livro("Abraão",245));
			add(new Livro("Arão",2512));
			add(new Livro("Artrides",22));
			add(new Livro("Arão",8266));
			add(new Livro("Aaeysha",52));
		
		}};

		System.out.println("Livros ordem inserção: "+livros);
		System.out.println();
		Collections.sort(livros);
		System.out.println("Livros sort: "+livros);
		// Collections.sort(livros, new ComparatorNumPag()); //ordena por num de paginas  
		livros.sort(new ComparatorNumPag()); //ordena por num de paginas  
		System.out.println();
		System.out.println("Por idade comparator: " +livros);
		System.out.println();
		Collections.sort(livros, new ComparatorNomeNumPag());
		System.out.println(livros);

	}

}
class Livro implements Comparable<Livro>{
	private String nome;
	private int nPag;

	public Livro(String nome, int nPag) {
		this.nome = nome;
		this.nPag = nPag;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getnPag() {
		return nPag;
	}

	public void setnPag(int nPag) {
		this.nPag = nPag;
	}

	@Override
	public String toString() {
		return "[nPag=" + nPag + ", nome=" + nome + "]";
	}

	public Livro() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nPag;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Livro other = (Livro) obj;
		if (nPag != other.nPag)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public int compareTo(Livro livro) {
		return this.getNome().compareToIgnoreCase(livro.getNome()); // ordem alfabetica
	}

}

class ComparatorNumPag implements Comparator<Livro>{

	@Override
	public int compare(Livro livro1, Livro livro2) {
		return Integer.compare(livro1.getnPag(), livro2.getnPag());
	}
	
}

class ComparatorNomeNumPag implements Comparator<Livro>{

	@Override
	public int compare(Livro l1, Livro l2) {
		int nome = l1.getNome().compareToIgnoreCase(l2.getNome());
		if(nome != 0) return nome;

		return Integer.compare(l1.getnPag(), l2.getnPag());
	}

}
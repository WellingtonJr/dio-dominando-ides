package br.com.dio.Collections.Set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
Crie uma classe LinguagemFavorita que possua os atributos nome, anoDeCriacao e IDE.
Em seguida, crie um conjunto com 3 linguagens e faça um programa que ordene esse conjunto por:
a) Ordem de inserção;
b) Ordem natural(nome);
c) IDE;
d) Ano de criação e nome;
e) Nome, ano de criação e IDE;
Ao final, exiba as linguagens no console, um abaixo da outra.
*/
public class SetExProposto2 {

    public static void rodarSetExProposto2() {
        Set<LinguagemFavorita> minhasLinguagensFavoritas = new HashSet<>();
        minhasLinguagensFavoritas.add(new LinguagemFavorita("Python", 1991, "Pycharm"));
        minhasLinguagensFavoritas.add(new LinguagemFavorita("JavaScript", 1995, "IntelliJ"));
        minhasLinguagensFavoritas.add(new LinguagemFavorita("Java", 1991, "Visual Studio Code"));
        
        //a
        LinkedHashSet<LinguagemFavorita> linguagemFavoritasLHS = new LinkedHashSet<>(
            Arrays.asList(
                        new LinguagemFavorita("Python", 1991, "Pycharm"),
                        new LinguagemFavorita("JavaScript", 1995, "IntelliJ"),
                        new LinguagemFavorita("Java", 1991, "Visual Studio Code")
                )
        );
        System.out.println(linguagemFavoritasLHS);

        //b
        Set<LinguagemFavorita> linguagemFavoritaSet = new TreeSet<>(minhasLinguagensFavoritas);
        for (LinguagemFavorita linguagemFavorita : linguagemFavoritaSet) {
            System.out.println(linguagemFavorita);
        }

        List<LinguagemFavorita> linguagemFavoritaList = new ArrayList<>(linguagemFavoritaSet);
        //c
        Collections.sort(linguagemFavoritaList, new ComparatorIDE());
        System.out.println(linguagemFavoritaList);

        //d
        Collections.sort(linguagemFavoritaList,new ComparatorAnoCriacaoNome());
        System.out.println(linguagemFavoritaList);

    }

}

class LinguagemFavorita implements Comparable<LinguagemFavorita> {
    String nome;
    int anoDeCriacao;
    String ide;

    public LinguagemFavorita(String nome, int anoDeCriacao, String ide) {
        this.nome = nome;
        this.anoDeCriacao = anoDeCriacao;
        this.ide = ide;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoDeCriacao() {
        return anoDeCriacao;
    }

    public void setAnoDeCriacao(int anoDeCriacao) {
        this.anoDeCriacao = anoDeCriacao;
    }

    public String getIde() {
        return ide;
    }

    public void setIde(String ide) {
        this.ide = ide;
    }

    @Override
    public String toString() {
        return " [anoDeCriacao=" + anoDeCriacao + ", ide=" + ide + ", nome=" + nome + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + anoDeCriacao;
        result = prime * result + ((ide == null) ? 0 : ide.hashCode());
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
        LinguagemFavorita other = (LinguagemFavorita) obj;
        if (anoDeCriacao != other.anoDeCriacao)
            return false;
        if (ide == null) {
            if (other.ide != null)
                return false;
        } else if (!ide.equals(other.ide))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    @Override
    public int compareTo(LinguagemFavorita linguagemFavorita) {
        return this.getNome().compareToIgnoreCase(linguagemFavorita.getNome());
    }

}

class ComparatorIDE implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        return l1.getIde().compareToIgnoreCase(l2.getIde());
    }
    
}

class ComparatorAnoCriacaoNome implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int anoCriacao = Integer.compare(l1.getAnoDeCriacao(), l2.getAnoDeCriacao());
        if (anoCriacao != 0 ) return anoCriacao;

        return l1.getNome().compareToIgnoreCase(l2.getNome());
    }

}
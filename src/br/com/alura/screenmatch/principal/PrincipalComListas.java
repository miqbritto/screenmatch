package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Movie;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalComListas {
    public static void main(String[] args) {
        Movie sonhoDeLiberdade = new Movie("Um Sonho de Liberdade", 1994);
        Movie bastardosInglorios = new Movie("Bastardos Inglorios", 2010);
        Movie starWars = new Movie("Star Wars III: A Vingança dos Sith", 2003);
        Serie got = new Serie("Game of Thrones", 2010);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(sonhoDeLiberdade);
        lista.add(starWars);
        lista.add(bastardosInglorios);
        lista.add(got);
        lista.forEach(coisa -> System.out.println(coisa));

        Collections.sort(lista);
        System.out.println("\nOrdenando por ordem alfabética:");
        System.out.println(lista);

        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("\nOrdenando por ano de lançamento:");
        System.out.println(lista);



    }
}

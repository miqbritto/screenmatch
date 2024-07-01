package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculo.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Movie;
import br.com.alura.screenmatch.modelos.Serie;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        Movie sonhoDeLiberdade = new Movie("Um Sonho de Liberdade", 1994);
        sonhoDeLiberdade.setDiretor("Frank Darabont");

        sonhoDeLiberdade.exibeFichaTecnica();
        System.out.println(sonhoDeLiberdade.getDiretor());


        sonhoDeLiberdade.avalia(8);
        sonhoDeLiberdade.avalia(8.5);
        sonhoDeLiberdade.avalia(9);

        System.out.println(sonhoDeLiberdade.pegaMedia());

        Movie bastardosInglorios = new Movie("Bastardos Inglorios", 2010);
        bastardosInglorios.setDiretor("Quentin Tarantino");

        Movie starWars = new Movie("Star Wars III: A Vingança dos Sith", 2003);
        starWars.setDiretor("George Lucas");

        Serie got = new Serie("Game of Thrones", 2010);
        got.setTemporadas(8);
        got.setEpPorTemporada(10);
        got.setEmissora("HBO");

        got.exibeFichaTecnica();
        System.out.println(got.getEmissora());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(sonhoDeLiberdade);

        Episodio got9x1 = new Episodio();
        got9x1.setNumero(9);
        got9x1.setSerie(got);
        got9x1.setTotalDeLikes(300);
        filtro.filtra(got9x1);

       // System.out.println("Total de avaliações: " + sonhoDeLiberdade.getQuantidadeAvaliacoes());

        ArrayList<Movie> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(sonhoDeLiberdade);
        listaDeFilmes.add(starWars);
        listaDeFilmes.add(bastardosInglorios);
        System.out.println("\nTamanho da Lista: " + listaDeFilmes.size());
        System.out.println("Primeiro filme: " + listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);




    }
}
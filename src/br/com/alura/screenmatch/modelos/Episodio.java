package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.calculo.Classificavel;

public class Episodio implements Classificavel {
    private String nome;
    private int numero;
    private Serie serie;
    private int totalDeLikes;

    public int getTotalDeLikes() {
        return totalDeLikes;
    }

    public void setTotalDeLikes(int totalDeLikes) {
        this.totalDeLikes = totalDeLikes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }


    @Override
    public int getClassificacao() {
        if (totalDeLikes > 500) {
            return 5;
        } else if (totalDeLikes > 400) {
            return 4;
        } else if (totalDeLikes >= 300) {
            return 3;
        } else if (totalDeLikes > 200) {
            return 2;
        } else {
            return 1;
        }
    }
}

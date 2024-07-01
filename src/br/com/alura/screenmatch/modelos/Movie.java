package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.calculo.Classificavel;

public class Movie extends Titulo implements Classificavel {

    private String diretor;

    public Movie(String nome, int anoDeLancamento){
        super(nome, anoDeLancamento);

    }

    public Movie(TituloOmdb tituloOmdb){
        diretor = tituloOmdb.director();
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassificacao() {
        return (int) (pegaMedia() / 2);
    }

    @Override
    public String toString() {
        return "Diretor: " + this.getDiretor() + "]";
    }
}



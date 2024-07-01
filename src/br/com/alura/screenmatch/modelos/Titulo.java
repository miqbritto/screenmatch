package br.com.alura.screenmatch.modelos;

import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo>{

    private String nome;

    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int quantidadeAvaliacoes;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb tituloOmdb){
        this.nome = tituloOmdb.title();
        this.anoDeLancamento = tituloOmdb.year();
    }

    public Titulo() {

    }

    public int getQuantidadeAvaliacoes(){
        return quantidadeAvaliacoes;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void exibeFichaTecnica(){
        System.out.println();
        System.out.println("Nome: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);

    }

    public void avalia(double nota){
        somaDasAvaliacoes += nota;
        quantidadeAvaliacoes++;
    }

    public double pegaMedia(){
        return somaDasAvaliacoes/(quantidadeAvaliacoes);
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "[Titulo: " + getNome() + " (" + getAnoDeLancamento() + ")";
    }
}

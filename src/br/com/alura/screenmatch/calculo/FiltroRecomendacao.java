package br.com.alura.screenmatch.calculo;

public class FiltroRecomendacao {

    public void filtra(Classificavel classificacao){
        if (classificacao.getClassificacao() >= 4){
            System.out.println("Está bombando");
        } else if (classificacao.getClassificacao() >= 3) {
            System.out.println("Bem avaliado");
        } else if (classificacao.getClassificacao() < 3) {
            System.out.println("Coloque na lista para assistir depois");
        }
    }
}

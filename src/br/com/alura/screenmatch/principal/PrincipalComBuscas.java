package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Movie;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBuscas {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner entrada = new Scanner(System.in);
            String busca = "";
        List<Titulo> titulos = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!busca.equalsIgnoreCase("sair")) {

            System.out.println("Digite o filme que quer buscar: ");

            busca = entrada.nextLine();

            if (busca.equalsIgnoreCase("sair")){
                break;
            }

            String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=c5069e80";
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                // System.out.println(json);



                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(meuTituloOmdb);
                // try {
                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println("Titulo já convertido:");
                System.out.println(meuTitulo);


                Movie meuFilme = new Movie(meuTituloOmdb);
                System.out.println(meuFilme);
                FileWriter escrita = new FileWriter("filmes.txt");
                escrita.write(meuTitulo.toString());
                escrita.write(" ");
                escrita.write(meuFilme.toString());
                escrita.close();

                titulos.add(meuTitulo);
                titulos.add(meuFilme);
            } catch (NumberFormatException e) {
                System.out.println("Ocorreu um erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Houve algum erro na busca, verifique o endereço");
                System.out.println(e.getMessage());
            }
        }

        System.out.println(titulos);

        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();

        System.out.println("O programa foi finalizado corretamente.");


    }
}

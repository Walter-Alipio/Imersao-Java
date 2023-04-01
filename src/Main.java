import Service.Conteudo;
import Service.ExtratoDeConteudoDaNasa;
import Service.ExtratorDeConteudo;
import Service.GeradorDeImagens;
import Utils.ClienteHTTP;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("Hello world!");

        //fazer uma conexão HTTP e buscar os top filmes
        ApiKey apiKey = new ApiKey();

//        String url = "https://api.themoviedb.org/3/movie/top_rated?api_key="+ apiKey.keyTMDB + "&language=pt-BR&page=1";
//        Service.ExtratorDeConteudo extrator = new Service.ExtratorDeConteudoTMDB();

        String url = "https://api.nasa.gov/planetary/apod?count=3&api_key=" + apiKey.keyNASA;
        ExtratorDeConteudo extrator = new ExtratoDeConteudoDaNasa();

//        String url = "http://localhost:8080/linguagens";
//        Service.ExtratorDeConteudo extrator = new Service.ExtratorDeConteudoLinguagem();

        var http = new ClienteHTTP();
        String json = http.BuscaDados(url);

        //extrair só os dados interessantes (titulo, imagem, classificação)
        Gson gson = new Gson();

        List<Conteudo> conteudos = extrator.ExtraiConteudos(json, gson);
        var gerador = new GeradorDeImagens();


        //exibir os dados
        for (Conteudo conteudo : conteudos
             ) {
            InputStream inputStream = new URL(conteudo.getUrlImagem())
                    .openStream();
            String imageText = "Vlw Alura!";
            gerador.Cria(inputStream,conteudo.getTitulo(), imageText);

            System.out.println("");
            System.out.println("\u001b[35m \u001b[1m" + conteudo.getTitulo() + "\u001b[m");
            System.out.println(conteudo.getUrlImagem());
            System.out.println();
        }

    }
    //{"images":{"base_url":"http://image.tmdb.org/t/p/",
    // "secure_base_url":"https://image.tmdb.org/t/p/",
    // "backdrop_sizes":["w300","w780","w1280","original"],
    // "logo_sizes":["w45","w92","w154","w185","w300","w500","original"],
    // "poster_sizes":["w92","w154","w185","w342","w500","w780","original"],
    // "profile_sizes":["w45","w185","h632","original"],
    // "still_sizes":["w92","w185","w300","original"]},

}
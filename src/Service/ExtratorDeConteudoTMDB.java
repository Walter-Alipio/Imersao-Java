package Service;

import Model.Filme;
import Model.Filmes;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ExtratorDeConteudoTMDB implements ExtratorDeConteudo{
    public List<Conteudo> ExtraiConteudos(String json, Gson gson)
    {
        var filmes = gson.fromJson(json, Filmes.class);

        List<Conteudo> conteudos = new ArrayList<>();

        for (Filme filme: filmes.getFilmes()
        ) {
            String urlImage = "https://image.tmdb.org/t/p/w500" + filme.getPoster_path();
            Conteudo conteudo = new Conteudo(filme.getTitle(),urlImage);
            conteudos.add(conteudo);
        }
        return conteudos;
    }
}

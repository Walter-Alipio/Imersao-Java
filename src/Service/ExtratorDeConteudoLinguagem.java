package Service;

import Model.Linguagem;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ExtratorDeConteudoLinguagem implements ExtratorDeConteudo{
    @Override
    public List<Conteudo> ExtraiConteudos(String json, Gson gson) {
        Linguagem[] linguagens = gson.fromJson(json, Linguagem[].class);

        List<Conteudo> conteudos = new ArrayList<>();

        for (Linguagem linguagem: linguagens
        ) {
            Conteudo conteudo = new Conteudo(linguagem.getTitle(),linguagem.getImage());
            conteudos.add(conteudo);
        }
        return conteudos;
    }
}

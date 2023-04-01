package Service;

import Model.NasaImage;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ExtratoDeConteudoDaNasa implements ExtratorDeConteudo {
    public List<Conteudo> ExtraiConteudos(String json, Gson gson)
    {
        NasaImage[] imagens = gson.fromJson(json, NasaImage[].class);

        List<Conteudo> conteudos = new ArrayList<>();

        for (NasaImage image: imagens
             ) {
            Conteudo conteudo = new Conteudo(image.getTitle(), image.getUrl());
            conteudos.add(conteudo);
        }
        return conteudos;
    }
}

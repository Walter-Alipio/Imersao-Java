package Service;

import com.google.gson.Gson;

import java.util.List;

public interface ExtratorDeConteudo {
    List<Conteudo> ExtraiConteudos(String json, Gson gson);
}

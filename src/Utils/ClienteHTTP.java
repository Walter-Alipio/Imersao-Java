package Utils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteHTTP {
    public String BuscaDados(String url)
    {
        try {
            HttpClient client = HttpClient.newHttpClient();
            URI endereco = URI.create(url);
            HttpRequest request  = HttpRequest
                    .newBuilder(endereco)
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        }catch (IOException | InterruptedException ex)
        {
            throw new RuntimeException(ex);
        }

    }
}

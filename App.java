import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        String url = "https://api.mocki.io/v2/549a5d8b" ;
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println("\u001b[1mTítulo: " + filme.get("title") + "\u001b[0m");
            System.out.println("\u001b[3mPôster: " + filme.get("image") + "\u001b[0m");
            System.out.println("\u001b[1mAvaliação: " + "\u001b[31;1m\u001b[43;1m" + filme.get("imDbRating") + "\u001b[m\u001b[m" + "🌟" );
            System.out.println();
        }
    }
}

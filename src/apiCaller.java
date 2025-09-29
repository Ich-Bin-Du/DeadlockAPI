import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class apiCaller {
    static HttpClient client = HttpClient.newHttpClient();
    HttpResponse<String> response;

    public void getPlayerStats(long playerId) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.deadlock-api.com/v1/players/" + playerId + "/match-history"))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        this.response = response;
        System.out.println("Status code: " + response.statusCode());

    }

    public void generateStatisticsFile(String fileName){
        String fileText = prettyJson.prettyPrintJson(response.body());

        dataFile.createFile(fileName);
        dataFile.writeFile(fileName, fileText);


    }

}

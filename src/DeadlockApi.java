import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DeadlockApi {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        long playerId = 76561199135594761L;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.deadlock-api.com/v1/players/" + playerId + "/match-history"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status code: " + response.statusCode());
        System.out.println("Body:\n" + response.body());
        String fileText = prettyJson.prettyPrintJson(response.body());
        String fileName = "Data";

        dataFile.createFile(fileName);
        dataFile.writeFile(fileName, fileText);
        dataFile.readMatchResult(fileName);

    }
}
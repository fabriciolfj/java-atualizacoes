package br.com.github.manningbook;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class Http2Simulacao {

    private static final URI URI_GOOGLE;

    static {
        try {
            URI_GOOGLE = new URI("https://google.com");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws URISyntaxException {
        var client = HttpClient.newBuilder().build();
        var request = HttpRequest.newBuilder(URI_GOOGLE)
                .build();

        var handler = HttpResponse.BodyHandlers.ofString();

        CompletableFuture.allOf(
                client.sendAsync(request, handler)
                        .thenAccept((resp) -> System.out.println(resp)),
                client.sendAsync(request, handler)
                        .thenAccept((resp) -> System.out.println(resp)),
                client.sendAsync(request, handler)
                        .thenAccept((resp) -> System.out.println(resp))
        ).join();

    }
}

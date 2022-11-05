package br.com.github.v1.http2;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class TesteRequestHttp2 {

	// Novidades do Java 11 - HTTP/2 Client API.
	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
		var body = "{\n" +
				"    \"name\" : \"teste\",\n" +
				"    \"document\" : \"1881\"\n" +
				"}";

		HttpClient httpClient = HttpClient.newHttpClient();
		HttpRequest httpRequest = HttpRequest.newBuilder(new URI("http://localhost:50051/api/v1/persons")).POST(HttpRequest.BodyPublishers
				.ofString(body)).build();
		HttpResponse<String> resp = httpClient.send(httpRequest, BodyHandlers.ofString());

		System.out.println(resp.statusCode());
		System.out.println(resp.body());
		System.out.println(resp.version());

	}
}

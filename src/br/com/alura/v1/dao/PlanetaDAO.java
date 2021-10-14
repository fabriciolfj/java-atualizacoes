package br.com.alura.v1.dao;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

public class PlanetaDAO {

	public void listar() throws URISyntaxException, IOException, InterruptedException {
		HttpClient httpClient = HttpClient.newBuilder().build();

		/*HttpResponse<String> send = httpClient.send(
				HttpRequest.newBuilder().uri(new URI("https://www.casadocodigo.com.br")).GET().build(),
				BodyHandlers.ofString());

		System.out.println(send.body());*/

		httpClient.sendAsync(HttpRequest.newBuilder()
				.uri(new URI("https://www.casadocodigo.com.br"))
				.GET()
				.build(), BodyHandlers.ofString())
		.whenComplete((v, e) -> {
			if (e != null) {
				throw new RuntimeException(e.getMessage());
			}

			System.out.println(v.body());
		});

	}
}

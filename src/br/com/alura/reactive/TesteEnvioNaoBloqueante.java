package br.com.alura.reactive;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.SubmissionPublisher;

import br.com.alura.reactive.model.NotaFiscal;
import br.com.alura.reactive.subscriber.NotaFiscalSubscriber;
import br.com.alura.reactive.wsclient.NotaFiscalWSClient;

public class TesteEnvioNaoBloqueante {

	public static void main(String[] args) {
		Executor executor = Executors.newFixedThreadPool(3);
		System.out.println("Thread: " + Thread.currentThread().getName());
		NotaFiscal primeiraNotaFiscal = new NotaFiscal("João", 39.99, LocalDate.now());
		NotaFiscal segundaNota = new NotaFiscal("Ricardo", 212.00, LocalDate.now());
		NotaFiscal terceiraNota = new NotaFiscal("Pedro", 11.00, LocalDate.now());
		SubmissionPublisher<NotaFiscal> publisher = new SubmissionPublisher<>(executor, 1);

		//var ws = new NotaFiscalWSClient();
		NotaFiscalSubscriber subscriber = new NotaFiscalSubscriber();
		//publisher.consume(ws::enviar);
		publisher.subscribe(subscriber);

		/*publisher.consume(data -> {
			System.out.println("Dados: " + data.toString());
			System.out.println("outra thread: " + Thread.currentThread().getName());
		});*/


		publisher.submit(primeiraNotaFiscal);
		publisher.submit(segundaNota);
		publisher.submit(terceiraNota);

		System.out.println("Você irá receber a nota fiscal no seu e-mail");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		scan.close();
		publisher.close();

	}
}

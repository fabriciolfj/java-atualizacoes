package br.com.github.v1.reactive.subscriber;

import br.com.github.v1.reactive.model.NotaFiscal;
import br.com.github.v1.reactive.wsclient.NotaFiscalWSClient;

import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;

public class NotaFiscalSubscriber implements Subscriber<NotaFiscal> {

    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("Chamando o subscribe");
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(NotaFiscal item) {
        System.out.println("Item recebido: " + item.toString());
        NotaFiscalWSClient ws = new NotaFiscalWSClient();
        ws.enviar(item);
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Falha ocorrida no processo: " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("Fluxo finalizado");
    }
}

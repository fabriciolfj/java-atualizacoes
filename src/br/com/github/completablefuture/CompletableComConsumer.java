package br.com.github.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableComConsumer {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> consumer = CompletableFuture.supplyAsync(() -> "teste");

        var result = consumer.thenAccept(s -> System.out.println(s));

        result.get();
    }
}

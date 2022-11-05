package br.com.github.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureCompose {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //quando o resultado de um completable é usado em outro
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "hello")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " world"));

        System.out.println(completableFuture.get());
    }
}

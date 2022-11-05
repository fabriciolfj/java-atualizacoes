package br.com.github.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExcecutarUmaAcao {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> System.out.println("teste"));

        future.get();

        //ou
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "teste");
        future2.thenRun(() -> System.out.println("fim"));

        future2.get();
    }
}

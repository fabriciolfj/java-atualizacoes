package br.com.github.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CompletableAsync {

    private static Executor executors = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> c1 = CompletableFuture.supplyAsync(() -> "teste");

        c1.thenAcceptAsync(e -> System.out.println(e), executors);

        c1.get();
    }
}

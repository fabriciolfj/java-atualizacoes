package br.com.github.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableThenApply {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        thenApply();
        thenCompose();
    }

    private static void thenCompose() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> c1 = CompletableFuture.supplyAsync(() -> 2)
                .thenCompose(i -> CompletableFuture.supplyAsync(() -> i + 3));

        System.out.println(c1.get());
    }

    private static void thenApply() throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> c1 = CompletableFuture.supplyAsync(() -> 2);
        var result = c1.thenApply(i -> i + 2);

        System.out.println(result.get());
    }
}

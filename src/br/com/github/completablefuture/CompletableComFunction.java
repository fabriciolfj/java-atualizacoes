package br.com.github.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableComFunction {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture parametro = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<String> function =  parametro.thenApply(s -> s + " World");

        System.out.println(function.get());
    }
}

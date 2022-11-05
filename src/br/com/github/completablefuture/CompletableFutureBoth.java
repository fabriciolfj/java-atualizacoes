package br.com.github.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureBoth {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //similar ao combine, mas nao retorna nada
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> "hello")
                .thenAcceptBoth(CompletableFuture.supplyAsync(() -> " world"), (s1, s2) -> System.out.println(s1 + s2));


        completableFuture.get();
    }
}

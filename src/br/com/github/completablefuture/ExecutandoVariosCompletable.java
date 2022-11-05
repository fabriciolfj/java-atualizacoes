package br.com.github.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExecutandoVariosCompletable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //all();
        join();
    }

    private static void join() {
        CompletableFuture<String> c1 = CompletableFuture.supplyAsync(() -> "teste1");
        CompletableFuture<String> c2 = CompletableFuture.supplyAsync(() -> "teste2");

       Stream.of(c1, c2)
                .map(CompletableFuture::join)
                .collect(Collectors.toList())
                .stream().forEach(System.out::println);


    }

    private static void all() throws InterruptedException, ExecutionException {
        CompletableFuture<String> c1 = CompletableFuture.supplyAsync(() -> "teste1");
        CompletableFuture<String> c2 = CompletableFuture.supplyAsync(() -> "teste2");

        var result = CompletableFuture.allOf(c1, c2);

        result.get();

        System.out.println(c1.isDone());
        System.out.println(c2.isDone());
    }
}

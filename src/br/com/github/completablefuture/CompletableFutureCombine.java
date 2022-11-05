package br.com.github.completablefuture;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureCombine {

    public static void main(String[] args) {
        //quando queremos que 2 completables executam de forma independente, mas queremos fazer algum com os 2 resultados
        CompletableFuture<String> result = CompletableFuture.supplyAsync(() -> "hello ")
                .thenCombine(CompletableFuture.supplyAsync(() -> " world"),  (s1, s2) -> s1 + s2);

        System.out.println(result);
    }
}

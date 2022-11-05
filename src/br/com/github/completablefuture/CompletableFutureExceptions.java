package br.com.github.completablefuture;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExceptions {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        example1();
        example2();
    }

    private static void example2() throws ExecutionException, InterruptedException {
        String name = null;
        CompletableFuture<String> value = CompletableFuture.supplyAsync(() -> {
            if (Objects.isNull(name)) {
                throw new RuntimeException();
            }

            return name;
        }).handle((v, e) -> {
            if(e != null) {
                v = "teste";
            }

            return v;
        });


        System.out.println(value.get());

    }

    private static void example1() {
        CompletableFuture<String> value = CompletableFuture.supplyAsync(() -> "teste2");

        value.whenComplete((v, e) -> {
            if (e != null) {
                e.printStackTrace();
                return;
            }

            System.out.println(v);
        });
    }
}

package br.com.github.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureTimeout {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        example3();
    }

    private static void example2() throws ExecutionException, InterruptedException {
        var result = CompletableFuture.supplyAsync(() -> "teste")
                .completeOnTimeout("ok", 1, TimeUnit.SECONDS);

        result.whenComplete((v, e) -> {
            if (e != null) {
                System.out.println(e.getMessage());
                return;
            }

            System.out.println(v);
        });
    }

    private static void example3() throws InterruptedException, ExecutionException {
        var result = CompletableFuture
                .supplyAsync(() -> getValue(), CompletableFuture.delayedExecutor(1, TimeUnit.SECONDS))
                .whenComplete((v, e) -> {
                    if (e != null) {
                        System.out.println(e.getMessage());
                        return;
                    }

                    System.out.println(v);
                });

        System.out.println(result.get());
    }

    private static void example1() throws InterruptedException, ExecutionException {
        var result = CompletableFuture.supplyAsync(() -> getValue())
                .orTimeout(4, TimeUnit.SECONDS)
                .whenComplete((v, e) -> {
                    if (e != null) {
                        System.out.println(e.getMessage());
                        return;
                    }

                    System.out.println(v);
                });
    }

    private static String getValue() {
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        return "teste";
    }
}

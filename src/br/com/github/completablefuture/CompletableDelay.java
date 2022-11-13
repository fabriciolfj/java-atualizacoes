package br.com.github.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableDelay {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var future = new CompletableFuture<String>();

        //future.completeAsync(() -> "ok", CompletableFuture.delayedExecutor(1, TimeUnit.SECONDS));
        future.completeOnTimeout("ok", 1, TimeUnit.SECONDS);

        System.out.println(future.get());
    }
}

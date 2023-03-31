package br.com.github.callablevssuplier.supplier;

import br.com.github.callablevssuplier.User;

import java.time.LocalDate;
import java.time.Period;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Simulacao {

    public User execute(final User user) {
        final ExecutorService executorService = Executors.newCachedThreadPool();
        final CompletableFuture<Integer> ageFut = CompletableFuture.supplyAsync(() -> Period.between(user.getBirthDate(), LocalDate.now()).getYears(), executorService)
                .exceptionally(t -> {
                    throw new RuntimeException(t.getMessage());
                });

        user.setAge(ageFut.join());
        return user;
    }
}

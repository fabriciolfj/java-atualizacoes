package br.com.github.callablevssuplier.callable;

import br.com.github.callablevssuplier.User;

import java.time.LocalDate;
import java.time.Period;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Simulacao {

    public static void main(String[] args) {

    }

    public User execute(final User user) {
        final ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            //Future<Integer> ageFuture = executorService.submit(new AgeCalculatorCallable(user.getBirthDate()));
            Future<Integer> ageFuture = executorService.submit(() -> Period.between(user.getBirthDate(), LocalDate.now()).getYears());
            user.setAge(ageFuture.get());
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e.getCause());
        }

        return user;
    }
}

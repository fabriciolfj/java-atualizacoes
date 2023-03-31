package br.com.github.callablevssuplier.callable;

import java.time.LocalDate;
import java.time.Period;
import java.util.concurrent.Callable;

public class AgeCalculatorCallable implements Callable<Integer> {

    private final LocalDate birthDate;

    public AgeCalculatorCallable(final LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public Integer call() throws Exception {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}

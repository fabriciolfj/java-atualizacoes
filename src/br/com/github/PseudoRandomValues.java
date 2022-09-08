package br.com.github;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PseudoRandomValues {

    public static void main(String[] args) {
        IntStream rnd = new Random().ints(20, 1, 100);

        var result = rnd
                .filter(i -> i % 2 ==0)
                .limit(10)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(result);
    }
}

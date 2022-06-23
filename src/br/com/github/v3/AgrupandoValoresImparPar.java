package br.com.github.v3;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AgrupandoValoresImparPar {

    public static void main(String[] args) {
        var result = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .collect(Collectors.groupingBy(v -> v % 2 == 0));

        System.out.println(result);
    }
}

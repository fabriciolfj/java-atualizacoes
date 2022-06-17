package br.com.alura.v3.programacaofuncional;

import java.util.Arrays;
import java.util.stream.Collectors;

public class DebugLambda {

    public static void main(String[] args) {
        var names = Arrays.asList("fabricio", "teste", null, "suzana");

        var resul = names
                .stream()
                .peek(System.out::println)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(resul);
    }
}

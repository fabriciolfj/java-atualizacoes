package br.com.alura.v3.programacaofuncional;

import java.util.function.Function;

public class TestandoMethodUseLambdas {

    public static void main(String[] args) {
        var result = firstAndLastChar.apply("fabricio");
        System.out.println(result);
    }

    private static final Function<String, String> firstAndLastChar =
            s -> s.charAt(0) + String.valueOf(s.charAt(s.length() - 1));
}

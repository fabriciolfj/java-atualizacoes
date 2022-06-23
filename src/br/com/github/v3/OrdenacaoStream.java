package br.com.github.v3;

import java.util.stream.Stream;

public class OrdenacaoStream {

    public static void main(String[] args) {
        var values = Stream.of(9, 4, 5, 6, 2, 4);

        values.sorted((x, y) -> x + y).forEach(System.out::println);

    }
}
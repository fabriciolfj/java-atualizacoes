package br.com.alura.v3.programacaofuncional;

import java.util.List;
import java.util.stream.Collectors;

public class FiltrandoElementsOfStream {

    public static void main(String[] args) {
        var ints = List.of(1, 2, -4, 0, 2, 0, -1, 14, 0, -1);
        var result = ints
                .stream()
                .filter(i -> i != 0)
                .skip(1)
                .limit(2)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(result);
    }
}

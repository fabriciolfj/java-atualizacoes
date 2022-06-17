package br.com.alura.v3.programacaofuncional;

import java.util.List;

public class InfinitStream {

    public static void main(String[] args) {
        var list = List.of(31,  1, 4, 20, 15, 2, 17, 5, 5, 22);
        list.stream().unordered()
                .forEach(System.out::println);

        System.out.println("===========================");

        list.stream().sequential().unordered().forEach(System.out::println);
    }
}

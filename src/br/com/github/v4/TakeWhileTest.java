package br.com.github.v4;

import java.util.List;
import java.util.stream.Collectors;

//ele vai adicionando, ate que a condicao seja atendida, e ignora o restante da lista
public class TakeWhileTest {

    public static void main(String[] args) {
        //example1();
        example2();
    }

    private static void example2() {
        var list = List.of(5, 2, 7, 8, 0, 2, 9, 11, 344);
        var result = list.stream().takeWhile(i -> i <= 5).limit(5).collect(Collectors.toList());


        System.out.println(result);
    }

    private static void example1() {
        var list = List.of(1, 2, 3, 4, 5, 6);
        var result = list.stream().takeWhile(i -> i <= 5).collect(Collectors.toList());


        System.out.println(result);
    }
}

package br.com.github.v4;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//ele vai retirando os itens, ate que a condicao seja atendida, e add restante
public class DropWhileTest {

    public static void main(String[] args) {
        example4();
    }

    private static void example4() {
        new Random().ints(10, 100)
                .filter(i -> i % 2 == 0)
                .dropWhile(i -> i >= 46)
                .limit(10)
                .forEach(System.out::println);
    }

    private static void example3() {
        IntStream.iterate(1 , i -> i + 1).map(i -> i * 4)
                .filter(i -> i % 2 == 0)
                .dropWhile(i -> i <= 10)
                .limit(10)
                .forEach(System.out::println);
    }

    private static void example2() {
        var list = List.of(5, 2, 7, 8, 0, 2, 9, 11, 344);
        var result = list.stream().dropWhile(i -> i <= 5).limit(5).collect(Collectors.toList());


        System.out.println(result);
    }

    private static void example1() {
        var list = List.of(1, 2, 3, 4, 5, 6);
        var result = list.stream().dropWhile(i -> i <= 5).collect(Collectors.toList());


        System.out.println(result);
    }
}

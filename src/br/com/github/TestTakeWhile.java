package br.com.github;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestTakeWhile {

    // interrompe a execucao quando encontrar o primeiro dado que nao corresponder ao predicate.

    private static List<Integer> list  = List.of(2, 3, 4, 5, 6, 7, 8, 9, 10);
    private static List<Integer> listn = List.of(4, 3, 8, 9, 2, 1, 10, 5, 6);

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    private static void test4(){
        var result = new Random().ints(1, 100)
                .takeWhile(i -> i % 2 == 0 && i >= 50)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(result);
    }

    private static void test3() {
        var result = IntStream.iterate(1, i -> i + 1)
                .takeWhile(i -> i <= 10)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(result);
    }

    private static void test1() {
        var result = list.stream().takeWhile(i -> i % 2 ==0)
                .collect(Collectors.toList());

        System.out.println("ordenada " + result);
    }

    private static void test2() {
        var result = listn.stream().takeWhile(i -> i % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("nao ordenada " + result);
    }
}

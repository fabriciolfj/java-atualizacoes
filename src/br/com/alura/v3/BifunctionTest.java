package br.com.alura.v3;

import java.util.function.BiFunction;

public class BifunctionTest {

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> function = (x , y) -> x + y;
        var result = execute(function, 2, 4);

        System.out.println(result);
    }

    public static Integer execute(BiFunction<Integer, Integer, Integer> funciton, Integer value1, Integer value2) {
        return funciton.apply(value1, value2);
    }
}

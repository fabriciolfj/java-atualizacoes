package br.com.github;


import java.util.function.BiFunction;
import java.util.function.Function;

public class TestFunction {

    public static void main(String[] args) {
        var nome = "fabricio";
        var result = prefixer.apply(nome)
                .apply("lucas");

        System.out.println(result);

        System.out.println(calc.apply(1L, 6L));
    }

    private static Function<String, String> sufixer() {
        return value -> value + ":";
    }

    private static Function<String, Function<String, String>> prefixer = prefix -> r -> prefix + ":" + r;

    private static BiFunction<Long, Long, String> calc = (a, b) -> String.valueOf(a + b);
}

package br.com.alura.v3.programacaofuncional;

import java.util.function.Function;
import java.util.stream.Stream;

public class RetornoInterfaceFunctional {

    public static void main(String[] args) {
        Function<String, String> f1 = s -> s.toUpperCase();
        Function<String, String> f2 = s -> s.concat(" DONE");

        var f = reduceStrings(f1, f2);
        System.out.println(f.apply("test"));
    }

    public static Function<String, String> reduceStrings(Function<String, String> ...functions) {
        var funciton = Stream.of(functions)
                .reduce(Function.identity(), Function::andThen);

        return funciton;
    }
}

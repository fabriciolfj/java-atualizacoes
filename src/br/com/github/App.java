package br.com.github;

import java.util.stream.Stream;

public class App {

    public final static void main(final String...args){
        int x = 10;
        Stream.iterate(0, n ->  n + (1 * x))
                .limit(10)
                .forEach(System.out::println);
        //x = 30;
    }
}

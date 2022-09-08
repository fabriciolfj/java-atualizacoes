package br.com.github;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InfiniteSequentialStream {

    public static void main(String[] args) {
        Stream<Integer> infStream = Stream
                .iterate(1 ,i -> i <= 10, i -> i % 2 == 0 ? new Random().nextInt(20) : -1 * new Random().nextInt(10));

        var result = infStream.limit(25)
                .collect(Collectors.toList());

        result.stream()
                .forEach(System.out::println);
    }
}

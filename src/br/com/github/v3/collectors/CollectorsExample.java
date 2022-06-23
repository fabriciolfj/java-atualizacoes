package br.com.github.v3.collectors;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsExample {

    public static void main(String[] args) {
        final String name = "Fabricio37";

        Map<String, Long> map = name.chars()
                .filter(Character::isAlphabetic)
                .map(Character::toLowerCase)
                .mapToObj(Character::toString)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        System.out.println(map);

        Map.Entry<String, Long> mostFrequentLetter =
                map.entrySet().stream()
                        .max(Map.Entry.comparingByValue())
                        .orElseThrow();

        System.out.println(mostFrequentLetter);

        var result = map.entrySet().stream()
                .sorted(Map.Entry.<String, Long> comparingByValue().reversed())
                //.limit(3)
                .toList();

        System.out.println(result);

    }
}

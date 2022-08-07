package br.com.github.abordagensconsulta;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Simulacao {

    private static final Predicate<Integer> PREDICATE = i -> i == 751879;

    public static void main(String[] args) {
        Supplier<Stream<Integer>> range = () -> IntStream.range(1, 1000000000).boxed();

        var init = System.currentTimeMillis();
        findUniqueElementMatchingPredicate_WithReduction(range.get(), PREDICATE);
        var end = System.currentTimeMillis() - init;
        System.out.printf("findUniqueElementMatchingPredicate_WithReduction: %s\n", end);

        init = System.currentTimeMillis();
        getUniqueElementMatchingPredicate_WithReduction(range.get(), PREDICATE);
        end = System.currentTimeMillis() - init;
        System.out.printf("getUniqueElementMatchingPredicate_WithReduction: %s\n", end);

        init = System.currentTimeMillis();
        findUniqueElementMatchingPredicate_WithCollectingAndThen(range.get(), PREDICATE);
        end = System.currentTimeMillis() - init;
        System.out.printf("findUniqueElementMatchingPredicate_WithCollectingAndThen: %s\n", end);

        init = System.currentTimeMillis();
        getUniqueElementMatchingPredicate_WithCollectionsAndThen(range.get(), PREDICATE);
        end = System.currentTimeMillis() - init;
        System.out.printf("getUniqueElementMatchingPredicate_WithCollectionsAndThen: %s\n", end);
    }

    public static <T> Optional<T> findUniqueElementMatchingPredicate_WithReduction(Stream<T> elements, Predicate<T> predicate) {
        return elements.filter(predicate)
                .collect(Collectors.reducing((a, b) -> null));
    }

    public static <T> T getUniqueElementMatchingPredicate_WithReduction(Stream<T> elements, Predicate<T> predicate) {
        return elements.filter(predicate)
                .reduce((a, b) -> {
                    throw new IllegalArgumentException("too many elements match the predicate");
                }) .orElseThrow(() -> new IllegalStateException("No element matchs the predicate"));
    }

    public static <T> Optional<T> findUniqueElementMatchingPredicate_WithCollectingAndThen(Stream<T> elements, Predicate<T> predicate) {
        return elements.filter(predicate)
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> Optional.ofNullable(findUniqueElement(list))));
    }

    public static <T> T getUniqueElementMatchingPredicate_WithCollectionsAndThen(Stream<T> elements, Predicate<T> predicate) {
        return elements.filter(predicate)
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> getUniqueElement(list)));
    }

    private static <T> T getUniqueElement(List<T> elements) {
        if (elements.size() > 1) {
            throw new IllegalStateException("Too many elements match the predicate");
        } else if (elements.size() == 0) {
            throw new IllegalStateException("No element matches the predicate");
        }

        return elements.get(0);
    }

    private static <T> T findUniqueElement(List<T> elements) {
        if (elements.size() == 1) {
            return elements.get(0);
        }

        return null;
    }
}

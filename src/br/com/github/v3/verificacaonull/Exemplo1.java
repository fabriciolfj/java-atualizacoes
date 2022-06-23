package br.com.github.v3.verificacaonull;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Exemplo1 {

    public static void main(String[] args) {
        final List<Integer> integers = Arrays.asList(1, 2, null, 12, 16, 15, 19);

        System.out.println(sumValuesNotNull(integers));
        System.out.println(isValuesListNull(integers));
    }

    private static boolean isValuesListNull(final List<Integer> integers) {
        return integers.stream()
                .anyMatch(Objects::isNull);
    }

    private static Integer sumValuesNotNull(final List<Integer> integers) {

        if (Objects.isNull(integers)) {
            throw new IllegalArgumentException("List is null");
        }

        return integers.stream().filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .sum();
    }
}

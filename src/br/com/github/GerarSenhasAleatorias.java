package br.com.github;

import java.security.SecureRandom;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GerarSenhasAleatorias {

    public static void main(String[] args) {
        Supplier<String> password = GerarSenhasAleatorias::randomPassword;
        var passwordStream = Stream.generate(password);

        var result = passwordStream.limit(10)
                .collect(Collectors.toList());

        IntStream s = IntStream.builder().add(2).build();
        s.forEach(System.out::println);

        System.out.println(result);

    }

    private static String randomPassword() {
        String chars = "abcd0123!@#$";

        return new SecureRandom().ints(8, 0, chars.length())
                .mapToObj(i -> String.valueOf(chars.charAt(i)))
                .collect(Collectors.joining());
    }
}

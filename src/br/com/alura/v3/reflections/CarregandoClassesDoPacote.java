package br.com.alura.v3.reflections;

import java.util.stream.Stream;

public class CarregandoClassesDoPacote {


    public static void main(String[] args) {
        var result = ClassLoader.getSystemClassLoader().getResource("br.com.alura.v3.reflections");

        System.out.println(result);

        Stream.of(Package.getPackages()).forEach(System.out::println);
    }
}

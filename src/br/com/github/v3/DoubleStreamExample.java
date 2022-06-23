package br.com.github.v3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class DoubleStreamExample {

    public static void main(String[] args) {
        double[] values = {1, 2, 3,4};
        DoubleStream stream = Arrays.stream(values);
        stream.forEach(System.out::println);

        Double[] values2 =  {1.0, 2.0, 3.0, 4.5};

        List<Double> elements = Arrays.asList(values2);

        Stream<Double> stream1 = elements.stream();

        var stream2 = elements.parallelStream();

        stream1.forEach(System.out::println);
        stream2.forEach(System.out::println);
    }

}

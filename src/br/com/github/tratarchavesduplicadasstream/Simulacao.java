package br.com.github.tratarchavesduplicadasstream;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

public class Simulacao {

    public static void main(String[] args) {
        final List<City> CITY_INPUT = Arrays.asList(
                new City("New York City", "USA"),
                new City("Shanghai", "China"),
                new City("Hamburg", "Germany"),
                new City("Paris", "France"),
                new City("Paris", "Texas, USA"));

        final Map<String, City> values =
                CITY_INPUT
                        .stream()
                                .collect(toMap(City::getName, Function.identity(), (f, s) -> {
                                    var result = f.getLocateIn() + " " + s.getLocateIn();
                                    return new City(f.getName(), result);
                                }));

        System.out.println(values);
    }
}

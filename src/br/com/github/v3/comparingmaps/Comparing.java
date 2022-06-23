package br.com.github.v3.comparingmaps;

import br.com.github.entities.Melon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Comparing {

    public static void main(String[] args) {
        Melon[] melons1 = {
                new Melon("apollo", 3000),
                new Melon("jade", 3000),
        };

        Melon[] melons2 = {
                new Melon("apollo", 3000),
                new Melon("jade", 3000),
        };

        Map<Integer, Melon[]> map1 = new HashMap<>();
        Map<Integer, Melon[]> map2 = new HashMap<>();

        map1.put(1, melons1);
        map2.put(1, melons2);

        var result1 = map1.equals(map2);

        System.out.println(result1);

        var result2 = map1.entrySet().stream()
                .allMatch(e -> Arrays.equals(e.getValue(), map2.get(e.getKey())));

        System.out.println(result2);

    }

}

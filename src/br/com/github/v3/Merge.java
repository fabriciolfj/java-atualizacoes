package br.com.github.v3;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Merge {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("postgresql", "9.6.1 ");
        map.put("mysql", "5.1 5.2 5.6 ");

        BiFunction<String, String, String> version = String::concat;

        var result = map.merge("mysql", "5.8", version);

        System.out.println(result);
        System.out.println(map);
    }
}

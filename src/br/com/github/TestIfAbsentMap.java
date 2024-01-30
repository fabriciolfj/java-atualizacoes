package br.com.github;

import java.util.HashMap;

public class TestIfAbsentMap {

    public static void main(String[] args) {
        var map = new HashMap<String, String>();
        map.put("1", "fabricio");
        map.put("2", "lucas");

        System.out.println(map.computeIfAbsent("1", v -> "nao achei"));
        System.out.println(map.computeIfAbsent("3", v -> "nao achei"));
        System.out.println(map.computeIfAbsent("4", v -> null));
    }
}

package br.com.github.v3;

import java.util.HashMap;
import java.util.Map;

public class PutIfAbsent {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "mysql");

        var mysql = map.putIfAbsent(1, "mysql");
        var postgres = map.putIfAbsent(2, "postgres");
        var postgres3 = map.putIfAbsent(2, "postgres");
        var cassandra = map.putIfAbsent(3, "cassandra");

        System.out.println(mysql);
        System.out.println(postgres);
        System.out.println(postgres3);
        System.out.println(cassandra);

        System.out.println(map);
        var postgres2 = map.putIfAbsent(2, "postgres");
        System.out.println(postgres2);
    }
}

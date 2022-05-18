package br.com.alura.v3;

import java.util.Map;

public class MapGetOrDefault {

    public static void main(String[] args) {
        Map<String, String> map = Map.of("mysql", "192.168.0.1:2701", "postgresl", "192.168.0.1:3472");

        var result = map.getOrDefault("mongodb", "192.168.0.1:2701");

        System.out.println(result);
    }
}

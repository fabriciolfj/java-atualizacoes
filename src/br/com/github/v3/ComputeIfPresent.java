package br.com.github.v3;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class ComputeIfPresent {

    //sempre vai computar, se a chave estiver presente
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("mysql", "192.168.0.1");
        map.put("postgresql", "127.0.0.1");

        BiFunction<String, String, String> jdbc = (k, v) -> "jdbc:" + k + "://" + v + "/customers_db";

        var url = map.computeIfPresent("mysql", jdbc);
        var url2 = map.computeIfPresent("mysql", jdbc);
        System.out.println(url);
        System.out.println(map);
    }
}

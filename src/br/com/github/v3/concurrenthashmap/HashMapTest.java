package br.com.github.v3.concurrenthashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMapTest {

    public static void main(String[] args) {
        var datas = new HashMap<String, String>();

        datas.put("fabricio", "linux");
        datas.put("roberto", "windows");
        datas.put("lucas", "linx");
        datas.put("carlos", "windows");
        datas.put("caio", "linux");

        var result = datas.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey, (k1, k2) -> k1.length() > k2.length() ? k1 : k2))
                .entrySet()
                .stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

        System.out.println(result);
    }
}

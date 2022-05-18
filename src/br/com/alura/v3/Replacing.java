package br.com.alura.v3;

import br.com.alura.entities.Apollo;
import br.com.alura.entities.Cantaloupe;
import br.com.alura.entities.Gac;
import br.com.alura.entities.Melon;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Replacing {

    public static void main(String[] args) {
        Map<Integer, Melon> map = new HashMap<>();
        map.put(1, new Apollo(3000));
        map.put(2, new Gac(1000));
        map.put(3, new Cantaloupe(1500));

        BiFunction<Integer, Melon, Melon> function = (k, v) -> v.getGrama() > 1000 ? new Melon(v.getName(), 1000) : v;

        map.replaceAll(function);

        System.out.println(map);
    }
}

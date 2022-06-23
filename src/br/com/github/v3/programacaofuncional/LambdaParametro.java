package br.com.github.v3.programacaofuncional;

import java.util.ArrayList;
import java.util.List;

public class LambdaParametro {

    public static void main(String[] args) {
        List<String> names = List.of("Ann a 15", "Mir el 28", "D oru 33");
        List<String> resultWs = replace(names, s -> s.replaceAll("\\s", ""));

        System.out.println(resultWs);
     }

    public static List<String> replace(List<String> list, Replacer<String> r) {
        List<String> result = new ArrayList<>();

        for (String s: list) {
            result.add(r.replace(s));
        }

        return result;
    }
}

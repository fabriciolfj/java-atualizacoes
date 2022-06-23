package br.com.github.v3.reflections;

import br.com.github.entities.Melon;

public class GenericsTest {

    public static void main(String[] args) {
        var fruit = new Melon("Gac", 2);
        fruit.coletar();
    }
}

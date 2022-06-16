package br.com.alura.v3.reflections;

import br.com.alura.entities.Melon;

public class GenericsTest {

    public static void main(String[] args) {
        var fruit = new Melon("Gac", 2);
        fruit.coletar();
    }
}

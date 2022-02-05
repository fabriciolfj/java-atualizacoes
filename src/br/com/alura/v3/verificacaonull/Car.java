package br.com.alura.v3.verificacaonull;

import java.util.Objects;

public class Car {

    private final String name;
    private final Color color;

    public Car(final String name, final Color color) {
        this.name = Objects.requireNonNullElse(name, "not name");
        this.color = Objects.requireNonNullElseGet(color, () -> new Color(0, 0, 0));
    }
}

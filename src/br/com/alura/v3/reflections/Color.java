package br.com.alura.v3.reflections;

import java.util.stream.Stream;

public enum Color {

    AZUL("azul"), VERDE("verde"), AMARELO("amarelo");
    private String describe;

    private Color(final String describe) {
        this.describe = describe;
    }

    public static Color toEnum(final String describe) {
        return Stream.of(Color.values())
                .filter(v -> v.describe.equals(describe))
                .findAny()
                .orElseThrow();
    }

    public String getDescribe() {
        return describe;
    }
}

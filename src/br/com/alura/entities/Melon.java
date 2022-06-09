package br.com.alura.entities;

import java.util.Objects;

public class Melon {

    private String name;
    private Integer grama;

    public Melon(final String name, final Integer grama) {
        this.name = name;
        this.grama = grama;
    }

    public String getName() {
        return name;
    }

    public Integer getGrama() {
        return grama;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Melon melon = (Melon) o;
        return Objects.equals(name, melon.name) && Objects.equals(grama, melon.grama);
    }

    private void teste() {}

    @Override
    public int hashCode() {
        return Objects.hash(name, grama);
    }

    @Override
    public String toString() {
        return "Melon{" +
                "name='" + name + '\'' +
                ", grama=" + grama +
                '}';
    }
}

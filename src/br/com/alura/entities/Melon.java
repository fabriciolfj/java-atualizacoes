package br.com.alura.entities;

import br.com.alura.v3.reflections.Fruit;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Melon extends Fruit<Melon> {

    private String name;
    private Integer grama;

    public Melon() {
        setType(this);
    }

    public Melon(final String name, final Integer grama) {
        this.name = name;
        this.grama = grama;
        setType(this);
    }

    public String getName() {
        return name;
    }

    public Integer getGrama() {
        return grama;
    }

    public void setGrama(Integer grama) {
        this.grama = grama;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Melon> cultivar(String type, int seeds) {
        List<Melon> melons = new ArrayList<>();
        for(int i = 0; i < seeds; i++) {
            melons.add(new Melon(type, 0));
        }

        return melons;
    }

    public static void cultiver(int seeds) {
        System.out.println("Method invocado: " + seeds);
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

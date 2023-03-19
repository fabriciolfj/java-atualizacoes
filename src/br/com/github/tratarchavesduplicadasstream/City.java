package br.com.github.tratarchavesduplicadasstream;

import java.util.Objects;

public class City {

    private String name;
    private String locateIn;

    public City(final String name, final String locateIn) {
        this.name = name;
        this.locateIn = locateIn;
    }

    public String getName() {
        return name;
    }

    public String getLocateIn() {
        return locateIn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(name, city.name) && Objects.equals(locateIn, city.locateIn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, locateIn);
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", locateIn='" + locateIn + '\'' +
                '}';
    }
}

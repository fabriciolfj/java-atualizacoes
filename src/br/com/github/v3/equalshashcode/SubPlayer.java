package br.com.github.v3.equalshashcode;

import java.util.Objects;

public class SubPlayer extends Player {

    private String address;

    public SubPlayer(String name, String address) {
        super(name);
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SubPlayer subPlayer = (SubPlayer) o;
        return Objects.equals(address, subPlayer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), address);
    }
}

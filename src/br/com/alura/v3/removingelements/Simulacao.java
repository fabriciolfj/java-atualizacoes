package br.com.alura.v3.removingelements;

import br.com.alura.entities.Melon;

import java.util.ArrayList;

public class Simulacao {

    public static void main(String[] args) {
        var melons = new ArrayList<Melon>();
        melons.add(new Melon("apollo", 3000));
        melons.add(new Melon("jade", 3500));
        melons.add(new Melon("cantaloupe", 1500));
        melons.add(new Melon("hami", 1400));

        melons.removeIf(t -> t.getGrama() < 3000);

        System.out.println(melons);
    }
}


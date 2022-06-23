package br.com.github.v3;

import br.com.github.entities.Melon;

import java.util.ArrayList;
import java.util.Collections;

public class Frequency {

    public static void main(String[] args) {
        var melons = new ArrayList<Melon>();
        melons.add(new Melon("apollo", 3000));
        melons.add(new Melon("jade", 3500));
        melons.add(new Melon("cantaloupe", 1500));
        melons.add(new Melon("hami", 1400));
        melons.add(new Melon("apollo", 3000));

        var result = Collections.frequency(melons, new Melon("apollo", 3000));

        System.out.println(result);
    }
}

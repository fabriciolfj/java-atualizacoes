package br.com.github.v3;

import br.com.github.entities.Melon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionBy {

    public static void main(String[] args) {
        var melons = new ArrayList<Melon>();
        melons.add(new Melon("apollo", 3000));
        melons.add(new Melon("jade", 3500));
        melons.add(new Melon("cantaloupe", 1500));
        melons.add(new Melon("hami", 1400));

        Map<Boolean, List<Melon>> separatedMelons = melons
                .stream()
                .collect(Collectors.partitioningBy(t -> t.getGrama() > 3000));

        System.out.println(separatedMelons.get(true));
    }
}

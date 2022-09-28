package br.com.github.v4;

import java.util.List;

public class MatchTest {

    private static List<String> melons = List.of("Gac", "Cantaloupe", "Hemi", "Gac", "Gac", "Hemi",
            "Cantaloupe", "Horned", "Hemi", "Hemi");

    public static void main(String[] args) {
        boolean isAnyGac = melons.stream().anyMatch(m -> m.equals("Gac"));

        System.out.println("anyMatch " + isAnyGac);

        boolean isNoneGac = melons.stream().noneMatch(m -> m.equals("Gac"));

        System.out.println("noneMatch " + isNoneGac);

        boolean isAllMatch = melons.stream().allMatch(m -> m.equals("Gac"));

        System.out.println("allMatch " + isAllMatch);

        boolean isAllMatchTwo = melons.stream().allMatch(m -> m.length() > 2);

        System.out.println("allMatchLength " + isAllMatchTwo);

    }
}

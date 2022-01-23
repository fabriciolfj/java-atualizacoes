package br.com.alura.v2;


import static java.time.DayOfWeek.SATURDAY;

public class SwitchNew {

    public static void main(String[] args) {
        var day = SATURDAY;
        int numLetters = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY                -> 7;
            default      -> {
                String s = day.toString();
                int result = s.length();
                yield result;
            }
        };

        System.out.println(numLetters);
    }
}

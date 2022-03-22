package br.com.alura.v3.otimizacao;

import java.util.Arrays;

public class Simulacao {

    public static void main(String[] args) {
        var events = Arrays.asList(
                new Event("serrana", 10, "t1", 1),
                new Event("cravinhos", 200, "t1", 1),
                new Event("serra azul", 30, "t2", 3),
                new Event("ribeirao preto", 60, "t3", 4),
                new Event("cassia", 80, "t4", 5),
                new Event("sao paulo", 90, "t5", 5),
                new Event("jardinopolis", 210, "t6", 7),
                new Event("uberlandia", 187, "t7", 9));

        var t = Math.abs(1 - 3);
        System.out.println(t);

        Event.getNearEvents(7, events, "New York", (l1, l2) -> Math.abs(l1.hashCode() - l2.hashCode()), "t1", 10)
                .forEach(System.out::println);
    }
}

package br.com.github;

import java.util.Scanner;

public class SwitchCaseTest {

    public static void main(String[] args) {
        System.out.println("Digite um dia da semana");
        final Scanner scanner = new Scanner(System.in);
        var dia = scanner.next();

        System.out.println("Digite o mes");
        var mes = scanner.nextInt();

        var result = switch (dia) {
            case "seg", "ter", "qua", "quin", "sex" -> {
                if (mes == 12) {
                    yield "abert 08:00 as 12:00";
                }

                yield "aberto 08:00 as 18:00";
            }
            case "sab" -> "aberto 08:00 as 13:00";
            case "dom" -> "fechado";
            default -> "Opção inválida";
        };

        System.out.println(result);

    }
}

package br.com.github;

import java.util.Scanner;

public class AnoBissexto {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o ano");

        final var ano = scanner.nextInt();
        final var result = ano % 400 == 0 || (ano % 4 == 0 && ano % 100 > 0);

        System.out.printf("Ano é bissexto %b%n", result);
    }
}

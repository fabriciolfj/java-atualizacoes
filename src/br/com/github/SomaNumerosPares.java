package br.com.github;

import java.util.Scanner;

public class SomaNumerosPares {

    public static void main(String[] args) {
        int soma = 0;
        final Scanner scanner = new Scanner(System.in);
        for (int index = 0; index < 10; index++) {
            System.out.println("Digite um numero: ");
            int value = scanner.nextInt();

            if (value % 2 > 0) {
                System.out.println("Digite apenas numero pares");
                index--;
                continue;
            }

            soma += value;
        }

        System.out.printf("Total %d%n", soma);
    }
}

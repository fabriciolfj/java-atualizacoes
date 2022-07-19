package br.com.github;

import java.util.Scanner;

public class NumeroPrimo {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.printf("Digite o valor: ");
        int value = scanner.nextInt();

        if (value <= 1) {
            System.out.printf("Valor digitado invalido");
            return;
        }

        int quantidade = 0;
        for (int i = 1; i <= value; i++) {
            if (value % i == 0) {
                quantidade++;
            }
        }

        System.out.printf("Valor digitado e primo? %s%n", quantidade == 2 ? "Sim" : "Nao");
    }
}

package br.com.github;

import java.util.Scanner;

public class CalcularPesoAeronave {

    public static void main(String[] args) {
        System.out.println("Peso aeronave");
        Scanner scanner = new Scanner(System.in);
        int pesoAeronave = scanner.nextInt();

        System.out.println("Digite a quantidade de passageiros");
        int quantidadePassageiros = scanner.nextInt();

        int totalPeso = 0;
        for (int i =0; i < quantidadePassageiros; i++) {
            System.out.printf("Digite o peso do passageiro %s%n", i);
            totalPeso += scanner.nextInt();
        }

        System.out.println("Total peso aeronave: " + pesoAeronave);
        System.out.println("Total peso passageiros: " + quantidadePassageiros);
        System.out.println("Peso: " + (totalPeso > pesoAeronave ? "excedido" : "normal"));
    }
}

package br.com.github;

import java.util.Scanner;

public class IMC {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu sexo: ");

        var sexo = scanner.next();

        System.out.print("Digite seu peso: ");

        var peso = scanner.nextDouble();

        System.out.print("Digite sua altura: ");

        var altura = scanner.nextDouble();

        var imc = peso / (altura * altura);

        if (sexo == "F") {
            if (imc <= 19.1) {
                System.out.println("Abaixo do peso");
            } else if (imc > 19.1 && imc < 25.8) {
                System.out.println("No peso ideal");
            } else if (imc >= 25.9 && imc <= 27.3) {
                System.out.println("Pouco acima do peso");
            } else {
                System.out.println("Obeso");
            }
        } else {
            if (imc <= 20.7) {
                System.out.println("Abaixo do peso");
            } else if (imc >= 20.8 && imc < 26.4) {
                System.out.println("No peso ideal");
            } else if (imc >= 26.5 && imc <= 27.8) {
                System.out.println("Pouco acima do peso");
            } else {
                System.out.println("Obeso");
            }
        }
    }
}

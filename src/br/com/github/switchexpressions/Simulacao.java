package br.com.github.switchexpressions;

public class Simulacao {

    public static void main(String[] args) {
        var month = Months.FEVEREIRO;

        final String message = switch (month) {
            case JANEIRO, FEVEREIRO -> "inicio";
            case MARCO, MAIO -> "ok";
            case JUNHO -> "maios ou menos";
        };

        System.out.println(message);
    }
}

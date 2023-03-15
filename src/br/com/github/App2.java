package br.com.github;

public class App2 {

    public static void main(String[] args) {
        int v = 3;
        int K = switch (v) {
            case 1 -> {
                yield 33;
            }

            case 2, 3 -> {
                yield 24;
            }

            default -> {
                yield 83;
            }
        };
        System.out.println(K);
    }
}

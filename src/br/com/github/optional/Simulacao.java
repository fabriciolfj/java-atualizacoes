package br.com.github.optional;

public class Simulacao {

    public static void main(String[] args) {
        var repo = new Repository();

        var result = repo.findOk().orElseThrow(() -> new RuntimeException("nok"));
        System.out.println(result);
    }
}

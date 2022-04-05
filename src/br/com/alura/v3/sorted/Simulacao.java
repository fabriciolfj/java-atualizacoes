package br.com.alura.v3.sorted;

import br.com.alura.v3.modelo.ConstroiArrayPessoa;
import br.com.alura.v3.modelo.Pessoa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Simulacao {

    public static void main(String[] args) {
        var pessoas = ConstroiArrayPessoa.execute();

        var comparing = Comparator.comparing(Pessoa::getIdade);

        var result = Arrays.stream(pessoas)
                .sorted(comparing::compare)
                .collect(Collectors.toList());

        result.forEach(System.out::println);
    }
}

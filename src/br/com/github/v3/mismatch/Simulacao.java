package br.com.github.v3.mismatch;

import br.com.github.v3.modelo.Pessoa;

import java.util.Arrays;

//retorna o index que for diferente
public class Simulacao {

    public static void main(String[] args) {
        var l1 = new Pessoa []{
                new Pessoa("fabricio", 10),
                new Pessoa("lucas", 20),
                new Pessoa("felicio", 30)
        };

        var l2 = new Pessoa []{
                new Pessoa("fabricio", 10),
                new Pessoa("lucas", 20),
                new Pessoa("carlos", 30)
        };

        var result = Arrays.mismatch(l1, l2);
        System.out.println(result);
    }
}

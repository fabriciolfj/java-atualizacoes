package br.com.github.v3.modelo;

public class ConstroiArrayPessoa {

    private ConstroiArrayPessoa() { }

    public static Pessoa[] execute() {
        return new Pessoa[]{
                new Pessoa("teste1", 10),
                new Pessoa("teste2", 11),
                new Pessoa("teste3", 23),
                new Pessoa("teste4", 43),
                new Pessoa("teste5", 124),
                new Pessoa("teste6", 76),
                new Pessoa("teste7", 54),
                new Pessoa("teste8", 34),
                new Pessoa("teste9", 23),
                new Pessoa("teste10", 63),
        };
    }

}

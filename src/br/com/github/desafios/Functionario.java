package br.com.github.desafios;

public class Functionario {

    private String nome;
    private Integer quantidadeFilhos;

    public Functionario(String nome, Integer quantidadeFilhos) {
        this.nome = nome;
        this.quantidadeFilhos = quantidadeFilhos;
    }

    public String getNome() {
        return nome;
    }

    public boolean isFilhos() {
        return this.quantidadeFilhos > 0;
    }

    @Override
    public String toString() {
        return "Functionario{" +
                "nome='" + nome + '\'' +
                ", quantidadeFilhos=" + quantidadeFilhos +
                '}';
    }
}

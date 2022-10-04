package br.com.github.desafios;

import java.math.BigDecimal;

public class Simulacao {

    public static void main(String[] args) {
        var funcionario = new Functionario("Fabricio", 2);
        var contrato = new ContratoTrabalho(funcionario, BigDecimal.valueOf(87), BigDecimal.valueOf(106));
        var folhaPagamento = new FolhaPagamento(160, 10);
        var holerite = folhaPagamento.calcular(contrato);

        System.out.println(holerite);
    }
}

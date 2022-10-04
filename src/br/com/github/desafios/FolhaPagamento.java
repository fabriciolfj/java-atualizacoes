package br.com.github.desafios;

import java.math.BigDecimal;

public class FolhaPagamento {

    private Integer quantidadeHoras;
    private Integer quantidadeHorasExtras;

    public FolhaPagamento(Integer quantidadeHoras, Integer quantidadeHorasExtras) {
        this.quantidadeHoras = quantidadeHoras;
        this.quantidadeHorasExtras = quantidadeHorasExtras;
    }

    public Holerite calcular(final ContratoTrabalho contrato) {
        final Holerite holerite = new Holerite();
        holerite.setFunctionario(contrato.getFunctionario());
        holerite.setTotalHora(contrato.getValorHora().multiply(BigDecimal.valueOf(quantidadeHoras)));
        holerite.setTotalHoraExtra(contrato.getValorHoraExtra().multiply(BigDecimal.valueOf(quantidadeHorasExtras)));
        holerite.calcularAdicional();

        return holerite;
    }
}

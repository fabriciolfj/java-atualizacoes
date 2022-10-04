package br.com.github.desafios;

import java.math.BigDecimal;

public class ContratoTrabalho {

    private Functionario functionario;
    private BigDecimal valorHora;
    private BigDecimal valorHoraExtra;

    public ContratoTrabalho(Functionario functionario, BigDecimal valorHora, BigDecimal valorHoraExtra) {
        this.functionario = functionario;
        this.valorHora = valorHora;
        this.valorHoraExtra = valorHoraExtra;
    }

    public Functionario getFunctionario() {
        return functionario;
    }

    public BigDecimal getValorHora() {
        return valorHora;
    }

    public BigDecimal getValorHoraExtra() {
        return valorHoraExtra;
    }
}

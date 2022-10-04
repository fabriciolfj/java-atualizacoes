package br.com.github.desafios;

import java.math.BigDecimal;

public class Holerite {

    private Functionario functionario;
    private BigDecimal totalHora;
    private BigDecimal totalHoraExtra;
    private BigDecimal adicionalFilhos;

    public void setFunctionario(Functionario functionario) {
        this.functionario = functionario;
    }

    public void setTotalHora(BigDecimal totalHora) {
        this.totalHora = totalHora;
    }

    public void setTotalHoraExtra(BigDecimal totalHoraExtra) {
        this.totalHoraExtra = totalHoraExtra;
    }

    public void calcularAdicional() {
        if (functionario.isFilhos()) {
            this.adicionalFilhos = getTotal().multiply(BigDecimal.valueOf(0.1));
            return;
        }

        this.adicionalFilhos = BigDecimal.ZERO;
    }

    private BigDecimal getTotal() {
        return this.totalHora.add(this.totalHoraExtra);
    }

    @Override
    public String toString() {
        return "Holerite{" +
                "functionario=" + functionario +
                ", totalHora=" + totalHora +
                ", totalHoraExtra=" + totalHoraExtra +
                ", adicionalFilhos=" + adicionalFilhos +
                '}';
    }
}

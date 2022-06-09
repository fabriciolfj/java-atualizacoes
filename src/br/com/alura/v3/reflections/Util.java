package br.com.alura.v3.reflections;

public class Util {

    private String value;

    private Util() {
        //lanca uma exception
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Valor: " + this.value;
    }
}

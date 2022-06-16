package br.com.alura.v3.reflections;

public abstract class Fruit<T> {

    private T obj;

    public void coletar() {
        System.out.println("Coletando a fruta: " + obj.toString());
    }

    protected void setType(T obj) {
        this.obj = obj;
    }
}

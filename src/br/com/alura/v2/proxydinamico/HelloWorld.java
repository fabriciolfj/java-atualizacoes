package br.com.alura.v2.proxydinamico;

public interface HelloWorld {

    default String hello() {
        return "world";
    }
}

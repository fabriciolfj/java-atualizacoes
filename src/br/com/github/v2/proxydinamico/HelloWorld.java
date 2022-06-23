package br.com.github.v2.proxydinamico;

public interface HelloWorld {

    default String hello() {
        return "world";
    }
}

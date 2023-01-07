package br.com.github.generics_pecs;

import java.util.List;

public class Simulacao {

    public static void main(String[] args) {
        var list = List.of(new Operator("fabricio"), new Customer("Lucas"));
        listUsers(list);
        addOperadores(list);
    }

    private static void listUsers(final List<? extends User> users) {
        users.forEach(System.out::println);
    }

    //aceita class que extenden a a classe mae de operator
    //para operacoes de adicao e leitura na mesma classe, utilizar a classe base
    private static void addOperadores(final List<? super Operator> operators) {
        System.out.println("execute");
    }
}

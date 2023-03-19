package br.com.github.v3.equalshashcode;

public class Main {

    public static void main(String[] args) {
        var p1 = new Player("fabricio");
        var p2 = new Player("fabricio");
        var p3 = new SubPlayer("fabricio", "teste1");

        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p3));

        int num = 100;
        if (num == 101) {
            System.out.println("ok");
        }
    }
}

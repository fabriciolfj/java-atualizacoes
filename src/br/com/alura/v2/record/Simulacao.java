package br.com.alura.v2.record;

public class Simulacao {

    public static void main(String[] args) {
        var book = new Book("Java", "Fabricio", "655888");
        var book2 = new Book("Java", "Fabricio", "655888");

        System.out.println(book);
        System.out.println(book.equals(book2));
    }
}

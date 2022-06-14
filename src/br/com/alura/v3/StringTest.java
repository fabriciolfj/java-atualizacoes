package br.com.alura.v3;

public class StringTest {

    public static void main(String[] args) {
        var value1 = "teste";
        var value2 = new String("teste");

        System.out.println(value2.intern());

        System.out.println(value1 == value2.intern());
        System.out.println(value1.intern() == value2);
        System.out.println(value1.equals(value2));
    }
}

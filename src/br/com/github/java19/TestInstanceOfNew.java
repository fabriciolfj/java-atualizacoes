package br.com.github.java19;

public class TestInstanceOfNew {

    public static void main(String[] args) {
        printSum(new Point( 3, 4));
    }

    private static void printSum(Object p) {
        if (p instanceof Point o) {
            System.out.println(o.x() + o.y());
        }
    }
}

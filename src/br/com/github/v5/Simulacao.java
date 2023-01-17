package br.com.github.v5;

public class Simulacao {

    public static void main(String[] args) {
        //var fxOrder = new FXOrder(-1, 1, 1, 1.0, LocalDateTime.now(), 0);
        var fxOrder = FXOrder.of(1, 2, 20.00);
        System.out.println(fxOrder);
    }
}

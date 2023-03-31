package br.com.github;

import java.time.LocalDateTime;

public class ArrayExample {

    public static void main(String[] args) {
        var a = new int[10];
        a[0] = 1;

        System.out.println(a[0]);

        var date = LocalDateTime.of(2020, 1, 1, 20, 0, 0, 0);
        System.out.println(date.toString());
    }
}

package br.com.github.colecoes;

import java.util.Arrays;
import java.util.Comparator;

public class ArraySimulacao {

    public static void main(String[] args) {
        Integer[] values = {4, 9, 7, 3, 10, 5};

        Arrays.sort(values, Comparator.reverseOrder());

        System.out.println(Arrays.toString(values));
    }
}

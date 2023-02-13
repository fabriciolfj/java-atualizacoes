package br.com.github;

import java.util.Arrays;

public class ExcluindoArray {

    public static void main(String[] args) {
        int[] source = {25, 11, 8, 46, 37, 14, 55};
        int[] dest = new int[source.length -1];

        int indexExclusao = 2;

        System.arraycopy(source, 0, dest, 0, indexExclusao);
        System.arraycopy(source, ++indexExclusao, dest, --indexExclusao, dest.length - indexExclusao);

        System.out.println(Arrays.toString(source));
        System.out.println(Arrays.toString(dest));
    }
}

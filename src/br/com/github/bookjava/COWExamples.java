package br.com.github.bookjava;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class COWExamples {

    public static void main(String[] args) {
        var ls = new CopyOnWriteArrayList(List.of(1, 2, 3));
        var it = ls.iterator();
        ls.add(4);
        var modifiedIt = ls.iterator();
        while (it.hasNext()) {
            System.out.println("Original: "+ it.next());
        }
        while (modifiedIt.hasNext()) {
            System.out.println("Modified: "+ modifiedIt.next());
        }
    }
}

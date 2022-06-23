package br.com.github.v3.concurrenthashmap;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Arrays.asList;

public class Simulacao {

    //thread safe map
    public static void main(String[] args) {
        Set<Integer> threadSafeUniqueNumbers = ConcurrentHashMap.newKeySet();
        threadSafeUniqueNumbers.add(20);
        threadSafeUniqueNumbers.add(45);

        System.out.println(threadSafeUniqueNumbers);

        ConcurrentHashMap<Integer,String> numbersMap = new ConcurrentHashMap<>();
        Set<Integer> numbersSet = numbersMap.keySet("SET-ENTRY");

        numbersMap.put(1, "One");
        numbersMap.put(2, "Two");
        numbersMap.put(3, "Three");

        System.out.println("Map before add: "+ numbersMap);
        System.out.println("Set before add: "+ numbersSet);

        numbersSet.addAll(asList(4,5));

        System.out.println("Map after add: "+ numbersMap);
        System.out.println("Set after add: "+ numbersSet);
    }
}

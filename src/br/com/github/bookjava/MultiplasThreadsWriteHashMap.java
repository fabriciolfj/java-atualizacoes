package br.com.github.bookjava;

import java.util.concurrent.ConcurrentHashMap;

public class MultiplasThreadsWriteHashMap {

    public static void main(String[] args) throws InterruptedException {
        var map = new ConcurrentHashMap<String, String>();
        var SIZE = 10_000;

        Runnable r1 = () -> {
            for (int i = 0; i < SIZE; i = i + 1) {
                map.put("t1" + i, "0");
            }
            System.out.println("Thread 1 done");
        };
        Runnable r2 = () -> {
            for (int i = 0; i < SIZE; i = i + 1) {
                map.put("t2" + i, "0");
            }
            System.out.println("Thread 2 done");
        };
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("Count: "+ map.size());
    }
}

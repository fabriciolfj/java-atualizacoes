package br.com.alura.v3.queue_dequeue;

import java.util.Deque;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Stack {

    /*
    * queue -> posso colocar e ouvir do outro lado
    * dequeue -> fila de duas pontas, onde posso colocar dados nas duas extremidades
    * */
    public static void main(String[] args) throws InterruptedException {
        Deque<Integer> stack = new ConcurrentLinkedDeque<>();
        stack.push(1);
        stack.push(2);

        CompletableFuture.runAsync(() -> {
            while(true) {
                System.out.println(stack.pop());
            }
        });

        Thread.sleep(21000);
    }
}

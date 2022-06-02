package br.com.alura.v3.bfs;

import java.nio.file.AccessDeniedException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Graph {

    private final int v;
    private final LinkedList<Integer>[] adjacents;

    public static void main(String[] args) {
        var graph = new Graph(4);
        graph.addEdge(0, 3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        graph.addEdge(3, 2);
        graph.addEdge(3, 3);

        var result = graph.visitor(2);

        System.out.println(result);
    }

    public Graph(int v) {
        this.v = v;
        this.adjacents = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            this.adjacents[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int e) {
        adjacents[v].add(e);
    }

    public List<Integer> visitor(int start) {
        var list = new LinkedList<Integer>();
        var visited = new boolean[v];

        while(adjacents.length > start) {
            Iterator<Integer> queue = adjacents[start].iterator();

            while (queue.hasNext()) {
                int i = queue.next();

                if (!visited[i]) {
                    list.add(i);
                    visited[i] = true;
                }
            }

            start++;
        }


        return list.stream().sorted().collect(Collectors.toList());
    }
}

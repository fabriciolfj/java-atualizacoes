package br.com.github.tree;

public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}

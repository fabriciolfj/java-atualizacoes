package br.com.github.tree;

public class Simulacao {

    public static void main(String[] args) {
        var tree = BinaryTreeFactory.get();

        System.out.println(tree.containsNode(6));

        tree.delete(8);
    }
}

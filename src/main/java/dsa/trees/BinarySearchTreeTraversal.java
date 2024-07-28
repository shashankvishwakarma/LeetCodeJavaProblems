package dsa.trees;

import java.util.Scanner;

public class BinarySearchTreeTraversal extends BinaryTree {

    public void preOrder() {
        preOrder(getRoot());
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getValue() + " ");
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    public void inOrder() {
        preOrder(getRoot());
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        preOrder(node.getLeft());
        System.out.print(node.getValue() + " ");
        preOrder(node.getRight());
    }

    public void postOrder() {
        preOrder(getRoot());
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        preOrder(node.getLeft());
        preOrder(node.getRight());
        System.out.print(node.getRight() + " ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTreeTraversal binarySearchTreeTraversal = new BinarySearchTreeTraversal();
        binarySearchTreeTraversal.populate(scanner);
        System.out.println("Tree values in structured format:");
        binarySearchTreeTraversal.display();
        binarySearchTreeTraversal.preOrder();
        binarySearchTreeTraversal.inOrder();
        binarySearchTreeTraversal.postOrder();
    }
}

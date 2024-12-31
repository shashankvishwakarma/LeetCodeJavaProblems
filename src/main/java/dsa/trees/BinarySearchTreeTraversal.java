package dsa.trees;

import java.util.LinkedList;
import java.util.Queue;
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
        inOrder(getRoot());
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
        postOrder(getRoot());
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        preOrder(node.getLeft());
        preOrder(node.getRight());
        System.out.print(node.getRight() + " ");
    }

    public static void levelOrder(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        q.add(null);
        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr == null) {
                System.out.println();
                //queue empty
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(curr.getValue() + " ");
                if (curr.getLeft() != null) {
                    q.add(curr.getLeft());
                }
                if (curr.getRight() != null) {
                    q.add(curr.getRight());
                }
            }
        }
    }


    public static void main(String[] args) {
        BinarySearchTreeTraversal binarySearchTreeTraversal = new BinarySearchTreeTraversal();

        //buildTreeAndTraversalApproach1(binarySearchTreeTraversal);

        buildTreeAndTraversalApproach2(binarySearchTreeTraversal);

    }

    private static void buildTreeAndTraversalApproach2(BinarySearchTreeTraversal binarySearchTreeTraversal) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        Node root = binarySearchTreeTraversal.buildPreOrderTree(nodes);
        System.out.println(root.getValue());
        binarySearchTreeTraversal.display(root);
        levelOrder(root);
    }

    private static void buildTreeAndTraversalApproach1(BinarySearchTreeTraversal binarySearchTreeTraversal) {
        Scanner scanner = new Scanner(System.in);

        binarySearchTreeTraversal.populate(scanner);
        System.out.println("Tree values in structured format:");
        binarySearchTreeTraversal.display();
        binarySearchTreeTraversal.preOrder();
        binarySearchTreeTraversal.inOrder();
        binarySearchTreeTraversal.postOrder();
    }
}

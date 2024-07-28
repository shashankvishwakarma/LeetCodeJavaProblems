package dsa;

import java.util.Objects;

public class CircularLinkedList {

    private Node head;
    private Node tail;

    public CircularLinkedList() {
        this.tail = null;
        this.head = null;
    }

    public void insert(String value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void display() {
        Node node = head;
        if (head != null) {
            do {
                System.out.print(node.value + " -> ");
                if (node.next != null) {
                    node = node.next;
                }
            } while (node != head);
        }
        System.out.println("HEAD");
    }

    public void delete(String value) {
        Node node = head;
        if (node == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        if (Objects.equals(node.value, value)) {
            head = head.next;
            tail.next = head;
            return;
        }

        do {
            Node n = node.next;
            if (Objects.equals(n.value, value)) {
                node.next = n.next;
                break;
            }
            node = node.next;
        } while (node != head);

    }

    private class Node {
        String value;
        Node next;

        public Node(String value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.insert("1");
        circularLinkedList.insert("2");
        circularLinkedList.insert("3");
        circularLinkedList.insert("4");
        circularLinkedList.insert("5");
        circularLinkedList.delete("4");
        circularLinkedList.insert("4");

        circularLinkedList.display();
    }
}

package dsa;

import java.util.Objects;

public class DoublyLinkedList {

    private Node head;

    public void insertFirst(String val) {
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
    }

    public void insertLast(String val) {
        Node node = new Node(val);
        node.next = null;
        Node last = head;

        if (head == null) {
            node.prev = null;
            head = node;
            return;
        }

        while (last.next != null) {
            last = last.next;
        }

        last.next = node;
        node.prev = last;
    }

    public void insert(String after, String value) {

        Node p = find(after);
        if (p == null) {
            System.out.println("does not exist");
            return;
        }

        Node node = new Node(value);
        node.next = p.next;
        node.prev = p;
        p.next = node;

        if (node.next != null) {
            node.next.prev = node;
        }

    }

    public Node find(String value) {
        Node node = head;
        if (head == null) {
            return null;
        }

        while (node != null) {
            if (Objects.equals(value, node.value)) {
                return node;
            }
            node = node.next;
        }

        return node;
    }

    public void display() {
        Node temp = head;

        do {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        while (temp != null);
        System.out.println("END");
    }

    private class Node {
        private String value;
        private Node next;
        private Node prev;

        public Node(String value) {
            this.value = value;
        }

        public Node(String value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertFirst("1");
        doublyLinkedList.insertFirst("2");
        doublyLinkedList.insertFirst("3");
        doublyLinkedList.insertLast("5");
        doublyLinkedList.insertLast("6");

        System.out.println(doublyLinkedList.find("3"));
        doublyLinkedList.insert("3", "4");
        doublyLinkedList.display();
    }
}


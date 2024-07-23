package dsa;

public class SinglyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList() {
        this.size = 0;
    }

    private class Node {
        private String value;
        private Node next;

        public Node(String value) {
            this.value = value;
        }

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void addFirst(String value) {
        Node node = new Node(value);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void addLast(String value) {
        Node node = new Node(value);
        if (head == null) {
            addFirst(value);
            return;
        }
        tail.next = node;
        tail = node;
        size++;
    }

    public void insertAt(String value, int index) {
        if (index == 0) {
            addFirst(value);
            return;
        }

        if (index == size) {
            addLast(value);
            return;
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        Node node = new Node(value);
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    public String deleteFirst() {
        String value = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }

    public String deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }
        String value = tail.value;
        Node temp = head;
        for (int i = 0; i < size - 2; i++) {
            temp = temp.next;
        }
        tail = temp;
        temp.next = null;
        size--;
        return value;
    }

    public void display() {
        Node node = head;
        do {
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        while (node != null);
        System.out.println("END");
    }
}

class SinglyLinkedListClient {
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addFirst("1");
        singlyLinkedList.addFirst("2");
        singlyLinkedList.addFirst("3");
        singlyLinkedList.addFirst("4");
        singlyLinkedList.addLast("7");
        singlyLinkedList.addLast("8");
        singlyLinkedList.insertAt("6", 3);
        System.out.println(singlyLinkedList.deleteFirst());
        System.out.println(singlyLinkedList.deleteLast());

        singlyLinkedList.display();
    }
}

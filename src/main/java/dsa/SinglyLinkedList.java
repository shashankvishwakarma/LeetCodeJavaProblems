package dsa;

public class SinglyLinkedList {

    public Node head;
    public Node tail;
    public static int size = 0;

    public class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void insertLast(int value) {
        Node node = new Node(value);
        if (head == null) {
            insertFirst(value);
            return;
        }
        tail.next = node;
        tail = node;
        size++;
    }

    public void insertAt(int value, int index) {
        if (index == 0) {
            insertFirst(value);
            return;
        }

        if (index == size) {
            insertLast(value);
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

    public int deleteFirst() {
        int value = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }

    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }
        int value = tail.value;
        Node temp = head;
        for (int i = 0; i < size - 2; i++) {
            temp = temp.next;
        }
        tail = temp;
        temp.next = null;
        size--;
        return value;
    }

    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
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
        singlyLinkedList.insertFirst(1);
        singlyLinkedList.insertFirst(2);
        singlyLinkedList.insertFirst(3);
        singlyLinkedList.insertFirst(4);
        singlyLinkedList.insertLast(7);
        singlyLinkedList.insertLast(8);
        singlyLinkedList.insertAt(6, 3);
        System.out.println(singlyLinkedList.deleteFirst());
        System.out.println(singlyLinkedList.deleteLast());
        System.out.println(singlyLinkedList.find(3));
        System.out.println(singlyLinkedList.get(3));
        singlyLinkedList.display();
    }
}

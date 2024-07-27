package leetcode;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // Method to insert at the beginning of the list
    public ListNode insertAtBeginning(int val) {
        ListNode newNode = new ListNode(val);
        ListNode current = this;

        if (current.next != null) {
            newNode.next = current;
        }
        return newNode;
    }

    // Method to insert at the end of the list
    public void insertAtEnd(int val) {
        ListNode newNode = new ListNode(val);
        ListNode current = this;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Method to insert at a specific position
    public ListNode insertAtPosition(int val, int position) {
        if (position == 0) {
            return insertAtBeginning(val);
        }
        ListNode newNode = new ListNode(val);
        ListNode current = this;
        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current != null) {
            newNode.next = current.next;
            current.next = newNode;
        }
        return this;
    }

    // Method to find the first node with a specified value
    public ListNode findElement(int val) {
        ListNode current = this;
        while (current != null) {
            if (current.val == val) {
                return current;
            }
            current = current.next;
        }
        return null; // Element not found
    }

    // Method to delete the first node with a specified value
    public ListNode deleteElement(int val) {
        if (this.val == val) {
            return this.next; // If the head is the element to delete, return the next node as the new head
        }

        ListNode current = this;
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
                return this; // Return the head of the list
            }
            current = current.next;
        }
        return this; // Element not found, return the head
    }

    // Method to print the list
    public void printList() {
        ListNode current = this;
        while (current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }
        System.out.println("END");

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.insertAtEnd(2);
        head.insertAtEnd(3);
        head.insertAtEnd(4);
        head.printList(); // Output: 1 2 3 4

        head = head.insertAtBeginning(0);
        head.printList(); // Output: 0 1 2 3 4

        head.insertAtEnd(5);
        head.printList(); // Output: 0 1 2 3 4 5

        head = head.insertAtPosition(9, 3);
        head.printList(); // Output: 0 1 2 9 3 4 5

        ListNode found = head.findElement(3);
        System.out.println(found != null ? found.val : "Element not found"); // Output: 3

        head = head.deleteElement(9);
        head.printList(); // Output: 0 1 2 3 4 5

        head = head.deleteElement(0);
        head.printList(); // Output: 1 2 3 4 5
    }
}
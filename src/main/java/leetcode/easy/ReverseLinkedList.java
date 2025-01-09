package leetcode.easy;

import dsa.linkedlist.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 * <p>
 * Example 1: Input: head = [1,2,3,4,5] Output: [5,4,3,2,1]
 * <p>
 * Example 2: Input: head = [1,2] Output: [2,1]
 * <p>
 * Example 3: Input: head = [] Output: []
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.insertAtEnd(2);
        head.insertAtEnd(3);
        head.insertAtEnd(4);
        head.insertAtEnd(5);
        System.out.print("Original List : ");
        head.printList();
        ListNode reversedHead = reverseList(head);
        System.out.print("Reversed List : ");
        reversedHead.printList(); //Output: [5,4,3,2,1]

        /*head = new ListNode(1);
        head.insertAtEnd(2);
        head.insertAtEnd(3);
        System.out.print("Original List : ");
        head.printList();
        reversedHead = reverseList(head);
        System.out.print("Reversed List : ");
        reversedHead.printList();//Output: [2,1]*/
    }

    public static ListNode reverseList(ListNode head) {

        if (head == null) {
            return head;
        }
        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }

    public static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prevNode = head;
        ListNode currNode = head.next;

        while (currNode != null) {
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;

            //update
            prevNode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = prevNode;
        return head;
    }
}

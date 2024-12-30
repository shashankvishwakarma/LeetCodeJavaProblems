package leetcode.medium;

import dsa.linkedlist.ListNode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 *
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 *
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
 */
public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.insertAtEnd(2);
        head.insertAtEnd(3);
        head.insertAtEnd(4);
        head.insertAtEnd(5);

        head.printList();
        ListNode listNode = removeNthFromEnd(head, 2);
        listNode.printList();
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }

        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        // removing SIZEth node from last i.e. head
        if (n == size) {
            return head.next;
        }

        // find previous node
        int ptf = size - n; // position to find
        ListNode prev = head; // previous node
        int cp = 1; // current position

        while (cp != ptf) {
            prev = prev.next;
            cp++;
        }

        prev.next = prev.next.next;
        return head;

    }
}

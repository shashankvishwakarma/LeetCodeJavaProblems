package leetcode.easy;

import dsa.linkedlist.ListNode;

/**
 * https://leetcode.com/problems/remove-linked-list-elements/
 * <p>
 * Example 1: Input: head = [1,2,6,3,4,5,6], val = 6 Output: [1,2,3,4,5]
 * <p>
 * Example 2: Input: head = [], val = 1 Output: []
 * <p>
 * Example 3: Input: head = [7,7,7,7], val = 7 Output: []
 */
public class RemoveLinkedListElements {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.insertAtEnd(2);
        head.insertAtEnd(6);
        head.insertAtEnd(3);
        head.insertAtEnd(4);
        head.insertAtEnd(5);
        head.insertAtEnd(6);

        head.printList();
        ListNode listNode = removeElements(head, 6);
        listNode.printList();
    }

    public static ListNode removeElements(ListNode head, int val) {
        // Handle the case where the head node(s) need to be removed
        while (head != null && head.val == val) {
            head = head.next; // Move the head pointer to the next node
        }

        // If the list is empty after removing the head nodes
        if (head == null) {
            return null;
        }

        // Start from the current head
        ListNode currNode = head;

        // Traverse the list
        while (currNode.next != null) {
            if (currNode.next.val == val) {
                // Skip the node with the value to be removed
                currNode.next = currNode.next.next;
            } else {
                // Move to the next node
                currNode = currNode.next;
            }
        }

        return head; // Return the updated head
    }
}

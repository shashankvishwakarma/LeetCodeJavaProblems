package leetcode.easy;

import dsa.linkedlist.ListNode;

/**
 * https://leetcode.com/problems/remove-linked-list-elements/
 * <p>
 * Example 1:
 * Input: head = [1,2,6,3,4,5,6], val = 6
 * Output: [1,2,3,4,5]
 * <p>
 * Example 2:
 * Input: head = [], val = 1
 * Output: []
 * <p>
 * Example 3:
 * Input: head = [7,7,7,7], val = 7
 * Output: []
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
        // Create a dummy node that helps simplify the removal of the head node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode currNode = dummy; // Start from the dummy node

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

        return dummy.next; // Return the next of dummy, which is the new head of the list
    }
}

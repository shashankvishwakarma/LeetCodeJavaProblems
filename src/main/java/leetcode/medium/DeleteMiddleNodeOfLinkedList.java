package leetcode.medium;

import dsa.linkedlist.ListNode;

/**
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
 * <p>
 * Example 1:
 * Input: head = [1,3,4,7,1,2,6]
 * Output: [1,3,4,1,2,6]
 * Explanation:
 * The above figure represents the given linked list. The indices of the nodes are written below.
 * Since n = 7, node 3 with value 7 is the middle node, which is marked in red.
 * We return the new list after removing this node.
 * <p>
 * Example 2:
 * Input: head = [1,2,3,4]
 * Output: [1,2,4]
 * Explanation:
 * The above figure represents the given linked list.
 * For n = 4, node 2 with value 3 is the middle node, which is marked in red.
 * <p>
 * Example 3:
 * Input: head = [2,1]
 * Output: [2]
 * Explanation:
 * The above figure represents the given linked list.
 * For n = 2, node 1 with value 1 is the middle node, which is marked in red.
 * Node 0 with value 2 is the only node remaining after removing node 1.
 */
class DeleteMiddleNodeOfLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.insertAtEnd(3);
        head.insertAtEnd(4);
        head.insertAtEnd(7);
        head.insertAtEnd(1);
        head.insertAtEnd(2);
        head.insertAtEnd(6);

        head.printList();
        ListNode listNode = deleteMiddle(head);
        listNode.printList(); // Output: [1,3,4,1,2,6]
    }

    public static ListNode deleteMiddle(ListNode head) {
        // If the list has only one node, return null
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // Move fast pointer two steps and slow pointer one step
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        // Now 'slow' is pointing to the middle node
        // 'prev' is pointing to the node before the middle node
        // Remove the middle node by adjusting the 'next' pointer of the previous node
        prev.next = slow.next;

        return head;
    }
}
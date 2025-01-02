package leetcode.medium;

import dsa.linkedlist.ListNode;
import leetcode.easy.ReverseLinkedList;

/**
 * https://leetcode.com/problems/remove-nodes-from-linked-list/description/
 * <p>
 * Example 1:
 * Input: head = [5,2,13,3,8]
 * Output: [13,8]
 * Explanation: The nodes that should be removed are 5, 2 and 3.
 * - Node 13 is to the right of node 5.
 * - Node 13 is to the right of node 2.
 * - Node 8 is to the right of node 3.
 * <p>
 * Example 2:
 * Input: head = [1,1,1,1]
 * Output: [1,1,1,1]
 * Explanation: Every node has value 1, so no nodes are removed.
 */
class RemoveNodesFromLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.insertAtEnd(2);
        head.insertAtEnd(13);
        head.insertAtEnd(3);
        head.insertAtEnd(8);

        head.printList();
        ListNode listNode = removeNodes(head);
        listNode.printList();
    }

    public static ListNode removeNodes(ListNode head) {
        // Step 1: Reverse the list
        head = ReverseLinkedList.reverseList(head);

        // Step 2: Traverse the reversed list and remove nodes
        ListNode newHead = null;
        int maxVal = Integer.MIN_VALUE;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val >= maxVal) {
                // Add this node to the new list
                ListNode newNode = new ListNode(curr.val);
                newNode.next = newHead;
                newHead = newNode;
                maxVal = curr.val; // Update the maximum value
            }
            curr = curr.next;
        }

        // Step 3: Return the head of the result list
        return newHead;
    }
}
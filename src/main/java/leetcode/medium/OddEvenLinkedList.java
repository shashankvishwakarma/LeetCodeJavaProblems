package leetcode.medium;

import dsa.linkedlist.ListNode;

/**
 * https://leetcode.com/problems/odd-even-linked-list/
 * <p>
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [1,3,5,2,4]
 * <p>
 * Example 2:
 * Input: head = [2,1,3,5,6,4,7]
 * Output: [2,3,6,7,1,5,4]
 */
class OddEvenLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.insertAtEnd(2);
        head.insertAtEnd(3);
        head.insertAtEnd(4);
        head.insertAtEnd(5);

        head.printList();
        ListNode listNode = oddEvenList(head);
        listNode.printList();
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize odd and even pointers
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        // Traverse the list and rearrange nodes
        while (even != null && even.next != null) {
            odd.next = even.next;  // Link odd node to the next odd node
            odd = odd.next;        // Move odd pointer to the next odd node

            even.next = odd.next;  // Link even node to the next even node
            even = even.next;      // Move even pointer to the next even node
        }

        // Link the last odd node to the head of the even list
        odd.next = evenHead;

        return head;
    }
}
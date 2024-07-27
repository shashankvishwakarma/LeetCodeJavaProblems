package leetcode.medium;

import dsa.ListNode;

import static leetcode.easy.MiddleOfTheLinkedList.middleNode;
import static leetcode.easy.ReverseLinkedList.reverseList;

/**
 * https://leetcode.com/problems/reorder-list/description/
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode mid = middleNode(head);

        ListNode hs = reverseList(mid);
        ListNode hf = head;

        // rearrange
        while (hf != null && hs != null) {
            ListNode temp = hf.next;
            hf.next = hs;
            hf = temp;

            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }

        // next of tail to null
        if (hf != null) {
            hf.next = null;
        }
    }
}

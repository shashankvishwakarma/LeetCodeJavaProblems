package leetcode.medium;

import dsa.linkedlist.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */
public class ReverseLinkedListSegment {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        // skip the first left-1 nodes
        ListNode current = head;
        ListNode prev = null;
        for (int i = 0; current != null && i < left - 1; i++) {
            prev = current;
            current = current.next;
        }

        ListNode last = prev;
        ListNode newEnd = current;

        // reverse between left and right
        ListNode next = current.next;
        for (int i = 0; current != null && i < right - left + 1; i++) {
            current.next = prev;
            prev = current;
            current = next;
            if (next != null) {
                next = next.next;
            }
        }

        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }

        newEnd.next = current;
        return head;
    }

}

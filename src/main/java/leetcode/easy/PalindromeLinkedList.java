package leetcode.easy;

import dsa.linkedlist.ListNode;

import static leetcode.easy.MiddleOfTheLinkedList.middleNode;
import static leetcode.easy.ReverseLinkedList.reverseList;

/**
 * https://leetcode.com/problems/palindrome-linked-list/description/
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode headSecond = reverseList(mid);
        ListNode rereverseHead = headSecond;

        // compare both the halves
        while (head != null && headSecond != null) {
            if (head.val != headSecond.val) {
                break;
            }
            head = head.next;
            headSecond = headSecond.next;
        }
        reverseList(rereverseHead);

        return head == null || headSecond == null;
    }
}

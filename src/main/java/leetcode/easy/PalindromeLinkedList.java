package leetcode.easy;

import static leetcode.easy.MiddleOfTheLinkedList.middleNode;
import static leetcode.easy.ReverseLinkedList.reverseList;

import dsa.linkedlist.ListNode;

/**
 * https://leetcode.com/problems/palindrome-linked-list/description/
 *
 * Example 1:
 * Input: head = [1,2,2,1]
 * Output: true
 *
 * Example 2:
 * Input: head = [1,2]
 * Output: false
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.insertAtEnd(2);
        head.insertAtEnd(6);
        head.insertAtEnd(3);
        head.insertAtEnd(4);
        head.insertAtEnd(5);
        head.insertAtEnd(6);

        head.printList();
        System.out.println("Linked list is palindrome " + isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode headSecond = reverseList(mid);
        ListNode reverseHead = headSecond;

        // compare both the halves
        while (head != null && headSecond != null) {
            if (head.val != headSecond.val) {
                break;
            }
            head = head.next;
            headSecond = headSecond.next;
        }
        reverseList(reverseHead);

        return head == null || headSecond == null;
    }
}

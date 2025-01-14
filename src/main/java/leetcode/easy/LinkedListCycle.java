package leetcode.easy;

import dsa.linkedlist.ListNode;

/**
 * https://leetcode.com/problems/linked-list-cycle
 */
public class LinkedListCycle {

  public static void main(String[] args) {
    ListNode head = new ListNode(3);
    head.insertAtEnd(2);
    head.insertAtEnd(0);
    head.insertAtEnd(4);
    System.out.print("Original List : ");
    head.printList();
    System.out.print("List has cycle : " + hasCycle(head));
  }

  public static boolean hasCycle(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;

      if (fast == slow) {
        return true;
      }
    }
    return false;
  }
}

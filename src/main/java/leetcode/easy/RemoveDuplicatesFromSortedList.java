package leetcode.easy;

import dsa.SinglyLinkedList;
import leetcode.ListNode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.insertLast(1);
        singlyLinkedList.insertLast(1);
        singlyLinkedList.insertLast(2);
        singlyLinkedList.insertLast(3);
        singlyLinkedList.insertLast(3);
        singlyLinkedList.insertLast(4);

        singlyLinkedList.display();
        deleteDuplicates(singlyLinkedList.head);
        singlyLinkedList.display();
    }

    public ListNode deleteDuplicates(ListNode node) {
        if(node == null) {
            return node;
        }

        ListNode head = node;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }


    public static SinglyLinkedList.Node deleteDuplicates(SinglyLinkedList.Node node) {
        if (node == null) {
            return node;
        }

        SinglyLinkedList.Node head = node;
        while (node.next != null) {
            if (node.value == node.next.value) {
                node.next = node.next.next;
                SinglyLinkedList.size--;
            } else {
                node = node.next;
            }
        }
        return head;
    }
}

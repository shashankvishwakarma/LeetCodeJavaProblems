package leetcode.easy;

import dsa.linkedlist.ListNode;
import dsa.linkedlist.SinglyLinkedList;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        SinglyLinkedList list1 = new SinglyLinkedList();
        list1.insertLast(1);
        list1.insertLast(2);
        list1.insertLast(4);

        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.insertLast(1);
        list2.insertLast(3);
        list2.insertLast(4);

        SinglyLinkedList list3 = mergeTwoLists(list1, list2);
        list3.display();
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;

        while (list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;

        return dummyHead.next;
    }

    public static SinglyLinkedList mergeTwoLists(SinglyLinkedList first, SinglyLinkedList second) {
        SinglyLinkedList.Node f = first.head;
        SinglyLinkedList.Node s = second.head;
        SinglyLinkedList ans = new SinglyLinkedList();

        while (f != null && s != null) {
            if (f.value < s.value) {
                ans.insertLast(f.value);
                f = f.next;
            } else {
                ans.insertLast(s.value);
                s = s.next;
            }
        }

        while (f != null) {
            ans.insertLast(f.value);
            f = f.next;
        }

        while (s != null) {
            ans.insertLast(s.value);
            s = s.next;
        }

        return ans;
    }
}

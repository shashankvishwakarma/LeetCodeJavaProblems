package leetcode.medium;

import dsa.linkedlist.ListNode;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/description/
 * <p>
 * Example 1:
 * Input: nums = [1,2,3], head = [1,2,3,4,5]
 * Output: [4,5]
 * Explanation:
 * Remove the nodes with values 1, 2, and 3.
 * <p>
 * Example 2:
 * Input: nums = [1], head = [1,2,1,2,1,2]
 * Output: [2,2,2]
 * Explanation:
 * Remove the nodes with value 1.
 * <p>
 * Example 3:
 * Input: nums = [5], head = [1,2,3,4]
 * Output: [1,2,3,4]
 * Explanation:
 * No node has value 5.
 */
class DeleteNodesFromLinkedListPresentInArray {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.insertAtEnd(2);
        head.insertAtEnd(3);
        head.insertAtEnd(4);
        head.insertAtEnd(5);

        int[] nums = new int[]{1, 2, 3};

        head.printList();
        ListNode listNode = modifiedList(nums, head);
        listNode.printList(); // Output: [4,5]
    }

    public static ListNode modifiedList(int[] nums, ListNode head) {
        // Convert nums array into a HashSet for O(1) lookups
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Handle the case where the head itself needs to be removed
        while (head != null && set.contains(head.val)) {
            head = head.next; // Skip the node to be removed
        }

        // Now head points to the first node that is not in the set (or null)
        ListNode current = head;

        // Iterate through the list and remove nodes whose value is in the set
        while (current != null && current.next != null) {
            if (set.contains(current.next.val)) {
                // Skip the next node
                current.next = current.next.next;
            } else {
                // Otherwise, move to the next node
                current = current.next;
            }
        }

        return head;
    }
}
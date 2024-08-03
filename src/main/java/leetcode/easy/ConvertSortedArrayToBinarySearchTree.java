package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 */
public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = sortedArrayToBST(nums);
        printLevelOrder(root); // Output should match the expected tree structure
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return convertToBST(nums, 0, nums.length - 1);
    }

    private static TreeNode convertToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = convertToBST(nums, left, mid - 1);
        node.right = convertToBST(nums, mid + 1, right);

        return node;
    }

    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) {
                System.out.print("null ");
            } else {
                System.out.print(current.val + " ");
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

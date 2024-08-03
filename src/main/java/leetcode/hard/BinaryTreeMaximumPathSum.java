package leetcode.hard;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 */
public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maxPathSum(root)); // expected output 42
    }

    public static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    static int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = helper(node.left);
        int right = helper(node.right);

        left = Math.max(0, left);
        right = Math.max(0, right);

        int pathSum = left + right + node.val;

        maxSum = Math.max(maxSum, pathSum);

        return Math.max(left, right) + node.val;
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

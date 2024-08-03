package leetcode.medium;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 */
public class KthSmallestElementInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        System.out.println(kthSmallest(root, 1)); //expected 1
    }

    static int count = 0;

    public static int kthSmallest(TreeNode root, int k) {
        return inOrderTraversal(root, k).val;
    }

    public static TreeNode inOrderTraversal(TreeNode root, int k) {
        if (root == null) {
            return null;
        }

        TreeNode left = inOrderTraversal(root.left, k);

        if (left != null) {
            return left;
        }

        count++;

        if (count == k) {
            return root;
        }

        return inOrderTraversal(root.right, k);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}




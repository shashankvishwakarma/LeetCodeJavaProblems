package leetcode.easy;

/**
 * https://leetcode.com/problems/invert-binary-tree/description/
 */
public class InvertBinaryTree {

    static int diameter = 0;

    public static void main(String[] args) {
        // Example input: root = [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(11);
        root.left.right = new TreeNode(13);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Printing the result
        System.out.println(invertTree(root)); //output 2
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
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

package leetcode.easy;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/description/
 */
public class DiameterOfBinaryTree {

    static int diameter = 0;

    public static void main(String[] args) {
        // Example input: root = [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        //root.left.left = new TreeNode(11);
        //root.left.right = new TreeNode(13);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Printing the result
        System.out.println(diameterOfBinaryTree(root)); //output 2
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter - 1;
    }

    public static int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        int dia = leftHeight + rightHeight + 1;
        diameter = Math.max(diameter, dia);

        return Math.max(leftHeight, rightHeight) + 1;
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

package misc;

/**
 * Find if path exists in given tree
 */
public class FindIfPathExistsInTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(12);
        root.right.left.left = new TreeNode(16);
        root.right.right.left = new TreeNode(8);

        int[] path = {3, 9, 12, 8};
        System.out.println(findPath(root, path)); // expected output true
    }

    static boolean findPath(TreeNode node, int[] path) {
        if (node == null) {
            return path.length == 0;
        }
        return helper(node, path, 0);
    }

    static boolean helper(TreeNode node, int[] path, int index) {
        if (node == null) {
            return false;
        }
        if (index >= path.length || node.val != path[index]) {
            return false;
        }
        if (node.left == null && node.right == null && index == path.length - 1) {
            return true;
        }
        return helper(node.left, path, index + 1) || helper(node.right, path, index + 1);
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

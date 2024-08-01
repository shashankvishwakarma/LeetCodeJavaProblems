package misc;

import java.util.LinkedList;
import java.util.Queue;


public class LevelOrderSuccessorOfNode {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(12);
        root.left.right = new TreeNode(14);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(11);
        root.left.right.left = new TreeNode(36);
        root.left.right.right = new TreeNode(9);
        root.right.right.left = new TreeNode(2);
        root.right.right.left.right = new TreeNode(44);

        System.out.println(findSuccessor(root, 14).val); // output should be 7
        System.out.println(findSuccessor(root, 11).val); // output should be 36

    }

    public static TreeNode findSuccessor(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode.val == key) {
                break;
            }
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }
        }
        return queue.peek();
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

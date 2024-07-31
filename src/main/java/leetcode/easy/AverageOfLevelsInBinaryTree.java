package leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
 */
public class AverageOfLevelsInBinaryTree {
    public static void main(String[] args) {
        // Example input: root = [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        //root.left.left = new TreeNode(11);
        //root.left.right = new TreeNode(13);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<Double> result = averageOfLevels(root);

        // Printing the result
        System.out.println(result);
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int currentNodeLevelSize = queue.size();
            double averageLevel = 0;

            for (int i = 0; i < currentNodeLevelSize; i++) {
                TreeNode node = queue.poll();
                averageLevel += node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            averageLevel = averageLevel / currentNodeLevelSize;
            result.add(averageLevel);
        }
        return result;
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

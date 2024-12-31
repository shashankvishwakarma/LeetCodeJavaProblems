package leetcode.easy;

import dsa.trees.BinarySearchTreeTraversal;
import dsa.trees.BinaryTree;

/**
 * https://leetcode.com/problems/subtree-of-another-tree/description/
 * <p>
 * Example 1:
 * Input: root = [3,4,5,1,2], subRoot = [4,1,2]
 * Output: true
 * <p>
 * Example 2:
 * Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
 * Output: false
 */
class SubtreeOfAnotherTree {

    public static void main(String[] args) {
        BinarySearchTreeTraversal binarySearchTreeTraversal = new BinarySearchTreeTraversal();

        int[] rootElements = {3, 4, 5, 1, 2};
        int[] subRootElements = {4, 1, 2};

        BinaryTree.Node rootNode = binarySearchTreeTraversal.buildPreOrderTree(rootElements);
        BinaryTree.Node subRootNode = binarySearchTreeTraversal.buildPreOrderTree(subRootElements);

        System.out.println("Is subtree of another tree " + isSubtree(rootNode, subRootNode));//Output: true
    }

    public static boolean isSubtree(BinaryTree.Node root, BinaryTree.Node subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (isIdentical(root, subRoot)) {
            return true;
        }
        return isSubtree(root.getLeft(), subRoot) || isSubtree(root.getRight(), subRoot);
    }

    public static boolean isIdentical(BinaryTree.Node root, BinaryTree.Node subRoot) {
        if (subRoot == null && root == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (root.getValue() == subRoot.getValue()) {
            return isIdentical(root.getLeft(), subRoot.getLeft()) && isIdentical(root.getRight(), subRoot.getRight());
        }
        return false;
    }

}
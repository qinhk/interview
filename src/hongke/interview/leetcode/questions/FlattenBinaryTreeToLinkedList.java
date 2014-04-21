package hongke.interview.leetcode.questions;

import hongke.interview.leetcode.common.TreeNode;

/**
 * Created by hongke on 4/20/14.
 */

/*
           1
         /  \
       2     5
      / \   / \
     3   4 6   7
 */
public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode node = root;
        inOrder(node);
    }

    private void inOrder(TreeNode node) {
        if (node != null) {
            TreeNode right = node.right;
            inOrder(node.left);
            node.right = node.left;
            node.left = null;
            node.right = appendRight(node.right, right);
            inOrder(node.right);
        }
    }

    private TreeNode appendRight(TreeNode newRight, TreeNode oldRight) {
        if (newRight == null) {
            return oldRight;
        }
        TreeNode head = newRight;
        while (newRight.right != null) {
            newRight = newRight.right;
        }
        newRight.right = oldRight;
        return head;
    }







    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList test = new FlattenBinaryTreeToLinkedList();
        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(2);
        t2.right = new TreeNode(9);
        t2.left.left = new TreeNode(3);
        t2.left.right = new TreeNode(6);
        t2.right.left = new TreeNode(10);
        t2.right.right = new TreeNode(13);
        t2.left.left.left = new TreeNode(4);
        t2.left.left.right = new TreeNode(5);
        t2.left.right.left = new TreeNode(7);
        t2.left.right.right = new TreeNode(8);
        t2.right.left.left = new TreeNode(11);
        t2.right.left.right = new TreeNode(12);
        t2.right.right.left = new TreeNode(14);
        t2.right.right.right = new TreeNode(15);

        TreeNode.printPretty(t2);
        test.flatten(t2);
        TreeNode node = t2;
        while (node.right != null && node.left == null ) {
            System.out.print(node.val + " -> ");
            node = node.right;
        }

        System.out.print(node.val + "\n");

    }
}

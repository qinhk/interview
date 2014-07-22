package hongke.interview.leetcode.questions;

import hongke.interview.leetcode.common.TreeNode;

import java.util.Stack;

/**
 * Created by hongke on 7/17/14.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        Stack<TreeNode> left = new Stack<TreeNode>();
        Stack<TreeNode> right = new Stack<TreeNode>();
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;

        while (leftNode != null && rightNode != null) {
            if (leftNode.val != rightNode.val) {
                return false;
            }

            if (leftNode.right != null && rightNode.left != null) {
                left.push(leftNode.right);
                right.push(rightNode.left);
            } else if (leftNode.right == null && rightNode.left == null) {
                // do nothing
            } else {
                return false;
            }

            if (rightNode.right != null && leftNode.left != null) {
                left.push(leftNode.left);
                right.push(rightNode.right);
            } else if (rightNode.right == null && leftNode.left == null) {
                // do nothing
            } else {
                return false;
            }

            if (!right.isEmpty() && !left.isEmpty()) {
                leftNode = left.pop();
                rightNode = right.pop();
            } else {
                leftNode = null;
                rightNode = null;
            }
        }

        if (left.isEmpty() && right.isEmpty()) {
            return true;
        }

        return false;

    }
}

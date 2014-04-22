package hongke.interview.leetcode.questions;

import hongke.interview.leetcode.common.TreeNode;

import java.util.Stack;

/**
 * Created by hongke on 4/3/14.
 */
public class BinaryTreeMaximumPathSum {

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return postOrderTraversal(root);
    }


    private int postOrderTraversal(TreeNode root) {

        // initialization
        int maxSum = Integer.MIN_VALUE;
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode visited = null;
        TreeNode current = root;

        // Post Order Traversal
        while (!s.isEmpty() || current != null) {
            if (current != null) {
                s.push(current);
                current = current.left;
            } else {
                TreeNode top = s.peek();
                if (top.right != null && top.right != visited) {
                    current = top.right;
                } else {
                    s.pop();
                    maxSum = Math.max(maxSum, visit(top));
                    visited = top;
                }
            }
        }
        return maxSum;
    }


    private int visit(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int n1 = 0;
        if (node.left != null) {
            n1 = node.left.val > 0 ? node.left.val : 0;
        }
        int n2 = 0;
        if (node.right != null) {
            n2 = node.right.val > 0 ? node.right.val : 0;
        }

        int sum = n1 + n2 + node.val;
        node.val = Math.max(n1, n2) + node.val;
        return sum;
    }

}

package hongke.interview.leetcode.questions;

/**
 * Created by hongke on 3/2/14.
 */

import hongke.interview.leetcode.common.TreeNode;

import java.util.Stack;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *w
 * Given a binary tree, find its maximum depth.

 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */

public class MaximumDepthOfBinaryTree {

    public int mexDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Initialization
        Stack<TreeNode> trace = new Stack<TreeNode>();
        trace.push(root);
        int maxDepth = trace.size();
        TreeNode current = trace.peek();

        // Binary tree traversal.
        while (!trace.isEmpty()) {
            // First push all left side nodes in to the stack
            while (current.left != null) {
                trace.push(current.left);
                if (trace.size() > maxDepth) {
                    maxDepth = trace.size();
                }
                current = trace.peek();
            }

            // Go right if the left child is empty
            if (current.right != null) {
                trace.push(current.right);
                if (trace.size() > maxDepth) {
                    maxDepth = trace.size();
                }
                current = trace.peek();
                continue;
            }

            // Both children are empty, reached leaf node, trace back.
            while (true) {
                current = trace.pop();
                if (trace.isEmpty()) {
                    break;
                }

                // found first un-visited right child, start to traversal.
                else if (trace.peek().right != null && trace.peek().right != current ) {
                    trace.push(trace.peek().right);
                    current = trace.peek();
                    break;
                }
            }
        }
        return maxDepth;
    }
}

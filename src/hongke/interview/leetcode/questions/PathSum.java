package hongke.interview.leetcode.questions;

import hongke.interview.leetcode.common.TreeNode;

import java.util.Stack;

/**
 * Created by hongke on 8/23/14.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null && sum == 0) {
            return true;
        } else if (root == null) {
            return false;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root, last = null;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode current = stack.peek();
                if (current.right != null && last != current.right) {
                    node = current.right;
                } else {
                    if (stack.peek().left == null && stack.peek().right == null) {
                        int pathSum = 0;
                        for (TreeNode t : stack) {
                            pathSum += t.val;
                        }
                        if (sum == pathSum) {
                            return true;
                        }
                    }

                    last = stack.pop();
                }
            }
        }
        return false;
    }

    public static void main (String[] args) {
        PathSum test = new PathSum();
        TreeNode input;
        input = new TreeNode(3);
        input.left = null;
        input.right = new TreeNode(-1);
        System.out.println(test.hasPathSum(input, 2));
    }
}

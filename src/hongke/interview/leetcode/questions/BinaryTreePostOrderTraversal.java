package hongke.interview.leetcode.questions;

import hongke.interview.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/*
 * Created by hongke on 3/8/14.
 * Given a binary tree, return the post order traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
 *   1
 *  / \
 * #   2
 *    /
 *   3
 * Return [3,2,1].
 */

/*
 * Note I: Post order traversal is also useful in deleting a tree. In order to
 * free up allocated memory of all nodes in a tree, the nodes must be deleted in
 * the order where the current node can only be deleted when both of its left
 * and right subtrees are deleted.
 */
@SuppressWarnings("unused")
public class BinaryTreePostOrderTraversal {

    public ArrayList<Integer> postOrderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }

        ArrayList<Integer> traversal = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        stack.push(root);

        while (!stack.isEmpty()) {
            // keeps going southwest
            while (current.left != null) {
                current = current.left;
                stack.push(current);
            }

            // goes southeast
            if (current.right != null) {
                current = current.right;
                stack.push(current);
            }

            // leaf node, trace back until it can goes southeast again.
            else {
                while (!stack.isEmpty()) {
                    current = stack.pop();
                    traversal.add(current.val);
                    if (!stack.isEmpty() && stack.peek().right != null && stack.peek().right != current) {
                        current = stack.peek().right;
                        stack.push(current);
                        break;
                    }
                }
            }
        }
        return traversal;
    }
}

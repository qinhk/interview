package hongke.interview.leetcode.questions;

import hongke.interview.leetcode.common.TreeNode;

import java.util.Stack;

/**
 * Created by hongke on 4/12/14.
 */
public class ConstructBinaryTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (inorder != null && inorder.length > 0) {
            return inOrder(inorder);
        }

        if (inorder != null && inorder.length > 0) {
            return postOrder(postorder);
        }
        return null;
    }

    private TreeNode inOrder(int[] values) {
        return null;
    }

    private TreeNode postOrder(int[] values) {                int depth = 0;
        int index = values.length;

        // determin maximum depth of the tree.
        while ((index = index / 2) != 0) {
            depth ++;
        }

        TreeNode root = new TreeNode(0);
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = null;

        int count = 0;
        while (count < values.length) {
            if (current == null && stack.size() < depth) {
                current = new TreeNode(0);
                current = current.left;
            } else {
                current = stack.peek();
                current.val = values[count];
                count ++;
                stack.pop();
                if (stack.peek().right == null) {
                    current = stack.peek();
                    current.right = new TreeNode(0);
                    stack.push(current.right);
                    current = current.right;
                }
            }
        }
        return root;
    }
//
//    private TreeNode preOrder(int[] values) {
//        return null;
//    }

}

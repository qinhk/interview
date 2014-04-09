package hongke.interview.leetcode.questions;

import hongke.interview.leetcode.common.TreeNode;

import java.util.Stack;

/**
 * Created by hongke on 4/6/14.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean[] isBalanced = new boolean[]{true};
        postOrderTraversalRec(root, isBalanced);
        return isBalanced[0];
    }

    private int postOrderTraversalRec(TreeNode root, boolean[] isBalanced) {
        int left = 0, right = 0;
        if (root == null || !isBalanced[0]) {
            return 0;
        }

        if (root.left != null) {
            left = postOrderTraversalRec(root.left, isBalanced);
        }

        if (root.right != null) {
            right = postOrderTraversalRec(root.right, isBalanced);
        }

        // terminate the search if not balanced.
        if (!isBalanced[0]) {
            return 0;
        }

        // check if is balanced
        if (Math.abs(left - right) > 1) {
            isBalanced[0] = false;
        } else {
            isBalanced[0] = true;
        }

        System.out.println("left:" + left + ", right:" + right);

        visit(root);
        return Math.max(left, right) + 1;
    }


    private boolean inOrderTravesal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Boolean isBalanced = true;
        TreeNode cur = root;
        while ((!stack.isEmpty() || cur != null) && isBalanced) {

            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                // visit leaf
                cur = stack.pop();
                isBalanced = visit(cur);
                // goes right
                cur = cur.right;
            }
        }
        return isBalanced;
    }

    private boolean preOrderTravesal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Boolean isBalanced = true;
        TreeNode cur = root;
        do {

            if (cur != null) {
                isBalanced = visit(cur);
                stack.push(cur.right);
                stack.push(cur.left);
            }
            cur = stack.pop();

        } while (!stack.isEmpty() && isBalanced);
        return isBalanced;
    }

    private boolean postOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Boolean isBalanced = true;
        TreeNode cur = root;
        TreeNode prev= null;

        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode node = stack.peek();
                if (node.right != null && node.right != prev) {
                    stack.push(node.right);
                } else {
                    prev = stack.pop();
                    isBalanced = visit(prev);
                }
            }
        }
        return isBalanced;
    }

    private boolean visit(TreeNode node) {
        System.out.println(node.val);
        if ((node.left ==null && node.right != null
                && (node.right.left != null || node.right.right != null))
             ||(node.right ==null && node.left != null
                && (node.left.left != null || node.left.right != null)))     {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t1.left.left = new TreeNode(4);
        t1.left.right = new TreeNode(5);
        t1.left.left.right = new TreeNode(6);
        BalancedBinaryTree test = new BalancedBinaryTree();
        System.out.println(test.isBalanced(t1));

        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(2);
        t2.right = new TreeNode(2);
        t2.left.left = new TreeNode(3);
        t2.left.right = new TreeNode(3);
        t2.right.left = new TreeNode(3);
        t2.right.right = new TreeNode(3);

        t2.left.left.left = new TreeNode(4);
        t2.left.left.right = new TreeNode(4);
        t2.left.right.left = new TreeNode(4);
        t2.left.right.right = new TreeNode(4);
        t2.right.left.left = new TreeNode(4);
        t2.right.left.right = new TreeNode(4);
//        t2.right.right.left = new TreeNode(4);
//        t2.right.right.right = new TreeNode(4);
        t2.left.left.left.right = new TreeNode(5);
        t2.left.left.left.left = new TreeNode(5);
        System.out.println(test.isBalanced(t2));
    }
}

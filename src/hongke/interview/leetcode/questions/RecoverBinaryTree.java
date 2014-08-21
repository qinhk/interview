package hongke.interview.leetcode.questions;

import hongke.interview.leetcode.common.TreeNode;

import java.util.*;

/**
 * Created by hongke on 8/17/14.
 */
public class RecoverBinaryTree {

    public void recoverTree(TreeNode root) {

        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<TreeNode> swapped = new ArrayList<TreeNode>();
        TreeNode last = null;
        TreeNode node = root;
        boolean isFinished = false;
        while ((!stack.isEmpty() || node != null) && !isFinished) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                isFinished = checkOrder(last, node, swapped);
                last = node;
                node = node.right;
            }
        }



        int tmp = swapped.get(0).val;
        swapped.get(0).val = swapped.get(1).val;
        swapped.get(1).val = tmp;
    }

    private boolean checkOrder(TreeNode last, TreeNode node, List<TreeNode> swapped) {

        if (last != null && node != null && node.val < last.val) {
            swapped.add(node);
            if (swapped.size() == 1) {
                swapped.add(last);
            } else {
                swapped.remove(0);
                swapped.add(node);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        RecoverBinaryTree test = new RecoverBinaryTree();
        TreeNode input;

        input = new TreeNode(0);
        input.left = new TreeNode(1);
        test.recoverTree(input);
        TreeNode.printPretty(input);

        input = new TreeNode(1);
        input.right = new TreeNode(0);
        test.recoverTree(input);
        TreeNode.printPretty(input);

        input = new TreeNode(2);
        input.left = new TreeNode(3);
        input.right = new TreeNode(1);
        test.recoverTree(input);
        TreeNode.printPretty(input);

        input = new TreeNode(1);
        input.left = new TreeNode(2);
        input.right = new TreeNode(3);
        test.recoverTree(input);
        TreeNode.printPretty(input);

        input = new TreeNode(146);
        input.left = new TreeNode(71);
        input.left.left = new TreeNode(55);
        input.left.left.left = new TreeNode(321);
        input.left.left.left.left = new TreeNode(-33);
        input.right = new TreeNode(-13);
        input.right.left = new TreeNode(231);
        input.right.right = new TreeNode(399);
        test.recoverTree(input);
        TreeNode.printPretty(input);


    }
}

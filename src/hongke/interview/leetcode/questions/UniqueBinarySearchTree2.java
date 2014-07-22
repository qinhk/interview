package hongke.interview.leetcode.questions;

import hongke.interview.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by hongke on 7/15/14.
 */
public class UniqueBinarySearchTree2 {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<TreeNode>();
        }
        List<TreeNode> results = new ArrayList<TreeNode>();
        results.add(new TreeNode(0));
        for (int i = n;  i > 0; i  --) {
            List<TreeNode> nextLevel = new ArrayList<TreeNode>();
            for (TreeNode root : results) {
                nextLevel.addAll(traversalAndGenerateNew(root));
            }
            results = nextLevel;
        }

        return results;
    }

    private List<TreeNode> traversalAndGenerateNew(TreeNode root) {
        List<TreeNode> newTrees = new ArrayList<TreeNode>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        while (current != null) {

            stack.push(current.right);
            stack.push(current.left);

            if (current.left == null) {
                newTrees.add(copyAndAddNew(root, current, Direction.Left));
            }
            if (current.right == null) {
                newTrees.add(copyAndAddNew(root, current, Direction.Right));
            }

            current = stack.pop();
        }

        return newTrees;
    }

    private TreeNode copyAndAddNew(TreeNode root, TreeNode current, Direction direction) {
        if (root == null || current == null) {
            return null;
        }

        TreeNode newRoot = new TreeNode(0);
        newRoot.val = root.val;
        Stack<TreeNode> newNodes = new Stack<TreeNode>();
        Stack<TreeNode> oldNodes = new Stack<TreeNode>();
        TreeNode oldCur = root;
        TreeNode newCur = newRoot;
        while (oldCur != null) {

            if (oldCur.right != null) {
                TreeNode newRight = new TreeNode(0);
                newRight.val = oldCur.right.val;
                newCur.right = newRight;
                newNodes.push(newRight);
                oldNodes.push(oldCur.right);
            }
            if (oldCur.left != null) {
                TreeNode newLeft = new TreeNode(0);
                newLeft.val = oldCur.left.val;
                newCur.left = newLeft;
                newNodes.push(newLeft);
                oldNodes.push(oldCur.left);
            }

            if (current == oldCur && direction == Direction.Left) {
                oldCur.left = new TreeNode(0);
            } else if (current == oldCur && direction == Direction.Right) {
                oldCur.right = new TreeNode(0);
            }

            oldCur = oldNodes.isEmpty() ? null : oldNodes.pop();
            newCur = newNodes.isEmpty() ? null : newNodes.pop();

        }

        return newRoot;
    }

    enum Direction {
        Left, Right;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTree2 test = new UniqueBinarySearchTree2();
        for (TreeNode t : test.generateTrees(3)) {
            TreeNode.printPretty(t);
        }

    }

}

package hongke.interview.leetcode.questions;

import hongke.interview.leetcode.common.TreeNode;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by hongke on 9/21/14.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0
            || postorder.length == 0 || inorder.length != postorder.length) {
            return null;
        }

        return buildNode(inorder, postorder);
    }

    private TreeNode buildNode(int[] inorder, int[] postorder) {
        TreeNode node = new TreeNode(postorder[postorder.length - 1]);
        int index = 0;
        while (index < inorder.length && inorder[index] != node.val) {
            index++;
        }
        if (index > 0) {
            node.left = buildNode(Arrays.copyOfRange(inorder, 0, index), Arrays.copyOfRange(postorder, 0, index));
        }

        if (index < postorder.length - 1) {
            node.right = buildNode(Arrays.copyOfRange(inorder, index + 1, postorder.length), Arrays.copyOfRange(postorder, index, postorder.length - 1));
        }
        return node;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromInorderAndPostorderTraversal test = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
        int[] inorder, postorder;

        inorder = new int[] {2, 3, 1};
        postorder = new int[] {3, 2, 1};
        TreeNode.printPretty(test.buildTree(inorder, postorder));

        inorder = new int[] {4, 2, 1, 5, 6, 3, 7};
        postorder = new int[] {4, 2, 6, 5, 7, 3, 1};
        TreeNode.printPretty(test.buildTree(inorder, postorder));
    }

}

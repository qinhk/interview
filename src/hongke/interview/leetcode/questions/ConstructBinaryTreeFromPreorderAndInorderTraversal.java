package hongke.interview.leetcode.questions;

import hongke.interview.leetcode.common.TreeNode;

import java.util.Arrays;

/**
 * Created by hongke on 9/21/14.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (inorder == null || inorder == null || inorder.length == 0
            || inorder.length == 0 || inorder.length != inorder.length) {
            return null;
        }

        return buildNode(preorder, inorder);
    }

    private TreeNode buildNode(int[] preorder, int[] inorder) {
        TreeNode node = new TreeNode(preorder[0]);
        int index = 0;
        while (index < inorder.length && inorder[index] != node.val) {
            index++;
        }
        if (index > 0) {
            node.left = buildNode(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));
        }

        if (index < preorder.length - 1) {
            node.right = buildNode(Arrays.copyOfRange(preorder, index + 1, preorder.length), Arrays.copyOfRange(inorder, index + 1, preorder.length));
        }
        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0)
            return null;

        return construct(preorder, 0, preorder.length - 1,  inorder, 0, inorder.length - 1);
    }

    private TreeNode construct(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (is > ie || ps > pe)
            return null;
        int mid = preorder[ps], i = 0;
        for (; i + is <= ie && inorder[i + is] != mid; i ++);
        TreeNode node = new TreeNode(mid);
        node.left = construct(preorder, ps + 1, ps + i, inorder, is, is + i - 1);
        node.right = construct(preorder, ps + i + 1, pe, inorder, is + i + 1, ie);
        return node;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal test = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        int[] inorder, preorder;

        inorder = new int[] {1, 2};
        preorder = new int[] {1, 2};
        TreeNode.printPretty(test.buildTree(preorder, inorder));

        inorder = new int[] {2, 3, 1};
        preorder = new int[] {1, 2, 3};
        TreeNode.printPretty(test.buildTree(preorder, inorder));

        inorder = new int[] {4, 2, 1, 5, 6, 3, 7};
        preorder = new int[] {1, 2, 4, 3, 5, 6, 7};
        TreeNode.printPretty(test.buildTree(preorder, inorder));
    }
}

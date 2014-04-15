package hongke.interview.leetcode.questions;

import hongke.interview.leetcode.common.TreeNode;

/**
 * Created by hongke on 4/14/14.
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) {
            return null;
        }
        TreeNode root = recurs(0, num.length - 1, num);
        return root;
    }

    private TreeNode recurs(int start, int end, int[] num) {
        int index = (end + start) / 2;
        TreeNode current = new TreeNode(num[index]);
        if (end != start) {
            if (start != index) {
                current.left = recurs(start, Math.max(index - 1, 0), num);
            }

            current.right = recurs(Math.min(end, index + 1), end, num);
        }
        return current;
    }

    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree test = new
                ConvertSortedArrayToBinarySearchTree();

        int[] test3 = new int[]{0, 1};
        TreeNode result3 = test.sortedArrayToBST(test3);
        System.out.println(result3);

        int[] test1 = new int[]{0, 1, 2, 3, 4, 5, 6};
        TreeNode result1 = test.sortedArrayToBST(test1);
        System.out.println(result1);

        int[] test2 = new int[]{0, 1, 2, 3, 4, 5};
        TreeNode result2 = test.sortedArrayToBST(test2);
        System.out.println(result2);
    }
}

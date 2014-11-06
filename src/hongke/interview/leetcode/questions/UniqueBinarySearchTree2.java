package hongke.interview.leetcode.questions;

import hongke.interview.leetcode.common.TreeNode;

import java.util.*;

/**
 * Created by hongke on 7/15/14.
 */
public class UniqueBinarySearchTree2 {
    public List<TreeNode> generateTrees(int n) {
        return recursiveGenerateTrees (n, 1);
    }

    private List<TreeNode> recursiveGenerateTrees(int n, int min) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (n == 0) {
            result.add(null);
        } else if (n == 1) {
            result.add(new TreeNode(min));
        } else {
            for (int i = 0; i < n; i ++) {
                List<TreeNode> lefts = recursiveGenerateTrees(i, min);
                List<TreeNode> rights = recursiveGenerateTrees(n - i - 1, min + i + 1);
                for (int j = 0; j < lefts.size(); j ++) {
                    for (int k = 0; k < rights.size(); k ++) {
                        TreeNode node = new TreeNode(min + i);
                        node.left = lefts.get(j);
                        node.right = rights.get(k);
                        result.add(node);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTree2 test = new UniqueBinarySearchTree2();
        for (TreeNode t : test.generateTrees(3)) {
            TreeNode.printPretty(t);
        }

    }

}

package hongke.interview.leetcode.questions;

import hongke.interview.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by hongke on 9/2/14.
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        List<TreeNode> currentLevel = new LinkedList<TreeNode>();
        currentLevel.add(root);
        int depth = 1;
        while (true) {
            List<TreeNode> nextLevel = new LinkedList<TreeNode>();
            while (!currentLevel.isEmpty()) {
                TreeNode head = currentLevel.remove(0);
                if (head.left == null && head.right == null) {
                    return depth;
                } else {
                    if (head.left != null) {
                        nextLevel.add(head.left);
                    }
                    if (head.right != null) {
                        nextLevel.add(head.right);
                    }
                }
            }

            currentLevel = nextLevel;
            depth ++;
        }
    }
}

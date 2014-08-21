package hongke.interview.leetcode.questions;

import hongke.interview.leetcode.common.TreeLinkNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by hongke on 8/18/14.
 */
public class PopulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeLinkNode> nextLevel = new ArrayDeque<TreeLinkNode>();
        Queue<TreeLinkNode> currentLevel;
        nextLevel.add(root);
        while (!nextLevel.isEmpty()) {
            currentLevel = nextLevel;
            nextLevel = new ArrayDeque<TreeLinkNode>();
            while (!currentLevel.isEmpty()) {
                TreeLinkNode node = currentLevel.poll();
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
                node.next = currentLevel.isEmpty() ? null : currentLevel.peek();
            }
        }
    }

    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNodeII test = new PopulatingNextRightPointersInEachNodeII();
        TreeLinkNode input;

        input = new TreeLinkNode(1);
        input.left = new TreeLinkNode(2);
        input.right = new TreeLinkNode(3);
        input.left.left = new TreeLinkNode(4);
        input.left.right = new TreeLinkNode(5);
        input.right.left = new TreeLinkNode(6);
        input.right.right = new TreeLinkNode(7);
        input.left.left.left = new TreeLinkNode(8);
        input.left.left.right = new TreeLinkNode(9);
        input.left.right.left = new TreeLinkNode(10);
        input.left.right.right = new TreeLinkNode(11);
        input.right.left.left = new TreeLinkNode(12);
        input.right.left.right = new TreeLinkNode(13);
        input.right.right.left = new TreeLinkNode(14);
        input.right.right.right = new TreeLinkNode(15);

        test.connect(input);
        TreeLinkNode.printPretty(input);
    }

}

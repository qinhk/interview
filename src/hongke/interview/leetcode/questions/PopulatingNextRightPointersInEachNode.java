package hongke.interview.leetcode.questions;

import hongke.interview.leetcode.common.TreeLinkNode;

import java.util.Stack;

/**
 * Created by hongke on 8/18/14.
 */
public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        TreeLinkNode node = root;
        Stack<TreeLinkNode> stack = new Stack<TreeLinkNode>();
        while (node != null) {
            if (node.left != null) {
                node.left.next = node.right;
                if (node.next != null) {
                    node.right.next = node.next.left;
                }
                stack.push(node.right);
                stack.push(node.left);
            }

            if (stack.isEmpty()) {
                break;
            }
            node = stack.pop();
        }

    }

    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNode test = new PopulatingNextRightPointersInEachNode();
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

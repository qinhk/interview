package hongke.interview.leetcode.questions;

import hongke.interview.leetcode.common.TreeLinkNode;

import java.util.*;

/**
 * Created by hongke on 8/18/14.
 */
public class PopulatingNextRightPointersInEachNodeII {

    public int singleNumber(int[] A) {
        if (A == null || A.length == 0)
            return 0;

        Map<Integer, int[]> count = new HashMap<Integer, int[]>();
        for (Integer i : A) {
            if (!count.containsKey(i)) {
                count.put(i, new int[]{0});
            }
            count.get(i)[0] ++;
        }
//        for (Map.Entry<Integer, Integer[]> e : count.entrySet()) {
//            if (e.getValue()[0] < 3) {
//                return e.getKey();
//            }
//        }
        return 0;
    }
    public void connect1(TreeLinkNode root) {
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

    public void connect2(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        populateNext(root, new ArrayDeque<TreeLinkNode>());
    }

    private void populateNext(TreeLinkNode node, Deque<TreeLinkNode> queue) {
        if (node == null)
            return;
        enqueue(queue, node.left);
        enqueue(queue, node.right);
        if (node.next != null) {
            queue.add(node.next.left);
            queue.add(node.next.right);
        }
        while (queue.size() > 1) {
            queue.removeFirst().next = queue.getFirst();
        }
        queue.clear();
        populateNext(node.left, queue);
        populateNext(node.right, queue);
    }

    private void enqueue(Deque<TreeLinkNode> deque, TreeLinkNode node) {
        if (node != null) {
            deque.add(node);
        }
    }

    public void connect(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode dummy = new TreeLinkNode(0), head = dummy;
            while(root != null) {
                if (root != null && root.left != null) {
                    head.next = root.left;
                    head = head.next;
                }
                if (root != null && root.right != null) {
                    head.next = root.right;
                    head = head.next;
                }
                root = forward(root.next);
            }
            root = dummy.next;
        }
    }

    private TreeLinkNode forward(TreeLinkNode h) {
        while (h != null && h.left == null && h.right == null)
            h = h.next;
        return h;
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

        test.connect1(input);
        TreeLinkNode.printPretty(input);
    }

}

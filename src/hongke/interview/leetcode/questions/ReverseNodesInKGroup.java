package hongke.interview.leetcode.questions;

import hongke.interview.leetcode.common.ListNode;

import java.util.Stack;

/**
 * Created by hongke on 8/10/14.
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode reversed = new ListNode(0);
        ListNode node = head, result = reversed;
        while (node != null) {
            for (int i = 0; node != null && i < k; i ++) {
                stack.push(node);
                node = node.next;
                stack.peek().next = null;
            }
            if (stack.size() < k) {
                while (!stack.isEmpty()) {
                    reversed.next = stack.remove(0);
                    reversed = reversed.next;
                }
            } else {
                while (!stack.isEmpty()) {
                    reversed.next = stack.pop();
                    reversed = reversed.next;
                }
            }
        }
        return result.next;
    }

    public static void main(String[] args) {
        ReverseNodesInKGroup test = new ReverseNodesInKGroup();
        ListNode.prettyPrint(test.reverseKGroup(ListNode.createLinkedList(new int[]{1,2,3,4,5}), 2));
        ListNode.prettyPrint(test.reverseKGroup(ListNode.createLinkedList(new int[]{1,2,3,4,5}), 3));
        ListNode.prettyPrint(test.reverseKGroup(ListNode.createLinkedList(new int[]{1,2,3,4,5}), 8));
        ListNode.prettyPrint(test.reverseKGroup(ListNode.createLinkedList(new int[]{}), 2));
    }
}

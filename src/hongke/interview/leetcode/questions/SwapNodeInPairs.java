package hongke.interview.leetcode.questions;

import hongke.interview.leetcode.common.ListNode;

/**
 * Created by hongke on 7/18/14.
 */
public class SwapNodeInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode head1 = head;
        ListNode head2 = head.next;

        ListNode node1 = head1;
        ListNode node2 = head2;

        while (node1 != null || node2 != null) {
            if (node1 != null && node1.next != null) {
                node1.next = node1.next.next;
                node1 = node1.next;
            } else {
                node1 = null;
            }

            if (node2 != null && node2.next != null) {
                node2.next = node2.next.next;
                node2 = node2.next;
            } else {
                node2 = null;
            }
        }

        ListNode result = new ListNode(0);
        ListNode node = result;
        boolean rotate = false;
        while (head1 != null || head2 != null) {
            node.next = rotate ? head1 : head2;;
            if (rotate) {
                head1 = head1 == null ? null : head1.next;
            } else {
                head2 = head2 == null ? null : head2.next;
            }
            if (node.next != null) {
                node = node.next;
            }
            rotate = !rotate;
        }

        return result.next;

    }

    public static void main(String[] args) {
        ListNode input = null;
        SwapNodeInPairs test = new SwapNodeInPairs();

        input = ListNode.createLinkedList(new int[]{1,2,3});
        ListNode.prettyPrint(test.swapPairs(input));
    }
}

package hongke.interview.leetcode.questions;

import hongke.interview.leetcode.common.ListNode;

/**
 * Created by hongke on 8/24/14.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null && x < 0) {
            return head;
        }

        ListNode nodeX = head;
        for (int i = 0; nodeX != null && i < x; i++) {
            nodeX = nodeX.next;
        }

        if (nodeX == null) {
            return head;
        }

        int threshold = nodeX.val;
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(0);
        ListNode node = head, node1 = head1, node2 = head2;
        while (node != null) {
            if (node.val < threshold) {
                node1.next = node;
                node = node.next;
                node1 = node1.next;
                node1.next = null;
            } else {
                node2.next = node;
                node = node.next;
                node2 = node2.next;
                node2.next = null;
            }
        }
        node1.next = head2.next;
        return head1.next;
    }

    public static void main(String[] args) {
        PartitionList test = new PartitionList();
        ListNode.prettyPrint(test.partition(ListNode.createLinkedList(new int[] {2,1}), 0));
    }
}

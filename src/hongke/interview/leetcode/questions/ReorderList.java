package hongke.interview.leetcode.questions;

import hongke.interview.leetcode.common.ListNode;

/**
 * Created by hongke on 8/15/14.
 */
public class ReorderList {
    int length;

    public void reorderList(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        ListNode node = head;
        length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }

        reorderRecursively(0, head);

    }

    private ListNode reorderRecursively(int index, ListNode node1) {
        if (index < (length - 1) / 2) {
            ListNode tmp = reorderRecursively(index + 1, node1.next);
            ListNode next1 = node1.next;
            node1.next = tmp;
            ListNode next2 = tmp.next;
            tmp.next = next1;
            return next2;
        } else {
            if (length % 2 == 0) {
                node1 = node1.next;
            }
            ListNode tmp = node1.next;
            node1.next = null;
            return tmp;
        }
    }

    public static void main(String[] args) {
        ReorderList test = new ReorderList();
        ListNode input;

        input = ListNode.createLinkedList(new int[] {});
        test.reorderList(input);
        ListNode.prettyPrint(input);

        input = ListNode.createLinkedList(new int[] {1});
        test.reorderList(input);
        ListNode.prettyPrint(input);

        input = ListNode.createLinkedList(new int[] {1, 2});
        test.reorderList(input);
        ListNode.prettyPrint(input);

        input = ListNode.createLinkedList(new int[] {1, 2, 3});
        test.reorderList(input);
        ListNode.prettyPrint(input);

        input = ListNode.createLinkedList(new int[] {1, 2, 3, 4});
        test.reorderList(input);
        ListNode.prettyPrint(input);


        input = ListNode.createLinkedList(new int[] {1, 2, 3, 4, 5});
        test.reorderList(input);
        ListNode.prettyPrint(input);

        input = ListNode.createLinkedList(new int[] {1, 2, 3, 4, 5, 6});
        test.reorderList(input);
        ListNode.prettyPrint(input);

        input = ListNode.createLinkedList(new int[] {1, 2, 3, 4, 5, 6, 7});
        test.reorderList(input);
        ListNode.prettyPrint(input);

        input = ListNode.createLinkedList(new int[] {1, 2, 3, 4, 5, 6, 7, 8});
        test.reorderList(input);
        ListNode.prettyPrint(input);

        input = ListNode.createLinkedList(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        test.reorderList(input);
        ListNode.prettyPrint(input);


    }
}

package hongke.interview.leetcode.questions;

import hongke.interview.leetcode.common.ListNode;

/**
 * Created by hongke on 8/11/14.
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <=0) {
            return head;
        }

        int pos = 0;
        ListNode cur = head, toDelete = null;
        while (pos <= n && cur != null) {
            cur  = cur.next;
            pos ++;
        }
        while (cur != null) {
            cur = cur.next;
            toDelete = toDelete.next;
        }

        if (toDelete != head) {
            toDelete.next = toDelete.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList test = new RemoveNthNodeFromEndOfList();

        ListNode.prettyPrint(test.removeNthFromEnd(ListNode.createLinkedList(new int[] {1, 2}), 2));
        ListNode.prettyPrint(test.removeNthFromEnd(ListNode.createLinkedList(new int[] {1, 2}), 1));
        ListNode.prettyPrint(test.removeNthFromEnd(ListNode.createLinkedList(new int[] {1, 2, 3, 4, 5}), 2));
        ListNode.prettyPrint(test.removeNthFromEnd(ListNode.createLinkedList(new int[] {1, 2, 3, 4, 5}), 5));
        ListNode.prettyPrint(test.removeNthFromEnd(ListNode.createLinkedList(new int[] {1, 2, 3, 4, 5}), 1));
    }
}

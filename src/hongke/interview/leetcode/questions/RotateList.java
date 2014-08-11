package hongke.interview.leetcode.questions;

import hongke.interview.leetcode.common.ListNode;

/**
 * Created by hongke on 8/8/14.
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int n) {

        if (head == null || head.next == null || n == 0) {
            return head;
        }
        ListNode start = head, end = head, oldEnd = head;
        int length = 1;
        while (oldEnd.next != null) {
            oldEnd = oldEnd.next;
            length ++;
        }
        n = n % length;
        oldEnd.next = head;
        for (; n > 0; n --) {
            end = end.next;
        }
        while (oldEnd.next != end) {
            end = end.next;
            start = start.next;
        }
        while (end.next != start) {
            end = end.next;
        }
        end.next = null;
        return start;
    }

    public static void main(String[] args) {
        RotateList test = new RotateList();

        ListNode.prettyPrint(test.rotateRight(ListNode.createLinkedList(new int[] {1, 2}), 1));
        ListNode.prettyPrint(test.rotateRight(ListNode.createLinkedList(new int[] {1, 2}), 2));
        ListNode.prettyPrint(test.rotateRight(ListNode.createLinkedList(new int[] {1, 2}), 20));
        ListNode.prettyPrint(test.rotateRight(ListNode.createLinkedList(new int[] {1, 2, 3, 4, 5}), 2));
    }
}

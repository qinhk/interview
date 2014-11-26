package hongke.interview.leetcode.questions;

import hongke.interview.leetcode.common.ListNode;

/**
 * Created by hongke on 8/10/14.
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween1(ListNode head, int m, int n) {
        if (head == null || n <= m) {
            return head;
        }

        ListNode start = head, beforeStart = new ListNode(0), result = beforeStart;
        beforeStart.next = head;
        int i = 1;
        while (i < m) {
            beforeStart.next = start;
            start = start.next;
            beforeStart = beforeStart.next;
            i++;
        }
        while (i < n) {
            if (start == null || start.next == null) {
                break;
            }
            ListNode tmp1 = start.next;
            start.next = tmp1.next;
            tmp1.next = beforeStart.next;
            beforeStart.next = tmp1;
            i++;
        }

        return result.next;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode follower = dummy, runner = dummy;

        while (m > 1) {
            follower = follower.next;
            runner = runner.next;
            m --;
            n --;
        }
        ListNode t1 = follower.next;
        while (n > 0) {
            runner = runner.next;
            n --;
        }
        follower.next = runner;
        while (runner != t1) {
            ListNode t2 = runner.next;
            runner.next = t1;
            t1 = t1.next;
            runner.next.next = t2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ReverseLinkedListII test = new ReverseLinkedListII();

        System.out.println(test.reverseBetween(ListNode.createLinkedList(new int[] {1, 2}), 1, 2));
        System.out.println(test.reverseBetween(ListNode.createLinkedList(new int[] {1, 2, 3, 4, 5}), 2, 4));
        System.out.println(test.reverseBetween(ListNode.createLinkedList(new int[] {1, 2}), 2, 4));
        System.out.println(test.reverseBetween(ListNode.createLinkedList(new int[] {1}), 2, 4));
        System.out.println(test.reverseBetween(ListNode.createLinkedList(new int[] {}), 2, 4));
    }
}

package hongke.interview.leetcode.questions;

import hongke.interview.leetcode.common.ListNode;

/**
 * Created by hongke on 4/27/14.
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode result = head;
        head = head.next;
        result.next = null;
        while (head != null) {
            ListNode cur1 = head;
            head = head.next;
            cur1.next = null;

            ListNode cur2 = result;
            ListNode cur2prev = null;
            while (cur2 != null && cur2.val < cur1.val) {
                cur2prev = cur2;
                cur2 = cur2.next;
            }

            if (cur2prev == null) {
                cur2prev = cur1;
                cur1.next = cur2;
                result = cur2prev;
            } else {
                cur2prev.next = cur1;
                cur1.next = cur2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        InsertionSortList test = new InsertionSortList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        System.out.println(test.insertionSortList(head));
    }
}

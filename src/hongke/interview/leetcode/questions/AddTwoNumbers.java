package hongke.interview.leetcode.questions;

import hongke.interview.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by hongke on 4/6/14.
 */
@SuppressWarnings("unused")
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null){
            return l1;
        }

        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode result = new ListNode(0);
        ListNode cur = result;
        int carry = 0;
        while (carry != 0 || !(head1 == null && head2 == null)) {
            int n1 = head1 == null ? 0 : head1.val;
            int n2 = head2 == null ? 0 : head2.val;

            int val = (n1 + n2 + carry) % 10;
            cur.next = new ListNode(val);
            carry = (n1 + n2 + carry) / 10;
            cur = cur.next;

            if (head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head2 = head2.next;
            }
        }

        result = result.next;

        return result;
    }

    public static void main(String[] args) {
        AddTwoNumbers test = new AddTwoNumbers();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        String result = test.addTwoNumbers(l1, l2).toString();
        System.out.println(result);
    }
}

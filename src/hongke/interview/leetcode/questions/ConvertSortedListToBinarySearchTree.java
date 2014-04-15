package hongke.interview.leetcode.questions;

import hongke.interview.leetcode.common.ListNode;
import hongke.interview.leetcode.common.TreeNode;

/**
 * Created by hongke on 4/14/14.
 */
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        int depth = depth(head);
        return null;
    }

    private int depth(ListNode head) {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            count ++;
        }

        int height = 0;
        while ((count = count / 2) != 0) {
            height ++;
        }

        return height;
    }

    public static void main(String[] args) {
        int height = 0, count = 8;
        while ((count = count / 2) != 0) {
            height ++;
        }
        System.out.println(height);
    }
}

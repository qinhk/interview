package hongke.interview.leetcode.questions;

import hongke.interview.leetcode.common.ListNode;
import hongke.interview.leetcode.common.TreeLinkNode;

/**
 * Created by hongke on 12/21/14.
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        int la = 0, lb = 0;
        for (ListNode end = headA; end != null; end = end.next) la ++;
        for (ListNode end = headB; end != null; end = end.next) lb ++;
        if (la > lb) { ListNode t = headA; headA = headB; headB = t; }

        for (int i = 0; i < lb - la; i ++) headB = headB.next;

        while (headA != null) {
            if (headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists test = new IntersectionOfTwoLinkedLists();
        ListNode node = ListNode.createLinkedList(new int[]{1, 2});
        test.getIntersectionNode(node, node.next);
    }
}

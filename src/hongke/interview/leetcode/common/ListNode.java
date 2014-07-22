package hongke.interview.leetcode.common;

/**
 * Created by hongke on 4/6/14.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(Integer.toString(val));
        if (next != null) {
            sb.append(" -> ");
            sb.append(next.toString());
        }
        return sb.toString();
    }

    public static ListNode createLinkedList(int[] num) {
        if (num == null || num.length == 0)
            return null;

        ListNode head = new ListNode(num[0]);
        ListNode point = head;
        for (int i = 1; i < num.length; i++) {
            point.next = new ListNode(num[i]);
            point = point.next;
        }
        return head;
    }

    public static void prettyPrint(ListNode node) {
        System.out.println(node.toString());
    }
}

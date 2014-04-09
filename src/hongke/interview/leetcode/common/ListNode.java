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
}
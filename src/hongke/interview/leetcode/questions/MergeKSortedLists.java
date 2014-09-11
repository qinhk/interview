package hongke.interview.leetcode.questions;

import hongke.interview.leetcode.common.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by hongke on 9/5/14.
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(List<ListNode> lists) {

        if (lists == null || lists.size() == 0) {
            return null;
        }

        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });

        for (ListNode list : lists) {
            heap.add(list);
        }

        ListNode result = new ListNode(0), node = result;
        while (!heap.isEmpty()) {
            node.next = heap.poll();
            node = node.next;
            if (node.next != null) {
                heap.add(node.next);
            }
            node.next = null;
        }

        return result.next;
    }
}

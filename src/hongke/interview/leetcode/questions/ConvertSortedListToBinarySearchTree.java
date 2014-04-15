package hongke.interview.leetcode.questions;

import hongke.interview.leetcode.common.ListNode;
import hongke.interview.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Created by hongke on 4/14/14.
 */
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        int count = count(head);
        TreeNode root = createTree(count);
        assignValues (root, head);
        return root;
    }

    private TreeNode createTree(int count) {
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        TreeNode root = new TreeNode(0);
        count --;
        queue.push(root);
        while (count > 0) {
            TreeNode node = queue.removeFirst();
            if (count > 0) {
                node.left = new TreeNode(0);
                queue.addLast(node.left);
                count --;
            }
            if (count > 0) {
                node.right = new TreeNode(0);
                queue.addLast(node.right);
                count --;
            }
        }
        return root;
    }

    private void assignValues(TreeNode root, ListNode head) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        ListNode num = head;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                cur.val = num.val;
                num = num.next;
                cur = cur.right;
            }
        }
    }

    private int count(ListNode head) {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            count ++;
        }
        return count;
    }

    public static void main(String[] args) {
    	ConvertSortedListToBinarySearchTree test = new ConvertSortedListToBinarySearchTree();
    	ListNode head1 = ListNode.createLinkedList(new int[] {0,1,2,3,4,5,6,7,8
        ,9,10,11,12,13});
    	TreeNode result1 = test.sortedListToBST(head1);
    	TreeNode.printPretty(result1);

        ListNode head2 = ListNode.createLinkedList(new int[] {0});
        TreeNode result2 = test.sortedListToBST(head2);
        TreeNode.printPretty(result2);
    }
}

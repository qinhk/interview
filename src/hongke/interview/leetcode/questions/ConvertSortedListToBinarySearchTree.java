package hongke.interview.leetcode.questions;

import hongke.interview.leetcode.common.ListNode;
import hongke.interview.leetcode.common.TreeNode;

import java.util.Stack;

/**
 * Created by hongke on 4/14/14.
 */
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        int depth = depth(head);
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ListNode num = head;
        TreeNode root = new TreeNode(0), cur = root;
        while (num != null) {
        	if (stack.size() <= depth) {
        		// create empty tree nodes, will assign value later.
        		stack.push(cur);
        		cur.left = new TreeNode(0);
        		cur = cur.left;
        	} else {
        		cur = stack.pop();
        		visit(cur, head);
        		cur.right = new TreeNode(0);
        		cur = cur.right;
        	}
        }
        return root;
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
    
    private TreeNode visit(TreeNode node, ListNode head) {
    	node.val = head.val;
    	head = head.next;
    	return node;
    }

    public static void main(String[] args) {
    	ConvertSortedListToBinarySearchTree test = new ConvertSortedListToBinarySearchTree();
    	int[] test1 = new int[] {0,1,2,3,4,5,6};
    	ListNode head = new ListNode(0);
    	ListNode point = head;
    	for (int i = 0; i < test1.length; i++) {
    		point.val = i;
    		if (i + 1 < test1.length) {
    			point.next = new ListNode(0);
    			point = point.next;
    		}
    	}
    	test.sortedListToBST(head);
    }
}

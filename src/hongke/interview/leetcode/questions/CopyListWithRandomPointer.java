package hongke.interview.leetcode.questions;

import hongke.interview.leetcode.common.RandomListNode;

/**
 * Created by hongke on 4/16/14.Ø
 */
public class CopyListWithRandomPointer {

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

//        if (head.next == null) {
//            RandomListNode newHead = new RandomListNode(head.label);
//            if
//            newHead.random = head.random;
//            return newHead;
//        }

        // Insert new nodes
        RandomListNode node = head;
        while (node != null) {
            RandomListNode newNode = new RandomListNode(node.label);
            newNode.next = node.next;
            node.next = newNode;
            node = newNode.next;
        }

        // Copy random pointer
        node = head;
        while (node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }

        // form new list and restore the old one
        RandomListNode newHead = head.next;
        node = head;
        while (node.next != null) {
            RandomListNode newNode = node.next;
            RandomListNode old = node;
            old.next = newNode.next;
            if (old.next != null) {
                newNode.next = old.next.next;
                node = old.next;
            }
        }

        return newHead;
    }

    public static void main(String[] args) {

        RandomListNode head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);
        head.next.next.next = new RandomListNode(4);
        head.next.next.next.next = new RandomListNode(5);

        head.random = head.next.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next;
        head.next.next.next.random = head.next.next;
        test(head);

        RandomListNode head1 = new RandomListNode(-1);
        head1.next = new RandomListNode(-1);
        head1.random = head1.next;
        head1.next.random = head1.next;
        test(head1);

        RandomListNode head2 = new RandomListNode(-1);
        head2.random = head2;
        test(head2);

    }

    private static void test (RandomListNode head) {
        CopyListWithRandomPointer test = new CopyListWithRandomPointer();
        RandomListNode.prettyPrint(head);
        System.out.println("---");
        RandomListNode result = test.copyRandomList(head);
        RandomListNode.prettyPrint(head);
        System.out.println("---");
        RandomListNode.prettyPrint(result);
        System.out.println("---");
    }

}

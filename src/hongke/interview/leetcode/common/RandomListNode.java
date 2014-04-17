package hongke.interview.leetcode.common;

/**
 * Created by hongke on 4/16/14.
 */
/*
 * Definition for singly-linked list with a random pointer.
 */
public class RandomListNode {
    public int label;
    public RandomListNode next, random;

    public RandomListNode(int x) {
        this.label = x;
    }

    @Override
    public String toString() {
        return hashCode() + ":" + label;
    }

    public static void prettyPrint(RandomListNode head) {
        RandomListNode n = head;
        while (n != null) {
            System.out.println(String.valueOf(n) + "[" + String.valueOf(n
                    .random) + "]");
            n = n.next;
        }
    }
};

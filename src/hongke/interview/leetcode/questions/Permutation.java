package hongke.interview.leetcode.questions;

import java.util.*;

/**
 * Created by hongke on 8/20/14.
 */
public class Permutation {
    public List<List<Integer>> permute(int[] num) {
        if (num == null || num.length == 0) {
            return new ArrayList<List<Integer>>();
        } else if (num.length == 1) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(num[0]);
            ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
            result.add(list);
            return result;
        }

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        PriorityQueue<Integer> index = new PriorityQueue<Integer>();
        for (int i = 1; i < num.length; i++) {
            index.add(i);
        }
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        boolean isFinished = false;
        while (!isFinished) {
            if (stack.size() == num.length) {
                List<Integer> result = new ArrayList<Integer>();
                isFinished = true;
                int prev = num.length;
                for (Integer i : stack) {
                    isFinished = isFinished && prev > i;
                    result.add(num[i]);
                    prev = i;
                }
                results.add(result);

                int last = stack.pop();
                while (!stack.isEmpty() && stack.peek() > last - 1) {
                    index.add(stack.pop());
                }

                if (!stack.isEmpty()) {
                    index.add(stack.pop());
                }

                stack.push(last);


            } else {
                stack.push(index.poll());
            }
        }

        return results;
    }

    public static void main(String[] args) {
        Permutation test = new Permutation();
        System.out.println(test.permute(new int[] {}));
        System.out.println(test.permute(new int[] {1}));
        System.out.println(test.permute(new int[] {1, 2}));
        System.out.println(test.permute(new int[] {1, 2, 3}));
    }
}

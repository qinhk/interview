package hongke.interview.leetcode.questions;

import java.util.*;

/**
 * Created by hongke on 7/28/14.
 */
public class SubsetII {
    public List<List<Integer>> subsets(int[] S) {

        Set<List<Integer>> results =  new HashSet<List<Integer>>();
        results.add(new ArrayList<Integer>());

        if (S == null || S.length == 0) {
            return new ArrayList<List<Integer>>(results);
        }

        Arrays.sort(S);
        int count = 0;

        while (count <= S.length) {
            Stack<Integer> stack = new Stack<Integer>();
            for (int i = 0; i < count; i ++) {
                stack.push(i);
            }

            while (stack.size() != 0) {
                List<Integer> subset = new ArrayList<Integer>();
                for (Integer index : stack) {
                    subset.add(S[index]);
                }
                results.add(subset);

                if(stack.peek() < S.length - 1) {
                    Integer last = stack.pop();
                    stack.push(last + 1);
                } else {
                    while (!stack.isEmpty() && stack.peek() >= S.length - 1 - count + stack.size()) {
                        stack.pop();
                    }

                    if (stack.isEmpty()) {
                        break;
                    }

                    int last = stack.pop();
                    while (stack.size() < count) {
                        stack.push(last + 1);
                        last ++;
                    }
                }
            }
            count ++;
        }
        List<List<Integer>> sortedResults = new ArrayList<List<Integer>>(results);
        return sortedResults;
    }
}

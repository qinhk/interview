package hongke.interview.leetcode.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by hongke on 7/28/14.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] S) {

        List<List<Integer>> results =  new ArrayList<List<Integer>>();
        results.add(new ArrayList<Integer>());

        if (S == null || S.length == 0) {
            return results;
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
        return results;
    }

    public static void main(String[] args) {
        Subsets test = new Subsets();
        List<List<Integer>> result;
        result = test.subsets(new int[]{});
        prettyPrint(result);

        result = test.subsets(new int[]{1,3,5});
        prettyPrint(result);

        int[] input = new int[10];
        for (int i = 9; i >= 0; i -- ) {
            input[i] = i;
        }
        result = test.subsets(input);
        prettyPrint(result);
    }

    private static void prettyPrint(List<List<Integer>> input) {
        for (List<Integer> l : input) {
            System.out.println(l);
        }
    }

}

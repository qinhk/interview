package hongke.interview.leetcode.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by hongke on 4/12/14.
 */
public class Combinations {

    ArrayList<ArrayList<Integer>> results;

    public ArrayList<ArrayList<Integer>> combine1(int n, int k) {
        if (n <= 0 || k <= 0) {
            return new ArrayList<ArrayList<Integer>>();
        }

        results = new ArrayList<ArrayList<Integer>>();
        pickOneNumber(1, n, k, new Stack<Integer>());
        return results;
    }

    public void pickOneNumber(int start, int end, int k, Stack<Integer> result) {
        if (k == 0) {
            results.add(new ArrayList<Integer>(result));
            return;
        }

        for (int i = start; i <= end; i ++) {
            result.push(i);
            pickOneNumber(i + 1, end, k - 1, result);
            result.pop();
        }
    }

    public static void main(String[] args) {
        Combinations test = new Combinations();
        System.out.println(System.currentTimeMillis());
        System.out.println(test.combine(10, 7));
        System.out.println(System.currentTimeMillis());
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n <= 0 || k <= 0) {
            return result;
        }
        combine(n, k, new Stack<Integer>(), result);
        return result;
    }

    private void combine(int n, int k, Stack<Integer> stack, List<List<Integer>> result) {
        if (stack.size() == k) {
            result.add(new ArrayList<Integer>(stack));
            return;
        }
        for (int i = n; i > 0; i --) {
            stack.push(i);
            combine(i - 1, k, stack, result);
            stack.pop();
        }
    }
}

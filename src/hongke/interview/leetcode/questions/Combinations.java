package hongke.interview.leetcode.questions;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by hongke on 4/12/14.
 */
public class Combinations {

    ArrayList<ArrayList<Integer>> results;

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
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
}

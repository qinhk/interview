package hongke.interview.leetcode.questions;

import java.util.*;

/**
 * Created by hongke on 4/12/14.
 */
public class CombinationSum {

    private HashSet<ArrayList<Integer>> results;

    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        if (target <= 0 || candidates == null || candidates.length == 0 ) {
            return new ArrayList<ArrayList<Integer>>();
        }

        results = new HashSet<ArrayList<Integer>>();

        Arrays.sort(candidates);
        substractAndFind(candidates, target, new Stack<Integer>());
        return new ArrayList<ArrayList<Integer>>(results);
    }

    private void substractAndFind(int[] candidates, int target, Stack<Integer> subset) {
        for (Integer candidate : candidates) {
            if (target - candidate == 0) {
                // valid combination, record it.
                ArrayList<Integer> result = new ArrayList<Integer>();
                result.addAll(subset);
                result.add(candidate);
                Collections.sort(result);
                results.add(result);
            }
            else if (target - candidate > 0) {
                // recursively search
                subset.push(candidate);
                substractAndFind(candidates, target - candidate, subset);
                subset.pop();
            }
            else {
                // target - candidate < 0
                // not a valid combination, do nothing;
            }
        }
    }
}

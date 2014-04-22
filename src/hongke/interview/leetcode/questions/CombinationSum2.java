package hongke.interview.leetcode.questions;

import java.util.*;

/**
 * Created by hongke on 4/12/14.
 */
public class CombinationSum2 {

    private HashSet<ArrayList<Integer>> results;

    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        if (target <= 0 || candidates == null || candidates.length == 0) {
            return new ArrayList<ArrayList<Integer>>();
        }

        results = new HashSet<ArrayList<Integer>>();

        Arrays.sort(candidates);
        substractAndFind(candidates, target, 0, new Stack<Integer>());
        return new ArrayList<ArrayList<Integer>>(results);
    }

    private void substractAndFind(int[] candidates, int target, int index, Stack<Integer> subset) {
        for (int i = index; i < candidates.length; i++) {

            if (target - candidates[i] == 0) {
                // valid combination, record it.
                ArrayList<Integer> result = new ArrayList<Integer>();
                result.addAll(subset);
                result.add(candidates[i]);
                Collections.sort(result);
                results.add(result);
            } else if (target - candidates[i] > 0) {
                // recursively search
                subset.push(candidates[i]);
                substractAndFind(candidates, target - candidates[i],
                        i + 1, subset);
                subset.pop();
            }

            System.out.println("Candidate:" + String.valueOf(candidates[i]));
            System.out.println("Stack:" + String.valueOf(subset));
            System.out.println("Results:" + String.valueOf(results));
            System.out.println("----------");
        }
    }

    public static void main(String[] args) {
        CombinationSum2 test = new CombinationSum2();
        int[] testInput1 = new int[]{1, 2, 3};
        System.out.println(String.valueOf(test.combinationSum(testInput1, 6)));
    }
}

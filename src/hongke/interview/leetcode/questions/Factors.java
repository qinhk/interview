package hongke.interview.leetcode.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by hongke on 7/7/14.
 */
public class Factors {

    public static ArrayList<ArrayList<Integer>> printFactors(int number) {

        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        printFactorsHelper(number, new ArrayList<Integer>(), results);
        return results;
    }

    private static void printFactorsHelper(int number, ArrayList<Integer> preResult,
        ArrayList<ArrayList<Integer>> results) {

        if (number == 1) {
            ArrayList<Integer> result = new ArrayList<Integer>(preResult);
            results.add(result);
            return;
        }

        int start = 2;
        if (preResult.size() > 0) {
            start = preResult.get(preResult.size() - 1);
        }
        for (int i = start; i > 0 && i <= number; i++) {
            try {
                if (number % i == 0) {
                    preResult.add(i);
                    printFactorsHelper(number / i, preResult, results);
                    preResult.remove(preResult.size() - 1);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE + 1);
        ArrayList<ArrayList<Integer>> results = Factors.printFactors(Integer.MAX_VALUE);
        System.out.println("start");
        for (ArrayList<Integer> result : results) {
            System.out.println(Arrays.toString(result.toArray()));
        }
        System.out.println("done");
    }

}

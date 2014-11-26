package hongke.interview.leetcode.questions;

import java.util.*;

/**
 * Created by hongke on 11/20/14.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
        if (num == null || num.length < 3) {
            return new ArrayList<List<Integer>>();
        }

        Arrays.sort(num);
        Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
        for (int i = 0; i < num.length; i++) {
            cache.put(num[i], i);
        }

        Set<List<Integer>> result = new HashSet<List<Integer>>();
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                Integer key = 0 - num[i] - num[j];
                if (cache.containsKey(key)
                        && cache.get(key) > j) {
                    result.add(getGroup(num, i, j, cache.get(key)));
                }
            }
        }
        return new ArrayList<List<Integer>>(result);
    }

    private List<Integer> getGroup(int[] num, int... index) {
        List<Integer> list = new ArrayList<Integer>(3);
        for (int i : index) {
            list.add(num[i]);
        }
        return list;
    }

    public ArrayList<ArrayList<Integer>> threeSum1(int[] num) {
        if (num == null || num.length < 3) {
            return new ArrayList<ArrayList<Integer>>();
        }

        Arrays.sort(num);
        HashMap<Integer, ArrayList<Integer>> numbers = new HashMap<Integer,
                ArrayList<Integer>>();
        for (int i = 0; i < num.length; i++) {
            if (numbers.get(num[i]) == null) {
                numbers.put(num[i], new ArrayList<Integer>());
            }
            numbers.get(num[i]).add(i);
        }

        Set<ArrayList<Integer>> results = new HashSet<ArrayList<Integer>>();
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                Integer k = 0 - num[i] - num[j];
                if (i != j && numbers.get(k) != null) {
                    ArrayList<Integer> index = numbers.get(k);
                    int indexK = index.get(index.size() - 1);
                    if (indexK <= j) {
                        continue;
                    }
                    ArrayList<Integer> triple = new ArrayList<Integer>();
                    triple.add(num[i]);
                    triple.add(num[j]);
                    triple.add(k);
                    results.add(triple);
                }
            }
        }

        return new ArrayList<ArrayList<Integer>>(results);
    }

    public static void main(String[] args) {
        int[] num = new int[]{-13, 11, 11, 0, -5, -14, 12, -11, -11, -14, -3, 0, -3, 12, -1, -9, -5, -13, 9, -7, -2, 9, -1, 4, -6, -13, -7, 10, 10, 9, 7, 13, 5, 4, -2, 7, 5, -13, 11, 10, -12, -14, -5, -8, 13, 2, -2, -14, 4, -8, -6, -13, 9, 8, 6, 10, 2, 6, 5, -10, 0, -11, -12, 12, 8, -7, -4, -9, -13, -7, 8, 12, -14, 10, -10, 14, -3, 3, -15, -14, 3, -14, 10, -11, 1, 1, 14, -11, 14, 4, -6, -1, 0, -11, -12, -14, -11, 0, 14, -9, 0, 7, -12, 1, -6};
        ThreeSum test = new ThreeSum();
        System.out.println(System.currentTimeMillis());
        System.out.println(test.threeSum(num));
        System.out.println(System.currentTimeMillis());
    }
}

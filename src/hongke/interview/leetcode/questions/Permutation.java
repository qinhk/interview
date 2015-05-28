package hongke.interview.leetcode.questions;

import java.util.*;

/**
 * Created by hongke on 8/20/14.
 */
public class Permutation {

    public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> returnList = new ArrayList<ArrayList<Integer>>();
        returnList.add(new ArrayList<Integer>());

        for (int i = 0; i < num.length; i++) {
            Set<ArrayList<Integer>> currentSet = new HashSet<ArrayList<Integer>>();
            for (List<Integer> l : returnList) {
                for (int j = 0; j < l.size() + 1; j++) {
                    l.add(j, num[i]);
                    ArrayList<Integer> T = new ArrayList<Integer>(l);
                    l.remove(j);
                    currentSet.add(T);
                }
            }
            returnList = new ArrayList<ArrayList<Integer>>(currentSet);
        }

        return returnList;
    }

    public List<List<Integer>> permute(int[] num) {

        if (num == null) {
            return new ArrayList<List<Integer>>();
        }
        Set<List<Integer>> results = new LinkedHashSet<List<Integer>>();
        int[] index = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            index[i] = i;
        }
        List<Integer> result;

        int begin = 0;
        while (begin < num.length) {
            int tmp = index[0];
            index[0] = index[begin];
            index[begin] = tmp;
            result = new ArrayList<Integer>();
            for (Integer i : index) {
                result.add(num[i]);
            }
            if (!results.contains(result)) {
                results.add(result);
            } else {
                break;
            }
            begin = begin == num.length - 1 ? 1 : begin + 1;
        }

        return new ArrayList<List<Integer>>(results);
    }

    public static void main(String[] args) {
        Permutation test = new Permutation();
        System.out.println(test.permute2(new int[] {}));
        System.out.println(test.permute2(new int[] {1}));
        System.out.println(test.permute2(new int[] {1, 2}));
        System.out.println(test.permute2(new int[] {1, 2, 3}));
        System.out.println(test.permuteUnique(new int[] {1, 2, 3, 3, 4}));

    }

    public List<List<Integer>> permute2(int[] num) {
        if (num == null || num.length == 0) {
            return new ArrayList<List<Integer>>();
        }

        Stack<Integer> stack = new Stack<Integer>();
        Set<List<Integer>> results = new LinkedHashSet<List<Integer>>();
        boolean[] used = new boolean[num.length];
        Arrays.fill(used, false);

        while (true) {
            if (stack.size() == num.length) {
                List<Integer> result = new ArrayList<Integer>();
                for (Integer i : stack) {
                    result.add(num[i]);
                }
                results.add(result);

                int next = num.length, last;
                while (next > num.length - 1) {
                    if (!stack.isEmpty()) {
                        last = stack.pop();
                    } else {
                        return new ArrayList<List<Integer>>(results);
                    }
                    next = last + 1;
                    used[last] = false;
                    while (next < num.length && used[next] == true) {
                        next++;
                    }
                }

                stack.push(next);
                used[next] = true;
            } else {
                for (int i = 0; i < num.length; i ++) {
                    if (used[i] == false) {
                        stack.push(i);
                        used[i] = true;
                    }
                }
            }
        }
    }
}

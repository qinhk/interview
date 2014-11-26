package hongke.interview.leetcode.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hongke on 8/27/14.
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        if (s == null || s.isEmpty()) {
            List<List<String>> resultList = new ArrayList<List<String>>();
            return resultList;
        }

        int n = s.length();
        Map<Integer, List<List<String>>> results = new HashMap<Integer, List<List<String>>>();
        List<List<String>> origin = new ArrayList<List<String>>();
        origin.add(new ArrayList<String>());
        origin.get(0).add("");
        results.put(0, origin);
        for (int i = 0; i < n; i++) {
            List<List<String>> prevPalindromes = results.get(i);
            for (int l = 1; prevPalindromes != null && l + i <= n; l++) {
                if (isPalindrome(s, i, l)) {
                    for (List<String> list : prevPalindromes) {
                        if (!results.containsKey(i + l)) {
                            results.put(i + l, new ArrayList<List<String>>());
                        }
                        List<String> newList = new ArrayList<String>();
                        newList.addAll(list);
                        newList.add(s.substring(i, i + l));
                        results.get(i + l).add(newList);
                    }
                }
            }
        }

        List<List<String>> partitions = results.get(n);
        for (List<String> partition : partitions) {
            partition.remove(0);
        }
        return partitions;
    }

    private boolean isPalindrome(String s, int startIndex, int length) {
        if (length == 1) {
            return true;
        }

        int i = startIndex, j = startIndex + length - 1, k = 0;
        while (i + k <= j - k) {
            if (s.charAt(i + k) != s.charAt(j - k)) {
                return false;
            }
            k ++;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning test = new PalindromePartitioning();

        System.out.println(test.partition("aab"));
        System.out.println(test.partition("ab"));
        System.out.println(test.partition("aabb"));
        System.out.println(test.partition("ababbbabbaba"));
    }
}

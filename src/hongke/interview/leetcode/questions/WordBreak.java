package hongke.interview.leetcode.questions;

import java.util.*;

/**
 * Created by hongke on 6/27/14.
 */
public class WordBreak {
    Boolean found;
    Set<String> dict;
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0 || dict == null || dict.size() == 0) {
            return false;
        }
        found = false;
        this.dict = dict;
//        backtracking(s, 0);
        return dpSearch(s, dict);
    }

    private void backtracking(String s, Integer i) {
        if (i > s.length() || found) {
            return;
        } else if (i == s.length()) {
            found = true;
            return;
        } else {
            for (int j = i + 1; j <= s.length(); j ++) {
                if (dict.contains(s.substring(i, j))) {
                    backtracking(s, j);
                }
            }
        }
    }

    private boolean dpSearch(String s, Set<String> dict) {
        Set<Integer> cache = new HashSet<Integer>();
        for (int i = s.length() - 1; i >= 0; i --) {
            if (dict.contains(s.substring(i))) {
                cache.add(i);
            }

            for (Integer j : cache) {
                if (dict.contains(s.substring(i,j))) {
                    cache.add(i);
                    break;
                }
            }
        }
        return cache.contains(0);
    }

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        Set<String> dict;
        long start, end;

        dict = new HashSet(Arrays.asList(new String[] {"a"}));
        start = System.nanoTime();
        System.out.println(wb.wordBreak("b", dict));
        end = System.nanoTime();
        System.out.println((end - start) / 1000);

        //"bb", ["a","b","bbb","bbbb"]
        dict = new HashSet(Arrays.asList(new String[] {"a","b","bbb","bbbb"}));
        start = System.nanoTime();
        System.out.println(wb.wordBreak("bb", dict));
        end = System.nanoTime();
        System.out.println((end - start) / 1000);

        dict = new HashSet(Arrays.asList(new String[] {"cat", "cats", "and", "sand", "dog"}));
        start = System.nanoTime();
        System.out.println(wb.wordBreak("catsanddog", dict));
        end = System.nanoTime();
        System.out.println((end - start) / 1000);

        dict = new HashSet(Arrays.asList(new String[] {"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"}));
        start = System.nanoTime();
        System.out.println(wb.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", dict));
        end = System.nanoTime();
        System.out.println((end - start) / 1000);

        dict = new HashSet(Arrays.asList(new String[] {"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"}));
        start = System.nanoTime();
        System.out.println(wb.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", dict));
        end = System.nanoTime();
        System.out.println((end - start) / 1000);

    }
}

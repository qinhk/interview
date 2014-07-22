package hongke.interview.leetcode.questions;

import java.util.*;

/**
 * Created by hongke on 6/26/14.
 */
public class WordBreak2 {
    public List<String> wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0 || dict == null || dict.size() == 0) {
            return new ArrayList<String>();
        }

        List<String> results = new ArrayList<String>();
        Map<Integer, List<String>> cache = dpSearch(s, dict);
        backtracking(s, 0, cache, new Stack<String>(), results);
        return results;
    }

    private Map<Integer, List<String>> dpSearch(String s, Set<String> dict) {
        Map <Integer, List<String>> wordsAtIndex = new HashMap<Integer, List<String>>();
        for (Integer i = s.length(); i >= 0; i --) {
            List<String> words = new ArrayList<String>();
            if (dict.contains(s.substring(i))) {
                words.add(s.substring(i));
            }

            for (Map.Entry<Integer, List<String>> entry : wordsAtIndex.entrySet()) {
                if (dict.contains(s.substring(i, entry.getKey()))) {
                    words.add(0, s.substring(i, entry.getKey()));
                }
            }

            if (words.size() != 0) {
                wordsAtIndex.put(i, words);
            }
        }
        return wordsAtIndex;
    }

    private void backtracking(String s, Integer i,  Map<Integer, List<String>> cache, Stack<String> sentence, List<String> results) {

        if (i == s.length()) {
            StringBuilder sb = new StringBuilder();
            for (String word : sentence) {
                sb.append(word + " ");
            }
            results.add(sb.toString().trim());
            return;
        } else if (i > s.length() || !cache.containsKey(i)) {
            return;
        } else {
            for (String word : cache.get(i)) {
                sentence.push(word);
                backtracking (s, i + word.length(), cache, sentence, results);
                sentence.pop();
            }
        }
    }

    public static void main(String[] args) {
        WordBreak2 wb2 = new WordBreak2();
        Set<String> dict;
        long start, end;

        dict = new HashSet(Arrays.asList(new String[] {"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"}));
        start = System.nanoTime();
        System.out.println(wb2.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", dict).size());
        end = System.nanoTime();
        System.out.println((end - start) / 1000);

        dict = new HashSet(Arrays.asList(new String[] {"a"}));
        start = System.nanoTime();
        System.out.println(wb2.wordBreak("a", dict));
        end = System.nanoTime();
        System.out.println((end - start) / 1000);

        //"bb", ["a","b","bbb","bbbb"]
        dict = new HashSet(Arrays.asList(new String[] {"a","b","bbb","bbbb"}));
        start = System.nanoTime();
        System.out.println(wb2.wordBreak("bb", dict));
        end = System.nanoTime();
        System.out.println((end - start) / 1000);

        dict = new HashSet(Arrays.asList(new String[] {"cat", "cats", "and", "sand", "dog"}));
        start = System.nanoTime();
        System.out.println(wb2.wordBreak("catsanddog", dict));
        end = System.nanoTime();
        System.out.println((end - start) / 1000);

        dict = new HashSet(Arrays.asList(new String[] {"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"}));
        start = System.nanoTime();
        System.out.println(wb2.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", dict));
        end = System.nanoTime();
        System.out.println((end - start) / 1000);


    }
}

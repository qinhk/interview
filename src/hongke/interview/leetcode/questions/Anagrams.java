package hongke.interview.leetcode.questions;

import java.util.*;

/**
 * Created by hongke on 4/6/14.
 */
public class Anagrams {
    public ArrayList<String> anagrams(String[] strs) {
        if (strs == null || strs.length < 2) {
            return new ArrayList<String>();
        }

        HashMap<String, List<String>> strSet = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = chars.length == 0 ? "empty" : Arrays.toString(chars);
            if (strSet.get(key) != null) {
                strSet.get(key).add(str);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(str);
                strSet.put(key, list);
            }
        }

        ArrayList<String> result = new ArrayList<String>();
        for (List<String> list : strSet.values()) {
            if (list.size() > 1) {
                result.addAll(list);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Anagrams test = new Anagrams();
        String[] test1 = new String[]{"", ""};
        System.out.println(test.anagrams(test1));

        String[] test2 = new String[]{"abc", "bca", "cab", "cba"};
        System.out.println(test.anagrams(test2));

    }


    public List<String> anagrams1(String[] strs) {
        List<String> result = new ArrayList<String>();
        if (strs == null || strs.length == 0) return result;
        Map<String, List<String>> anagrams = new HashMap<String, List<String>>();
        for (String s : strs) {
            String key = getKey(s);
            if (!anagrams.containsKey(key)) {
                anagrams.put(key, new ArrayList<String>());
            }
            anagrams.get(key).add(s);
        }
        for (List<String> l : anagrams.values()) {
            if (l.size() > 1) {
                result.addAll(l);
            }
        }
        return result;
    }

    private String getKey(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder();
        for(char c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }
}

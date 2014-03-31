package hongke.interview.leetcode.questions;

import java.util.*;

/**
 * Created by hongke on 3/26/14.
 */

@SuppressWarnings("unused")
public class WordLadder {

    HashSet<String> dict;

    /*
    Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

    Only one letter can be changed at a time
    Each intermediate word must exist in the dictionary
    For example,

    Given:
    start = "hit"
    end = "cog"
    dict = ["hot","dot","dog","lot","log"]
    Return
      [
        ["hit","hot","dot","dog","cog"],
        ["hit","hot","lot","log","cog"]
      ]
    Note:
    All words have the same length.
    All words contain only lowercase alphabetic characters.
     */
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {

        if (start == null || end == null || dict == null) {
            return null;
        }

        if (start.equals(end)) {
            return new ArrayList<ArrayList<String>>();
        }

        this.dict = dict;
        ArrayList<ArrayList<String>> result = new
                ArrayList<ArrayList<String>>();

        Stack<String> stack = new Stack<String>();
        stack.push(start.trim().toLowerCase());

        backTrackingSearch(start.trim().toLowerCase(), end.trim().toLowerCase(),
                stack, result,
                new Integer(Integer.MAX_VALUE));

        return result;
    }

    private void backTrackingSearch(String start, String end,
                                    Stack<String> stack,
                                    ArrayList<ArrayList<String>> result,
                                    Integer shortestLength) {
        if (stack.size() > shortestLength) {
            // skip some useless path
            return;
        } else {
            if (stack.peek().equals(end)) {
                // found a valid leaf
                if (stack.size() == shortestLength) {
                    if (result != null) {
                        // need to record the stack
                        stack.remove(0);
                        result.add(new ArrayList(Arrays.asList(stack.toArray())));
                    }
                } else {
                    // stack.size() < shortestLength
                    if (result != null) {
                        // need to record the stack, delete all previous records
                        // since found a better one.
                        result.clear();
                        stack.remove(0);
                        result.add(new ArrayList(Arrays.asList(stack.toArray())));
                    }

                    // update the known shortestPath.
                    shortestLength = new Integer(stack.size());
                }
            }

            // following section is where the black magic happen
            String next = getNext(stack.pop());

            if (next == null) {
                // done search
                return;
            } else {
                // more to search
                stack.push(next);
                backTrackingSearch(start, end, stack, result, shortestLength);
            }
        }
    }

    private String getNext(String current) {
        if (current.matches("[z]+")) {
            return null;
        }

        String next = null;
        for (int i = 0; i < current.length(); i++) {
            do {
                char nextLetter = (char) (current
                        .charAt(i) + 1);
                char[] chars = current.toCharArray();
                chars[i] = nextLetter;
                next = new String(chars);
            } while (!dict.contains(next) && !next.matches("[z]+"));
        }
        return next;
    }


    public static void main(String[] args) {
        WordLadder wl = new WordLadder();
        wl.findLadders("hit", "cog", new HashSet(Arrays.asList(new String[]{"hit",
                "hot", "dot", "dog", "cog"})));
    }

}

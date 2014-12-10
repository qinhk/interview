package hongke.interview.datastructure.tree;

import java.util.*;

/**
 * Created by hongke on 10/12/14.
 */
public class Trie {

    TrieNode head;

    public class TrieNode {
        Character letter;
        Map<Character, TrieNode> children;

        TrieNode(char c) {
            letter = c;
            children = new HashMap<Character, TrieNode>();
        }

        public TrieNode getChild(char c) {
            return children.get(c);
        }

        public List<TrieNode> getAllChildren() {
            return new ArrayList<TrieNode>(children.values());
        }
    }

    public Trie(Set<String> dict) {
        this();
        if (dict != null) {
            for (String s : dict) {
                put(s);
            }
        }
    }

    public Trie() {
        head = new TrieNode('^');
    }

    public void put(String word) {
        TrieNode root = head;
        int i = 0;
        while (i < word.length()) {
            if (!root.children.containsKey(word.charAt(i))) {
                root.children.put(word.charAt(i), new TrieNode(word.charAt(i)));
            }
            root = root.children.get(word.charAt(i));
            i ++;
        }
        root.children.put('$', new TrieNode('$'));
    }

    public boolean contains(String word) {
        TrieNode root = head;
        int i = 0;
        while (i < word.length() && root != null) {
            root = root.children.get(word.charAt(i));
            i ++;
        }

        if (root != null && root.children.containsKey('$')) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Trie test = new Trie();
        test.put("aa");
        test.put("aaa");
        test.put("aab");
        test.put("aac");
        test.put("aba");
        test.put("abb");
        test.put("abc");
        test.put("aca");
        test.put("acb");
        test.put("acc");

        System.out.println(test.contains("aa"));
        System.out.println(test.contains("aaa"));
        System.out.println(test.contains("aab"));
        System.out.println(test.contains("aac"));
        System.out.println(test.contains("aba"));
        System.out.println(test.contains("acc"));
        System.out.println(test.contains("abcd"));
        System.out.println(test.contains("a"));
        System.out.println(test.contains(""));

    }

}

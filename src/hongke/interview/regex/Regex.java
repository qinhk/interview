package hongke.interview.regex;

import hongke.interview.datastructure.Digraph;

import java.util.*;

/**
 * Created by hongke on 12/3/14.
 */
public class Regex {

    Digraph<Character> graph;

    Regex() {
        graph = new Digraph<Character>();
    }

    public boolean match(String str) {
        assert str != null;
        Set<Integer> epsilon = new HashSet<Integer>();
        epsilon.addAll(graph.bfs(0));

        for (Character c : str.toCharArray()) {
            List<Integer> match = new ArrayList<Integer>();
            for (Integer r : epsilon) {
                if (c == graph.get(r) || graph.get(r) == '.') {
                    match.add(r + 1);
                }
            }
            epsilon = new HashSet<Integer>();
            for (Integer r : match) {
                epsilon.addAll(graph.bfs(r));
            }
        }
        for (Integer i : epsilon) {
            if (graph.get(i) == '$') {
                return true;
            }
        }
        return false;
    }

    public static Regex compile(String pattern) {
        assert pattern != null;
        assert pattern.length() != 0;
        Regex regex = new Regex();
        regex.graph.add('^');
        boolean isStar = false;
        for (Character c : pattern.toCharArray()) {
            if (c == '*') {
                isStar = true;
            } else {
                if (isStar) {
                    regex.graph.add('*');
                    isStar = false;
                }
                regex.graph.add(c);
            }
        }
        if (isStar) {
            regex.graph.add('*');
        }
        regex.graph.add('$');
        int i = 0;
        for (Character c : regex.graph.getVertex()) {
            if (c == '*') {
                regex.graph.connect(i, i - 1, i + 1);
                regex.graph.connect(i - 1, i);
            } else if (c == '^') {
                regex.graph.connect(i, i + 1);
            }
            i ++;
        }
        return regex;
    }

    public static boolean isMatch(String str, String pattern) {
        Regex re = Regex.compile(pattern);
        return re.match(str);
    }
}

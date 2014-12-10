package hongke.interview.algorithms.graph;

import hongke.interview.datastructure.graph.Digraph;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hongke on 12/6/14.
 */
public class DepthFirstSearch {

    Set<Integer> visited;

    DepthFirstSearch(Digraph dg, int v) {
        this.visited = new HashSet<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        dfs(dg, v, visited);
    }

    void dfs(Digraph dg, int v, Set<Integer> visited) {
        visited.add(v);
        for (Integer w : dg.adj(v)) {
            if (!visited.contains(w)) {
                dfs(dg, w, visited);
            }
        }
    }

    public static DepthFirstSearch search(Digraph dg, int v) {
        assert dg != null;
        assert v >= 0 && v < dg.V();
        return new DepthFirstSearch(dg, v);
    }
}

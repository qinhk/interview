package hongke.interview.algorithms.graph;

import hongke.interview.datastructure.graph.Digraph;
import hongke.interview.io.In;
import hongke.interview.io.StdOut;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by hongke on 12/7/14.
 */
public class DirectedCycle {

    private Stack<Integer> cycle;
    private Set<Integer> visited;
    private int[] edgeTo;
    private Set<Integer> onStack;

    DirectedCycle(Digraph G) {
        assert G != null;
        visited = new HashSet<Integer>();
        edgeTo = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if (!visited.contains(i))
                dfs(G, i);
        }
    }

    private void dfs(Digraph G, int v) {
        visited.add(v);
        onStack.add(v);
        for (int w : G.adj(v)) {
            if (cycle != null) {
                return; //short cut
            } else if (!visited.contains(w)) {
                edgeTo[w] = v;
                dfs(G, w);
            } else if (onStack.contains(w)) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; w = edgeTo[w]) {
                    cycle.push(w);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack.remove(v);
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);

        DirectedCycle finder = new DirectedCycle(G);
        if (finder.hasCycle()) {
            StdOut.print("Cycle: ");
            for (int v : finder.cycle()) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }

        else {
            StdOut.println("No cycle");
        }
    }
}

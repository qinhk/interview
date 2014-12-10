package hongke.interview.algorithms.graph;

import hongke.interview.datastructure.graph.Digraph;
import hongke.interview.datastructure.graph.EdgeWeightedDigraph;

/**
 * Created by hongke on 12/7/14.
 */
public class Topological {

    private Iterable<Integer> order;

    public Topological(Digraph G) {
        DirectedCycle cycleFinder = new DirectedCycle(G);
        if (cycleFinder.hasCycle())
            throw new IllegalStateException("Cycle detected in the input graph.");
        DepthFirstOrder dfs = new DepthFirstOrder(G);
        order = dfs.reversePost();
    }

    public Topological(EdgeWeightedDigraph G) {
        EdgeWeightedDirectedCycle cycleFinder = new EdgeWeightedDirectedCycle(G);
        if (cycleFinder.hasCycle())
            throw new IllegalStateException("Cycle detected in the input graph.");
        DepthFirstOrder dfs = new DepthFirstOrder(G);
        order = dfs.reversePost();
    }

    public Iterable<Integer> order() {
        return order;
    }

    public boolean hasOrder() {
        return order != null;
    }

}

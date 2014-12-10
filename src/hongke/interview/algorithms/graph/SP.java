package hongke.interview.algorithms.graph;

import hongke.interview.datastructure.graph.EdgeWeightedDigraph.DirectedEdge;

/**
 * Created by hongke on 12/8/14.
 */
public interface SP {

    double distTo(int v);

    Iterable<DirectedEdge> pathTo(int v);
}

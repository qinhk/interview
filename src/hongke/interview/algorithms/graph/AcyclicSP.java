package hongke.interview.algorithms.graph;

import hongke.interview.datastructure.graph.EdgeWeightedDigraph;
import hongke.interview.datastructure.graph.EdgeWeightedDigraph.DirectedEdge;
import hongke.interview.io.In;
import hongke.interview.io.StdOut;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by hongke on 12/9/14.
 */
public class AcyclicSP {

    private static final int INF = Integer.MAX_VALUE;

    private double[] distTo;
    private DirectedEdge[] edgeTo;

    public AcyclicSP(EdgeWeightedDigraph G, int s) {
        assert G != null;
        assert s >= 0 && s < G.V();
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        Arrays.fill(distTo, INF);
        distTo[s] = 0;

        Topological topological = new Topological(G);
        for (int v : topological.order()) {
            for (DirectedEdge e : G.adj(v)) {
                relax(e);
            }
        }
    }

    private void relax(DirectedEdge e) {
        int v = e.from(), w = e.to();
        double dist = distTo[v] + e.weight();
        if (dist < distTo[w]) {
            distTo[w] = dist;
            edgeTo[w] = e;
        }
    }

    // return length of the shortest path from s to v, infinity if no such path
    public double distTo(int v) {
        return distTo[v];
    }

    // is there a path from s to v?
    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    // return view of the shortest path from s to v, null if no such path
    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }
        return path;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int s = Integer.parseInt(args[1]);
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);

        // find shortest path from s to each other vertex in DAG
        AcyclicSP sp = new AcyclicSP(G, s);
        for (int v = 0; v < G.V(); v++) {
            if (sp.hasPathTo(v)) {
                StdOut.printf("%d to %d (%.2f)  ", s, v, sp.distTo(v));
                for (DirectedEdge e : sp.pathTo(v)) {
                    StdOut.print(e + "   ");
                }
                StdOut.println();
            } else {
                StdOut.printf("%d to %d         no path\n", s, v);
            }
        }
    }
}

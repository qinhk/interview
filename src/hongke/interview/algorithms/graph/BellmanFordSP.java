package hongke.interview.algorithms.graph;

import hongke.interview.datastructure.graph.EdgeWeightedDigraph;
import hongke.interview.datastructure.graph.EdgeWeightedDigraph.DirectedEdge;
import hongke.interview.io.In;
import hongke.interview.io.StdOut;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by hongke on 12/10/14.
 */
public class BellmanFordSP {
    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private Queue<Integer> queue;
    private boolean[] onQueue;
    private Iterable<DirectedEdge> cycle;
    private int round;

    public BellmanFordSP(EdgeWeightedDigraph G, int s) {
        assert G != null;
        assert s >= 0 && s < G.V();
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        onQueue = new boolean[G.V()];
        queue = new LinkedList<Integer>();
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[s] = 0;
        queue.add(s);
        while (queue.size() != 0 && !hasNegativeCycle()) {
            int v = queue.poll();
            onQueue[v] = false;
            relax(G, v);
        }
    }

    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            double dist = e.weight() + distTo[v];
            if (dist < distTo[w]) {
                distTo[w] = dist;
                edgeTo[w] = e;
                if (!onQueue[w]) {
                    onQueue[w] = true;
                    queue.add(w);
                }
            }
            if (round++ % G.V() == 0)
                findNegativeCycle();
        }
    }

    // by finding a cycle in predecessor graph
    private void findNegativeCycle() {
        int V = edgeTo.length;
        EdgeWeightedDigraph spt = new EdgeWeightedDigraph(V);
        for (int v = 0; v < V; v++)
            if (edgeTo[v] != null)
                spt.addEdge(edgeTo[v]);

        EdgeWeightedDirectedCycle finder = new EdgeWeightedDirectedCycle(spt);
        cycle = finder.cycle();
    }


    // is there a path from s to v?
    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }


    // return length of shortest path from s to v
    public double distTo(int v) {
        return distTo[v];
    }

    // return view of shortest path from s to v, null if no such path
    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }
        return path;
    }

    // is there a negative cycle reachable from s?
    public boolean hasNegativeCycle() {
        return cycle != null;
    }

    // return a negative cycle; null if no such cycle
    public Iterable<DirectedEdge> negativeCycle() {
        return cycle;
    }


    public static void main(String[] args) {
        In in = new In(args[0]);
        int s = Integer.parseInt(args[1]);
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);

        BellmanFordSP sp = new BellmanFordSP(G, s);

        // print negative cycle
        if (sp.hasNegativeCycle()) {
            for (DirectedEdge e : sp.negativeCycle())
                StdOut.println(e);
        }

        // print shortest paths
        else {
            for (int v = 0; v < G.V(); v++) {
                if (sp.hasPathTo(v)) {
                    StdOut.printf("%d to %d (%5.2f)  ", s, v, sp.distTo(v));
                    for (DirectedEdge e : sp.pathTo(v)) {
                        StdOut.print(e + "   ");
                    }
                    StdOut.println();
                } else {
                    StdOut.printf("%d to %d           no path\n", s, v);
                }
            }
        }
    }
}

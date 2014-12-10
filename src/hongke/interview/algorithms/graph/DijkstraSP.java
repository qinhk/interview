package hongke.interview.algorithms.graph;

import hongke.interview.datastructure.graph.EdgeWeightedDigraph;
import hongke.interview.datastructure.graph.EdgeWeightedDigraph.DirectedEdge;
import hongke.interview.io.In;
import hongke.interview.io.StdOut;

import java.util.*;

/**
 * Created by hongke on 12/8/14.
 */
public class DijkstraSP {

    private class EdgeTo implements Comparable<EdgeTo> {
        int to;
        double dist;

        public EdgeTo(int to, double dist) {
            this.to = to;
            this.dist = dist;
        }

        public int compareTo(EdgeTo d) {
            return Double.compare(dist, d.dist);
        }

        public boolean equals(EdgeTo d) {
            return d.to == to;
        }

    }

    private DirectedEdge[] edgeTo;
    private double distTo[];
    private PriorityQueue<EdgeTo> queue;

    public DijkstraSP(EdgeWeightedDigraph G, int s) {
        this.edgeTo = new DirectedEdge[G.V()];
        this.distTo = new double[G.V()];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[s] = 0;
        queue = new PriorityQueue<EdgeTo>();
        queue.add(new EdgeTo(s, 0));
        while (queue.size() != 0) {
            relax(G, queue.poll());
        }
    }

    private void relax(EdgeWeightedDigraph G, EdgeTo v) {
        for (DirectedEdge e : G.adj(v.to)) {
            double dist = distTo[e.from()] + e.weight();
            if (distTo[e.to()] > dist) {
                distTo[e.to()] = dist;
                edgeTo[e.to()] = e;
                EdgeTo d = new EdgeTo(e.to(), dist);
                if (queue.contains(d)) {
                    queue.remove(d);
                }
                queue.add(d);
            }
        }
    }

    private double distTo(int v) {
        return distTo[v];
    }

    // is there a path from s to v?
    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    // shortest path from s to v as an Iterable, null if no such path
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
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
        int s = Integer.parseInt(args[1]);

        // compute shortest paths
        DijkstraSP sp = new DijkstraSP(G, s);


        // print shortest path
        for (int t = 0; t < G.V(); t++) {
            if (sp.hasPathTo(t)) {
                StdOut.printf("%d to %d (%.2f)  ", s, t, sp.distTo(t));
                if (sp.hasPathTo(t)) {
                    for (DirectedEdge e : sp.pathTo(t)) {
                        StdOut.print(e + "   ");
                    }
                }
                StdOut.println();
            }
            else {
                StdOut.printf("%d to %d         no path\n", s, t);
            }
        }
    }

}

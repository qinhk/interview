package hongke.interview.datastructure.graph;

import hongke.interview.io.In;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongke on 12/8/14.
 */
public class EdgeWeightedDigraph {
    int V, E;
    List<List<DirectedEdge>> adj;

    public static class DirectedEdge implements Comparable<DirectedEdge> {
        int v, w;
        double weight;

        public DirectedEdge(int v, int w, double weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }

        public int from() {
            return v;
        }

        public int to() {
            return w;
        }

        public double weight() {
            return weight;
        }

        public String toString() {
            return v + "->" + w + " " + String.format("%5.2f", weight);
        }

        public int compareTo(DirectedEdge e) {
            assert e != null;
            return Double.compare(weight(), e.weight());
        }

    }


    /**
     * Create an edge-weighted digraph from input stream.
     */
    public EdgeWeightedDigraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            addEdge(new DirectedEdge(v, w, weight));
        }
    }

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = new ArrayList<List<DirectedEdge>>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<DirectedEdge>());
        }
    }

    public EdgeWeightedDigraph(EdgeWeightedDigraph G) {
        this(G.V());
        for (DirectedEdge e : G.edges()) {
            addEdge(e);
        }
    }

    public void addEdge(DirectedEdge edge) {
        int v = edge.from();
        assert v < V && v >= 0;
        adj.get(v).add(edge);
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj.get(v);
    }

    public int outDegree(int v) {
        return adj.get(v).size();
    }

    public Iterable<DirectedEdge> edges() {
        List<DirectedEdge> list = new ArrayList<DirectedEdge>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge e : adj(v)) {
                list.add(e);
            }
        }
        return list;
    }

    /**
     * Return a string representation of this digraph.
     */
    public String toString() {
        String NEWLINE = System.getProperty("line.separator");
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (DirectedEdge e : adj.get(v)) {
                s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

}

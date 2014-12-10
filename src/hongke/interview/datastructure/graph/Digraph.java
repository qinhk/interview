package hongke.interview.datastructure.graph;

import hongke.interview.io.In;
import hongke.interview.io.StdOut;

import java.util.*;

/**
 * Created by hongke on 12/6/14.
 */
public class Digraph {
    private final int V;

    private int E;

    private Set<Integer>[] adj;

    public Digraph(int V) {
        this.V = V;
        this.adj = new Set[V];
        this.E = 0;
        for (int i = 0; i < V; i++) {
            adj[i] = new HashSet<Integer>();
        }
    }

    public Digraph(In in) {
        try {
            this.V = in.readInt();
            if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
            adj = (Set<Integer>[]) new Set[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new HashSet<Integer>();
            }
            int E = in.readInt();
            if (E < 0) throw new IllegalArgumentException("Number of edges in a Digraph must be nonnegative");
            for (int i = 0; i < E; i++) {
                int v = in.readInt();
                int w = in.readInt();
                addEdge(v, w);
            }
        } catch (NoSuchElementException e) {
            throw new InputMismatchException("Invalid input format in Digraph constructor");
        }
    }

    public void addEdge(int v, int w) {
        if (v < 0 || v >= V) throw new IndexOutOfBoundsException();
        if (w < 0 || v >= V) throw new IndexOutOfBoundsException();
        if (!adj[v].contains(w)) adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        if (v < 0 || v >= V) throw new IndexOutOfBoundsException();
        return adj[v];
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public Digraph reverse() {
        Digraph reversed = new Digraph(V);
        for (int v = 0; v < V; v ++) {
            for (Integer w : adj(v)) {
                reversed.addEdge(w, v);
            }
        }
        return reversed;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        String NEWLINE = System.getProperty("line.separator");
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(String.format("%d: ", v));
            for (int w : adj[v]) {
                s.append(String.format("%d ", w));
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }


    /**
     * Test client.
     */
    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        StdOut.println(G);
    }
}

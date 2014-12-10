package hongke.interview.algorithms.graph;

import hongke.interview.datastructure.graph.Digraph;
import hongke.interview.datastructure.graph.EdgeWeightedDigraph;
import hongke.interview.datastructure.graph.EdgeWeightedDigraph.DirectedEdge;

import java.util.*;

/**
 * Created by hongke on 12/8/14.
 */
public class DepthFirstOrder {

    private List<Integer> preorder;
    private List<Integer> postorder;
    private Set<Integer> visited;
    private int[] pre;
    private int[] post;
    private int preCounter;
    private int postCounter;

    public DepthFirstOrder(Digraph G) {
        assert G != null;
        preorder = new ArrayList<Integer>();
        postorder = new ArrayList<Integer>();
        visited = new HashSet<Integer>();
        pre = new int[G.V()];
        post = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if (!visited.contains(i)) {
                dfs(G, i);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        visited.add(v);
        pre[v] = preCounter++;
        preorder.add(v);
        for (int w : G.adj(v)) {
            if (!visited.contains(w)) {
                pre[w] = v;
                post[v] = w;
                dfs(G, w);
            }
        }
        postorder.add(v);
        post[v] = postCounter++;
    }

    public DepthFirstOrder(EdgeWeightedDigraph G) {
        assert G != null;
        preorder = new ArrayList<Integer>();
        postorder = new ArrayList<Integer>();
        visited = new HashSet<Integer>();
        pre = new int[G.V()];
        post = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if (!visited.contains(i)) {
                dfs(G, i);
            }
        }
    }

    private void dfs(EdgeWeightedDigraph G, int v) {
        visited.add(v);
        pre[v] = preCounter++;
        preorder.add(v);
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (!visited.contains(w)) {
                pre[w] = v;
                post[v] = w;
                dfs(G, w);
            }
        }
        postorder.add(v);
        post[v] = postCounter++;
    }

    public int pre(int v) {
        return pre[v];
    }

    public int post(int v) {
        return post[v];
    }

    // return vertices in postorder as an Iterable
    public Iterable<Integer> post() {
        return postorder;
    }

    // return vertices in preorder as an Iterable
    public Iterable<Integer> pre() {
        return preorder;
    }

    // return vertices in reverse postorder as an Iterable
    public Iterable<Integer> reversePost() {
        Stack<Integer> reverse = new Stack<Integer>();
        for (int v : postorder)
            reverse.push(v);
        return reverse;
    }

}

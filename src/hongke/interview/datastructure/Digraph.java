package hongke.interview.datastructure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by hongke on 12/3/14.
 */
public class Digraph<K> {

    private class Vertex<K> {
        K value;
        List<Vertex<K>> adjacents;

        Vertex(K k) {
            this(k, new ArrayList<Vertex<K>>());
        }

        Vertex(K k, List<Vertex<K>> adj) {
            this.value = k;
            this.adjacents = adj;
        }
    }

    private List<Vertex<K>> vertexes;

    public Digraph (){
        vertexes = new ArrayList<Vertex<K>>();
    }

    public K get(int index) {
        assert index < vertexes.size();
        return vertexes.get(index).value;
    }

    public void add(K k) {
        assert k != null;
        vertexes.add(new Vertex<K>(k));
    }

    public List<K> getVertex() {
        List<K> list = new ArrayList<K>();
        for (Vertex<K> v : vertexes) {
            list.add(v.value);
        }
        return list;
    }

    public List<Integer> bfs(int index) {
        List<Integer> list = new ArrayList<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        Set<Integer> current = new HashSet<Integer>();
        current.add(index);
        while (current.size() != 0) {
            Set<Integer> next = new HashSet<Integer>();
            for (Integer i : current) {
                list.add(i);
                visited.add(i);
                for (Vertex<K> v : vertexes.get(i).adjacents) {
                    int j = vertexes.indexOf(v);
                    if (!visited.contains(j)) {
                        next.add(j);
                    }
                }
            }
            current = next;
        }
        return list;
    }

    public void connect(int index, int ...adj) {
        assert index < vertexes.size();
        assert adj != null;
        vertexes.get(index).adjacents = new ArrayList<Vertex<K>>();
        for (Integer i : adj) {
            assert vertexes.size() > i;
            vertexes.get(index).adjacents.add(vertexes.get(i));
        }
    }
}

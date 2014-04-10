package hongke.interview.leetcode.questions;

/**
 * Created by hongke on 4/10/14.
 */

import hongke.interview.leetcode.common.UndirectedGraphNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;


public class CloneGraph {

    Set<UndirectedGraphNode> visited;

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        Deque<UndirectedGraphNode> nodes = new ArrayDeque<UndirectedGraphNode>
                ();
        Deque<UndirectedGraphNode> clones = new ArrayDeque<UndirectedGraphNode>
                ();

        nodes.addLast(node);
        while (!nodes.isEmpty()) {
            cloneNode(nodes.getFirst());
        }
        return clone;
    }

    private void cloneNode(UndirectedGraphNode node) {

    }
}

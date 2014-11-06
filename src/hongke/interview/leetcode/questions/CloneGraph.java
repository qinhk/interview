package hongke.interview.leetcode.questions;

/**
 * Created by hongke on 4/10/14.
 */

import hongke.interview.leetcode.common.UndirectedGraphNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        if (node == null) {
            return null;
        }

        Map<Integer, UndirectedGraphNode> added = new HashMap<Integer, UndirectedGraphNode>();
        LinkedList<UndirectedGraphNode> toAdd = new LinkedList<UndirectedGraphNode>();
        toAdd.add(node);
        while (!toAdd.isEmpty()) {
            UndirectedGraphNode curr = toAdd.remove(0);
            if (!added.containsKey(curr.label)) {
                added.put(curr.label, new UndirectedGraphNode(curr.label));
            }

            UndirectedGraphNode newNode = added.get(curr.label);
            for (UndirectedGraphNode neighbor : curr.neighbors) {
                if (!added.containsKey(neighbor.label)) {
                    toAdd.add(neighbor);
                    added.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                }
                newNode.neighbors.add(added.get(neighbor.label));
            }
        }
        return added.get(node.label);
    }
}
